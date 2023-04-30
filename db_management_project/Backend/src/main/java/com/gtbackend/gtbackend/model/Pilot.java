package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pilot")
public class Pilot extends Person{

    @Column(name = "taxID")
    private String taxID;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "flying_airline")
    private String flying_airline;

    @Column(name = "flying_tail")
    private String flying_tail;

    public Pilot() {
    }

    public Pilot(String personID, String first_name, String last_name, String locationID, String taxID, Integer experience, String flying_airline, String flying_tail) {
        super(personID, first_name, last_name, locationID);
        this.taxID = taxID;
        this.experience = experience;
        this.flying_airline = flying_airline;
        this.flying_tail = flying_tail;
    }

    public String getTaxID(){
        return taxID;
    }

    public void setTaxID(String taxID){
        this.taxID = taxID;
    }

    public Integer getExperience(){
        return experience;
    }

    public void setExperience(Integer experience){
        this.experience = experience;
    }

    public String getFlying_airline(){
        return flying_airline;
    }

    public void setFlying_airline(String flying_airline){
        this.flying_airline = flying_airline;
    }

    public String getFlying_tail(){
        return flying_tail;
    }

    public void setFlying_tail(String flying_tail){
        this.flying_tail = flying_tail;
    }

}
