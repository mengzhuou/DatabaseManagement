package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@DiscriminatorValue("PASSENGER")
public class Passenger extends Person{
    @Column(name = "miles")
    private int miles;

    public int getMiles(){
        return miles;
    }

    public void setMiles(int miles){
        this.miles = miles;
    }
}