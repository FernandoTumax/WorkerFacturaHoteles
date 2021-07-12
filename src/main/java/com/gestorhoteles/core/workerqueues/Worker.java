package com.gestorhoteles.core.workerqueues;


//import com.gestorhoteles.core.beans.Root;
import com.gestorhoteles.core.entitys.*;
import com.gestorhoteles.core.manejadores.ManejadorDeCorreo;
import com.gestorhoteles.core.reports.GenerarReporte;
import com.gestorhoteles.core.services.*;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.stereotype.Component;

@Component
public class Worker {

    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IClientService clientService;
    @Autowired
    private IHotelService hotelService;
    @Autowired
    private IRoomService roomService;
    @Autowired
    private IRootService facturaService;
    @Autowired
    private IFacturaRoomService facturaRoomService;
    @Autowired
    private IFacturaServiceService facturaServiceService;

    final static Logger logger = Logger.getLogger(Worker.class);
    @Value("${com.gestorhotel.core.broker.host}")
    private String host;
    @Value("${com.gestorhotel.core.broker.port}")
    private int port;
    @Value("${com.gestorhotel.core.broker.username}")
    private String username;
    @Value("${com.gestorhotel.core.broker.password}")
    private String password;
    @Value("${com.gestorhotel.core.broker.virtualhost}")
    private String virtualhost;
    @Value("${com.gestorhotel.core.broker.queue}")
    private String queue;

