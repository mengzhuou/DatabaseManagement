package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PersonDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;

@Service
public class PersonService {
    private static final Logger logger = LogManager.getLogger(PersonService.class);
    @Autowired
    private PersonDao personDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addPerson(String personID, String first_name, String last_name, String locationID, String taxID,
                             int experience, String flying_airline, String flying_tail, int miles) {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cs = conn.prepareCall("{ call add_person(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cs.setString(1, personID);
            cs.setString(2, first_name);
            cs.setString(3, last_name);
            cs.setString(4, locationID);
            cs.setString(5, taxID);
            cs.setInt(6, experience);
            cs.setString(7, flying_airline);
            cs.setString(8, flying_tail);
            cs.setInt(9, miles);
            cs.execute();
            cs.close();
            conn.close();
            return true;
        } catch (Exception e) {
            logger.error("Service error adding person: " + e.getMessage());
            return false;
        }

    }
}