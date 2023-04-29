package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.PilotLicenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotLicensesDao extends JpaRepository<PilotLicenses, String> {
    @Query("SELECT a FROM PilotLicenses a")
    List<PilotLicenses> getPilotLicensesAll();
}
