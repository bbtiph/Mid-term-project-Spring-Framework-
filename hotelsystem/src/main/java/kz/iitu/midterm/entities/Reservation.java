package kz.iitu.midterm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`reservation`")
public class Reservation {

    // reservation fields and annotate with it's column to connect to jpa entity manager

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "reservation_roomId")
    private int roomId;

    @Column(name = "reservation_price")
    private int price;

    @Column(name = "reservation_num_of_rooms")
    private int rooms;

    @Column(name = "reservation_num_of_persons")
    private int persons;

    @Column(name = "reservation_from_date")
    private String arrivalDate;

    @Column(name = "reservation_stay_days")
    private int stayDays;

    @Column(name = "reservation_user_id")
    private int userId;

    public Reservation() {
    }

    public Reservation(int  roomId, int price, int rooms, int persons,
                       String arrivalDate, int stayDays, int userId) {
        this.roomId = roomId;
        this.price = price;
        this.rooms = rooms;
        this.persons = persons;
        this.arrivalDate = arrivalDate;
        this.stayDays = stayDays;
        this.userId = userId;
    }

    // reservation getters and setters fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getStayDays() {
        return stayDays;
    }

    public void setStayDays(int stayDays) {
        this.stayDays = stayDays;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return  "+-----------------------------+" +
                "\n Reservation:" +
                "\n ID: " + id +
                "\n Room: " + roomId +
                "\n Price: " + price +
                "\n Rooms: " + rooms +
                "\n Persons: " + persons +
                "\n ArrivalDate: " + arrivalDate +
                "\n StayDays: " + stayDays +
                "\n UserId: " + userId +
                "\n+-----------------------------+";
    }
}

