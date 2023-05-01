package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.RouteDao;
import com.gtbackend.gtbackend.model.Route;
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
import java.util.List;

@Service
public class RouteService {
    private static final Logger logger = LogManager.getLogger(PersonService.class);

    @Autowired
    private RouteDao routeDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Route> getRouteAll() {
        return routeDao.getRouteAll();
    }

    public boolean startRoute(String routeID, String legID) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("start_route")
                    .declareParameters(
                            new SqlParameter("ip_routeID", Types.VARCHAR),
                            new SqlParameter("ip_legID", Types.VARCHAR),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_routeID", routeID);
            paramMap.put("ip_legID", legID);

            Map<String, Object> result = jdbcCall.execute(paramMap);
            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");
            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error starting route: " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error starting route: " + e.getMessage(), e);
        } catch (ConstraintViolationException e){
            logger.error("Service error starting route: " + e.getMessage());
            throw new DataIntegrityViolationException("Error starting route: " + e.getMessage(), e);
        }
    }

}
