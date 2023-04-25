package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirlineDAO;
import com.gtbackend.gtbackend.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlineDAO airlineDAO;

    public List<Airline> getAirlineAll() {
        return airlineDAO.getAirlineAll();
    }
}
