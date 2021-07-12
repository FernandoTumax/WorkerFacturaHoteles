package com.gestorhoteles.core.services;

import com.gestorhoteles.core.entitys.Service;
import com.gestorhoteles.core.dao.IServicesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService{

    @Autowired
    private IServicesDao servicesDao;

    @Override
    public List<Service> findAll() {
        return this.servicesDao.findAll();
    }

    @Override
    public Service save(Service service) {
        return this.servicesDao.save(service);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return this.servicesDao.findAll(pageable);
    }

    @Override
    public Service findById(String id) {
        return this.servicesDao.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return this.servicesDao.existsById(id);
    }

    @Override
    public void delete(Service service) {
        this.servicesDao.delete(service);
    }

    @Override
    public void delete(String id) {
        this.servicesDao.deleteById(id);
    }
}
