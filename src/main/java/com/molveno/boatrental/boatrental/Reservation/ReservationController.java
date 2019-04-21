package com.molveno.boatrental.boatrental.Reservation;

import com.molveno.boatrental.boatrental.Boats.Boat;
import com.molveno.boatrental.boatrental.Boats.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    BoatRepository boatRepository;

    @RequestMapping(value = "/get-reservation", method = RequestMethod.GET)
    public List<Reservation> getReservation() {

        return reservationRepository.findAll();
    }

    @RequestMapping(value = "/get-reservation-by-id", method = RequestMethod.GET)
    public Reservation getReservationById(@RequestParam long id) {
        return reservationRepository.findById(id);
    }

//    @RequestMapping(value = "/add-reservation", method = RequestMethod.POST, consumes = "application/json")
//    public void saveReservation(@RequestBody Reservation reservation) {
//        reservationRepository.save(reservation);
//    }

    @RequestMapping(value = "/delete-reservation", method = RequestMethod.DELETE)
    public void deleteReservation(@RequestParam Long id) {
        reservationRepository.deleteById(id);
    }

    @RequestMapping(value = "/edit-reservation", method = RequestMethod.POST, consumes = "application/json")
    public Reservation editReservation(@RequestBody Reservation reservation) {
        Reservation reservation1 = reservationRepository.findById(reservation.getId());
        reservation1.setStartReservationTime(reservation.getStartReservationTime());
        reservation1.setEndReservationTime(reservation.getEndReservationTime());
        reservation1.setCost(reservation.getCost());
        return reservationRepository.save(reservation1);
    }

    @RequestMapping(value = "/trip", method = RequestMethod.POST,consumes = "application/json")
    public void startTrip(@RequestBody Reservation reservation) {
        List<Reservation> reservations = reservationRepository.findAll();
         List<Boat> boats =boatRepository.findAll();
         ReservationLogic.statTrip(reservation,reservations,boats);
         reservationRepository.save(reservation);

    }
    @RequestMapping (value = "/end-trip", method = RequestMethod.POST,consumes = "application/json")
    public void endTrip(@RequestBody Reservation reservation){
        System.out.println(reservation.getId());

        Reservation reservation1 = reservationRepository.findById(reservation.getId());
        System.out.println(reservation1.getStartReservationTime());
       ReservationLogic.stopTrip(reservation1);
       reservationRepository.save(reservation1);
    }
}

