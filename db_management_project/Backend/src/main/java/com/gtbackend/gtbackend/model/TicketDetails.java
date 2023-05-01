package com.gtbackend.gtbackend.model;

public class TicketDetails {
    private Ticket ticket;
    private TicketSeats ticketSeats;

    public TicketDetails() {}

    public TicketDetails(Ticket ticket, TicketSeats ticketSeats) {
        this.ticket = ticket;
        this.ticketSeats = ticketSeats;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketSeats getTicketSeats() {
        return ticketSeats;
    }

    public void setTicketSeats(TicketSeats ticketSeats) {
        this.ticketSeats = ticketSeats;
    }
}
