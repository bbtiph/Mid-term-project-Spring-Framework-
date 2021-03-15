package kz.iitu.midterm.services.impl;

import kz.iitu.midterm.entities.room.Room;
import kz.iitu.midterm.entities.room.RoomType;
import kz.iitu.midterm.repository.RoomRepository;
import kz.iitu.midterm.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void makeRoomIsnotEmpty(int id) {
        Room room = roomRepository.getById(id);
        room.setEmpty(false);
        roomRepository.save(room);
    }

    @Override
    public void createRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> emptyRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(int id) {
         Room room = roomRepository.getById(id);
         return room;
    }

    @Override
    public void roomsByType(RoomType roomType) {
        List<Room> roomList = roomRepository.findByType(roomType);
        System.out.println(roomType + " rooms list: ");
        for (Room room: roomList) {
            System.out.println(room);
        }
    }
}
