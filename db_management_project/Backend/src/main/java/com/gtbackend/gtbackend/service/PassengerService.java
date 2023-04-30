package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PassengerDao;
import com.gtbackend.gtbackend.model.Airplane;
import com.gtbackend.gtbackend.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerDao passengerDao;
    public List<Passenger> getPassengerAll() {
        return passengerDao.getPassengerAll();
    }

}
