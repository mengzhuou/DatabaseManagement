package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneDao extends JpaRepository<Airplane, String> {
    @Query(value = "{ CALL add_airplane(:airlineID, :tail_num, :seat_capacity, :speed, :locationID, :plane_type, :skids, :propellers, :jet_engines) }",
            nativeQuery = true)
    void addAirplane(@Param("airlineID") String airlineID, @Param("tail_num") String tail_num, @Param("seat_capacity") int seat_capacity,
                     @Param("speed") int speed, @Param("locationID") String locationID, @Param("plane_type") String plane_type,
                     @Param("skids") int skids, @Param("propellers") int propellers, @Param("jet_engines") int jet_engines);
}
