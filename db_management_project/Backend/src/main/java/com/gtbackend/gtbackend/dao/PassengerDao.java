package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Airport;
import com.gtbackend.gtbackend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, String> {
    @Query("SELECT a FROM Passenger a")
    List<Passenger> getPassengerAll();
}
