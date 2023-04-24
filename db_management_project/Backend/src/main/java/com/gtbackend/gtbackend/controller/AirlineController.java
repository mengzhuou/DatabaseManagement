package com.gtbackend.gtbackend.controller;

import com.gtbackend.gtbackend.dao.AirlineDAO;
import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/v1")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/getAirlineAll")
    public List<Airline> getAirlineAll() throws IllegalArgumentException{
        List<Airline> getInfo = airlineService.getAirlineAll();
        return getInfo;
    }
}
