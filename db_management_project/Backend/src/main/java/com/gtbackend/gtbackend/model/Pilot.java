package com.gtbackend.gtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pilot")
public class Pilot extends Person{

    @Id
    @Column(name = "personID")
    private String personID;

    @Column(name = "taxID")
    private String taxID;

    @Column(name = "experience")
    private int experience;

    @Column(name = "flying_airline")
    private String flying_airline;

    @Column(name = "flying_tail")
    private String flying_tail;

    //personID
    public String getPersonID(){
        return personID;
    }

    public void setPersonID(String personID){
        this.personID = personID;
    }

    //taxID
    public String getTaxID(){
        return taxID;
    }

    public void setTaxID(String taxID){
        this.taxID = taxID;
    }

    //experience
    public int getExperience(){
        return experience;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    //flying_airline
    public String getFlying_airline(){
        return flying_airline;
    }

    public void setFlying_airline(String flying_airline){
        this.flying_airline = flying_airline;
    }

    //flying_tail
    public String getFlying_tail(){
        return flying_tail;
    }

    public void setFlying_tail(String flying_tail){
        this.flying_tail = flying_tail;
    }
}