package kz.iitu.midterm.services;

import kz.iitu.midterm.entities.Reservation;

public interface ReservationService {
    void bookingList();
    void createReservation(Reservation reservation);
}
