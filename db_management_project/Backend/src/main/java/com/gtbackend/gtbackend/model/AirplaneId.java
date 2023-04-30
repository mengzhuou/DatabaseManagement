package com.gtbackend.gtbackend.model;

import java.io.Serializable;

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
}
