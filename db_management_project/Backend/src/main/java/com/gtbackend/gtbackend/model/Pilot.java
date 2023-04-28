package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pilot")
@DiscriminatorValue("PILOT")
public class Pilot extends Person{

    @Column(name = "taxID")
    private String taxID;

    @Column(name = "experience")
    private int experience;

    @Column(name = "flying_airline")
    private String flying_airline;

    @Column(name = "flying_tail")
    private String flying_tail;

    @ElementCollection
    @CollectionTable(name = "pilot_licenses", joinColumns = @JoinColumn(name = "personID"))
    @Column(name = "license")
    private List<String> licenses;

    public String getTaxID(){
        return taxID;
    }

    public void setTaxID(String taxID){
        this.taxID = taxID;
    }

    public int getExperience(){
        return experience;
    }

    public void setExperience(int experience){
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

    // Getter and setter for licenses
    public List<String> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<String> licenses) {
        this.licenses = licenses;
    }
}
