package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "facturacion_service")
public class FacturaService implements Serializable {
    @EmbeddedId
    private FacturaServiceFK facturaServiceFK;
    @ManyToOne
    @JoinColumn(name = "root_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Root root;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Service service;
}
