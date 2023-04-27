package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "route_path")
public class RoutePath extends Route{
    @Id
    @Column(name = "routeID")
    private String routeID;

    @Id
    @Column(name = "legID")
    private String legID;

    @Id
    @Column(name = "sequence")
    private int sequence;

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getLegID() {
        return legID;
    }

    public void setLegID(String legID) {
        this.legID = legID;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}