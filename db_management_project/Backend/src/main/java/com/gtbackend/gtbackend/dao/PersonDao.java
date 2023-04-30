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
import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, String> {
    @Query("SELECT a FROM Person a")
    List<Person> getPersonAll();
}