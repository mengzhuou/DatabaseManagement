package com.gtbackend.gtbackend.model;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
// import org.springframework.format.annotation.*;

// import java.time.LocalTime;

@Entity
@Table(name = "people_on_the_ground")
public class PeopleOnTheGround {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departing_from")
    private String departingFrom;

    @Column(name = "airport")
    private String airport;

    @Column(name = "airport_name")
    private String airport_name;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "num_pilots")
    private int num_pilots;

    @Column(name = "num_passengers")
    private int num_passengers;

    @Column(name = "joint_pilots_passengers")
    private int joint_pilots_passengers;

    @Column(name = "person_list")
    private String person_list;

    //getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDepartingFrom(){
        return departingFrom;
    }

    public void setDepartingFrom(String departingFrom){
        this.departingFrom = departingFrom;
    }

    public String getAirport(){
        return airport;
    }

    public void setAirport(String airport){
        this.airport = airport;
    }

    public String getAirportName(){
        return airport_name;
    }

    public void setAirportName(String airport_name){
        this.airport_name = airport_name;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public int getNumPilots(){
        return num_pilots;
    }

    public void setNumPilots(int num_pilots){
        this.num_pilots = num_pilots;
    }

    public int getNumPassengers(){
        return num_passengers;
    }

    public void setNumPassengers(int num_passengers){
        this.num_passengers = num_passengers;
    }

    public int getJointPilotsPassengers(){
        return joint_pilots_passengers;
    }

    public void setJointPilotsPassengers(int joint_pilots_passengers){
        this.joint_pilots_passengers = joint_pilots_passengers;
    }

    public String getPersonList(){
        return person_list;
    }

    public void setPersonList(String person_list){
        this.person_list = person_list;
    }
}
