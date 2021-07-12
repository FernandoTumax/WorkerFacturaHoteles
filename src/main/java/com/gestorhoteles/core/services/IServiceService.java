package com.gestorhoteles.core.services;

import com.gestorhoteles.core.entitys.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    public List<Service> findAll();
    public Service save(Service service);
    public Page<Service> findAll(Pageable pageable);
    public Service findById(String id);
    public boolean existsById(String id);
    public void delete(Service service);
    public void delete(String id);
}
