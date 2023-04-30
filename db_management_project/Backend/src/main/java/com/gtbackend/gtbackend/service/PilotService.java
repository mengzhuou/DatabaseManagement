package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PilotDao;
import com.gtbackend.gtbackend.model.Pilot;
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
public class PilotService {
    private static final Logger logger = LogManager.getLogger(PilotService.class);

    @Autowired
    private PilotDao pilotDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Pilot> getPilotAll() {
        return pilotDao.getPilotAll();
    }
}
