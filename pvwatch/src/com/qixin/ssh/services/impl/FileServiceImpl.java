package com.qixin.ssh.services.impl;
import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import com.qixin.ssh.model.Batch;
import com.qixin.ssh.model.Files;
import com.qixin.ssh.services.FileService;

public class FileServiceImpl implements FileService {
	private SessionFactory sessionFactory; 	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;	
	}
	
	public void init(){
		System.out.println("try starts");
	}

	@Override
	public Files saveFiles(Files files) {
		// TODO Auto-generated method stub
	
			 sessionFactory.getCurrentSession().save(files);
			return files;
		
	}

	@Override
	public Files downFiles(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Files files=null;
				List<Files> list = sessionFactory.getCurrentSession().createQuery("from Files where fileId=" + id).list();
				if(list != null && list.size() > 0){
					files = list.get(0);
				}
				return files;
	}


}
