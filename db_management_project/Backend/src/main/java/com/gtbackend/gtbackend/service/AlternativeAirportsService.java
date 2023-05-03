package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AlternativeAirportsDao;
import com.gtbackend.gtbackend.model.AlternativeAirports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class AlternativeAirportsService {
    @Autowired
    private AlternativeAirportsDao alternativeAirportsDao;

    public List<AlternativeAirports> getAlternativeAirports() {
        return alternativeAirportsDao.getAlternativeAirports();
    }
}
