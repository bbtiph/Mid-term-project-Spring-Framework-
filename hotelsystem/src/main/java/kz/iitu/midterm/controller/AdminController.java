package kz.iitu.midterm.controller;

import kz.iitu.midterm.entities.room.Room;
import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.services.ReservationService;
import kz.iitu.midterm.services.RoomService;
import kz.iitu.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ReservationService reservationService;

    public void createUser(User user){
        userService.createUser(user);
    }

    public void deleteUser(int id){
        userService.delelteUser(id);
    }

    public void findById(int id) {
        userService.findById(id);
    }

    public void createRoom(Room room) {
        roomService.createRoom(room);
    }

    public void deleteRoom(int id) {
        roomService.deleteRoom(id);
    }

    public void showEmptyRooms() {
        System.out.println(roomService.emptyRooms());
    }

    public void reservationList() {
        reservationService.bookingList();
    }
}
