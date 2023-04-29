package com.gtbackend.gtbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class AirplaneId implements Serializable {
    private String airlineID;
    private String tail_num;

    public AirplaneId() {}

    public AirplaneId(String airlineID, String tail_num) {
        this.airlineID = airlineID;
        this.tail_num = tail_num;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getTail_num() {
        return tail_num;
    }

    public void setTail_num(String tail_num) {
        this.tail_num = tail_num;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirplaneId that = (AirplaneId) o;

        if (!Objects.equals(tail_num, that.tail_num)) return false;
        return Objects.equals(airlineID, that.airlineID);
    }

    @Override
    public int hashCode() {
        int result = tail_num != null ? tail_num.hashCode() : 0;
        result = 31 * result + (airlineID != null ? airlineID.hashCode() : 0);
        return result;
    }
}
