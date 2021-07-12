package com.gestorhoteles.core.services;

import com.gestorhoteles.core.dao.IFacturacionRoomDao;
import com.gestorhoteles.core.entitys.FacturaRoom;
import com.gestorhoteles.core.entitys.FacturaRoomFK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaRoomServiceImpl implements IFacturaRoomService{

    @Autowired
    private IFacturacionRoomDao iFacturacionRoomDao;

    @Override
    public List<FacturaRoom> findAll() {
        return this.iFacturacionRoomDao.findAll();
    }

    @Override
    public Page<FacturaRoom> findAll(Pageable pageable) {
        return this.iFacturacionRoomDao.findAll(pageable);
    }

    @Override
    public FacturaRoom save(FacturaRoom facturaRoom) {
        return this.iFacturacionRoomDao.save(facturaRoom);
    }

    @Override
    public FacturaRoom findByRootIdAndRoomId(FacturaRoomFK facturaRoomFK) {
        return this.iFacturacionRoomDao.findByRootIdAndRoomId(facturaRoomFK);
    }

    @Override
    public boolean existsById(FacturaRoomFK facturaRoomFK) {
        return this.iFacturacionRoomDao.existsById(facturaRoomFK);
    }

    @Override
    public void delete(FacturaRoom facturaRoom) {
        this.iFacturacionRoomDao.delete(facturaRoom);
    }
}
