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

    @JoinColumn(name = "carrier")
    private String carrier;

    @JoinColumn(name = "customer")
    private String customer;

    @JoinColumn(name = "deplane_at")
    private String deplane_at;

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

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDeplane_at() {
        return deplane_at;
    }

    public void setDeplane_at(String deplane_at) {
        this.deplane_at = deplane_at;
    }
}
