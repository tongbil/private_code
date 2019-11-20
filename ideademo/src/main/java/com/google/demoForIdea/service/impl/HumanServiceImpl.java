package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.HumanDao;
import com.google.demoForIdea.model.Human;
import com.google.demoForIdea.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "humanService")
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanDao humanDao;


    @Override
    public Human getHuman(int id) {
        return humanDao.getHuman(id);
    }

    @Override
    public List<Human> getAll() {
        return humanDao.getAll();
    }

    @Override
    public void updateHuman(int id) {
        humanDao.updateHuman(id);
    }

    @Override
    public void deleteHuman(int id) {
        humanDao.deleteHuman(id);
    }

    @Override
    public void insertHuman(Human human) {
        humanDao.insertHuman(human);
    }
}
