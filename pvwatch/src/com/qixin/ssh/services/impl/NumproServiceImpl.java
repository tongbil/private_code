package com.qixin.ssh.services.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.qixin.ssh.model.Numpro;
import com.qixin.ssh.services.NumproService;

public class NumproServiceImpl implements NumproService {
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getForcomany(String id) {
		// TODO Auto-generated method stub
		String sql = "select GenericChineseName,ProductID from data_product  where MahId ='"+id+"'  GROUP BY GenericChineseName";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Numpro getFornumber(int id) {
		// TODO Auto-generated method stub
		Numpro number =null;
		List<Numpro> list = sessionFactory.getCurrentSession().createQuery("from Numpro as num where 1 = 1 and num.productId = " + id).list();
			
		if(list != null && list.size() > 0){
			number = list.get(0);
		}
		return number;
	}

	@Override
	public boolean saveNum(Numpro numpro) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().save(numpro);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean updateNum(Numpro numpro) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().update(numpro);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
