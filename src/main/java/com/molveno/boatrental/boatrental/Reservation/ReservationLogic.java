package com.molveno.boatrental.boatrental.Reservation;

import com.molveno.boatrental.boatrental.Boats.Boat;
import com.molveno.boatrental.boatrental.Boats.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ReservationLogic {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    BoatRepository boatRepository;

    public static   void statTrip(Reservation reservation,List<Reservation> reservations,List<Boat> boats1) {
//
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




System.out.println(boats1);
        for (Boat b : boats1){
            if (b.getBoatNumberOfSeats()>=reservation.getNumOfPerson() ){
                reservation.setBoat(b);
                reservation.setStatus("In Progress");
                reservation.setStartReservationTime(LocalDateTime.now());
                return ;
            }
        }

    }

//    Stop trip

    public static void stopTrip (Reservation reservation){
        reservation.setEndReservationTime(LocalDateTime.now());
        reservation.setStatus("Ended");
//        ----Get trip duration----
//        Get time
        double endTime = reservation.getEndReservationTime().toLocalTime().getSecond();
        double startTime = reservation.getStartReservationTime().toLocalTime().getSecond();
//        Convert to hours
        double endTimeReservation = endTime / 3600;
        double startTimeReservation = startTime / 3600;
        double duration = endTimeReservation - startTimeReservation ;
        reservation.setDuration(duration);
//        Get trip cost
        double tripCost = duration * reservation.getBoat().getHourPrice();
        tripCost =tripCost*100;
        tripCost=Math.round(tripCost);
        tripCost=tripCost/100;
        reservation.setCost(tripCost);
    }


    public static List<Reservation> getInProgressTrips(List<Reservation> reservations){
        reservations.removeIf(reservation -> (!reservation.getStatus().equals("In Progress")));

        return reservations;

    }

}
