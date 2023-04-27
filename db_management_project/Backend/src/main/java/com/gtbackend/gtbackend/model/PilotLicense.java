package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "pilot_licenses")
public class PilotLicense extends Pilot{
    @Id
    @Column(name = "personID")
    private String personID;

    @Id
    @Column(name = "license")
    private String license;

    public String getPersonID(){
        return personID;
    }

    public void setPersonID(String personID){
        this.personID = personID;
    }

    public String getLicense(){
        return license;
    }

    public void setLicense(String license){
        this.license = license;
    }
}