    public void processWork() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(this.host);
        connectionFactory.setPort(this.port);
        connectionFactory.setUsername(this.username);
        connectionFactory.setPassword(this.password);
        connectionFactory.setVirtualHost(this.virtualhost);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(this.queue,true,false,false,null);
        logger.debug("ProccesWork <<< [*] waiting for message (to exits press CTRL+C)");
        channel.basicQos(1);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            logger.debug("proccesWork <<< [x] received ==> ".concat(message).concat(" <=="));
            try{
                System.out.println(message);
                //Root root = new Gson().fromJson(message,Root.class);
                com.gestorhoteles.core.beans.Root rootJson = new Gson().fromJson(message, com.gestorhoteles.core.beans.Root.class);
                Root nuevaFactura = new Root();
                System.out.println(rootJson);
                for (com.gestorhoteles.core.beans.Room elemento : rootJson.getRoom()){
                    Room habitacion = roomService.findById(elemento.get_id());
                    if(habitacion == null){
                        Room nuevo = new Room();
                        nuevo.set_id(elemento.get_id());
                        nuevo.setCodigoHabitacion(elemento.getCodigoHabitacion());
                        nuevo.setPrecio(elemento.getPrecio());
                        nuevo.setTipoHabitacion(elemento.getTipoHabitacion());
                        habitacion = roomService.save(nuevo);
                    }
                    FacturaRoom facturaRoom = new FacturaRoom();
                    facturaRoom.setRoom(habitacion);
                    facturaRoom.setRoot(nuevaFactura);
                    nuevaFactura.getFacturaRooms().add(facturaRoom);
                }
                System.out.println("Finalizando rooms");
                for (com.gestorhoteles.core.beans.Service elemento : rootJson.getService()){
                    Service servicio = serviceService.findById(elemento.get_id());
                    if(servicio == null){
                        Service nuevo = new Service();
                        nuevo.set_id(elemento.get_id());
                        nuevo.setNombreServicio(elemento.getNombreServicio());
                        nuevo.setPrecio(elemento.getPrecio());
                        servicio = serviceService.save(nuevo);
                    }
                    FacturaService facturaService = new FacturaService();
                    facturaService.setService(servicio);
                    facturaService.setRoot(nuevaFactura);
                    nuevaFactura.getService().add(facturaService);
                }
                System.out.println("Finalizando services");
                Hotel hotel = hotelService.findById(rootJson.getHotel().get_id());
                if(hotel == null){
                    Hotel nuevo = new Hotel();
                    nuevo.set_id(rootJson.getHotel().get_id());
                    nuevo.setDireccionHotel(rootJson.getHotel().getDireccionHotel());
                    nuevo.setNombreHotel(rootJson.getHotel().getNombreHotel());
                    hotel = hotelService.save(nuevo);
                }
                nuevaFactura.setHotel(hotel);
                System.out.println("Finalizando hotels");
                Client cliente = clientService.findById(rootJson.getClient().get_id());
                if(cliente == null){
                    Client nuevo = new Client();
                    nuevo.set_id(rootJson.getClient().get_id());
                    nuevo.setNombreCliente(rootJson.getClient().getNombreCliente());
                    nuevo.setApellidoCliente(rootJson.getClient().getApellidoCliente());
                    nuevo.setEmailCliente(rootJson.getClient().getEmailCliente());
                    cliente = clientService.save(nuevo);
                }
                nuevaFactura.setClient(cliente);
                nuevaFactura.set_id(rootJson.get_id());
                nuevaFactura.setFechaIngreso(rootJson.getFechaIngreso());
                nuevaFactura.setFechaSalida(rootJson.getFechaSalida());
                nuevaFactura.setNumeroTarjeta(rootJson.getNumeroTarjeta());
                nuevaFactura.setTotalPagar(rootJson.getTotalPagar());
                System.out.println("Finalizando clients");
                System.out.println(rootJson.get_id());
                if(!facturaService.existsById(nuevaFactura.get_id())){
                    facturaService.save(nuevaFactura);
                }
                for (FacturaRoom elemento : nuevaFactura.getFacturaRooms()){
                    FacturaRoomFK facturaRoomFK = new FacturaRoomFK();
                    facturaRoomFK.setRoomId(elemento.getRoom().get_id());
                    facturaRoomFK.setRootId(nuevaFactura.get_id());
                    FacturaRoom facturaRoom = new FacturaRoom();
                    facturaRoom.setFacturaRoomFK(facturaRoomFK);
                    facturaRoomService.save(facturaRoom);
                }
                for (FacturaService elemento : nuevaFactura.getService()){
                    FacturaServiceFK facturaServiceFK = new FacturaServiceFK();
                    facturaServiceFK.setServiceId(elemento.getService().get_id());
                    facturaServiceFK.setRootId(nuevaFactura.get_id());
                    FacturaService facturaService = new FacturaService();
                    facturaService.setFacturaServiceFK(facturaServiceFK);
                    facturaServiceService.save(facturaService);
                }
                System.out.println("Finalizando facturas");
                doWork(message);
                GenerarReporte.getInstances().generar(nuevaFactura.get_id());
                try{
                    System.out.println(rootJson.getClient().getEmailCliente());
                    ManejadorDeCorreo.getInstancia().enviarCorreoRegistro("Factura de confirmacion para reservacion en TuMejorEstadia.com","Factura No.".concat(nuevaFactura.get_id()), "Aqui esta tu reservacion en el hotel ".concat(rootJson.getHotel().getNombreHotel()), "Muchas gracias cliente ".concat(rootJson.getClient().getNombreCliente()).concat(" por contar con nosotros, que disfrutes tus vacaciones"), rootJson.getClient().getEmailCliente());
                }catch (Exception e){
                    e.printStackTrace();
                }
                /*System.out.println(service.findAll().size());
                System.out.println(client.findAll().size());
                System.out.println(hotel.findAll().size());
                System.out.println(room.findAll().size());
                System.out.println(factura.findAll().size());*/
            }finally {
                System.out.println("proccessWork <<< [x] done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(this.queue, false, deliverCallback, consumerTag -> {
           System.out.println("done");
        });
    }

    public static void doWork(String task){
        int i = 0;
        for(char letter : task.toCharArray()){
            if(letter == '.'){
                try {
                    System.out.println("doWork <<< working ".concat(String.valueOf(i++)).concat("..."));
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("doWork <<< done!!!");
    }

}
