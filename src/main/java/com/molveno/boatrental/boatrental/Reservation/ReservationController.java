package com.molveno.boatrental.boatrental.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value = "/get-reservation" , method = RequestMethod.GET)
    public List<Reservation> getReservation(){

        return reservationRepository.findAll();
    }
    @RequestMapping(value = "/get-reservation-by-id" ,  method = RequestMethod.GET)
    public Reservation getReservationById(@RequestParam long id) { return reservationRepository.findById(id);}

    @RequestMapping(value = "/add-reservation",method = RequestMethod.POST,consumes = "application/json")
    public void saveReservation(@RequestBody Reservation reservation) {reservationRepository.save(reservation);}

    @RequestMapping (value = "/delete-reservation" ,method = RequestMethod.DELETE , consumes = "application/json")
    public void deleteReservation(@RequestBody Reservation reservation) {reservationRepository.deleteById(reservation.getId());}

    @RequestMapping (value = "/edit-reservation" , method = RequestMethod.POST , consumes = "application/json")
    public void editReservation(@RequestBody Reservation reservation){
        Reservation reservation1 = new Reservation();
        reservation1.setStartReservationTime(reservation.getStartReservationTime());
        reservation1.setEndReservationTime(reservation.getEndReservationTime());
    }
}
