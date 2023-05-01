package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.time.LocalTime;
import org.springframework.format.annotation.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flights_in_the_air")
public class FlightInTheAir {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departing_from")
    private String departingFrom;

    @Column(name = "arriving_at")
    private String arrivingAt;

    @Column(name = "num_flights")
    private int numFlights;

    @Column(name = "flight_list")
    private String flightList;

    @Column(name = "earliest_arrival")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime earliestArrival;

    @Column(name = "latest_arrival")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime latestArrival;

    @Column(name = "airplane_list")
    private String airplaneList;

    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDepartingFrom() {
        return departingFrom;
    }
    
    public void setDepartingFrom(String departingFrom) {
        this.departingFrom = departingFrom;
    }
    
    public String getArrivingAt() {
        return arrivingAt;
    }
    
    public void setArrivingAt(String arrivingAt) {
        this.arrivingAt = arrivingAt;
    }
    
    public int getNumFlights() {
        return numFlights;
    }
    
    public void setNumFlights(int numFlights) {
        this.numFlights = numFlights;
    }
    
    public String getFlightList() {
        return flightList;
    }
    
    public void setFlightList(String flightList) {
        this.flightList = flightList;
    }
    
    public LocalTime getEarliestArrival() {
        return earliestArrival;
    }
    
    public void setEarliestArrival(LocalTime earliestArrival) {
        this.earliestArrival = earliestArrival;
    }
    
    public LocalTime getLatestArrival() {
        return latestArrival;
    }
    
    public void setLatestArrival(LocalTime latestArrival) {
        this.latestArrival = latestArrival;
    }
    
    public String getAirplaneList() {
        return airplaneList;
    }
    
    public void setAirplaneList(String airplaneList) {
        this.airplaneList = airplaneList;
    }

    
    
    
}
