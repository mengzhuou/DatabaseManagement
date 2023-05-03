package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.RouteSummaryDao;
import com.gtbackend.gtbackend.model.RouteSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RouteSummaryService {
    
    @Autowired
    private RouteSummaryDao routeSummaryDao;

    public List<RouteSummary> getRouteSummary() {
        return routeSummaryDao.getRouteSummary();
    }
}
