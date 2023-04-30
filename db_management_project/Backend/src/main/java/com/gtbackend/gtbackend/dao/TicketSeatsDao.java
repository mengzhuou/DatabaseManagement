package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Ticket;
import com.gtbackend.gtbackend.model.TicketSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSeatsDao extends JpaRepository<TicketSeats, String> {
    @Query("SELECT a FROM TicketSeats a")
    List<TicketSeats> getTicketSeatsAll();
}
