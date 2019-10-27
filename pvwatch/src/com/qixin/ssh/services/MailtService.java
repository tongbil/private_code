package com.qixin.ssh.services;


import com.qixin.ssh.model.MailAccept;
import com.qixin.ssh.model.Semail;
import com.qixin.ssh.model.SemailFile;
import com.qixin.ssh.model.sysUser;

import java.util.List;

public interface MailtService {
	
	//查看回收站的邮件
	public List<Semail> hsEmail(String mailName);
	//邮件入库
	public	Semail addEmail(Semail semail);
	//文件入库
	//邮件入库
	public	boolean addEmailFile(SemailFile semailFile);

	//查看未读邮件
	public List<Semail> listMails(String mailName);
	
	public List<Semail> listMail(String mailName);
	
	//报告调的接口
	public boolean upMailReport(String emailId, String reportId, String userId, String bgCode);
	
	
	
	//查看已读邮件
	public List<Semail> oldReader(String mailName);
	//查看已搜入邮件
	public List<Semail> srMail(String mailName);
	
	
	//放入回收站
	public  Semail delEmail(int id, String value, String userId);
	//回收站恢复
	public  boolean updelEmail(int id);
	//修改已读状态
	public Semail upRead(int id);
	//修改录入状态
	public Semail upRr(int id);

	//查看邮件的所有文件
	public List<SemailFile> upFiles(int id);
	//删除重复邮件
	public boolean disEmail();

	//查找本地邮件包含回收站
	public List<Semail> localAll(String mailName);
	//查找邮件表的所有fileID
	public  List<SemailFile> listFileLocal();
	//查找配置信息库
	public MailAccept mailDeploy();
	//保存修改信息库
	public  void SavemailDeploy(MailAccept mailAccept);

	//拿出管理员Id
	public sysUser userId();
	//根据时间去查邮件
		public boolean getTimes(String time,String userName);
}
