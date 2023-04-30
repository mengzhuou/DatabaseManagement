package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airplane;
import com.gtbackend.gtbackend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;

@Repository
public interface FlightDao extends JpaRepository<Flight, String> {
    @Query(value = "{ CALL offer_flight(:flightID, :routeID, :support_airline, :support_tail, :progress, :airplane_status, :next_time) }", nativeQuery = true)
    void offerFlight(@Param("flightID") String flightID,
                     @Param("routeID") String routeID,
                     @Param("support_airline") String supportAirline,
                     @Param("support_tail") String supportTail,
                     @Param("progress") Integer progress,
                     @Param("airplane_status") String airplaneStatus,
                     @Param("next_time") Time nextTime);
}