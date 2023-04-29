package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Leg;
import com.gtbackend.gtbackend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteDao extends JpaRepository<Route, String>{
    @Query("SELECT a FROM Route a")
    List<Route> getRouteAll();
}
