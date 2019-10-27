package com.qixin.ssh.model;

import java.util.Date;

public class FileEntity {
	private Integer fileId;
	private String name;
	private String createUserId;
	private String createUserAccount;
	private String updateTime;
	private String lookPath;
	private String downloadPath;
	private Integer version;
	private Integer pid;
	private Integer status; //1:文件 0：文件夹
	
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLookPath() {
		return lookPath;
	}
	public void setLookPath(String lookPath) {
		this.lookPath = lookPath;
	}
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserAccount() {
		return createUserAccount;
	}
	public void setCreateUserAccount(String createUserAccount) {
		this.createUserAccount = createUserAccount;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
