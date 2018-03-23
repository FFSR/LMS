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
 * LmsTmplRequestHopsRoleMap com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_tmpl_request_hops_role_map", catalog = "lmsdb")
public class LmsTmplRequestHopsRoleMap implements java.io.Serializable {

	private Integer id;
	private LmsTmplWfHops lmsTmplWfHops;
	private LmsTmplWfRequestType lmsTmplWfRequestType;
	private LmsTmplWfRole lmsTmplWfRole;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsWfRequestHops> lmsWfRequestHopses = new HashSet<LmsWfRequestHops>(0);
	private Set<LmsTmplWfFlowControl> lmsTmplWfFlowControlsForTrhmHopsId = new HashSet<LmsTmplWfFlowControl>(0);
	private Set<LmsTmplWfFlowControl> lmsTmplWfFlowControlsForTrhmDependedHopsId = new HashSet<LmsTmplWfFlowControl>(0);

	public LmsTmplRequestHopsRoleMap() {
	}

	public LmsTmplRequestHopsRoleMap(LmsTmplWfHops lmsTmplWfHops, LmsTmplWfRequestType lmsTmplWfRequestType,
			LmsTmplWfRole lmsTmplWfRole, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Set<LmsWfRequestHops> lmsWfRequestHopses, Set<LmsTmplWfFlowControl> lmsTmplWfFlowControlsForTrhmHopsId,
			Set<LmsTmplWfFlowControl> lmsTmplWfFlowControlsForTrhmDependedHopsId) {
		this.lmsTmplWfHops = lmsTmplWfHops;
		this.lmsTmplWfRequestType = lmsTmplWfRequestType;
		this.lmsTmplWfRole = lmsTmplWfRole;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsWfRequestHopses = lmsWfRequestHopses;
		this.lmsTmplWfFlowControlsForTrhmHopsId = lmsTmplWfFlowControlsForTrhmHopsId;
		this.lmsTmplWfFlowControlsForTrhmDependedHopsId = lmsTmplWfFlowControlsForTrhmDependedHopsId;
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
	@JoinColumn(name = "WF_HOPS_ID")
	public LmsTmplWfHops getLmsTmplWfHops() {
		return this.lmsTmplWfHops;
	}

	public void setLmsTmplWfHops(LmsTmplWfHops lmsTmplWfHops) {
		this.lmsTmplWfHops = lmsTmplWfHops;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_REQUEST_TYPE_ID")
	public LmsTmplWfRequestType getLmsTmplWfRequestType() {
		return this.lmsTmplWfRequestType;
	}

	public void setLmsTmplWfRequestType(LmsTmplWfRequestType lmsTmplWfRequestType) {
		this.lmsTmplWfRequestType = lmsTmplWfRequestType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_ROLE_ID")
	public LmsTmplWfRole getLmsTmplWfRole() {
		return this.lmsTmplWfRole;
	}

	public void setLmsTmplWfRole(LmsTmplWfRole lmsTmplWfRole) {
		this.lmsTmplWfRole = lmsTmplWfRole;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsTmplRequestHopsRoleMap")
	public Set<LmsWfRequestHops> getLmsWfRequestHopses() {
		return this.lmsWfRequestHopses;
	}

	public void setLmsWfRequestHopses(Set<LmsWfRequestHops> lmsWfRequestHopses) {
		this.lmsWfRequestHopses = lmsWfRequestHopses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsTmplRequestHopsRoleMapByTrhmHopsId")
	public Set<LmsTmplWfFlowControl> getLmsTmplWfFlowControlsForTrhmHopsId() {
		return this.lmsTmplWfFlowControlsForTrhmHopsId;
	}

	public void setLmsTmplWfFlowControlsForTrhmHopsId(Set<LmsTmplWfFlowControl> lmsTmplWfFlowControlsForTrhmHopsId) {
		this.lmsTmplWfFlowControlsForTrhmHopsId = lmsTmplWfFlowControlsForTrhmHopsId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsTmplRequestHopsRoleMapByTrhmDependedHopsId")
	public Set<LmsTmplWfFlowControl> getLmsTmplWfFlowControlsForTrhmDependedHopsId() {
		return this.lmsTmplWfFlowControlsForTrhmDependedHopsId;
	}

	public void setLmsTmplWfFlowControlsForTrhmDependedHopsId(
			Set<LmsTmplWfFlowControl> lmsTmplWfFlowControlsForTrhmDependedHopsId) {
		this.lmsTmplWfFlowControlsForTrhmDependedHopsId = lmsTmplWfFlowControlsForTrhmDependedHopsId;
	}

}
