package com.qixin.ssh.model;

public class Files {
 private int fileId;
 private int medicalId;
 private String fileName;
 private String fileUrl;
 private String groupName;
 private String saveName;
 
 
 
 
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public String getSaveName() {
	return saveName;
}
public void setSaveName(String saveName) {
	this.saveName = saveName;
}
public int getFileId() {
	return fileId;
}
public void setFileId(int fileId) {
	this.fileId = fileId;
}
public int getMedicalId() {
	return medicalId;
}
public void setMedicalId(int medicalId) {
	this.medicalId = medicalId;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getFileUrl() {
	return fileUrl;
}
public void setFileUrl(String fileUrl) {
	this.fileUrl = fileUrl;
}
 
}
