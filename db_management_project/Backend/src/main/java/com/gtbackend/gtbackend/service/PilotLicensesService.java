package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PilotDao;
import com.gtbackend.gtbackend.dao.PilotLicensesDao;
import com.gtbackend.gtbackend.model.Pilot;
import com.gtbackend.gtbackend.model.PilotLicenses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PilotLicensesService {
    private static final Logger logger = LogManager.getLogger(PilotLicensesService.class);
    @Autowired
    private PilotLicensesDao pilotLicensesDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PilotLicenses> getPilotLicensesAll() {
        return pilotLicensesDao.getPilotLicensesAll();
    }

    public boolean grantPilotLicense(Pilot pilot, String license) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("grant_pilot_license")
                    .declareParameters(
                            new SqlParameter("ip_personID", Types.VARCHAR),
                            new SqlParameter("ip_license", Types.VARCHAR)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_personID", pilot.getPersonID());
            paramMap.put("ip_license", license);

            Map<String, Object> result = jdbcCall.execute(paramMap);
            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");
            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error grant pilot license : " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error grant pilot license: " + e.getMessage(), e);
        } catch (ConstraintViolationException e) {
            logger.error("Service error grant pilot license: " + e.getMessage());
            throw new DataIntegrityViolationException("Error grant pilot license: " + e.getMessage(), e);
        }
    }
}