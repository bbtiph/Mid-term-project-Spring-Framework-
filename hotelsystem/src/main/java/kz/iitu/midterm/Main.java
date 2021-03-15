package kz.iitu.midterm;

import kz.iitu.midterm.config.SpringConfig;
import kz.iitu.midterm.controller.AdminController;
import kz.iitu.midterm.controller.ClientController;
import kz.iitu.midterm.entities.Reservation;
import kz.iitu.midterm.entities.room.Room;
import kz.iitu.midterm.entities.room.RoomType;
import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.entities.user.UserType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AdminController adminController = context.getBean("adminController",AdminController.class);
        ClientController clientController = context.getBean("clientController",ClientController.class);
        //adminController.findById(1);
        //User user = new User(1,"bbtiph", "14521", "bbtiph@gmail.com", UserType.ADMIN);
        //adminController.createUser(user);

//        for (int i=15; i<=18; i++) {
//            Room room = new Room(i, true, RoomType.TRIPLE);
//            adminController.createRoom(room);
//        }
        Scanner in= new Scanner(System.in);
        int choise;
        while (true){
            System.out.println("\n          Welcome!\n" +
                    "+-----------------------------+" +
                    "\n 1. Login " +
                    "\n 2. Registration " +
                    "\n 3. Login without registration " +
                    "\n 4. Quit \n " +
                    "+-----------------------------+");
            System.out.print("Choise:");
            choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.print("Login:  ");
                    String login = in.next();
                    System.out.print("Password:  ");
                    String password = in.next();
                    User user = clientController.verificationUser(login, password);
                    if (user != null) {
                        switch (user.getType()) {
                            case ADMIN:

                                while (true) {
                                    System.out.println("WELCOME TO ADMIN PAGE:\n" +
                                            "+-------------------------+\n" +
                                            " 1. Create room \n" +
                                            " 2. Delete room \n" +
                                            " 3. Create administrator \n" +
                                            " 4. Delete user \n" +
                                            " 5. Show empty rooms \n" +
                                            " 6. Show bookings \n" +
                                            " 0. Exit\n" +
                                            "+-------------------------+");
                                    System.out.print("Choise: ");
                                    int choise1 = in.nextInt();
                                    switch (choise1) {
                                        case 1:
                                            Random rand = new Random();
                                            int id = rand.nextInt(10000);
                                            System.out.println("Choose: \n" +
                                                    "+--------------+/n" +
                                                    " 1. Single room \n" +
                                                    " 2. Double room \n" +
                                                    " 3. Triple room \n" +
                                                    "+--------------+");
                                            System.out.print("Choise: ");
                                            int choise2 = in.nextInt();
                                            RoomType roomType;
                                            switch (choise2) {
                                                case 1:
                                                    roomType=RoomType.SINGLE;
                                                    break;
                                                case 2:
                                                    roomType=RoomType.DOUBLE;
                                                    break;
                                                case 3:
                                                    roomType=RoomType.TRIPLE;
                                                    break;
                                                default:
                                                    throw new IllegalStateException("Unexpected value: " + choise2);
                                            }
                                            System.out.print("Enter price: ");
                                            int price = in.nextInt();
                                            Room room = new Room(id, true, roomType, price);
                                            adminController.createRoom(room);
                                            System.out.println("Room succesfully created!!!");
                                            break;

                                        case 2:
                                            System.out.print("ID of room: ");
                                            int id2 = in.nextInt();
                                            adminController.deleteRoom(id2);
                                            break;

                                        case 3:
                                            Random rand1 = new Random();
                                            int id1 = rand1.nextInt(10000);
                                            System.out.print("Username: ");
                                            String username = in.next();
                                            System.out.print("Password: ");
                                            String password1 = in.next();
                                            System.out.print("e-mail: ");
                                            String email = in.next();
                                            User user1 = new User(id1, username, password1, email, UserType.ADMIN);
                                            adminController.createUser(user1);
                                            break;

                                        case 4:
                                            System.out.print("ID of user: ");
                                            int id3 = in.nextInt();
                                            adminController.deleteUser(id3);
                                            break;

                                        case 5:
                                            adminController.showEmptyRooms();
                                            break;

                                        case 6:
                                            adminController.reservationList();
                                            break;

                                        case 0:
                                            return;
                                    }
                                }

                            case CLIENT:
                                while (true) {
                                    System.out.println("WELCOME TO CLIENT PAGE: \n" +
                                            "+-----------------------+\n" +
                                            " 1. Show empty rooms \n" +
                                            " 2. Make reservation \n" +
                                            " 0. Exit\n" +
                                            "+-----------------------+");
                                    System.out.print("Choise: ");
                                    int choise3 = in.nextInt();
                                    switch (choise3) {
                                        case 1:
                                            clientController.showEmptyRooms();
                                            break;

                                        case 2:
                                            System.out.println("Choose: \n" +
                                                    "+---------------+ \n" +
                                                    " 1. Single room \n" +
                                                    " 2. Double room \n" +
                                                    " 3. Triple room \n" +
                                                    " 0. Prev. page \n" +
                                                    "+---------------+");
                                            int choise4 = in.nextInt();
                                            RoomType roomType=null;
                                            int numRooms=0;
                                            switch (choise4) {
                                                case 1:
                                                    roomType=RoomType.SINGLE;
                                                    numRooms=1;
                                                    break;
                                                case 2:
                                                    roomType=RoomType.DOUBLE;
                                                    numRooms=2;
                                                    break;
                                                case 3:
                                                    roomType=RoomType.TRIPLE;
                                                    numRooms=3;
                                                    break;
                                            }
                                            clientController.roomsByType(roomType);
                                            System.out.println("Please enter ID of room: ");
                                            int id = in.nextInt();
                                            Room room = clientController.findById(id);
                                            System.out.println(room);
                                            System.out.println("Please number of persons: ");
                                            int numPerson = in.nextInt();
                                            System.out.println("Please number of stay days: ");
                                            int stayDays = in.nextInt();
                                            Date date = new Date();
                                            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                                            String stringDate= DateFor.format(date);
                                            Reservation reservation = new Reservation(room.getId(), room.getPrice(), numRooms, numPerson, stringDate, stayDays, user.getId());
                                            System.out.println(stringDate);
                                            clientController.addReservation(reservation);
                                            System.out.println("\n\n Thank you!!! Your order: \n" +
                                                    reservation + "\n\n");

                                            break;

                                        case 0:
                                            return;
                                    }
                                    break;
                                }
                        }
                    } else {
                        System.out.println("Your password or username is not correct!!!");
                    }
                break;

                case 2:
                    System.out.println("Enter your login:");
                    String log = in.next();
                    String password1;
                    while(true) {
                        System.out.println("Enter your password:");
                        password1 = in.next();
                        System.out.println("Confirm your password:");
                        String password2 = in.next();
                        if (password1.equals(password2)) {
                            break;
                        } else {
                            System.out.println("Your password is not correct!");
                        }
                    }
                    System.out.println("Enter your e-mail:");
                    String email = in.next();
                    Random rand = new Random();
                    int id = rand.nextInt(10000);
                    User user1 = new User(id, log, password1, email, UserType.CLIENT);
                    adminController.createUser(user1);
                    break;

                case 3:
                    System.out.println("MAIN PAGE");
                    break;

                case 0:
                    return;
            }
        }
    }
}
