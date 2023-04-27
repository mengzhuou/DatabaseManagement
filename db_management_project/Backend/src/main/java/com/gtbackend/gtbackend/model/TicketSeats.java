package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket_seats")
public class TicketSeats extends Ticket{
    @Id
    @Column(name = "ticketID")
    private String ticketID;

    @Id
    @Column(name = "seat_number")
    private String seat_number;

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seat_number;
    }

    public void setSeatNumber(String seatNumber) {
        this.seat_number = seatNumber;
    }
}