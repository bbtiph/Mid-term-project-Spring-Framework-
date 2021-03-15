package kz.iitu.midterm.controller;

import kz.iitu.midterm.entities.Reservation;
import kz.iitu.midterm.entities.room.Room;
import kz.iitu.midterm.entities.room.RoomType;
import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.services.ReservationService;
import kz.iitu.midterm.services.RoomService;
import kz.iitu.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    public User verificationUser(String login, String password) {
        return userService.verificationUser(login,password);
    }
    public void showEmptyRooms() {
        roomService.emptyRooms();
    }
    public void roomsByType(RoomType roomType){
        roomService.roomsByType(roomType);
    }
    public Room findById(int id){
        return roomService.findById(id);
    }

    public void addReservation(Reservation reservation){
        reservationService.createReservation(reservation);
        roomService.makeRoomIsnotEmpty(reservation.getRoomId());
    }
}
