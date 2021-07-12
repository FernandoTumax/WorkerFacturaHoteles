package com.gestorhoteles.core.services;

import com.gestorhoteles.core.entitys.FacturaService;
import com.gestorhoteles.core.entitys.FacturaServiceFK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacturaServiceService {
    public List<FacturaService> findAll();
    public Page<FacturaService> findAll(Pageable pageable);
    public FacturaService save(FacturaService facturaService);
    public FacturaService findRootIdAndServiceId(FacturaServiceFK facturaServiceFK);
    public boolean existsById(FacturaServiceFK facturaServiceFK);
    public void delete(FacturaService facturaService);
}
