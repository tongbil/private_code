package com.qixin.ssh.model;
import java.util.Date;

public class Batch {
	private int batchId;  //id;
	private String batchNum; //批次号
	private String productName; //通用名称
	private String CFDACode;//  批准文号
	private String dosage; //剂型
	private String strength; //规格
	private Date manufactureTime;//生产日期
	private int number;  //数量
	private String packaging; //包装单位
	private String Manufacturer; //生产企业
	private int productId; //产品id
	private String mahId; //企业标识
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCFDACode() {
		return CFDACode;
	}
	public void setCFDACode(String cFDACode) {
		CFDACode = cFDACode;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public Date getManufactureTime() {
		return manufactureTime;
	}
	public void setManufactureTime(Date manufactureTime) {
		this.manufactureTime = manufactureTime;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMahId() {
		return mahId;
	}
	public void setMahId(String mahId) {
		this.mahId = mahId;
	}
	
	
	@Override
	public String toString() {
		return "batch [batchId=" + batchId + ", batchNum=" + batchNum
				+ ", productName=" + productName + ", CFDACode=" + CFDACode
				+ ", dosage=" + dosage + ", strength=" + strength
				+ ", manufactureTime=" + manufactureTime + ", number=" + number
				+ ", packaging=" + packaging + ", Manufacturer=" + Manufacturer
				+ ", productId=" + productId + ", mahId=" + mahId + "]";
	}

}
