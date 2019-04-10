package com.molveno.boatrental.boatrental.Boats;

import javax.persistence.*;

@Entity
@Table (name = "Boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    @Column
    private String boatType;
    @Column
    private int boatNumber;
    @Column
    private int boatNumberOfSeats;
    @Column
    private double hourPrice;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public double getTripPrice() { return hourPrice; }
    public void setTripPrice(double tripPrice) {this.hourPrice = tripPrice; }

    public int getBoatNumberOfSeats() { return boatNumberOfSeats; }
    public void setBoatNumberOfSeats(int boatNumberOfSeats) { this.boatNumberOfSeats = boatNumberOfSeats; }

    public String getBoatType() { return boatType; }
    public void setBoatType(String boatType) { this.boatType = boatType; }

    public int getBoatNumber() { return boatNumber; }
    public void setBoatNumber(int boatNumber) { this.boatNumber = boatNumber; }
}
