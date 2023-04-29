package com.gtbackend.gtbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "pilot_licenses")
public class PilotLicenses {

    @EmbeddedId
    private PilotLicensesId id;

    @ManyToOne
    @MapsId("personID")
    @JoinColumn(name = "personID")
    @JsonIgnore
    private Pilot pilot;

    public PilotLicenses(){

    }

    public PilotLicenses(PilotLicensesId id, Pilot pilot) {
        this.id = id;
        this.pilot = pilot;
    }

//    @JsonIgnore
    public PilotLicensesId getId() {
        return id;
    }

    public void setId(PilotLicensesId id) {
        this.id = id;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @JsonIgnore
    public String getLicense() {
        return id.getLicense();
    }

    public void setLicense(String license) {
        id.setLicense(license);
    }
}
