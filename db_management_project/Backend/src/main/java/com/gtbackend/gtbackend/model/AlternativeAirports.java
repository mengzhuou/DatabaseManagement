package com.gtbackend.gtbackend.model;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
// import org.springframework.format.annotation.*;

// import java.time.LocalTime;

@Entity
@Table(name = "alternative_airports")
public class AlternativeAirports {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "num_airports")
    private int num_airports;

    @Column(name = "airport_code_list")
    private String airport_code_list;

    @Column(name = "airport_name_list")
    private String airport_name_list;

    //getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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

    public int getNumAirports(){
        return num_airports;
    }

    public void setNumAirports(int num_airports){
        this.num_airports = num_airports;
    }

    public String getAirportCodeList(){
        return airport_code_list;
    }

    public void setAirportCodeList(String airport_code_list){
        this.airport_code_list = airport_code_list;
    }

    public String getAirportNameList(){
        return airport_name_list;
    }

    public void setAirportNameList(String airport_name_list){
        this.airport_name_list = airport_name_list;
    }
}
