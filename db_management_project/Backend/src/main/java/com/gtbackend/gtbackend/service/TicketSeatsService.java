package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.TicketSeatsDao;
import com.gtbackend.gtbackend.model.TicketSeats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketSeatsService {
    @Autowired
    TicketSeatsDao ticketDao;
    public List<TicketSeats> getTicketSeatsAll(){
        return ticketDao.getTicketSeatsAll();
    }
}
