package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;

@Service
public class AirportService {
    private static final Logger logger = LogManager.getLogger(AirportService.class);
    @Autowired
    private AirportDao airportDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addAirport(String airportID, String airportName, String city, String state, String locationID) {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cs = conn.prepareCall("{ call add_airport(?, ?, ?, ?, ?) }");
            cs.setString(1, airportID);
            cs.setString(2, airportName);
            cs.setString(3, city);
            cs.setString(4, state);
            cs.setString(5, locationID);
            cs.execute();
            cs.close();
            conn.close();
            return true;
        } catch (Exception e) {
            logger.error("Service error adding airport: " + e.getMessage());
            return false;
        }
    }
}
