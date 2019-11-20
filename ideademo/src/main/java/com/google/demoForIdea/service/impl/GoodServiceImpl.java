package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.GoodDao;
import com.google.demoForIdea.model.Good;
import com.google.demoForIdea.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;


    @Override
    public Good getGood(int good_id) {
        return goodDao.getGood(good_id);
    }

    @Override
    public List<Good> getAll() {
        return goodDao.getAll();
    }

    @Override
    public List<Good> getAllOdd() {
        return goodDao.getAllOdd();
    }

    @Override
    public List<Good> getAllEven() {
        return goodDao.getAllEven();
    }

    @Override
    public Good getCartInfo(int good_id) {
        return goodDao.getCartInfo(good_id);
    }

    @Override
    public List<Good> getByType(String goodType) {
        return goodDao.getByType(goodType);
    }

    @Override
    public List<Good> getTitle() {
        return goodDao.getTitle();
    }
}
