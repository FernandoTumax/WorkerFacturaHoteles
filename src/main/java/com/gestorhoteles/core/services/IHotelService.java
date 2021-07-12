package com.gestorhoteles.core.services;

import com.gestorhoteles.core.entitys.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHotelService {
    public List<Hotel> findAll();
    public Page<Hotel> findAll(Pageable pageable);
    public Hotel save(Hotel hotel);
    public Hotel findById(String id);
    public boolean existsById(String id);
    public void delete(Hotel hotel);
    public void delete(String id);
}
