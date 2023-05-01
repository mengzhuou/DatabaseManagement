package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "route_path")
@IdClass(RoutePathId.class)
public class RoutePath implements Serializable {

    @Id
    @Column(name = "routeID")
    private String routeID;

    @Id
    @Column(name = "legID")
    private String legID;

    @Column(name = "sequence")
    private int sequence;

    public RoutePath() {
    }

    public RoutePath(String routeID, String legID, int sequence) {
        this.routeID = routeID;
        this.legID = legID;
        this.sequence = sequence;
    }

    public String getRouteID() {
        return routeID;
    }

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
