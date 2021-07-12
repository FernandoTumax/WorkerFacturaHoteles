package com.gestorhoteles.core.services;

import com.gestorhoteles.core.dao.IRoomDao;
import com.gestorhoteles.core.entitys.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService{

    @Autowired
    private IRoomDao roomDao;

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Room save(Room room) {
        return roomDao.save(room);
    }

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return this.roomDao.findAll(pageable);
    }

    @Override
    public Room findById(String id) {
        return this.roomDao.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return this.roomDao.existsById(id);
    }

    @Override
    public void delete(Room room) {
        this.roomDao.delete(room);
    }

    @Override
    public void delete(String id) {
        this.roomDao.deleteById(id);
    }
}
