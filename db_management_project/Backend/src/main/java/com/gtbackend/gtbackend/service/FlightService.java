package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.FlightDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalTime;

@Service
public class FlightService {
    private static final Logger logger = LogManager.getLogger(FlightService.class);
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean offerFlight(String flightID, String routeID, String supportAirline, String supportTail, int progress, String airplaneStatus, LocalTime nextTime) {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cs = conn.prepareCall("{ call offer_flight(?, ?, ?, ?, ?, ?, ?) }");
            cs.setString(1, flightID);
            cs.setString(2, routeID);
            cs.setString(3, supportAirline);
            cs.setString(4, supportTail);
            cs.setInt(5, progress);
            cs.setString(6, airplaneStatus);
            cs.setTime(7, nextTime != null ? Time.valueOf(nextTime) : null);
            cs.execute();
            cs.close();
            conn.close();
            return true;
        } catch (Exception e) {
            logger.error("Service error offering flight: " + e.getMessage());
            return false;
        }
    }

}
