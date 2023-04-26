package com.gtbackend.gtbackend.controller;

import com.gtbackend.gtbackend.model.*;
import com.gtbackend.gtbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    private PersonService personService;

    @Autowired
    public Controllers(AirlineService airlineService, AirplaneService airplaneService, AirportService airportService, FlightService flightService) {
        this.airlineService = airlineService;
        this.airplaneService = airplaneService;
        this.airportService = airportService;
        this.flightService = flightService;
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

    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody Map<String, Person> personMap) {
        try {
            Person person = personMap.get("person");
            String personID = person.getPersonID();
            String firstName = person.getFirst_name();
            String lastName = person.getLast_name();
            String locationID = person.getLocationID();

            String taxID = null;
            int experience = 0;
            String flyingAirline = null;
            String flyingTail = null;

            if (person instanceof Pilot) {
                Pilot pilot = (Pilot) person;
                taxID = pilot.getTaxID();
                experience = pilot.getExperience();
                flyingAirline = pilot.getFlying_airline();
                flyingTail = pilot.getFlying_tail();
            }

            int miles = 0;

            if (person instanceof Passenger) {
                Passenger passenger = (Passenger) person;
                miles = passenger.getMiles();
            }

            boolean isAdded = personService.addPerson(
                    personID,
                    firstName,
                    lastName,
                    taxID,
                    experience,
                    flyingAirline,
                    flyingTail,
                    locationID,
                    miles
            );

            if (isAdded) {
                return ResponseEntity.ok("Person gets added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Person failed to be added.");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add person: " + e.getMessage());
        }
    }



}
