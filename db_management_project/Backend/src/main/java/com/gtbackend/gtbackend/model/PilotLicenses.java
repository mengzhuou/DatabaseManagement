package com.gtbackend.gtbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@IdClass(PilotLicensesId.class)
@Entity
@Table(name = "pilot_licenses")
public class PilotLicenses {

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "personID")
    private Pilot personID;

    @Id
    @Column(name = "license")
    private String license;

    public PilotLicenses() {
    }

    public PilotLicenses(Pilot personID, String license) {
        this.personID = personID;
        this.license = license;
    }

    @JsonIgnore
    public Pilot getPersonID() {
        return personID;
    }

    public void setPersonID(Pilot personID) {
        this.personID = personID;
    }

    @JsonProperty("license")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @JsonProperty("personID")
    public String getPersonIDString() {
        return personID.getPersonID();
    }
}
