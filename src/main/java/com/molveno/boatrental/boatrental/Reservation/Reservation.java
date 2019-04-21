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
    @Column (name = "tripcost")
    private double cost = 10;
    @Column (name = "status")
    private String status = "";
    @Column (name = "Duration")
    private double duration;

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    private int numOfPerson =5;

    public int getNumOfPerson() {
        return numOfPerson;
    }

    public void setNumOfPerson(int numOfPerson) {
        this.numOfPerson = numOfPerson;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {  this.status = status;   }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }


    public LocalDateTime getStartReservationTime() { return startReservationTime;    }
    public void setStartReservationTime(LocalDateTime startReservationTime) { this.startReservationTime = startReservationTime;    }

    public LocalDateTime getEndReservationTime() { return endReservationTime;    }
    public void setEndReservationTime(LocalDateTime endReservationTime) {this.endReservationTime = endReservationTime;    }

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
