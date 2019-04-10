package com.molveno.boatrental.boatrental.Reservation;

import com.molveno.boatrental.boatrental.Boats.Boat;
import com.molveno.boatrental.boatrental.Guests.Guest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table (name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column
    private long id;
    @Column (name = "startreservationtime")
    private LocalDateTime startReservationTime;
    @Column (name = "endreservationtime")
    private LocalDateTime endReservationTime;

    public LocalDateTime getStartReservationTime() {
        return startReservationTime;
    }

    public void setStartReservationTime(LocalDateTime startReservationTime) {
        this.startReservationTime = startReservationTime;
    }

    public LocalDateTime getEndReservationTime() {
        return endReservationTime;
    }

    public void setEndReservationTime(LocalDateTime endReservationTime) {
        this.endReservationTime = endReservationTime;
    }

    @OneToOne
    @JoinColumn(name = "guestid",referencedColumnName = "id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "boatid",referencedColumnName = "id")
    private Boat boat;


    public Boat getBoat() { return boat; }
    public void setBoat(Boat boat) { this.boat = boat; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }



    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

}
