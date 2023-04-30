package com.gtbackend.gtbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@IdClass(TicketSeatsId.class)
@Entity
@Table(name = "ticket_seats")
public class TicketSeats {


//    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "ticketID")
    private Ticket ticketID;
    @Id
    private String seatNumber;

    public TicketSeats(){}
    public TicketSeats(Ticket ticketID, String seatNumber) {
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
    }

    public Ticket getTicketID() {
        return ticketID;
    }

    public void setTicketID(Ticket ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}

