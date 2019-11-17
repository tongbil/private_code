package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.UserDomain;

import java.util.List;
import java.util.Map;

public interface XcxDao {
    List<Map> selectbo(Map<String, Object> map);
}
