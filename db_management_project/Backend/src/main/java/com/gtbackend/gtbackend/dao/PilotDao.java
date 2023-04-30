package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airport;
import com.gtbackend.gtbackend.model.Passenger;
import com.gtbackend.gtbackend.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotDao extends JpaRepository<Pilot, String> {
    @Query("SELECT a FROM Pilot a")
    List<Pilot> getPilotAll();
}
