package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.FlightInTheAirDao;
import com.gtbackend.gtbackend.model.FlightInTheAir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInTheAirService {
    @Autowired
    private FlightInTheAirDao flightInTheAirDao;

    public List<FlightInTheAir> getFlightInTheAir() {
        return flightInTheAirDao.getFlightInTheAir();
    }
}