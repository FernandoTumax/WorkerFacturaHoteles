package com.gestorhoteles.core.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {
    private String _id;
    private String codigoHabitacion;
    private String tipoHabitacion;
    private int precio;
}
