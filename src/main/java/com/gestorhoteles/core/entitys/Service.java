package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "service")
public class Service implements Serializable {
    @Id
    @Column(name = "id")
    private String _id;
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Column(name = "precio")
    private int precio;
    @OneToMany(mappedBy = "service")
    private List<FacturaService> facturaService = new ArrayList<FacturaService>();
}
