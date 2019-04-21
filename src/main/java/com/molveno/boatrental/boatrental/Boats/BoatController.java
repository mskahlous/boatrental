package com.molveno.boatrental.boatrental.Boats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BoatController {
    @Autowired
    BoatRepository boatRepository;
    @RequestMapping(value = "/get-boats" , method = RequestMethod.GET)
    public List<Boat> getBoat(){
        return boatRepository.findAll();
    }

    @RequestMapping (value = "/add-boat", method = RequestMethod.POST,consumes = "application/json" )
    public void saveBoat(@RequestBody Boat boat) {boatRepository.save(boat);}

    @RequestMapping (value = "/delete-boat",method = RequestMethod.DELETE)
    public void deleteBoat(@RequestParam long id) {boatRepository.deleteById(id);}

    @RequestMapping (value = "edit-boat", method = RequestMethod.POST,consumes = "application/json" )
    public void editBoat(@RequestBody Boat boat) {
        Boat boat1 =  boatRepository.findById(boat.getId());
        boat1.setBoatNumber(boat.getBoatNumber());
        boat1.setBoatNumberOfSeats(boat.getBoatNumberOfSeats());
        boat1.setBoatType(boat.getBoatType());
        boat1.setHourPrice(boat.getHourPrice());
        boat1.setChargingTime(boat.getChargingTime());
    }
}
