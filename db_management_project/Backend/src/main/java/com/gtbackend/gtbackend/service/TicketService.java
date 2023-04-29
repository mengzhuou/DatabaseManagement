package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.RouteDao;
import com.gtbackend.gtbackend.dao.TicketDao;
import com.gtbackend.gtbackend.model.Route;
import com.gtbackend.gtbackend.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private static final Logger logger = LogManager.getLogger(TicketService.class);
    @Autowired
    private TicketDao ticketDao;
    public List<Ticket> getTicketAll(){
        return ticketDao.getTicketAll();
    }
}
