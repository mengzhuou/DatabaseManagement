package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneDao extends JpaRepository<Airplane, String> {
    @Query(value = "{ CALL add_airplane(:airlineID, :tail_num, :seat_capacity, :speed, :locationID, :plane_type, :skids, :propellers, :jet_engines) }",
            nativeQuery = true)
    void addAirplane(String airlineID, String tail_num, Integer seat_capacity, Integer speed, String locationID, String plane_type, boolean skids, Integer propellers, Integer jet_engines);

}
