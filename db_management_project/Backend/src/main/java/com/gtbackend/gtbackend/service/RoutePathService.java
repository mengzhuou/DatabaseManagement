package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.RoutePathDao;
import com.gtbackend.gtbackend.model.RoutePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutePathService {

    @Autowired
    private RoutePathDao routePathDao;

    public List<RoutePath> getRoutePathAll() {
        return routePathDao.getRoutePathAll();
    }
}
