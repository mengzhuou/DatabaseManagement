package com.gtbackend.gtbackend.service;


import com.gtbackend.gtbackend.dao.PeopleInTheAirDao;
import com.gtbackend.gtbackend.model.PeopleInTheAir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PeopleInTheAirService {
    @Autowired
    private PeopleInTheAirDao peopleInTheAirDao;
    
    public List<PeopleInTheAir> getPeopleInTheAir() {
        return peopleInTheAirDao.getPeopleInTheAir();
    }
}
