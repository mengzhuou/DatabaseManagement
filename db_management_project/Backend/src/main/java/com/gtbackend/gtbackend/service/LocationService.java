package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirlineDao;
import com.gtbackend.gtbackend.dao.LocationDao;
import com.gtbackend.gtbackend.model.Airline;
import com.gtbackend.gtbackend.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationDao locationDao;

    public List<Location> getLocationAll() {
        return locationDao.getLocationAll();
    }
}
