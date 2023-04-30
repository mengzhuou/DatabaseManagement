package com.gtbackend.gtbackend.model;

import javax.persistence.*;
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
    private String support_airline;

    @Column(name = "support_tail")
    private String support_tail;

    @Column(name = "progress")
    private Integer progress;

    @Column(name = "airplane_status")
    private String airplane_status;

    @Column(name = "next_time")
    private LocalTime next_time;

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

    public String getSupport_airline() {
        return support_airline;
    }

    public void setSupport_airline(String support_airline) {
        this.support_airline = support_airline;
    }

    public String getSupport_tail() {
        return support_tail;
    }

    public void setSupport_tail(String support_tail) {
        this.support_tail = support_tail;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getAirplane_status() {
        return airplane_status;
    }

    public void setAirplane_status(String airplane_status) {
        this.airplane_status = airplane_status;
    }

    public LocalTime getNext_time() {
        return next_time;
    }

    public void setNext_time(LocalTime next_time) {
        this.next_time = next_time;
    }
}
