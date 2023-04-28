package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "route_path")
public class RoutePath {
    @Id
    @ManyToOne
    @JoinColumn(name = "routeID")
    private Route route;

    @Id
    @ManyToOne
    @JoinColumn(name = "legID")
    private Leg leg;

    @Column(name = "sequence")
    private int sequence;

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

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
