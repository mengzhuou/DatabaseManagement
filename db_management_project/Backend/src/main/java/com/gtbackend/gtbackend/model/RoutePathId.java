package com.gtbackend.gtbackend.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutePathId that = (RoutePathId) o;

        if (!Objects.equals(route, that.route)) return false;
        return Objects.equals(leg, that.leg);
    }

    @Override
    public int hashCode() {
        int result = route != null ? route.hashCode() : 0;
        result = 31 * result + (leg != null ? leg.hashCode() : 0);
        return result;
    }
}
