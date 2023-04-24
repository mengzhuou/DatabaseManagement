package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name="airline")
public class Airline {
    @Id
    private String airlineID;
    @Column(name = "revenue", columnDefinition = "INT DEFAULT null", nullable = true)
    private Integer revenue;

    public String getAirlineID() { return airlineID; }
    public void setAirlineID(String airlineID) { this.airlineID = airlineID; }
    public int getRevenue() { return revenue; }
    public void setRevenue(int revenue) { this.revenue = revenue; }
}

