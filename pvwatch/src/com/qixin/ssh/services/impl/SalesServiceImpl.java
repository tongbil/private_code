package com.qixin.ssh.services.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.qixin.ssh.model.Batch;
import com.qixin.ssh.model.Sales;
import com.qixin.ssh.services.BatchService;
import com.qixin.ssh.services.SalesService;

public class SalesServiceImpl implements SalesService {
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

	//查看所有的数据
		@SuppressWarnings("unchecked")
		@Override
		public List<Sales> getList() {
			// TODO Auto-generated method stub
			String hql="from Sales where 1=1";
			System.out.println(hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();	
		}
		
		
		//获取搜索后的数据
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> getOneSales(String qiyeId,String genericFunction, String strength,
				Date date, Date datese) {
			// TODO Auto-generated method stub
			//转成字符串
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String hql;
			System.out.println(genericFunction.equals(""));
			if(genericFunction.equals("")){
				hql= "select s.presId,s.productId,s.proName,s.CFDACode,s.numbers,s.adress,s.intime,s.outtime,s.strength,s.danwei from data_product p ,data_sales s "
						+ "where s.productId =p.ProductID  and p.MahId ='"+qiyeId+"'";
				if(strength !=null && !strength.equals("")){
					hql=hql+" and s.strength="+strength;
				}
				
				if(date !=null && !date.equals("")){
					String dates = formatter.format(date);
					hql=hql+" and s.outtime >= '"+ dates + "'";
				}
				if(datese !=null && !datese.equals("")){
					String dateses = formatter.format(datese);
					hql=hql+" and s.outtime <= '"+ dateses + "'";
				}
				SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(hql);
				List<Object[]> list = createSQLQuery.list();
				return list;

			}else{
				 hql ="select s.presId,s.productId,s.proName,s.CFDACode,s.numbers,s.adress,s.intime,s.outtime,s.strength,s.danwei from data_sales as s where 1=1";
				if(genericFunction !=null && !genericFunction.equals("")){
					hql=hql+" and s.productId="+genericFunction;
				}
				if(strength !=null && !strength.equals("")){
					hql=hql+" and s.strength="+strength;
				}
				
				if(date !=null && !date.equals("")){
					String dates = formatter.format(date);
					hql=hql+" and s.outtime >= '"+ dates + "'";
				}
				if(datese !=null && !datese.equals("")){
					String dateses = formatter.format(datese);
					hql=hql+" and s.outtime <= '"+ dateses + "'";
				}			
					SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(hql);
					List<Object[]> list = createSQLQuery.list();
					return list;
			}
		
			
		}
		//获取通用名称
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> getSalesName(String tName) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			String sql = "select GenericChineseName,ProductID from data_product  where MahId ='"+tName+"'  GROUP BY GenericChineseName";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}
		//获取通用名称规格和批准文号
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> getProduct() {
			// TODO Auto-generated method stub
			String sql ="select  ProductID,GenericChineseName,strength,CFDADrugCode from data_product  group by GenericChineseName";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
			
		}
		//获取省
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> getSheng() {
			// TODO Auto-generated method stub
			String sql ="select * from sys_area where ParentCode =000000";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}
		//获取市
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> getShi(String shi) {
			// TODO Auto-generated method stub
			String sql ="select * from sys_area where ParentCode ='"+shi+"'";
			SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			List<Object[]> list = createSQLQuery.list();
			return list;
		}

		@Override
		public boolean saveSales(Sales sales) {
			// TODO Auto-generated method stub
			try {			
				sessionFactory.getCurrentSession().save(sales);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
		}

}
