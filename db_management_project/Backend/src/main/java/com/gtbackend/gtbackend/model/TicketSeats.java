package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket_seats")
@IdClass(TicketSeatsId.class)
public class TicketSeats {

    @Id
    @Column(name = "ticketID")
    private String ticketID;

    @Id
    @Column(name = "seat_number")
    private String seatNumber;

    public TicketSeats() {
    }

    public TicketSeats(String ticketID, String seatNumber) {
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
    }

    public String getTicket() {
        return ticketID;
    }

    public void setTicket(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}

