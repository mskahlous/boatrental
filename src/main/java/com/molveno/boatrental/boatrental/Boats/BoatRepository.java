package com.molveno.boatrental.boatrental.Boats;

import com.molveno.boatrental.boatrental.Reservation.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface BoatRepository extends CrudRepository <Boat,Long> {
    List<Boat> findAll();
    Boat findById (long id);
}
