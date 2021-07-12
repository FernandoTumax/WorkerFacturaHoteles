package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class FacturaServiceFK implements Serializable {
    @Column(name = "root_id")
    private String rootId;
    @Column(name = "service_id")
    private String serviceId;
}
