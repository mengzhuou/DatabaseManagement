package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.PeopleInTheAir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleInTheAirDao extends JpaRepository<PeopleInTheAir, String> {
    @Query("SELECT P FROM PeopleInTheAir P")
        List<PeopleInTheAir> getPeopleInTheAir();
}
