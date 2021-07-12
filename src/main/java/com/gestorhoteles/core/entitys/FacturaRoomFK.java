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
public class FacturaRoomFK implements Serializable {
    @Column(name = "root_id")
    private String rootId;
    @Column(name = "room_id")
    private String roomId;
}
