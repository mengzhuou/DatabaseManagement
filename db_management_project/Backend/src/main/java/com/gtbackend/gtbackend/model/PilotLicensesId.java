package com.gtbackend.gtbackend.model;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
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

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PilotLicensesId that = (PilotLicensesId) o;
        return personID.equals(that.personID) && license.equals(that.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID, license);
    }
}
