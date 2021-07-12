package com.gestorhoteles.core.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "facturacion_room")
public class FacturaRoom implements Serializable {
    @EmbeddedId
    private FacturaRoomFK facturaRoomFK;
    @ManyToOne
    @JoinColumn(name = "root_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Root root;
    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Room room;
}
