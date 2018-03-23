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
 * LmsTmplWfFlowControl com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_tmpl_wf_flow_control", catalog = "lmsdb")
public class LmsTmplWfFlowControl implements java.io.Serializable {

	private Integer id;
	private LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMapByTrhmHopsId;
	private LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMapByTrhmDependedHopsId;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsTmplWfFlowControl() {
	}

	public LmsTmplWfFlowControl(LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMapByTrhmHopsId,
			LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMapByTrhmDependedHopsId, Date insertDate, Integer insertBy,
			Date updateDate, Integer updateBy) {
		this.lmsTmplRequestHopsRoleMapByTrhmHopsId = lmsTmplRequestHopsRoleMapByTrhmHopsId;
		this.lmsTmplRequestHopsRoleMapByTrhmDependedHopsId = lmsTmplRequestHopsRoleMapByTrhmDependedHopsId;
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
	@JoinColumn(name = "TRHM_HOPS_ID")
	public LmsTmplRequestHopsRoleMap getLmsTmplRequestHopsRoleMapByTrhmHopsId() {
		return this.lmsTmplRequestHopsRoleMapByTrhmHopsId;
	}

	public void setLmsTmplRequestHopsRoleMapByTrhmHopsId(
			LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMapByTrhmHopsId) {
		this.lmsTmplRequestHopsRoleMapByTrhmHopsId = lmsTmplRequestHopsRoleMapByTrhmHopsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRHM_DEPENDED_HOPS_ID")
	public LmsTmplRequestHopsRoleMap getLmsTmplRequestHopsRoleMapByTrhmDependedHopsId() {
		return this.lmsTmplRequestHopsRoleMapByTrhmDependedHopsId;
	}

	public void setLmsTmplRequestHopsRoleMapByTrhmDependedHopsId(
			LmsTmplRequestHopsRoleMap lmsTmplRequestHopsRoleMapByTrhmDependedHopsId) {
		this.lmsTmplRequestHopsRoleMapByTrhmDependedHopsId = lmsTmplRequestHopsRoleMapByTrhmDependedHopsId;
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
