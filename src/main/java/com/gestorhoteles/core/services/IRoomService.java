package com.gestorhoteles.core.services;

import com.gestorhoteles.core.entitys.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoomService {
    public List<Room> findAll();
    public Room save(Room room);
    public Page<Room> findAll(Pageable pageable);
    public Room findById(String id);
    public boolean existsById(String id);
    public void delete(Room room);
    public void delete(String id);
}
