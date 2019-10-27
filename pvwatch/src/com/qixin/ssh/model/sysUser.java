package com.qixin.ssh.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name="sys_user")
public class sysUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserID")
	private Integer userId;
	
	@Column(name="RealName")
	private String realName;
	
	@Column(name="UserAccount")
	private String userAccount;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="MobilePhone")
	private String mobilePhone;
	
	@Column(name="EMail")
	private String email;
	
	@Column(name="NickName")
	private String nickName;
	
	@Column(name="Avatar")
	private Blob avatar;
	
	@Column(name="QQ")
	private String qq;
	
	@Column(name="Weixin")
	private String weixin;
	
	@Column(name="DeptName")
	private String deptName;
	
	@Column(name="SuperAdmin")
	private Integer superAdmin;
	
	@Column(name="Status")
	private Integer status;
	
	@Column(name="CreateTime")
	private Date createTime;
	
	@Column(name="Creater")
	private Integer creater;
	
	@Column(name="CloudStatus")
	private Integer cloudStatus;
	
	@Column(name="LoginTimes")
	private Integer loginTimes;
	
	@Column(name="LastLoginTime")
	private Date lastLoginTime;
	
	@Column(name="AreaId")
	private String areaId;
	
	@Column(name="IsManager")
	private Integer isManager;

	@Column(name="LastAlterTime")
	private Date lastAlterTime;
	
	@Column(name="MAHID")
	private String mahId;
	
	
	// Constructors

	public Date getLastAlterTime() {
		return lastAlterTime;
	}

	public void setLastAlterTime(Date lastAlterTime) {
		this.lastAlterTime = lastAlterTime;
	}

	public String getMahId() {
		return mahId;
	}

	public void setMahId(String mahId) {
		this.mahId = mahId;
	}

	/** default constructor */
	public sysUser() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(Integer superAdmin) {
		this.superAdmin = superAdmin;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Integer getCloudStatus() {
		return cloudStatus;
	}

	public void setCloudStatus(Integer cloudStatus) {
		this.cloudStatus = cloudStatus;
	}

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public Integer getIsManager() {
		return isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "sysUser [userId=" + userId + ", realName=" + realName
				+ ", userAccount=" + userAccount + ", password=" + password
				+ ", mobilePhone=" + mobilePhone + ", email=" + email
				+ ", nickName=" + nickName + ", avatar=" + avatar + ", qq="
				+ qq + ", weixin=" + weixin + ", deptName=" + deptName
				+ ", superAdmin=" + superAdmin + ", status=" + status
				+ ", createTime=" + createTime + ", creater=" + creater
				+ ", cloudStatus=" + cloudStatus + ", loginTimes=" + loginTimes
				+ ", lastLoginTime=" + lastLoginTime + ", areaId=" + areaId
				+ ", isManager=" + isManager + "]";
	}

	
}
