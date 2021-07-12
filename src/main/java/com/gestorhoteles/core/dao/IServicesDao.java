package com.gestorhoteles.core.dao;

import com.gestorhoteles.core.entitys.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicesDao extends JpaRepository<Service, String>{

}
