package com.gestorhoteles.core.dao;

import com.gestorhoteles.core.entitys.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientDao extends JpaRepository<Client, String> {
}
