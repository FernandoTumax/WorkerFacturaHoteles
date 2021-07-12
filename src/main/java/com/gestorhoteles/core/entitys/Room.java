package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @Column(name = "id")
    private String _id;
    @Column(name = "codigo_habitacion")
    private String codigoHabitacion;
    @Column(name = "tipo_habitacion")
    private String tipoHabitacion;
    @Column(name = "precio")
    private int precio;
    @OneToMany(mappedBy = "room")
    private List<FacturaRoom> facturaRooms = new ArrayList<FacturaRoom>();
}
