package com.hotel.backend.controller;

import com.hotel.backend.entity.Reservation;
import com.hotel.backend.service.ReservationService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    ReservationService reservationService;

// 예약정보들 DB에 저장
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

    // DB에 저장되어있는 데이터들 가져오기
    @GetMapping("/resInfo")
    public List<Reservation> resList(Model model) {
        System.out.println("Vue Gethering Test.....");
        List<Reservation> resList = reservationRepository.findAll();
        System.out.println("아이템 리스트 ==> " + resList);

        model.addAttribute("checkList", resList);
        return resList;
    }
    
    // service를 이용해서 DB값 변경
    @PostMapping("/updatePayCheck")
    public void updatePayCheck(@RequestBody List<Long> reservationIds) {
        System.out.println("updatePayCheck ==> ");

        reservationService.updatePayCheck(reservationIds);
    }

}