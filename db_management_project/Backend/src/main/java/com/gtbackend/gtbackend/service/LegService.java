package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.AirportDao;
import com.gtbackend.gtbackend.dao.LegDao;
import com.gtbackend.gtbackend.model.Leg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegService {
    private static final Logger logger = LogManager.getLogger(LegService.class);
    @Autowired
    private LegDao legDao;
    public List<Leg> getLegAll(){
        return legDao.getLegAll();
    }
}
