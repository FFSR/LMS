package com.web.lms.model;
// com.web.lms.modelerated Mar 23, 2018 5:44:35 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.com.web.lms.modeleratedValue;
import static javax.persistence.com.web.lms.modelerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LmsWfRequest com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_wf_request", catalog = "lmsdb")
public class LmsWfRequest implements java.io.Serializable {

	private Integer id;
	private LmsTmplWfRequestType lmsTmplWfRequestType;
	private LmsUser lmsUser;
	private Date startDate;
	private Date endDate;
	private String status;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsWfRequestHops> lmsWfRequestHopses = new HashSet<LmsWfRequestHops>(0);

	public LmsWfRequest() {
	}

	public LmsWfRequest(LmsTmplWfRequestType lmsTmplWfRequestType, LmsUser lmsUser, Date startDate, Date endDate,
			String status, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Set<LmsWfRequestHops> lmsWfRequestHopses) {
		this.lmsTmplWfRequestType = lmsTmplWfRequestType;
		this.lmsUser = lmsUser;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsWfRequestHopses = lmsWfRequestHopses;
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
	@JoinColumn(name = "TMPL_WF_REQUEST_TYPE_ID")
	public LmsTmplWfRequestType getLmsTmplWfRequestType() {
		return this.lmsTmplWfRequestType;
	}

	public void setLmsTmplWfRequestType(LmsTmplWfRequestType lmsTmplWfRequestType) {
		this.lmsTmplWfRequestType = lmsTmplWfRequestType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUser() {
		return this.lmsUser;
	}

	public void setLmsUser(LmsUser lmsUser) {
		this.lmsUser = lmsUser;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsWfRequest")
	public Set<LmsWfRequestHops> getLmsWfRequestHopses() {
		return this.lmsWfRequestHopses;
	}

	public void setLmsWfRequestHopses(Set<LmsWfRequestHops> lmsWfRequestHopses) {
		this.lmsWfRequestHopses = lmsWfRequestHopses;
	}

}
