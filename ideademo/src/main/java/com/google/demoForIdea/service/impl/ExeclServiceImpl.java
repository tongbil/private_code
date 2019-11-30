package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.ExeclDao;
import com.google.demoForIdea.service.ExeclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service(value = "execlService")
public class ExeclServiceImpl  implements ExeclService {
	@Autowired
	private ExeclDao  execlDao;
	@Override
	public int inserExecl(Map<String, Object> map) {
		return execlDao.inserExecl(map);
	}
}
