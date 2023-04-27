package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationDao extends JpaRepository<Location, String> {
    @Query("SELECT a FROM Location a")
    List<Location> getLocationAll();

}