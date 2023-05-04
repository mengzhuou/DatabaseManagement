package com.gtbackend.gtbackend.model;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
// import org.springframework.format.annotation.*;

// import java.time.LocalTime;


@Entity
@Table (name = "route_summary")
public class RouteSummary {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "route")
    private String route;

    @Column(name = "num_legs")
    private int num_legs;

    @Column(name = "leg_sequence")
    private String leg_sequence;

    @Column(name = "route_length")
    private int route_length;

    @Column(name = "num_flights")
    private int num_flights;

    @Column(name = "flight_list")
    private String flight_list;

    @Column(name = "airport_sequence")
    private String airport_sequence;

    //getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute(){
        return route;
    }

    public void setRoute(String route){
        this.route = route;
    }
    
    public int getNumLegs(){
        return num_legs;
    }

    public void setNumLegs(int num_legs){
        this.num_legs = num_legs;
    }

    public String getLegSequence(){
        return leg_sequence;
    }

    public void setLegSequence(String leg_sequence){
        this.leg_sequence = leg_sequence;
    }

    public int getRouteLength(){
        return route_length;
    }

    public void setRouteLength(int route_length){
        this.route_length = route_length;
    }

    public int getNumFlights(){
        return num_flights;
    }

    public void setNumFlights(int num_flights){
        this.num_flights = num_flights;
    }

    public String getFlightList(){
        return flight_list;
    }

    public void setFlightList(String flight_list){
        this.flight_list = flight_list;
    }

    public String getAirportSequence(){
        return airport_sequence;
    }

    public void setAirportSequence(String airport_sequence){
        this.airport_sequence = airport_sequence;
    }
}
