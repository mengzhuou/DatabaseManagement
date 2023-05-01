package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.TicketDao;
import com.gtbackend.gtbackend.model.Ticket;
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

@Service
public class TicketService {
    private static final Logger logger = LogManager.getLogger(PersonService.class);

    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ticket> getTicketAll() {
        return ticketDao.getTicketAll();
    }

    public boolean purchaseTicketAndSeat(String ticketID, Integer cost, String flightID, String customer, String deplane_at, String seatNumber) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("purchase_ticket_and_seat")
                    .declareParameters(
                            new SqlParameter("ip_ticketID", Types.VARCHAR),
                            new SqlParameter("ip_cost", Types.INTEGER),
                            new SqlParameter("ip_carrier", Types.VARCHAR),
                            new SqlParameter("ip_customer", Types.VARCHAR),
                            new SqlParameter("ip_deplane_at", Types.VARCHAR),
                            new SqlParameter("ip_seat_number", Types.VARCHAR),
                            new SqlOutParameter("op_success", Types.BOOLEAN)
                    );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ip_ticketID", ticketID);
            paramMap.put("ip_cost", cost);
            paramMap.put("ip_carrier", flightID);
            paramMap.put("ip_customer", customer);
            paramMap.put("ip_deplane_at", deplane_at);
            paramMap.put("ip_seat_number", seatNumber);

            Map<String, Object> result = jdbcCall.execute(paramMap);

            System.out.println("Result map: " + result);
            Boolean op_success = (Boolean) result.get("op_success");

            return op_success;
        } catch (DataAccessException e) {
            logger.error("Service error purchasing ticket and seat: " + e.getMessage());
            throw new DataIntegrityViolationException("Data Access Error purchasing ticket and seat: " + e.getMessage(), e);
        } catch (ConstraintViolationException e){
            logger.error("Service error purchasing ticket and seat: " + e.getMessage());
            throw new DataIntegrityViolationException("Error purchasing ticket and seat: " + e.getMessage(), e);
        }
    }
}
