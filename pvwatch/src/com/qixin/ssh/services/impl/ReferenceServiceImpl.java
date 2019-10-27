package com.qixin.ssh.services.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.qixin.ssh.model.Batch;
import com.qixin.ssh.model.Reference;
import com.qixin.ssh.model.Sales;
import com.qixin.ssh.services.BatchService;
import com.qixin.ssh.services.ReferenceService;
import com.qixin.ssh.services.SalesService;

public class ReferenceServiceImpl implements ReferenceService {
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
	public List<Object[]> getName(String mahid) {
		if(mahid.equals("-1")){
			String sql = "select GenericChineseName,ProductID from data_product   GROUP BY GenericChineseName";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}else{
			String sql = "select GenericChineseName,ProductID from data_product  where MahId ='"+mahid+"'  GROUP BY GenericChineseName";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}
		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getblfy(String productId) {
		// TODO Auto-generated method stub
		if(productId.equals("-1")){
			String sql = "select ProductID,EventName,EventCode from data_product_event";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}else{
			String sql = "select ProductID,EventName,EventCode from data_product_event where ProductID ="+productId;
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllblfy() {
		String sql="select u.RealName,r.id,r.productName,r.eventName,r.eventCode,r.userId,r.element,r.content,r.createTime from iscr_product_medical_reference as r,sys_user as u where u.UserID=r.userId";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}

	@Override
	public boolean deleteInfo(int batchId) {
		// TODO Auto-generated method stub
		
					Reference batch =new Reference();
					batch.setId(batchId);
					sessionFactory.getCurrentSession().delete(batch);
					return true;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> seclittle(String qiyeId,String proName,String zccf,String blName) {
		// TODO Auto-generated method stub
		String hql="select u.RealName,r.id,r.productName,r.eventName,r.eventCode,r.userId,r.element,r.content,r.createTime from iscr_product_medical_reference as r,sys_user as u,data_product as p  where u.UserID=r.userId  and p.GenericChineseName =r.productName";
		if(qiyeId !=null && qiyeId.equals("")){
			hql=hql+"and p.MahId ="+qiyeId+"'";
		}
		if(proName !=null && !proName.equals("")){
			hql=hql+" and r.productName='"+proName+"'";
		}
		if(zccf !=null && !zccf.equals("")){
			hql=hql+" and r.element='"+zccf+"'";
		}
		
		if(blName !=null && !blName.equals("")){
			hql=hql+" and r.eventName='"+blName+"'";
		}
		
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(hql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}
	//获取所有组成成分
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> zccf() {
		// TODO Auto-generated method stub
		String sql = "select SubstanceName_CN from data_substance ";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}

	@Override
	public boolean saveRef(Reference reference) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().save(reference);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectRefone(int id) {
		// TODO Auto-generated method stub
		String sql="select d.MahId,r.* from data_product d,iscr_product_medical_reference r where r.productName =d.ProductName and r.id = "+id+"  group by d.MahId ";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
		
	}

	@Override
	public boolean updateRef(Reference reference) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().update(reference);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> sid() {
		// TODO Auto-generated method stub
		String sql="select id from iscr_product_medical_reference order by id desc limit 0,1";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}
	

		
	

}
