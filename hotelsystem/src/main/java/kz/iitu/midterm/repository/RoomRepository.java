package kz.iitu.midterm.repository;

import kz.iitu.midterm.entities.room.Room;
import kz.iitu.midterm.entities.room.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByType(RoomType roomType);
    Room getById(int id);
}
