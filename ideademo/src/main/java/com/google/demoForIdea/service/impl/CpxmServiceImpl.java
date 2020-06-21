package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.CpxmDao;
import com.google.demoForIdea.service.CpxmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service(value = "cpxmService")
public class CpxmServiceImpl implements CpxmService {
	@Autowired
	private CpxmDao cpxmDao;

	@Override
	public int insert_Template(Map<String, Object> map) {
		return cpxmDao.insert_Template(map);
	}

	@Override
	public int insert_Template_item(Map<String, Object> map) {
		return cpxmDao.insert_Template_item(map);
	}

	@Override
	public int insert_Template_item_config(Map<String, Object> map) {
		return cpxmDao.insert_Template_item_config(map);
	}

	@Override
	public int person(Map<String, Object> map) {
		return cpxmDao.person(map);
	}
	@Override
	public List<Map> select_template() {
		return cpxmDao.select_template();
	}
}
