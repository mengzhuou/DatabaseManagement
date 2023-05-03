package com.gtbackend.gtbackend.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.*;

import java.time.LocalTime;

@Entity
@Table(name = "people_in_the_air")
public class PeopleInTheAir {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departing_from")
    private String departingFrom;

    @Column(name = "arriving_at")
    private String arrivingAt;

    @Column(name = "num_airplanes")
    private int numAirplanes;

    @Column(name = "airplane_list")
    private String airplaneList;

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

    @Column(name = "num_pilots")
    private int numPilots;

    @Column(name = "num_passengers")
    private int numPassengers;

    @Column(name = "joint_pilots_passengers")
    private int jointPilotsPassengers;

    @Column(name = "person_list")
    private String personList;

        // getters
        public Long getId() {
            return id;
        }
    
        public String getDepartingFrom() {
            return departingFrom;
        }
    
        public String getArrivingAt() {
            return arrivingAt;
        }
    
        public int getNumAirplanes() {
            return numAirplanes;
        }
    
        public String getAirplaneList() {
            return airplaneList;
        }
    
        public String getFlightList() {
            return flightList;
        }
    
        public LocalTime getEarliestArrival() {
            return earliestArrival;
        }
    
        public LocalTime getLatestArrival() {
            return latestArrival;
        }
    
        public int getNumPilots() {
            return numPilots;
        }
    
        public int getNumPassengers() {
            return numPassengers;
        }
    
        public int getJointPilotsPassengers() {
            return jointPilotsPassengers;
        }
    
        public String getPersonList() {
            return personList;
        }
    
        // setters
        public void setDepartingFrom(String departingFrom) {
            this.departingFrom = departingFrom;
        }
    
        public void setArrivingAt(String arrivingAt) {
            this.arrivingAt = arrivingAt;
        }
    
        public void setNumAirplanes(int numAirplanes) {
            this.numAirplanes = numAirplanes;
        }
    
        public void setAirplaneList(String airplaneList) {
            this.airplaneList = airplaneList;
        }
    
        public void setFlightList(String flightList) {
            this.flightList = flightList;
        }
    
        public void setEarliestArrival(LocalTime earliestArrival) {
            this.earliestArrival = earliestArrival;
        }
    
        public void setLatestArrival(LocalTime latestArrival) {
            this.latestArrival = latestArrival;
        }
    
        public void setNumPilots(int numPilots) {
            this.numPilots = numPilots;
        }
    
        public void setNumPassengers(int numPassengers) {
            this.numPassengers = numPassengers;
        }
    
        public void setJointPilotsPassengers(int jointPilotsPassengers) {
            this.jointPilotsPassengers = jointPilotsPassengers;
        }
    
        public void setPersonList(String personList) {
            this.personList = personList;
        }
}
