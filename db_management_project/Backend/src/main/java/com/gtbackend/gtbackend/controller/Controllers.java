package com.gtbackend.gtbackend.controller;

import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Airplane;
import com.gtbackend.gtbackend.model.Airport;
import com.gtbackend.gtbackend.model.Flight;
import com.gtbackend.gtbackend.model.Leg;
import com.gtbackend.gtbackend.model.Location;
import com.gtbackend.gtbackend.service.AirlineService;
import com.gtbackend.gtbackend.service.AirplaneService;
import com.gtbackend.gtbackend.service.AirportService;
import com.gtbackend.gtbackend.service.FlightService;
import com.gtbackend.gtbackend.service.LegService;
import com.gtbackend.gtbackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private AirportService airportService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private LegService legService;
    @Autowired
    private LocationService locationService;

    @Autowired
    public Controllers(AirlineService airlineService, AirplaneService airplaneService, AirportService airportService, FlightService flightService,
        LegService legService, LocationService locationService) {
        this.airlineService = airlineService;
        this.airplaneService = airplaneService;
        this.airportService = airportService;
        this.flightService = flightService;
        this.legService = legService;
        this.locationService = locationService;
    }

    @GetMapping("/getAirlineAll")
    public List<Airline> getAirlineAll(){
        List<Airline> getInfo = airlineService.getAirlineAll();
        return getInfo;
    }
    @PostMapping("/addAirplane")
    public ResponseEntity<String> addAirplane(@RequestBody Airplane airplane) {
        try {
            boolean isAdded = airplaneService.addAirplane(
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
            if (isAdded) {
                return ResponseEntity.ok("Airplane added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Airplane failed to be added");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add airplane: " + e.getMessage());
        }
    }

    @PostMapping("/addAirport")
    public ResponseEntity<String> addAirport(@RequestBody Airport airport) {
        try {
            boolean isAdded = airportService.addAirport(
                    airport.getAirportID(),
                    airport.getAirportName(),
                    airport.getCity(),
                    airport.getState(),
                    airport.getLocationID()
            );
            if (isAdded) {
                return ResponseEntity.ok("Airport added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Airport failed to be added");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add airport: " + e.getMessage());
        }
    }

    @PostMapping("/offerFlight")
    public ResponseEntity<String> offerFlight(@RequestBody Flight flight) {
        try {
            boolean isOffered = flightService.offerFlight(
                    flight.getFlightID(),
                    flight.getRouteID(),
                    flight.getSupportAirline(),
                    flight.getSupportTail(),
                    flight.getProgress(),
                    flight.getAirplaneStatus(),
                    flight.getNextTime()
            );
            if (isOffered) {
                return ResponseEntity.ok("Flight offered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Flight failed to be offered");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to offer flight: " + e.getMessage());
        }
    }

    @PostMapping("/addLeg")
    public ResponseEntity<String> addLeg(@RequestBody Leg leg) {
        try {
            boolean isAdded = legService.addLeg(
                    leg.getLegID(),
                    leg.getDistance(),
                    leg.getDeparture(),
                    leg.getArrival()
            );
            if (isAdded) {
                return ResponseEntity.ok("Leg added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Leg failed to be added");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add leg: " + e.getMessage());
        }
    }

    @PostMapping("/addLocation")
    public ResponseEntity<String> addLocation(@RequestBody Location location) {
        try {
            boolean isAdded = locationService.addLocation(
                    location.getLocationID()
            );
            if (isAdded) {
                return ResponseEntity.ok("Location added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Location failed to be added");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add location: " + e.getMessage());
        }
    }


}
