package com.gtbackend.gtbackend.service;

import com.gtbackend.gtbackend.dao.PeopleOnTheGroundDao;
import com.gtbackend.gtbackend.model.PeopleOnTheGround;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PeopleOnTheGroundService {
    @Autowired
    private PeopleOnTheGroundDao peopleOnTheGroundDao;

    public List<PeopleOnTheGround> getPeopleOnTheGround() {
        return peopleOnTheGroundDao.getPeopleOnTheGround();
    }
}
