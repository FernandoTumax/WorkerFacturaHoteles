package com.gestorhoteles.core.dao;

import com.gestorhoteles.core.entitys.FacturaService;
import com.gestorhoteles.core.entitys.FacturaServiceFK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFacturacionServiceDao extends JpaRepository<FacturaService, FacturaServiceFK> {
    @Query("from FacturaService fs where fs.facturaServiceFK.rootId = ?1 and fs.facturaServiceFK.serviceId = ?2")
    public FacturaService findByRootIdAndServiceId(FacturaServiceFK facturaServiceFK);
}
