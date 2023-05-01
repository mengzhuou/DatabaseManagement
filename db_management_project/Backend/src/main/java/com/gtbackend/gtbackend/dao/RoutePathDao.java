package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.RoutePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoutePathDao extends JpaRepository<RoutePath, String> {
    @Query("SELECT a FROM RoutePath a")
    List<RoutePath> getRoutePathAll();
}
