package com.google.demoForIdea.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository

public interface DuoshujuyuanDao {

	List<Map> selectByOddUserId(Map<String, Object> map);

}
