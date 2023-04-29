package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger extends Person{
    @Column(name = "miles")
    private Integer miles;

    public Integer getMiles(){
        return miles;
    }

    public void setMiles(Integer miles){
        this.miles = miles;
    }
}