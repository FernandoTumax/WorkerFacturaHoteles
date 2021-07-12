package com.gestorhoteles.core.services;

import com.gestorhoteles.core.dao.IFacturacionServiceDao;
import com.gestorhoteles.core.entitys.FacturaService;
import com.gestorhoteles.core.entitys.FacturaServiceFK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceServiceImpl implements IFacturaServiceService{

    @Autowired
    private IFacturacionServiceDao iFacturacionServiceDao;

    @Override
    public List<FacturaService> findAll() {
        return this.iFacturacionServiceDao.findAll();
    }

    @Override
    public Page<FacturaService> findAll(Pageable pageable) {
        return this.iFacturacionServiceDao.findAll(pageable);
    }

    @Override
    public FacturaService save(FacturaService facturaService) {
        return this.iFacturacionServiceDao.save(facturaService);
    }

    @Override
    public FacturaService findRootIdAndServiceId(FacturaServiceFK facturaServiceFK) {
        return this.iFacturacionServiceDao.findByRootIdAndServiceId(facturaServiceFK);
    }

    @Override
    public boolean existsById(FacturaServiceFK facturaServiceFK) {
        return this.iFacturacionServiceDao.existsById(facturaServiceFK);
    }

    @Override
    public void delete(FacturaService facturaService) {
        this.iFacturacionServiceDao.delete(facturaService);
    }
}
