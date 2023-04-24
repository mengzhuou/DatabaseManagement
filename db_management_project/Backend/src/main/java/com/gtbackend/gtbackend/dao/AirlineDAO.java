package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineDao extends JpaRepository<Airline, String> {
//    @Query("SELECT a FROM Airline a WHERE a.airlineID = :airlineId")
//    List<Airline> getAirlineAll(@Param("airlineId") String airlineId);
    @Query("SELECT a FROM Airline a")
    List<Airline> getAirlineAll();
}
