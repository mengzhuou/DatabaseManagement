package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PilotLicensesDao;
import com.gtbackend.gtbackend.model.PilotLicenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotLicensesService {
    @Autowired
    private PilotLicensesDao pilotLicensesDao;
    public List<PilotLicenses> getPilotLicensesAll() {
        return pilotLicensesDao.getPilotLicensesAll();
    }

}