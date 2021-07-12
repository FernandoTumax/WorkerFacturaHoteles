package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "facturacion")
public class Root implements Serializable {
    @Id
    @Column(name = "id")
    private String _id;
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;
    @Column(name = "fecha_salida")
    private String fechaSalida;
    @Column(name = "numero_tarjeta")
    private int numeroTarjeta;
    @Column(name = "total_pagar")
    private double totalPagar;
    @Column(name = "service")
    @OneToMany(mappedBy = "root")
    private List<FacturaService> service = new ArrayList<FacturaService>();
    @OneToMany(mappedBy = "root")
    private List<FacturaRoom> facturaRooms = new ArrayList<FacturaRoom>();
    @OneToOne
    private Hotel hotel;
    @OneToOne
    private Client client;
    @Column(name = "version")
    private int v;
}
