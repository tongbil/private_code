package com.qixin.ssh.model;

import java.util.Date;

public class Reference {
 private int id;
 private String productName;//产品名字
 private String eventName; //不良反应名称
 private String eventCode;//不良反应名称编码
 private int userId;//人
 private String element;//组成成分
 private String content; //富文本录入的信息
 private Date createTime; //创建的时间
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getEventCode() {
	return eventCode;
}
public void setEventCode(String eventCode) {
	this.eventCode = eventCode;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getElement() {
	return element;
}
public void setElement(String element) {
	this.element = element;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
@Override
public String toString() {
	return "Reference [id=" + id + ", productName=" + productName
			+ ", eventName=" + eventName + ", eventCode=" + eventCode
			+ ", userId=" + userId + ", element=" + element + ", content="
			+ content + ", createTime=" + createTime + "]";
}
 

 
}
