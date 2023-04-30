package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @Column(name = "routeID")
    private String routeID;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RoutePath> routePaths;

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public List<RoutePath> getRoutePaths() {
        return routePaths;
    }

    public void setRoutePaths(List<RoutePath> routePaths) {
        this.routePaths = routePaths;
    }
}
