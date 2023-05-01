package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.RouteDao;
import com.gtbackend.gtbackend.model.Pilot;
import com.gtbackend.gtbackend.model.Route;
import com.gtbackend.gtbackend.model.RoutePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteDao routeDao;

    public List<Route> getRouteAll() {
        return routeDao.getRouteAll();
    }
}
