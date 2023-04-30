package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Passenger;
import com.gtbackend.gtbackend.model.Person;
import com.gtbackend.gtbackend.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
@Repository
public interface PersonDao extends JpaRepository<Person, String> {
    @Query(value = "{ CALL add_person(:personID, :first_name, :last_name, :taxID, :locationID, :experience, :flying_airline, :flying_tail, :miles) }", nativeQuery = true)
    void addPerson  (@Param("personID") String flightID,
                     @Param("first_name") String first_name,
                     @Param("last_name") String last_name,
                     @Param("taxID") String taxID,
                     @Param("locationID") String locationID,
                     @Param("experience") int experience,
                     @Param("flying_airline") String flying_airline,
                     @Param("flying_tail") String flying_tail,
                     @Param("miles") int miles);
}