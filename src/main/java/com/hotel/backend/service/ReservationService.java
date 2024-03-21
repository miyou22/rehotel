package com.hotel.backend.service;

import com.hotel.backend.entity.Reservation;
import com.hotel.backend.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void delete(Long resId) {
        System.out.println("삭제 서비스에서 받은 id : " + resId);
        Reservation reservation = reservationRepository.findById(resId).orElseThrow(() -> new RuntimeException(resId + "에 해당하는 상품이 존재하지 않습니다."));
        reservationRepository.delete(reservation);
    }
}
