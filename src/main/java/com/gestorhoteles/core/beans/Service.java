package com.gestorhoteles.core.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private String _id;
    private String nombreServicio;
    private int precio;
}
