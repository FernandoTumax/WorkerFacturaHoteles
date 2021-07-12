package com.gestorhoteles.core.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    private String _id;
    private String nombreHotel;
    private String direccionHotel;
}
