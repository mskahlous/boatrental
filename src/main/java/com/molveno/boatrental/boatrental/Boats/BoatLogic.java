package com.molveno.boatrental.boatrental.Boats;

import com.molveno.boatrental.boatrental.Reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class BoatLogic {
    public static List<Boat> getAvaBoats( List<Reservation> reservations, List<Boat> boats1){

        List<Boat> usedBoats = new ArrayList<>();

//        usedBoats now

        for (Reservation r : reservations) {
            if (r.getStatus().equals("In Progress")) {
                usedBoats.add(r.getBoat());
            }

        }




//        Check available boats
        boats1.removeIf((boat -> (usedBoats.contains(boat))));
        if (boats1.isEmpty()) {
            System.out.println("No Boats Available");
        }
//        Start trip

        boats1.removeIf(boat -> boat.getStatus().equals("Blocked"));


        return  boats1;

    }

}
