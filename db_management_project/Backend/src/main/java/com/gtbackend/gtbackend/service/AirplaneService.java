package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirplaneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {
    @Autowired
    private AirplaneDao airplaneDao;

    public void addAirplane(String airlineID, String tail_num, Integer seat_capacity, Integer speed, String locationID, String plane_type, boolean skids, Integer propellers, Integer jet_engines) {
        airplaneDao.addAirplane(airlineID, tail_num, seat_capacity, speed, locationID, plane_type, skids, propellers, jet_engines);
    }

}
