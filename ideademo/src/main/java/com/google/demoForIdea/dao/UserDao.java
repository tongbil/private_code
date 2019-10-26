package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.UserDomain;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int insert(UserDomain record);

    List<UserDomain> selectUsers();
    List<Map> getAllTeacherInfo(Map<String,Object> map);
    List<Map> selUser(Map<String,Object> map);
}
