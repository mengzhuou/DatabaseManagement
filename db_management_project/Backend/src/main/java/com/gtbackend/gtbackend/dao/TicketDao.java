package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Route;
import com.gtbackend.gtbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketDao extends JpaRepository<Ticket, String>{
    @Query("SELECT a FROM Ticket a")
    List<Ticket> getTicketAll();
}
