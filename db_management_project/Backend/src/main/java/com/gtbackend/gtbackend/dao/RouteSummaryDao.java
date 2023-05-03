package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.RouteSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteSummaryDao extends JpaRepository<RouteSummary, String>{
    
    @Query("SELECT r FROM RouteSummary r")
    List<RouteSummary> getRouteSummary();
}
