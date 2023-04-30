package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger extends Person{
    @Column(name = "miles")
    private Integer miles;


    public Passenger() {
    }

    public Passenger(String personID, String first_name, String last_name, String locationID, Integer miles) {
        super(personID, first_name, last_name, locationID);
        this.miles = miles;
    }

    public Integer getMiles(){
        return miles;
    }

    public void setMiles(Integer miles){
        this.miles = miles;
    }
}