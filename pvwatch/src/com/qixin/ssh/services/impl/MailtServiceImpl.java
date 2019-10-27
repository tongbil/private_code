package com.qixin.ssh.services.impl;

import com.qixin.ssh.model.MailAccept;
import com.qixin.ssh.model.Semail;
import com.qixin.ssh.model.SemailFile;
import com.qixin.ssh.model.sysUser;
import com.qixin.ssh.services.MailtService;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MailtServiceImpl implements MailtService {

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
    public Semail addEmail(Semail semail) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().save(semail);
        return semail;

    }
   
    @Override
    public boolean addEmailFile(SemailFile semailFile) {
        // TODO Auto-generated method stub
        try {
            sessionFactory.getCurrentSession().save(semailFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Semail> listMails(String mailName) {

                String hql = "from Semail where 1=1  and reader ='未读' and status = '1' and sName like '%" + mailName + "%' ORDER BY time desc";
                Query query = sessionFactory.getCurrentSession().createQuery(hql);
                return query.list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public Semail delEmail(int id,String value,String userId) {
        Semail semail=null;
        List<Semail> list = sessionFactory.getCurrentSession().createQuery("from Semail where id=" + id).list();
        if(list != null && list.size() > 0){
            semail = list.get(0);
            semail.setDelWhy(value);
            semail.setStatus("0");
            semail.setLjUser(userId);
            

            sessionFactory.getCurrentSession().update(semail);
            return semail;
        }
        return  null;
       
    }
    @SuppressWarnings("unchecked")
    @Override
    public Semail upRead(int id) {

        Semail semail = null;
        List<Semail> list = sessionFactory.getCurrentSession().createQuery("from Semail where id=" + id).list();
        if (list != null && list.size() > 0) {
            semail = list.get(0);
            semail.setReader("已读");
            sessionFactory.getCurrentSession().update(semail);
            return semail;
        } else {
            return null;
        }

    }
    @SuppressWarnings("unchecked")
    @Override
    public List<SemailFile> upFiles(int id) {

        List<SemailFile> list = sessionFactory.getCurrentSession().createQuery("from SemailFile where mailId='" + id+"'").list();
        if (list != null && list.size() > 0) {

            return list;
        } else {
            return null;
        }
    }
   
    @Override
    public boolean disEmail() {

        String sql="delete from data_semail where id not in (select minid from (select min(id) as minid from data_semail group by time) b);";
        String sql1= "delete from data_mail_file  where  mailId not in (select id from data_semail)";
        String sql2="delete from file_document  where  id not in (select fileId from data_mail_file)";
        sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
        sessionFactory.getCurrentSession().createSQLQuery(sql1).executeUpdate();
        sessionFactory.getCurrentSession().createSQLQuery(sql2).executeUpdate();
            return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Semail> localAll(String mailName) {
        String hql = "from Semail where 1=1 and sName like '%" + mailName + "%' ORDER BY time desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<SemailFile> listFileLocal() {

        String hql = "from SemailFile where 1=1 ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Semail> hsEmail(String mailName) {
        String hql = "from Semail where 1=1 and status = '0' and sName like '%" + mailName + "%' ORDER BY time desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
    @SuppressWarnings("unchecked")
	@Override
	public List<Semail> oldReader(String mailName) {
		// TODO Auto-generated method stub
		  String hql = "from Semail where 1=1  and reader ='已读' and sR is null and status = '1' and sName like '%" + mailName + "%' ORDER BY time desc";
          Query query = sessionFactory.getCurrentSession().createQuery(hql);
          return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Semail> srMail(String mailName) {
		// TODO Auto-generated method stub
		 String hql = "from Semail where 1=1  and reader ='已读' and sR ='1' and status ='1' and sName like '%" + mailName + "%' ORDER BY time desc";
         Query query = sessionFactory.getCurrentSession().createQuery(hql);
         return query.list();
	}
	@SuppressWarnings("unchecked")
	  @Override
	    public List<Semail> listMail(String mailName) {
            String hql = "from Semail where 1=1 and status = '1' and sName like '%" + mailName + "%' ORDER BY time desc";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            return query.list();
	    }
	@SuppressWarnings("unchecked")
	@Override
	public MailAccept mailDeploy() {
		// TODO Auto-generated method stub
		   String hql = "from MailAccept where 1=1 ";
		   List<MailAccept> list = sessionFactory.getCurrentSession().createQuery(hql).list();
	        if (list != null && list.size() > 0) {
	            return list.get(0);
	        } else {
	            return null;
	        }
	}

	@Override
	public void SavemailDeploy(MailAccept mailAccept) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mailAccept);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Semail upRr(int id) {

        Semail semail = null;
        List<Semail> list = sessionFactory.getCurrentSession().createQuery("from Semail where id=" + id).list();
        if (list != null && list.size() > 0) {
            semail = list.get(0);
            semail.setReader("已读");
          //  semail.setsR("1");
            sessionFactory.getCurrentSession().update(semail);
            return semail;
        } else {
            return null;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updelEmail(int id) {
		// TODO Auto-generated method stub
		  Semail semail=null;
	        List<Semail> list = sessionFactory.getCurrentSession().createQuery("from Semail where id=" + id).list();
	        if(list != null && list.size() > 0){
	            semail = list.get(0);
	          
	            semail.setStatus("1");
	            semail.setReader("未读");
	            

	            sessionFactory.getCurrentSession().update(semail);
	            return true;
	        }
	        return  false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean upMailReport(String emailId,String reportId,String userId,String bgCode) {
		// TODO Auto-generated method stub
		 //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //收件的时间
      
		  Semail semail=null;
	        List<Semail> list = sessionFactory.getCurrentSession().createQuery("from Semail where id=" + emailId).list();
	        if(list != null && list.size() > 0){
	            semail = list.get(0);
	            semail.setSrTime(sdf.format(new Date()));
	            semail.setReportId(reportId);
	            semail.setSrUser(userId);
	            semail.setReader("已读");
	            semail.setsR("1");
	            semail.setBgCode(bgCode);
	    
	            sessionFactory.getCurrentSession().update(semail);
	            return true;
	        }
	        
	        return  false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public sysUser userId() {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		   String hql = "from sysUser where 1=1 and RealName LIKE '%超级管理员%'";
		   List<sysUser> list = sessionFactory.getCurrentSession().createQuery(hql).list();
	        if (list != null && list.size() > 0) {
	            return list.get(0);
	        } else {
	            return null;
	        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean getTimes(String time,String userName) {
		// TODO Auto-generated method stub
		  
	        List<Semail> list = sessionFactory.getCurrentSession().createQuery("from Semail where   time='" + time+"'").list();
	        if (list != null && list.size() > 0) {
	        	
	            return true;
	        } else {
	            return false;
	        }
		
	}

}
