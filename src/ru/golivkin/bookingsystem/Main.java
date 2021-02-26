package ru.golivkin.bookingsystem;

import ru.golivkin.bookingsystem.model.Bill;
import ru.golivkin.bookingsystem.model.Client;
import ru.golivkin.bookingsystem.model.Hotel;
import ru.golivkin.bookingsystem.model.Room;
import ru.golivkin.bookingsystem.service.BookingService;

public class Main {

    public static void main(String[] args) {
        Bill alexBill = new Bill(20000);
        Client alexClient = new Client("Alex", "Ivanov",
                "+7(928)123-55-77", "alex@mail.ru", alexBill);

        Bill maxBill = new Bill(30000);
        Client maxClient = new Client("Max", "Petrov",
                "+7(928)123-55-88", "max@mail.ru", maxBill);

        Room[] californiaHotelRooms = new Room[]{new Room(1, 1500, true),
                new Room(2, 2500, true), new Room(3, 3500, true)};

        Hotel californiaHotel = new Hotel("California", californiaHotelRooms);

        Room[] americaHotelRooms = new Room[]{new Room(1, 1800, true),
                new Room(2, 3000, true), new Room(3, 4500, true)};

        Hotel americaHotel = new Hotel("America", americaHotelRooms);

        BookingService bookingService = new BookingService();
        bookingService.book(californiaHotel, alexClient, 2);
        System.out.println("\n");
        bookingService.book(californiaHotel, alexClient, 4);
        System.out.println("\n");
        bookingService.book(americaHotel, maxClient, 3);
    }
}
