package com.gestorhoteles.core.dao;

import com.gestorhoteles.core.entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomDao extends JpaRepository<Room, String> {
}
