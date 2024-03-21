package com.hotel.backend.controller;

import com.hotel.backend.entity.Reservation;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hotel.backend.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping("/reserve")
   public void saveReservation(@RequestBody Reservation reservation) {
        System.out.println("예약정보 ==> Start ");
        System.out.println("예약정보 ==> " + reservation);
        // reservationRepository.save(reservation);
        reservation.setResId(reservation.getResId());
        reservation.setRoomName(reservation.getRoomName());
        reservation.setRoomPrice(reservation.getRoomPrice());
        reservation.setUserName(reservation.getUserName());
        reservation.setUserTel(reservation.getUserTel());
        reservation.setUserEmail(reservation.getUserEmail());
        reservation.setResCheckin(reservation.getResCheckin());
        reservation.setResCheckout(reservation.getResCheckout());
        reservation.setResRequest(reservation.getResRequest());
        reservation.setResDate(reservation.getResDate());
        reservation.setFacCheck(reservation.getFacCheck());
        reservation.setPayCheck(reservation.getPayCheck());
        // Item savedItem = itemRepository.save(item);
        reservationRepository.save(reservation);
    }

    @GetMapping("/resInfo")
    public List<Reservation> resList(Model model) {
        System.out.println("Vue Gethering Test.....");
        List<Reservation> resList = reservationRepository.findAll();
        System.out.println("아이템 리스트 ==> " + resList);

        model.addAttribute("checkList", resList);
        return resList;
    }


}