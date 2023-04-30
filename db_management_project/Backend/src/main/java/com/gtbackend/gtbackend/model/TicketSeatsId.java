package com.gtbackend.gtbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class TicketSeatsId implements Serializable {

    private String ticketID;
    private String seatNumber;

    public TicketSeatsId(String ticketID, String seatNumber) {
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
    }

    public TicketSeatsId(){}
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketSeatsId that = (TicketSeatsId) o;
        return Objects.equals(ticketID, that.ticketID) && Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, seatNumber);
    }
}


