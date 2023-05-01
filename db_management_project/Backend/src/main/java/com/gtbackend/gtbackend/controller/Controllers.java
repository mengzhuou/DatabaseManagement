package com.gtbackend.gtbackend.controller;

import com.gtbackend.gtbackend.dto.PilotLicensesDTO;
import com.gtbackend.gtbackend.model.*;
import com.gtbackend.gtbackend.service.*;
import org.hibernate.exception.ConstraintViolationException;
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
    private PassengerService passengerService;
    @Autowired
    private PilotService pilotService;
    @Autowired
    private PilotLicensesService pilotLicensesService;
    @Autowired
    private LegService legService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private RoutePathService routePathService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketSeatsService ticketSeatsService;


    @Autowired
    public Controllers(AirlineService airlineService,
                       AirplaneService airplaneService,
                       AirportService airportService,
                       FlightService flightService,
                       PersonService personService,
                       PassengerService passengerService,
                       PilotService pilotService,
                       PilotLicensesService pilotLicensesService,
                       LocationService locationService,
                       LegService legService,
                       RouteService routeService,
                       RoutePathService routePathService,
                       TicketService ticketService,
                       TicketSeatsService ticketSeatsService
    ) {
        this.airlineService = airlineService;
        this.airplaneService = airplaneService;
        this.airportService = airportService;
        this.flightService = flightService;
        this.personService = personService;
        this.passengerService = passengerService;
        this.pilotService = pilotService;
        this.pilotLicensesService = pilotLicensesService;
        this.locationService = locationService;
        this.legService = legService;
        this.routeService = routeService;
        this.routePathService = routePathService;
        this.ticketService = ticketService;
        this.ticketSeatsService = ticketSeatsService;
    }

    @GetMapping("/getAirlineAll")
    public List<Airline> getAirlineAll() {
        List<Airline> getInfo = airlineService.getAirlineAll();
        return getInfo;
    }

    @GetMapping("/getLocationAll")
    public List<Location> getLocationAll() {
        List<Location> getInfo = locationService.getLocationAll();
        return getInfo;
    }

    @GetMapping("/getAirportAll")
    public List<Airport> getAirportAll() {
        List<Airport> getInfo = airportService.getAirportAll();
        return getInfo;
    }

    @GetMapping("/getFlightAll")
    public List<Flight> getFlightAll() {
        List<Flight> getInfo = flightService.getFlightAll();
        return getInfo;
    }

    @GetMapping("/getAirplaneAll")
    public List<Airplane> getAirplaneAll() {
        List<Airplane> getInfo = airplaneService.getAirplaneAll();
        return getInfo;
    }

    @GetMapping("/getPersonAll")
    public List<Person> getPersonAll() {
        List<Person> getInfo = personService.getPersonAll();
        return getInfo;
    }

    @GetMapping("/getPassengerAll")
    public List<Passenger> getPassengerAll() {
        List<Passenger> getInfo = passengerService.getPassengerAll();
        return getInfo;
    }

    @GetMapping("/getPilotAll")
    public List<Pilot> getPilotAll() {
        List<Pilot> getInfo = pilotService.getPilotAll();
        return getInfo;
    }

    @GetMapping("/getPilotLicensesAll")
    public List<PilotLicenses> getPilotLicensesAll() {
        List<PilotLicenses> getInfo = pilotLicensesService.getPilotLicensesAll();
        return getInfo;
    }

    @GetMapping("/getTicketAll")
    public List<Ticket> getTicketAll() {
        List<Ticket> getInfo = ticketService.getTicketAll();
        return getInfo;
    }

    @GetMapping("/getTicketSeatsAll")
    public List<TicketSeats> getTicketSeatsAll() {
        List<TicketSeats> getInfo = ticketSeatsService.getTicketSeatsAll();
        return getInfo;
    }

    @GetMapping("/getRouteAll")
    public List<Route> getRouteAll() {
        List<Route> getInfo = routeService.getRouteAll();
        return getInfo;
    }

    @GetMapping("/getRoutePathAll")
    public List<RoutePath> getRoutePathAll() {
        List<RoutePath> getInfo = routePathService.getRoutePathAll();
        return getInfo;
    }

    @PostMapping("/addAirplane")
    public ResponseEntity<String> addAirplane(@RequestBody Airplane airplane) {
        try {
            System.out.println("airlineID: " + airplane.getAirlineID());
            System.out.println("tail_num: " + airplane.getTail_num());
            System.out.println("seat_capacity: " + airplane.getSeat_capacity());
            System.out.println("speed: " + airplane.getSpeed());
            System.out.println("locationID: " + airplane.getLocationID());
            System.out.println("plane_type: " + airplane.getPlane_type());
            System.out.println("skids: " + airplane.getSkids());
            System.out.println("propellers: " + airplane.getPropellers());
            System.out.println("jet_engines: " + airplane.getJet_engines());

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
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add airplane: " + e.getMessage());
        }
    }


    @PostMapping("/addAirport")
    public ResponseEntity<String> addAirport(@RequestBody Airport airport) {
        try {
            System.out.println("airportID: " + airport.getAirportID());
            System.out.println("airport_name: " + airport.getAirportName());
            System.out.println("city: " + airport.getCity());
            System.out.println("state: " + airport.getState());
            System.out.println("locationID: " + airport.getLocationID());

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
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add airport: " + e.getMessage());
        }
    }

    @PostMapping("/grantPilotLicense")
    public ResponseEntity<String> grantPilotLicense(@RequestBody PilotLicensesDTO pilotLicensesDTO) {
        try {

            PilotLicenses pilotLicenses = new PilotLicenses();
            Pilot pilot = new Pilot();
            pilot.setPersonID(pilotLicensesDTO.getPersonID());
            pilotLicenses.setPersonID(pilot);
            pilotLicenses.setLicense(pilotLicensesDTO.getLicense());


            System.out.println("personID: " + pilotLicensesDTO.getPersonID());
            System.out.println("license: " + pilotLicensesDTO.getLicense());

            boolean isOffered = pilotLicensesService.grantPilotLicense(
                    pilotLicenses.getPersonID(),
                    pilotLicenses.getLicense()
            );
            if (isOffered) {
                return ResponseEntity.ok("Pilot license offered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Pilot license failed to be offered");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add pilot license: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add pilot license: " + e.getMessage());
        }
    }

    @PostMapping("/offerFlight")
    public ResponseEntity<String> offerFlight(@RequestBody Flight flight) {
        try {
            System.out.println("flightID: " + flight.getFlightID());
            System.out.println("routeID: " + flight.getRouteID());
            System.out.println("supportAirline: " + flight.getSupport_airline());
            System.out.println("supportTail: " + flight.getSupport_tail());
            System.out.println("progress: " + flight.getProgress());
            System.out.println("airplaneStatus: " + flight.getAirplane_status());
            System.out.println("nextTime: " + flight.getNext_time());

            boolean isOffered = flightService.offerFlight(
                    flight.getFlightID(),
                    flight.getRouteID(),
                    flight.getSupport_airline(),
                    flight.getSupport_tail(),
                    flight.getProgress(),
                    flight.getAirplane_status(),
                    flight.getNext_time()
            );
            if (isOffered) {
                return ResponseEntity.ok("Flight offered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Flight failed to be offered");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add flight: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add flight: " + e.getMessage());
        }
    }

    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody PersonDetails personDetails) {
        try {
            Person person = personDetails.getPerson();
            Pilot pilot = personDetails.getPilot();
            Passenger passenger = personDetails.getPassenger();

            String personID = person.getPersonID();
            String first_name = person.getFirst_name();
            String last_name = person.getLast_name();
            String locationID = person.getLocationID();

            String taxID = null;
            Integer experience = 0;
            String flying_airline = null;
            String flying_tail = null;

            if (pilot != null) {
                taxID = pilot.getTaxID();
                experience = pilot.getExperience();
                flying_airline = pilot.getFlying_airline();
                flying_tail = pilot.getFlying_tail();
            }

            Integer miles = 0;

            if (passenger != null) {
                miles = passenger.getMiles();
            }

            boolean isAdded = personService.addPerson(
                    personID,
                    first_name,
                    last_name,
                    locationID,
                    taxID,
                    experience,
                    flying_airline,
                    flying_tail,
                    miles
            );

            if (isAdded) {
                return ResponseEntity.ok("Person gets added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Person failed to be added.");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add person: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add person: " + e.getMessage());
        }
    }

    @PostMapping("/purchaseTicketAndSeat")
    public ResponseEntity<String> purchaseTicketAndSeat(@RequestBody TicketDetails ticketDetails) {
        try {
            Ticket ticket = ticketDetails.getTicket();
            TicketSeats ticketSeats = ticketDetails.getTicketSeats();
            if (ticketSeats == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("TicketSeats information is missing");
            }
            String ticketID = ticket.getTicketID();
            Integer cost = ticket.getCost();
            String carrier = ticket.getCarrier();
            String customer = ticket.getCustomer();
            String deplane_at = ticket.getDeplane_at();
            String seat_number = ticketSeats.getSeatNumber();

            boolean isPurchased = ticketService.purchaseTicketAndSeat(
                    ticketID,
                    cost,
                    carrier,
                    customer,
                    deplane_at,
                    seat_number
            );

            if (isPurchased) {
                return ResponseEntity.ok("Ticket and seat purchased successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ticket and seat failed to be purchased.");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to purchase ticket and seat: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to purchase ticket and seat: " + e.getMessage());
        }
    }

    @PostMapping("/addUpdateLeg")
    public ResponseEntity<String> addUpdateLeg(@RequestBody Leg leg) {
        try {
            boolean isAddedOrUpdated = legService.addUpdateLeg(
                    leg.getLegID(),
                    leg.getDistance(),
                    leg.getDeparture(),
                    leg.getArrival()
            );
            if (isAddedOrUpdated) {
                return ResponseEntity.ok("Leg added or updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Leg failed to be added or updated");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add or update leg: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to add or update leg: " + e.getMessage());
        }
    }

    @PostMapping("/startRoute")
    public ResponseEntity<String> startRoute(@RequestBody RouteDetails routeDetails) {
        try {
            Route route = routeDetails.getRoute();
            String routeID = route.getRouteID();

            RoutePath routePath = routeDetails.getRoutePath();
            String legID = routePath.getLegID();

            boolean isStarted = routeService.startRoute(
                    routeID,
                    legID
            );

            if (isStarted) {
                return ResponseEntity.ok("Route started successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Route failed to start");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to start route: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to start route: " + e.getMessage());
        }
    }
    @PostMapping("/extendRoute")
    public ResponseEntity<String> extendRoute(@RequestBody RouteDetails routeDetails) {
        try {
            Route route = routeDetails.getRoute();
            String routeID = route.getRouteID();

            RoutePath routePath = routeDetails.getRoutePath();
            String legID = routePath.getLegID();

            boolean isExtended = routeService.extendRoute(
                    routeID,
                    legID
            );

            if (isExtended) {
                return ResponseEntity.ok("Route extended successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Route failed to extend");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to extend route: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to extend route: " + e.getMessage());
        }
    }

    @PostMapping("/flightLanding")
    public ResponseEntity<String> flightLanding(@RequestBody Flight flight) {
        try {
            String flightID = flight.getFlightID();
            boolean isLanded = flightService.flightLanding(flightID);
            if (isLanded) {
                return ResponseEntity.ok("Flight landed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Flight failed to land");
            }
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to land flight: " + e.getMessage());
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller failed to land flight: " + e.getMessage());
        }
    }


}
