package ru.golivkin.bookingsystem.service;

import ru.golivkin.bookingsystem.model.Bill;
import ru.golivkin.bookingsystem.model.Client;
import ru.golivkin.bookingsystem.model.Hotel;
import ru.golivkin.bookingsystem.model.Room;

public class BookingService {

    public void book(Hotel hotel, Client client, int numberOfPerson) {
        Room[] rooms = hotel.getRooms();
        boolean isFreeRooms = false;
        for (Room r : rooms) {
            if (r.isFree()) {
                isFreeRooms = true;
                break;
            }
        }

        if (!isFreeRooms) {
            System.out.println("Свободных номеров в отеле: " + hotel.getName() + " нет!");
        }

        bookRoom(client, numberOfPerson, rooms);

    }

    private void bookRoom(Client client, int numberOfPerson, Room[] rooms) {
        boolean success = false;
        String clientName = client.getName();
        for (Room room : rooms) {
            if (room.getNumberOfPerson() == numberOfPerson) {
                success = true;
                System.out.println("Нашелся номер для пользователя: " + clientName);
                if (client.getBill().getAmount() >= room.getCost()) {
                    Bill clientBill = client.getBill();
                    clientBill.setAmount(clientBill.getAmount() - room.getCost());
                    room.setFree(false);
                    System.out.println("Номер был успешно забронирован клиентом: " + clientName);
                } else {
                    System.out.println("Не достаточно денег для бронирования номера, клиент: " + clientName);
                }

            }
        }

        if (!success) {
            System.out.println("Не нашлось подходящего номера для клиента: " + clientName);

        }
    }
}
