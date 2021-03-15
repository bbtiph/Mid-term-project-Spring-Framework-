package kz.iitu.midterm.services;

import kz.iitu.midterm.entities.room.Room;
import kz.iitu.midterm.entities.room.RoomType;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    void createRoom(Room room);
    void deleteRoom(int id);
    List<Room> emptyRooms();
    void roomsByType(RoomType roomType);
    Room findById(int id);
    void makeRoomIsnotEmpty(int id);
}
