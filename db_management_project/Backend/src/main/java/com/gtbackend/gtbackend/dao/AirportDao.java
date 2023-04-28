package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {
    @Query("SELECT a FROM Airport a")
    List<Airport> getAirportAll();
}