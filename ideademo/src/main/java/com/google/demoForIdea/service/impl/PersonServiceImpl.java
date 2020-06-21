package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.PersonDao;
import com.google.demoForIdea.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service(value = "personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	@Override
	public int insert_edit_message(Map<String, String> map) {
		return personDao.insert_edit_message(map);
	}
}
