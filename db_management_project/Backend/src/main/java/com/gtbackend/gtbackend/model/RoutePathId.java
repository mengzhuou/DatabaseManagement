package com.gtbackend.gtbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class RoutePathId implements Serializable {

    private String routeID;

    private String legID;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoutePathId)) return false;
        RoutePathId that = (RoutePathId) o;
        return Objects.equals(routeID, that.routeID) &&
                Objects.equals(legID, that.legID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeID, legID);
    }
}
