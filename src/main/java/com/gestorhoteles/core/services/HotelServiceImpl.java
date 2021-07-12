package com.gestorhoteles.core.services;

import com.gestorhoteles.core.dao.IHotelDao;
import com.gestorhoteles.core.entitys.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private IHotelDao iHotelDao;

    @Override
    public List<Hotel> findAll() {
        return this.iHotelDao.findAll();
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return this.iHotelDao.findAll(pageable);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return this.iHotelDao.save(hotel);
    }

    @Override
    public Hotel findById(String id) {
        return this.iHotelDao.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return this.iHotelDao.existsById(id);
    }

    @Override
    public void delete(Hotel hotel) {
        this.iHotelDao.delete(hotel);
    }

    @Override
    public void delete(String id) {
        this.iHotelDao.deleteById(id);
    }
}
