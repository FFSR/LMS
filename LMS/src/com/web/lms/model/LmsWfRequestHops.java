package com.web.lms.model;
// com.web.lms.modelerated Mar 23, 2018 5:44:35 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.com.web.lms.modeleratedValue;
import static javax.persistence.com.web.lms.modelerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LmsWfRequestHops com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_wf_request_hops", catalog = "lmsdb")
public class LmsWfRequestHops implements java.io.Serializable {

	private Integer id;
	private LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMap;
	private LmsWfRequest lmsWfRequest;
	private Integer wfRoleId;
	private Date startDate;
	private Date endDate;
	private String status;
	private Integer userId;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsWfRequestHops() {
	}

	public LmsWfRequestHops(LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMap, LmsWfRequest lmsWfRequest,
			Integer wfRoleId, Date startDate, Date endDate, String status, Integer userId, Date insertDate,
			Integer insertBy, Date updateDate, Integer updateBy) {
		this.lmsTmplRequestHopsRoleMap = lmsTmplRequestHopsRoleMap;
		this.lmsWfRequest = lmsWfRequest;
		this.wfRoleId = wfRoleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.userId = userId;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}

	@Id
	@com.web.lms.modeleratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TMPL_WF_HOPS_ID")
	public LmsTmplRequestHopsRoleMap getLmsTmplRequestHopsRoleMap() {
		return this.lmsTmplRequestHopsRoleMap;
	}

	public void setLmsTmplRequestHopsRoleMap(LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMap) {
		this.lmsTmplRequestHopsRoleMap = lmsTmplRequestHopsRoleMap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_REQUEST_ID")
	public LmsWfRequest getLmsWfRequest() {
		return this.lmsWfRequest;
	}

	public void setLmsWfRequest(LmsWfRequest lmsWfRequest) {
		this.lmsWfRequest = lmsWfRequest;
	}

	@Column(name = "WF_ROLE_ID")
	public Integer getWfRoleId() {
		return this.wfRoleId;
	}

	public void setWfRoleId(Integer wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "STATUS", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "USER_ID")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERT_DATE", length = 19)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Column(name = "INSERT_BY")
	public Integer getInsertBy() {
		return this.insertBy;
	}

	public void setInsertBy(Integer insertBy) {
		this.insertBy = insertBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_BY")
	public Integer getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

}
