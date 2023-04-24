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

    public void save(Airline airline) {
        airlineDAO.save(airline);
    }

    public Airline findByID(String airlineID) {
        return airlineDAO.findById(airlineID).orElse(null);
    }

    public List<Airline> findAll() {
        return airlineDAO.findAll();
    }

    public void update(Airline airline) {
        airlineDAO.save(airline);
    }

    public void delete(String airlineID) {
        airlineDAO.deleteById(airlineID);
    }

    public List<Airline> getAirlineAll(String airlineId) {
        return airlineDAO.getAirlineAll(airlineId);
    }
}
