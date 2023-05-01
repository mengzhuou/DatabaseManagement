package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.FlightOnTheGroundDao;
import com.gtbackend.gtbackend.model.FlightOnTheGround;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FlightOnTheGroundService {

    @Autowired
    private FlightOnTheGroundDao flightOnTheGroundDao;

    public void createFlightsOnTheGroundView() {
        flightOnTheGroundDao.createFlightsOnTheGroundView();
    }

    public List<FlightOnTheGround> getFlightsOnTheGround() {
        return flightOnTheGroundDao.getFlightsOnTheGround();
    }

}

