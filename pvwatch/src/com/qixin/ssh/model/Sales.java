package com.qixin.ssh.model;

import java.util.Date;



public class Sales {
	private int presId;//销量id主键
	private String productId;//关联产品主键
	private String proName; //产品名字
	private String CFDACode; //批准文号
	private String numbers; //销量
	private String adress;//地区
	private Date intime; //录入时间
	private Date outtime;//售出时间
	private String strength;//规格
	private String danwei;//单位
	public int getPresId() {
		return presId;
	}
	public void setPresId(int presId) {
		this.presId = presId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getCFDACode() {
		return CFDACode;
	}
	public void setCFDACode(String cFDACode) {
		CFDACode = cFDACode;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Date getOuttime() {
		return outtime;
	}
	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	@Override
	public String toString() {
		return "Sales [presId=" + presId + ", productId=" + productId
				+ ", proName=" + proName + ", CFDACode=" + CFDACode
				+ ", numbers=" + numbers + ", adress=" + adress + ", intime="
				+ intime + ", outtime=" + outtime + ", strength=" + strength
				+ ", danwei=" + danwei + "]";
	}
	
	
}
