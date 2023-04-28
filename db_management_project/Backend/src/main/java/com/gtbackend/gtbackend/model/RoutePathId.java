package com.gtbackend.gtbackend.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RoutePathId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "routeID")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "legID")
    private Leg leg;

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
