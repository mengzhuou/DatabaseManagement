package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao extends JpaRepository<Route, String> {
}
