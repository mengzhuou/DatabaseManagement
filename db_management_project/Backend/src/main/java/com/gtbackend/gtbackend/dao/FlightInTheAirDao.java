package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.FlightInTheAir;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.query.Procedure;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightInTheAirDao extends JpaRepository<FlightInTheAir, Long>{
    @Query("SELECT a FROM FlightInTheAir a")
    List<FlightInTheAir> getFlightInTheAir();
}
