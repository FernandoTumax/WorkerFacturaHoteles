package com.gestorhoteles.core.dao;

import com.gestorhoteles.core.entitys.FacturaRoom;
import com.gestorhoteles.core.entitys.FacturaRoomFK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFacturacionRoomDao extends JpaRepository<FacturaRoom, FacturaRoomFK> {
    @Query("from FacturaRoom fr where fr.facturaRoomFK.roomId = ?1 and fr.facturaRoomFK.rootId = ?2")
    public FacturaRoom findByRootIdAndRoomId(FacturaRoomFK facturaRoomFK);
}
