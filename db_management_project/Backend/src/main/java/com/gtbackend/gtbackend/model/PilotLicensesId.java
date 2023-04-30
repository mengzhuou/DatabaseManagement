package com.gtbackend.gtbackend.model;

import java.io.Serializable;

public class PilotLicensesId implements Serializable {

    private String personID;
    private String license;

    public PilotLicensesId() {
    }

    public PilotLicensesId(String personID, String license) {
        this.personID = personID;
        this.license = license;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
