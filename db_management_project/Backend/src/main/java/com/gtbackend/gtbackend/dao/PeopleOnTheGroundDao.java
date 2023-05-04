package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.PeopleOnTheGround;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleOnTheGroundDao extends JpaRepository<PeopleOnTheGround, String>{

    //Query 22 view people_on_the_ground
    @Query("SELECT p FROM PeopleOnTheGround p")
    List<PeopleOnTheGround> getPeopleOnTheGround();
}
