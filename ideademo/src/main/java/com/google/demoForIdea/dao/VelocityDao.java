package com.google.demoForIdea.dao;

import java.util.List;
import java.util.Map;

public interface VelocityDao {
	List<Map> do_sql(Map<String,Object> map);
}
