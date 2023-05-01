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
    private String seat_number;

    public TicketSeats() {
    }

    public TicketSeats(String ticketID, String seat_number) {
        this.ticketID = ticketID;
        this.seat_number = seat_number;
    }

    public String getTicket() {
        return ticketID;
    }

    public void setTicket(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seat_number;
    }

    public void setSeatNumber(String seat_number) {
        this.seat_number = seat_number;
    }
}

