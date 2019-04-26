package com.molveno.boatrental.boatrental.Guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class GuestController {
    @Autowired
    GuestRepository guestRepository;
    @RequestMapping(value = "/get-guest" , method = RequestMethod.GET)
    public List<Guest> getGuest(){
        return guestRepository.findAll();
    }
    @RequestMapping(value = "/add-guest", method = RequestMethod.POST, consumes = "application/json")
    public void addGuest (@RequestBody Guest guest){
        List<Guest> guests = guestRepository.findAll();
        guestRepository.save(guest);
    }

}
