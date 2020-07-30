package com.google.demoForIdea.dao;

import com.google.demoForIdea.common.TargetDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface Duoshujuyuan2Dao {
	@TargetDataSource("osgitest")
	List<Map> selectByEvenUserId(Map<String, Object> map);
}
