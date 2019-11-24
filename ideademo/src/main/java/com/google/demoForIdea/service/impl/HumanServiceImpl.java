package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.HumanDao;
import com.google.demoForIdea.model.Human;
import com.google.demoForIdea.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "humanService")
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanDao humanDao;


    @Override
    public void insertHuman(Human human) {
        humanDao.insertHuman(human);
    }

    @Override
    public void updateHuman(Human human) {
        humanDao.updateHuman(human);
    }

    @Override
    public Human selectOneHuman(String openid) {
        return humanDao.selectOneHuman(openid);
    }
}
