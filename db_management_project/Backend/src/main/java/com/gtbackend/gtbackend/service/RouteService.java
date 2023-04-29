package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.LegDao;
import com.gtbackend.gtbackend.dao.RouteDao;
import com.gtbackend.gtbackend.model.Leg;
import com.gtbackend.gtbackend.model.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private static final Logger logger = LogManager.getLogger(RouteService.class);
    @Autowired
    private RouteDao routeDao;
    public List<Route> getRouteAll(){
        return routeDao.getRouteAll();
    }
}
