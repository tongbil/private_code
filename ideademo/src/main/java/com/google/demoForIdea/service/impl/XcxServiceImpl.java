package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.UserDao;
import com.google.demoForIdea.dao.XcxDao;
import com.google.demoForIdea.service.XcxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "xcxService")
public class XcxServiceImpl implements XcxService {

    @Autowired
    private XcxDao xcxDao;//这里会报错，但是并不会影响 想要不报错 Settings - Editor - Inspections - Spring - Spring Core - Code - Autowiring for Bean Class 勾去掉


    @Override
    public List<Map> selectbo(Map<String, Object> map) {
        return xcxDao.selectbo(map
        );
    }
}
