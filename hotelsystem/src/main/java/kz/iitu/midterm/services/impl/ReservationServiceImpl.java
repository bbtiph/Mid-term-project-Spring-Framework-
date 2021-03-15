package kz.iitu.midterm.services.impl;

import kz.iitu.midterm.entities.Reservation;
import kz.iitu.midterm.repository.ReservationRepository;
import kz.iitu.midterm.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public void bookingList() {
        System.out.println(reservationRepository.findAll());
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
