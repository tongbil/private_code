package com.qixin.ssh.services.impl;
import com.qixin.ssh.model.Batch;
import com.qixin.ssh.services.BatchService;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BatchServiceImpl implements BatchService {
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
	//根据批次号,时间,通用类型,获取当前数据对象
	@SuppressWarnings("unchecked")
	@Override
	public List<Batch> getOneBatch(String batchNum,Date starTime,Date endTime,String productName) {
		// TODO Auto-generated method stub

		//转成字符串
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


		String hql ="from Batch as b where 1=1";
		if(batchNum !=null && !batchNum.equals("")){
			hql=hql+" and b.batchNum="+batchNum;
		}
		if(productName !=null && !productName.equals("")){
			hql=hql+" and b.productName="+productName;
		}

		if(starTime !=null && !starTime.equals("")){
			String starTimes = formatter.format(starTime);
			hql=hql+" and b.manufactureTime >= '"+ starTimes + "'";
		}
		if(endTime !=null && !endTime.equals("")){
			String endTimes = formatter.format(endTime);
			hql=hql+" and b.manufactureTime <= '"+ endTimes + "'";
		}

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	//根据id查看详情
	@SuppressWarnings("unchecked")
	@Override
	public Batch getDetalsBatch(int batchId) {
		// TODO Auto-generated method stub
		Batch batch=null;
		List<Batch> list = sessionFactory.getCurrentSession().createQuery("from Batch where batchId=" + batchId).list();
		if(list != null && list.size() > 0){
			batch = list.get(0);
		}
		return batch;
	}
	//查看所有的数据
	@SuppressWarnings("unchecked")
	@Override
	public List<Batch> getList() {
		// TODO Auto-generated method stub
		String hql="from Batch where 1=1";
		System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	//录入一个数据
	@Override
	public boolean saveInfo(Batch batch) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(batch);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//修改一个数据
	@Override
	public boolean updateInfo(Batch batch) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(batch);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//删除
	@Override
	public boolean deleteInfo(int batchId) {
		// TODO Auto-generated method stub

		Batch batch =new Batch();
		batch.setBatchId(batchId);
		sessionFactory.getCurrentSession().delete(batch);
		return true;
	}
	//根据批次号获取对象
	@SuppressWarnings("unchecked")
	@Override
	public Batch getPici(int batchNum) {
		// TODO Auto-generated method stub
		Batch batch=null;
		List<Batch> list = sessionFactory.getCurrentSession().createQuery("from Batch where batchId=" + batchNum).list();
		if(list != null && list.size() > 0){
			batch = list.get(0);
		}
		return batch;
	}
	//根据Mahid获取通用名称
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getName(String mahid) {
		// TODO Auto-generated method stub
		String sql = "select DISTINCT(GenericChineseName),ProductI,MahId from data_product  where MahId ='"+mahid+"'";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPici(String tName) {
		// TODO Auto-generated method stub
		String sql = "select CFDADrugCode from data_product  where CFDADrugCode='"+tName+"'";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPiNum(String PciNum) {
		// TODO Auto-generated method stub
		String sql = "select dosageForm ,Strength  from data_product  where CFDADrugCode='"+PciNum+"'";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}










	//导入exel表
	@Override
	public Boolean addAnticipation(List<Batch> Batchs) {
		try {
			if(Batchs!=null && Batchs.size()>0){
				for(int i=0;i<Batchs.size();i++){
					sessionFactory.getCurrentSession().save(Batchs.get(i));
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//规整手动导入
	@Override
	public Boolean addManualanticipation(List<Batch> Batchs) {


		try {
			if(Batchs!=null && Batchs.size()>0){
				for(int i=0;i<Batchs.size();i++){
					sessionFactory.getCurrentSession().save(Batchs.get(i));
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Object[]> getlikePici(String tName) {
		// TODO Auto-generated method stub
		String sql = "select CFDADrugCode from data_product  where CFDADrugCode like'%"+tName+"%'";
		SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> list = createSQLQuery.list();
		return list;
	}




}
