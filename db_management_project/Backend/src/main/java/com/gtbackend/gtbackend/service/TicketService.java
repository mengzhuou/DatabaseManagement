package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.TicketDao;
import com.gtbackend.gtbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketDao ticketDao;

    public List<Ticket> getTicketAll() {
        return ticketDao.getTicketAll();
    }
}
