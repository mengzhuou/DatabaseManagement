package com.gtbackend.gtbackend.model;

public class RouteDetails {

    private Route route;
    private RoutePath routePath;

    public RouteDetails() {}

    public RouteDetails(Route route, RoutePath routePath) {
        this.route = route;
        this.routePath = routePath;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public RoutePath getRoutePath() {
        return routePath;
    }

    public void setRoutePath(RoutePath routePath) {
        this.routePath = routePath;
    }
}
