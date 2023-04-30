package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "route_path")
public class RoutePath implements Serializable {
    @EmbeddedId
    private RoutePathId id;

    @Column(name = "sequence")
    private int sequence;

    @MapsId("route") // Change to the property name of RoutePathId class
    @ManyToOne
    @JoinColumn(name = "routeID")
    private Route route;

    @MapsId("leg") // Change to the property name of RoutePathId class
    @ManyToOne
    @JoinColumn(name = "legID")
    private Leg leg;

    public RoutePathId getId() {
        return id;
    }

    public void setId(RoutePathId id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }
}
