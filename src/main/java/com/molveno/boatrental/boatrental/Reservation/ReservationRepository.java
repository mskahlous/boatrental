package com.molveno.boatrental.boatrental.Reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAll();
    Reservation findById(long id);
}
