package com.gtbackend.gtbackend.service;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Service
public class LegService {

    private static final Logger logger = LogManager.getLogger(LegService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean addUpdateLeg(String legID, Integer distance, String departure, String arrival) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("add_update_leg")
                    .declareParameters(
                            new SqlParameter("ip_legID", Types.VARCHAR),
                            new SqlParameter("ip_distance", Types.INTEGER),
                            new SqlParameter("ip_departure", Types.CHAR),
                            new SqlParameter("ip_arrival", Types.CHAR),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_legID", legID);
            paramMap.put("ip_distance", distance);
            paramMap.put("ip_departure", departure);
            paramMap.put("ip_arrival", arrival);

            Map<String, Object> result = jdbcCall.execute(paramMap);
            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");
            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error adding/updating leg: " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error adding/updating leg: " + e.getMessage(), e);
        } catch (ConstraintViolationException e){
            logger.error("Service error adding/updating leg: " + e.getMessage());
            throw new DataIntegrityViolationException("Error adding/updating leg: " + e.getMessage(), e);
        }
    }
}
