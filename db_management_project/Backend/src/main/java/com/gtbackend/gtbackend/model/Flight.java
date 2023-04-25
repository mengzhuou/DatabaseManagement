package com.gtbackend.gtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "flightID")
    private String flightID;

    @Column(name = "routeID")
    private String routeID;

    @Column(name = "support_airline")
    private String supportAirline;

    @Column(name = "support_tail")
    private String supportTail;

    @Column(name = "progress")
    private int progress;

    @Column(name = "airplane_status")
    private String airplaneStatus;

    @Column(name = "next_time")
    private LocalTime nextTime;

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getSupportAirline() {
        return supportAirline;
    }

    public void setSupportAirline(String supportAirline) {
        this.supportAirline = supportAirline;
    }

    public String getSupportTail() {
        return supportTail;
    }

    public void setSupportTail(String supportTail) {
        this.supportTail = supportTail;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getAirplaneStatus() {
        return airplaneStatus;
    }

    public void setAirplaneStatus(String airplaneStatus) {
        this.airplaneStatus = airplaneStatus;
    }

    public LocalTime getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalTime nextTime) {
        this.nextTime = nextTime;
    }
}
