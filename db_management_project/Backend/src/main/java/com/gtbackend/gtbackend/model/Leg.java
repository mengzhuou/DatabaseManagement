package com.gtbackend.gtbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "leg")
public class Leg {
    @Id
    private String legID;
    private int distance;
    private String departure;
    private String arrival;

    public String getLegID() {
        return legID;
    }

    public void setLegID(String legID) {
        this.legID = legID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
}
