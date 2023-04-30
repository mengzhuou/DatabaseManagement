package com.gtbackend.gtbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class TicketSeatsId implements Serializable {

    private String ticketID;
    private String seat_number;

    public TicketSeatsId(String ticketID, String seat_number) {
        this.ticketID = ticketID;
        this.seat_number = seat_number;
    }

    public TicketSeatsId(){}
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seat_number;
    }

    public void setSeatNumber(String seat_number) {
        this.seat_number = seat_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketSeatsId that = (TicketSeatsId) o;
        return Objects.equals(ticketID, that.ticketID) && Objects.equals(seat_number, that.seat_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, seat_number);
    }
}


