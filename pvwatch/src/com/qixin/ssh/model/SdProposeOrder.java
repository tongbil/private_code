package com.qixin.ssh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.servlet.view.JstlView;

/**
 * 申请数据质控审核主表
 */
@Entity
@Table(name = "sd_propose_order")
public class SdProposeOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dataOrder;	//业务申请编码
	private String mahId;		//企业编码
	private String object;		//业务对象
	private String optionType;	//操作类型
	private Integer proposerId;	//申请人id
	private String proposerReason;//申请理由
	private Date proposerCreatTime;//申请时间
	private Integer auditorId;	//审核人
	private Date auditorTime;	//审核时间
	private String auditorReason;//审核理由
	private String checkStatus;	//审核状态
	private String beforeJson;//之前数据
	private String afterJson;//之后数据
	private String version;
	private Date versionCreateTime;
	private String url;//返回Json得接口
	
	
	
	
	private String tableName;	//表名
	private Integer caseId;//主键
	private String reservedTwo;
	private Integer reservedThree;
	private Date reservedFour;
	private Integer number;

	// Constructors

	/** default constructor */
	public SdProposeOrder() {
	}


	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "dataOrder")
	public String getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(String dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "mahId")
	public String getMahId() {
		return this.mahId;
	}

	public void setMahId(String mahId) {
		this.mahId = mahId;
	}

	@Column(name = "object")
	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	@Column(name = "optionType")
	public String getOptionType() {
		return this.optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "proposerId")
	public Integer getProposerId() {
		return this.proposerId;
	}

	public void setProposerId(Integer proposerId) {
		this.proposerId = proposerId;
	}

	@Column(name = "proposerReason")
	public String getProposerReason() {
		return this.proposerReason;
	}

	public void setProposerReason(String proposerReason) {
		this.proposerReason = proposerReason;
	}

	@Column(name = "proposerCreatTime")
	public Date getProposerCreatTime() {
		return this.proposerCreatTime;
	}

	public void setProposerCreatTime(Date proposerCreatTime) {
		this.proposerCreatTime = proposerCreatTime;
	}

	@Column(name = "auditorId")
	public Integer getAuditorId() {
		return this.auditorId;
	}

	public void setAuditorId(Integer auditorId) {
		this.auditorId = auditorId;
	}

	@Column(name = "auditorTime")
	public Date getAuditorTime() {
		return auditorTime;
	}

	public void setAuditorTime(Date auditorTime) {
		this.auditorTime = auditorTime;
	}

	@Column(name = "checkStatus")
	public String getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	@Column(name = "beforeJson")
	public String getBeforeJson() {
		return beforeJson;
	}


	public void setBeforeJson(String beforeJson) {
		this.beforeJson = beforeJson;
	}

	@Column(name="afterJson")
	public String getAfterJson() {
		return afterJson;
	}

	public void setAfterJson(String afterJson) {
		this.afterJson = afterJson;
	}
	
	@Column(name = "tableName")
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	@Column(name = "reservedTwo")
	public String getReservedTwo() {
		return this.reservedTwo;
	}


	public void setReservedTwo(String reservedTwo) {
		this.reservedTwo = reservedTwo;
	}

	@Column(name = "reservedThree")
	public Integer getReservedThree() {
		return this.reservedThree;
	}

	public void setReservedThree(Integer reservedThree) {
		this.reservedThree = reservedThree;
	}

	@Column(name = "reservedFour")
	public Date getReservedFour() {
		return this.reservedFour;
	}

	public void setReservedFour(Date reservedFour) {
		this.reservedFour = reservedFour;
	}
	
	@Column(name="url")
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="version")
	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name="versionCreateTime")
	public Date getVersionCreateTime() {
		return versionCreateTime;
	}


	public void setVersionCreateTime(Date versionCreateTime) {
		this.versionCreateTime = versionCreateTime;
	}

	
	@Column(name="caseId")
	public Integer getCaseId() {
		return caseId;
	}


	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	

	@Column(name="auditorReason")
	public String getAuditorReason() {
		return auditorReason;
	}

	public void setAuditorReason(String auditorReason) {
		this.auditorReason = auditorReason;
	}


	@Override
	public String toString() {
		return "SdProposeOrder [id=" + id + ", dataOrder=" + dataOrder
				+ ", mahId=" + mahId + ", object=" + object + ", optionType="
				+ optionType + ", proposerId=" + proposerId
				+ ", proposerReason=" + proposerReason + ", proposerCreatTime="
				+ proposerCreatTime + ", auditorId=" + auditorId
				+ ", auditorTime=" + auditorTime + ", auditorReason="
				+ auditorReason + ", checkStatus=" + checkStatus
				+ ", beforeJson=" + beforeJson + ", afterJson=" + afterJson
				+ ", version=" + version + ", versionCreateTime="
				+ versionCreateTime + ", url=" + url + ", tableName="
				+ tableName + ", caseId=" + caseId + ", reservedTwo="
				+ reservedTwo + ", reservedThree=" + reservedThree
				+ ", reservedFour=" + reservedFour + ", number=" + number + "]";
	}


}