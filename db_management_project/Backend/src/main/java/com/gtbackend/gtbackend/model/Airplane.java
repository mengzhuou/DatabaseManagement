package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name="airplane")
@IdClass(AirplaneId.class)
public class Airplane extends AirplaneId {
    @Id
    @Column(name = "airlineID", nullable = false)
    private String airlineID;

    @Id
    @Column(name = "tail_num", nullable = false)
    private String tail_num;

    @Column(name = "seat_capacity")
    private Integer seat_capacity;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "locationID")
    private String locationID;

    @Column(name = "plane_type")
    private String plane_type;

    @Column(name = "skids")
    private Integer skids;

    @Column(name = "propellers")
    private Integer propellers;

    @Column(name = "jet_engines")
    private Integer jet_engines;

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

    public Integer getSeat_capacity() {
        return seat_capacity;
    }

    public void setSeat_capacity(Integer seat_capacity) {
        this.seat_capacity = seat_capacity;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getPlane_type() {
        return plane_type;
    }

    public void setPlane_type(String plane_type) {
        this.plane_type = plane_type;
    }

    public Integer getSkids() {
        return skids;
    }

    public void setSkids(Integer skids) {
        this.skids = skids;
    }

    public Integer getPropellers() {
        return propellers;
    }

    public void setPropellers(Integer propellers) {
        this.propellers = propellers;
    }

    public Integer getJet_engines() {
        return jet_engines;
    }

    public void setJet_engines(Integer jet_engines) {
        this.jet_engines = jet_engines;
    }
}

