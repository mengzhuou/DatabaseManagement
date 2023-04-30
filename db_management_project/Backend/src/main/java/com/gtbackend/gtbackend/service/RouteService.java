package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.RouteDao;
import com.gtbackend.gtbackend.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteDao routeDao;

    public Optional<Route> getRouteById(String routeId) {
        return routeDao.findById(routeId);
    }
}
