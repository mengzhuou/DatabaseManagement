package com.gtbackend.gtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger extends Person{
    @Id
    @Column(name = "personID")
    private String personID;

    @Column(name = "miles")
    private int miles;

    //personID
    public String getPersonID(){
        return personID;
    }

    public void setPersonID(String personID){
        this.personID = personID;
    }

    //miles
    public int getMiles(){
        return miles;
    }

    public void setMiles(int miles){
        this.miles = miles;
    }
}