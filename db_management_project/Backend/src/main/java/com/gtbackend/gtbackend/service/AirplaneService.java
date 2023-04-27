package com.gtbackend.gtbackend.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Service
public class AirplaneService {
    private static final Logger logger = LogManager.getLogger(AirlineService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addAirplane(String airlineID, String tail_num, int seat_capacity, int speed, String locationID, String plane_type, Integer skids, Integer propellers, Integer jet_engines) {
        try {

            if (skids == null || skids == 0) {
                skids = null;
            }
            if (propellers == null || propellers == 0) {
                propellers = null;
            }
            if (jet_engines == null || jet_engines == 0) {
                jet_engines = null;
            }
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("add_airplane")
                    .declareParameters(
                            new SqlParameter("ip_airlineID", Types.VARCHAR),
                            new SqlParameter("ip_tail_num", Types.VARCHAR),
                            new SqlParameter("ip_seat_capacity", Types.INTEGER),
                            new SqlParameter("ip_speed", Types.INTEGER),
                            new SqlParameter("ip_locationID", Types.VARCHAR),
                            new SqlParameter("ip_plane_type", Types.VARCHAR),
                            new SqlParameter("ip_skids", Types.INTEGER),
                            new SqlParameter("ip_propellers", Types.INTEGER),
                            new SqlParameter("ip_jet_engines", Types.INTEGER),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_airlineID", airlineID);
            paramMap.put("ip_tail_num", tail_num);
            paramMap.put("ip_seat_capacity", seat_capacity);
            paramMap.put("ip_speed", speed);
            paramMap.put("ip_locationID", locationID);
            paramMap.put("ip_plane_type", plane_type);
            paramMap.put("ip_skids", skids);
            paramMap.put("ip_propellers", propellers);
            paramMap.put("ip_jet_engines", jet_engines);

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
}
