package com.gtbackend.gtbackend.controller;

import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Airplane;
import com.gtbackend.gtbackend.service.AirlineService;
import com.gtbackend.gtbackend.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/v1")
public class Controllers {

    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    public Controllers(AirlineService airlineService, AirplaneService airplaneService) {
        this.airlineService = airlineService;
        this.airplaneService = airplaneService;
    }

    @GetMapping("/getAirlineAll")
    public List<Airline> getAirlineAll(){
        List<Airline> getInfo = airlineService.getAirlineAll();
        return getInfo;
    }
    @PostMapping("/addAirplane")
    public void addAirplane(@RequestBody Airplane airplane) {
        airplaneService.addAirplane(
                airplane.getAirlineID(),
                airplane.getTail_num(),
                airplane.getSeat_capacity(),
                airplane.getSpeed(),
                airplane.getLocationID(),
                airplane.getPlane_type(),
                airplane.getSkids(),
                airplane.getPropellers(),
                airplane.getJet_engines()
        );
    }

}
