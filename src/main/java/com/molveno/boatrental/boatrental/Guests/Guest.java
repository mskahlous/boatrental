package com.molveno.boatrental.boatrental.Guests;

import javax.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column (name = "name")
    private String name;
    @Column (name = "idtype")
    private String idType;
    @Column (name = "idnumber")
    private int idNumber;
    @Column (name = "phonenumber")
    private String phoneNumber;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIdType() { return idType; }
    public void setIdType(String idType) { this.idType = idType; }

    public int getIdNumber() { return idNumber; }
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
