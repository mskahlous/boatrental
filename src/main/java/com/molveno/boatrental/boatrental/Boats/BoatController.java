package com.molveno.boatrental.boatrental.Boats;

import com.molveno.boatrental.boatrental.Reservation.Reservation;
import com.molveno.boatrental.boatrental.Reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoatController {
    @Autowired
    BoatRepository boatRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value = "/get-boats", method = RequestMethod.GET)
    public List<Boat> getBoat() {
        return boatRepository.findAll();
    }

    @RequestMapping(value = "/add-boat", method = RequestMethod.POST, consumes = "application/json")
    public boolean saveBoat(@RequestBody Boat boat) {
        for (Boat b : boatRepository.findAll()) {
            if (b.getBoatNumber() == boat.getBoatNumber()) {
                return false;
            }

        }

        boatRepository.save(boat);
        return true;
    }

    @RequestMapping(value = "/delete-boat", method = RequestMethod.DELETE)
    public void deleteBoat(@RequestParam long id) {
        System.out.println(id);
        boatRepository.deleteById(id);
    }

    @RequestMapping(value = "edit-boat", method = RequestMethod.POST, consumes = "application/json")
    public void editBoat(@RequestBody Boat boat) {
        Boat boat1 = boatRepository.findById(boat.getId());
        boat1.setBoatNumber(boat.getBoatNumber());
        boat1.setBoatNumberOfSeats(boat.getBoatNumberOfSeats());
//        boat1.setBoatType(boat.getBoatType());
        boat1.setHourPrice(boat.getHourPrice());
//        boat1.setChargingTime(boat.getChargingTime());
    }

    @RequestMapping(value = "block-boat", method = RequestMethod.POST, consumes = "application/json")
    public void blockBoat(@RequestBody Boat boat) {
        Boat boat1 = boatRepository.findById(boat.getId());

        boat1.setStatus("Blocked");
    }
    @RequestMapping(value = "get-ava-boats", method = RequestMethod.GET)
    public int getAvaBoats( ) {
        List<Reservation> reservations = reservationRepository.findAll();
        List<Boat> boats = boatRepository.findAll();
        List<Boat> boats1 = BoatLogic.getAvaBoats(reservations,boats);
        System.out.println(boats1.size());
        return boats1.size();

    }


}
