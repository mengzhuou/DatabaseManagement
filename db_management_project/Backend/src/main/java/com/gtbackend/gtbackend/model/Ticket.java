package com.gtbackend.gtbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "ticketID")
    private String ticketID;

    @Column(name = "cost")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "carrier", referencedColumnName = "flightID")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "personID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "deplane_at", referencedColumnName = "airportID")
    private Airport airport;

    @ElementCollection
    @CollectionTable(name = "ticket_seats", joinColumns = @JoinColumn(name = "ticketID"))
    @Column(name = "seat_number")
    private List<String> seats;

    // Getters and setters for all fields
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
