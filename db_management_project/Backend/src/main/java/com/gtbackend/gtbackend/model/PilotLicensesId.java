package com.gtbackend.gtbackend.model;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotLicensesId that = (PilotLicensesId) o;
        return Objects.equals(personID, that.personID) && Objects.equals(license, that.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID, license);
    }

}
