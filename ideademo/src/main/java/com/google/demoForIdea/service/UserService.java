package com.google.demoForIdea.service;

import com.github.pagehelper.PageInfo;
import com.google.demoForIdea.model.UserDomain;
import java.util.List;
import java.util.Map;

public interface  UserService {
   int addUser(UserDomain user);

   List<Map> selUser(Map<String,Object> map);

   List<Map> getAllTeacherInfo(Map<String,Object> map);

   PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
