package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {
    @Id
    @Column(name = "id")
    private String _id;
    @Column(name = "nombre_hotel")
    private String nombreHotel;
    @Column(name = "direccion_hotel")
    private String direccionHotel;
}
