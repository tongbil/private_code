package com.qixin.ssh.services.impl;
import com.qixin.ssh.model.Repetion;
import com.qixin.ssh.services.RepetionService;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;


public class RepetionServiceImpl implements RepetionService {
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
	public List<Repetion> getAllRepetion() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
					String hql="from Repetion where 1=1";
					System.out.println(hql);
					Query query = sessionFactory.getCurrentSession().createQuery(hql);
					return query.list();	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Repetion updateRepetion(String id) {
		// TODO Auto-generated method stub
		Repetion repetion =null;
		if(id!=null && !id.equals("")){
			List<Repetion> list = sessionFactory.getCurrentSession().createQuery("from Repetion where id=" + id).list();
		    if(list != null && list.size() > 0){
		    	repetion = list.get(0);
		    		repetion.setStatus(Integer.parseInt("1"));
	            sessionFactory.getCurrentSession().update(repetion);
	            return repetion;
	        }
		}else{
			List<Repetion> list = sessionFactory.getCurrentSession().createQuery("from Repetion where 1 = 1").list();
		    if(list != null && list.size() > 0){
		    	for(int i=0;i<list.size();i++){
		    		list.get(i).setStatus(0);
		            sessionFactory.getCurrentSession().update(list.get(i));
		    	}
	        }
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Repetion> getStatus() {
		List<Repetion> list = sessionFactory.getCurrentSession().createQuery("from Repetion where status = 1").list();
		if(list!=null&& list.size()>0){
			return list;
		}
		 return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]>  upAreaCode() {
		// TODO Auto-generated method stub
		ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
		String sql="select  b.ReportCode,b.Country,b.AreaCode, b.ReportID from (select a.ReportCode,a.Country,a.AreaCode,a.ReportID from icsr_general a where a.ReportCode NOT like '[A-Z]%' and a.ReportCode is not null and a.ReportID !='') as b where b.AreaCode is NULL or b.AreaCode =''";
		List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++){
					 Object[] objects = list.get(i);
					 if(objects[0]!=null){
						 objects[2]=objects[0].toString().substring(0, 6);
						 String hql="update icsr_general set AreaCode ='"+objects[2] +"' where ReportID="+objects[3];
						 sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
					 }
					 arrayList.add(objects);
				}
				return arrayList;
			}
			return null;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> putReportAll() {
		// TODO Auto-generated method stub
		String sql ="select m.ReportID,m.ReportCode,m.OccurrenceDate,m.PatientBirthdate, m.PatientSex,m.PatientOnsetAge,m.PatientOnsetAgeUnit, m.CaseNarrativeComment from  (select g.ReportID ,g.ReportCode,p.PatientBirthdate,g.OccurrenceDate, p.PatientSex,p.PatientOnsetAge,p.PatientOnsetAgeUnit ,s.CaseNarrativeComment from icsr_general g,icsr_patient p,icsr_native_language_summary s  where p.ReportID =g.ReportID and g.ReportID =s.ReportID)m  where  m.PatientOnsetAge is  null or m.PatientSex = 0";
		List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();	
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getContent(int obj) {
		// TODO Auto-generated method stub
		String sql= "select CaseNarrativeComment from icsr_native_language_summary where ReportID="+obj;
		List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();	
		if(list!=null &&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean upOneReport(String obj,String sex,String age,String dw) {
		// TODO Auto-generated method stub
		String sql="update icsr_patient set PatientSex="+sex+",PatientOnsetAge="+age+",PatientOnsetAgeUnit='"+dw+"' where ReportID="+obj;
		int executeUpdate = sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
		if(executeUpdate>0){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getUser() {
		// TODO Auto-generated method stub
		String sql="select   UserID,RealName from sys_user";
		List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();	
		if(list!=null &&list.size()>0){
			return list;
		}
		return null;
		
	}

}
