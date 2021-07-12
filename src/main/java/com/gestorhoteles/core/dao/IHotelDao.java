package com.gestorhoteles.core.dao;

import com.gestorhoteles.core.entitys.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelDao extends JpaRepository<Hotel, String> {
}
