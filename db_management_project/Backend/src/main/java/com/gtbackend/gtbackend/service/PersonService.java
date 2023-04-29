package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PersonDao;
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
import java.util.Map;
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
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("add_person")
                    .declareParameters(
                            new SqlParameter("ip_personID", Types.VARCHAR),
                            new SqlParameter("ip_first_name", Types.VARCHAR),
                            new SqlParameter("ip_last_name", Types.VARCHAR),
                            new SqlParameter("ip_locationID", Types.VARCHAR),
                            new SqlParameter("ip_taxID", Types.VARCHAR),
                            new SqlParameter("ip_experience", Types.INTEGER),
                            new SqlParameter("ip_flying_airline", Types.VARCHAR),
                            new SqlParameter("ip_flying_tail", Types.VARCHAR),
                            new SqlParameter("ip_miles", Types.INTEGER),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_personID", personID);
            paramMap.put("ip_first_name", first_name);
            paramMap.put("ip_last_name", last_name);
            paramMap.put("ip_locationID", locationID);
            paramMap.put("ip_taxID", taxID);
            paramMap.put("ip_experience", experience);
            paramMap.put("ip_flying_airline", flying_airline);
            paramMap.put("ip_flying_tail", flying_tail);
            paramMap.put("ip_miles", miles);

            Map<String, Object> result = jdbcCall.execute(paramMap);
            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");
            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error adding person: " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error adding person: " + e.getMessage(), e);
        } catch (ConstraintViolationException e){
            logger.error("Service error adding person: " + e.getMessage());
            throw new DataIntegrityViolationException("Error adding person: " + e.getMessage(), e);
        }
    }

}