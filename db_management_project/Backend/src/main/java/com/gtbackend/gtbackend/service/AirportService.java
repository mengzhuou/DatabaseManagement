package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirportDao;
import com.gtbackend.gtbackend.model.Airport;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {
    private static final Logger logger = LogManager.getLogger(AirportService.class);
    @Autowired
    private AirportDao airportDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addAirport(String airportID, String airportName, String city, String state, String locationID) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("add_airport")
                    .declareParameters(
                            new SqlParameter("ip_airportID", Types.VARCHAR),
                            new SqlParameter("ip_airport_name", Types.VARCHAR),
                            new SqlParameter("ip_city", Types.VARCHAR),
                            new SqlParameter("ip_state", Types.VARCHAR),
                            new SqlParameter("ip_locationID", Types.VARCHAR),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_airportID", airportID);
            paramMap.put("ip_airport_name", airportName);
            paramMap.put("ip_city", city);
            paramMap.put("ip_state", state);
            paramMap.put("ip_locationID", locationID);

            Map<String, Object> result = jdbcCall.execute(paramMap);
            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");
            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error adding airplane: " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error adding airplane: " + e.getMessage(), e);
        } catch (ConstraintViolationException e){
            logger.error("Service error adding airplane: " + e.getMessage());
            throw new DataIntegrityViolationException("Error adding airplane: " + e.getMessage(), e);
        }
    }

    public List<Airport> getAirportAll() {
        return airportDao.getAirportAll();
    }
}
