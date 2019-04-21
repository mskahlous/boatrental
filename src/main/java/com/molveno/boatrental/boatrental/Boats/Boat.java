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
    private int boatNumberOfSeats =10 ;
    @Column
    private double hourPrice;

    private double chargingTime;

    public String getStatus() { return status;}

    public void setStatus(String status) { this.status = status; }

    @Column (name = "status")
    private String status = "";


    public double getChargingTime() { return chargingTime; }

    public void setChargingTime(double chargingTime) { this.chargingTime = chargingTime; }

    public double getHourPrice() {return hourPrice; }
    public void setHourPrice(double hourPrice) { this.hourPrice = hourPrice;}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getBoatNumberOfSeats() { return boatNumberOfSeats; }
    public void setBoatNumberOfSeats(int boatNumberOfSeats) { this.boatNumberOfSeats = boatNumberOfSeats; }

    public String getBoatType() { return boatType; }
    public void setBoatType(String boatType) { this.boatType = boatType; }

    public int getBoatNumber() { return boatNumber; }
    public void setBoatNumber(int boatNumber) { this.boatNumber = boatNumber; }
}
