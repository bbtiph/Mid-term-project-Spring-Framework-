package kz.iitu.midterm.entities.room;

import kz.iitu.midterm.entities.user.UserType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`room`")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int id;

    @Column(name = "room_isEmpty")
    private boolean isEmpty;

    @Column(name = "room_type")
    private RoomType type;

    @Column(name = "room_price")
    private int price;


    public Room(int id, boolean isEmpty, RoomType type, int price) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.type = type;
        this.price = price;
    }

    public Room() {
    }

    @Override
    public String toString() {
        return "|" +
                " ID: " + id +
                "| IsEmpty: " + isEmpty +
                "| Type: " + type +
                "| Price: " + price +
                " |";
    }
}
