package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PilotDao;
import com.gtbackend.gtbackend.model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {
    @Autowired
    private PilotDao pilotDao;
    public List<Pilot> getPilotAll() {
        return pilotDao.getPilotAll();
    }

}
