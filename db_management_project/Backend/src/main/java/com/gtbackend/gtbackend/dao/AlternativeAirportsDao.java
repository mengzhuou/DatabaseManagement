package com.gtbackend.gtbackend.dao;
import com.gtbackend.gtbackend.model.AlternativeAirports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlternativeAirportsDao extends JpaRepository<AlternativeAirports, String>{
    
    @Query("SELECT a FROM AlternativeAirports a")
    List<AlternativeAirports> getAlternativeAirports();
}

