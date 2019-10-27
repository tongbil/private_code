package com.qixin.ssh.model;
public class Semail {
	private int id;
	private String fName;  //发件人
	private String sName;	//收件人
	private String status; //状态判断删除
	private String content; //邮件内容
	private String title; //邮件标题
	private String time; //邮件时间
	private String reader; //是否已读
	private String cName; //抄送人
	private String delWhy;//删除原因
	private String sR;//是否搜入
	private String reportId;//报告Id
	private String srTime;//录入时间
	private String srUser;//录入人
	private String sjTime;//收件时间
	private String sjUser;//收件人
	private String ljUser;//回收垃圾人
	private String bgCode;//报告编码
	
	public String getBgCode() {
		return bgCode;
	}
	public void setBgCode(String bgCode) {
		this.bgCode = bgCode;
	}
	public String getLjUser() {
		return ljUser;
	}
	public void setLjUser(String ljUser) {
		this.ljUser = ljUser;
	}
	public String getSrUser() {
		return srUser;
	}
	public void setSrUser(String srUser) {
		this.srUser = srUser;
	}
	public String getSjTime() {
		return sjTime;
	}
	public void setSjTime(String sjTime) {
		this.sjTime = sjTime;
	}
	public String getSjUser() {
		return sjUser;
	}
	public void setSjUser(String sjUser) {
		this.sjUser = sjUser;
	}
	public String getSrTime() {
		return srTime;
	}
	public void setSrTime(String srTime) {
		this.srTime = srTime;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getsR() {
		return sR;
	}
	public void setsR(String sR) {
		this.sR = sR;
	}
	public String getDelWhy() {
		return delWhy;
	}
	public void setDelWhy(String delWhy) {
		this.delWhy = delWhy;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getReader() {
		return reader;
	}
	public void setReader(String reader) {
		this.reader = reader;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
