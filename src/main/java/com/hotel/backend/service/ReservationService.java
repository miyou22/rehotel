package com.hotel.backend.service;

import com.hotel.backend.entity.Reservation;
import com.hotel.backend.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public void updatePayCheck(List<Long> reservationIds) {
        List<Reservation> reservations = reservationRepository.findAllById(reservationIds);
        for (Reservation reservation : reservations) {
            reservation.setFacCheck(0);
            reservation.setPayCheck(0);
        }
        reservationRepository.saveAll(reservations);
    }
}
