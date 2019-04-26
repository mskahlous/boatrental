package com.molveno.boatrental.boatrental.Guests;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface GuestRepository extends CrudRepository<Guest,Long> {
    List<Guest> findAll ();
}
