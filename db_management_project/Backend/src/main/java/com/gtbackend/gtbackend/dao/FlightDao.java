package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Airplane;
import com.gtbackend.gtbackend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface FlightDao extends JpaRepository<Flight, String> {
    @Query("SELECT a FROM Flight a")
    List<Flight> getFlightAll();
}