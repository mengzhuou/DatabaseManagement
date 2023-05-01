package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @Column(name = "routeID")
    private String routeID;

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }
}
