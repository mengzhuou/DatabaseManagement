package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirplaneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;

@Service
public class AirplaneService {
    private static final Logger logger = LogManager.getLogger(AirlineService.class);
    @Autowired
    private AirplaneDAO airplaneDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addAirplane(String airlineID, String tail_num, Integer seat_capacity, Integer speed, String locationID, String plane_type, int skids, int propellers, int jet_engines) {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cs = conn.prepareCall("{call add_airplane(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, airlineID);
            cs.setString(2, tail_num);
            cs.setInt(3, seat_capacity);
            cs.setInt(4, speed);
            cs.setString(5, locationID);
            cs.setString(6, plane_type);
            cs.setInt(7, skids);
            cs.setInt(8, propellers);
            cs.setInt(9, jet_engines);
            cs.execute();
            return true;
        } catch (Exception e) {
            logger.error("Service error adding airplane: " + e.getMessage());
            return false;
        }
    }
}
