package com.gestorhoteles.core.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Root {
    private String _id;
    private String fechaIngreso;
    private String fechaSalida;
    private int numeroTarjeta;
    private double totalPagar;
    private List<Service> service = new ArrayList<Service>();
    private List<Room> room = new ArrayList<Room>();
    private Hotel hotel;
    private Client client;
    private int __v;
}
