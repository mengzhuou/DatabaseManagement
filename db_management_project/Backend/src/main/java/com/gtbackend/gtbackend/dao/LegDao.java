package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.Leg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegDao extends JpaRepository<Leg, String> {
}
