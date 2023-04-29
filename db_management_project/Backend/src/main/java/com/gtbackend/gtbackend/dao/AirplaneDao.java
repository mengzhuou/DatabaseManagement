package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneDao extends JpaRepository<Airplane, String> {
    @Query(value = "{ CALL add_airplane(:airlineID, :tail_num, :seat_capacity, :speed, :locationID, :plane_type, :skids, :propellers, :jet_engines) }",
            nativeQuery = true)
    void addAirplane(@Param("airlineID") String airlineID, @Param("tail_num") String tail_num, @Param("seat_capacity") Integer seat_capacity,
                     @Param("speed") Integer speed, @Param("locationID") String locationID, @Param("plane_type") String plane_type,
                     @Param("skids") Integer skids, @Param("propellers") Integer propellers, @Param("jet_engines") Integer jet_engines);
    @Query("SELECT a FROM Airplane a")
    List<Airplane> getAirplaneAll();
}
