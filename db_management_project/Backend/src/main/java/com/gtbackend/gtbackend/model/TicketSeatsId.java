package com.gtbackend.gtbackend.model;

import java.io.Serializable;

public class TicketSeatsId implements Serializable {

    private String ticketID;
    private String seatNumber;

    public TicketSeatsId(String ticketID, String seatNumber) {
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}


