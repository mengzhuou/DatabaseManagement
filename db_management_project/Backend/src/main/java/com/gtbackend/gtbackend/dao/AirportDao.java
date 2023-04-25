package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airplane;
import com.gtbackend.gtbackend.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {

    @Query(value = "{ CALL add_airport(:airportID, :airportName, :city, :state, :locationID) }", nativeQuery = true)
    void addAirport(@Param("airportID") String airportID,
                    @Param("airportName") String airportName,
                    @Param("city") String city,
                    @Param("state") String state,
                    @Param("locationID") String locationID);
}