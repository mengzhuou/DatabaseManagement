package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirlineDao;
import com.gtbackend.gtbackend.dao.FlightDao;
import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Time;
import java.time.LocalTime;

@Service
public class FlightService {
    private static final Logger logger = LogManager.getLogger(FlightService.class);
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean offerFlight(String flightID, String routeID, String supportAirline, String supportTail, Integer progress, String airplaneStatus, LocalTime nextTime) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("offer_flight")
                    .declareParameters(
                            new SqlParameter("ip_flightID", Types.VARCHAR),
                            new SqlParameter("ip_routeID", Types.VARCHAR),
                            new SqlParameter("ip_support_airline", Types.VARCHAR),
                            new SqlParameter("ip_support_tail", Types.VARCHAR),
                            new SqlParameter("ip_progress", Types.INTEGER),
                            new SqlParameter("ip_airplane_status", Types.VARCHAR),
                            new SqlParameter("ip_next_time", Types.TIME),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_flightID", flightID);
            paramMap.put("ip_routeID", routeID);
            paramMap.put("ip_support_airline", supportAirline);
            paramMap.put("ip_support_tail", supportTail);
            paramMap.put("ip_progress", progress);
            paramMap.put("ip_airplane_status", airplaneStatus);
            paramMap.put("ip_next_time", nextTime != null ? Time.valueOf(nextTime) : null);

            Map<String, Object> result = jdbcCall.execute(paramMap);
            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");
            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error offering flight: " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error offering flight: " + e.getMessage(), e);
        } catch (ConstraintViolationException e){
            logger.error("Service error offering flight: " + e.getMessage());
            throw new DataIntegrityViolationException("Error offering flight: " + e.getMessage(), e);
        }
    }

    public List<Flight> getFlightAll() {
        return flightDao.getFlightAll();
    }


}
