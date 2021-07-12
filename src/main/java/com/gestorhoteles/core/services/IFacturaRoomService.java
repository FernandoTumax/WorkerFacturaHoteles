package com.gestorhoteles.core.services;

import com.gestorhoteles.core.entitys.FacturaRoom;
import com.gestorhoteles.core.entitys.FacturaRoomFK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFacturaRoomService {
    public List<FacturaRoom> findAll();
    public Page<FacturaRoom> findAll(Pageable pageable);
    public FacturaRoom save(FacturaRoom facturaRoom);
    public FacturaRoom findByRootIdAndRoomId(FacturaRoomFK facturaRoomFK);
    public boolean existsById(FacturaRoomFK facturaRoomFK);
    public void delete(FacturaRoom facturaRoom);
}
