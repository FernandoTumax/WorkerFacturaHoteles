package com.gestorhoteles.core.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    private String _id;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
}
