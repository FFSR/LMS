package com.web.lms.model;
// Generated May 19, 2018 10:54:22 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * LmsWftRequestHopRolePageMap generated by hbm2java
 */
@Entity
@Table(name = "lms_wft_request_hop_role_page_map", catalog = "lmsdb")
public class LmsWftRequestHopRolePageMap implements java.io.Serializable {

	private Integer id;
	private LmsPages lmsPages;
	private LmsWftHop lmsWftHop;
	private LmsWftRequestType lmsWftRequestType;
	private LmsWftRole lmsWftRole;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsWfRequestHop> lmsWfRequestHops = new HashSet<LmsWfRequestHop>(0);
	private Set<LmsWftFlowControl> lmsWftFlowControlsForTrhmHopsId = new HashSet<LmsWftFlowControl>(0);
	private Set<LmsWftFlowControl> lmsWftFlowControlsForTrhmDependedHopsId = new HashSet<LmsWftFlowControl>(0);

	public LmsWftRequestHopRolePageMap() {
	}

	public LmsWftRequestHopRolePageMap(LmsPages lmsPages, LmsWftHop lmsWftHop, LmsWftRequestType lmsWftRequestType,
			LmsWftRole lmsWftRole, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Set<LmsWfRequestHop> lmsWfRequestHops, Set<LmsWftFlowControl> lmsWftFlowControlsForTrhmHopsId,
			Set<LmsWftFlowControl> lmsWftFlowControlsForTrhmDependedHopsId) {
		this.lmsPages = lmsPages;
		this.lmsWftHop = lmsWftHop;
		this.lmsWftRequestType = lmsWftRequestType;
		this.lmsWftRole = lmsWftRole;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsWfRequestHops = lmsWfRequestHops;
		this.lmsWftFlowControlsForTrhmHopsId = lmsWftFlowControlsForTrhmHopsId;
		this.lmsWftFlowControlsForTrhmDependedHopsId = lmsWftFlowControlsForTrhmDependedHopsId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PAGE_ID")
	public LmsPages getLmsPages() {
		return this.lmsPages;
	}

	public void setLmsPages(LmsPages lmsPages) {
		this.lmsPages = lmsPages;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WF_HOPS_ID")
	public LmsWftHop getLmsWftHop() {
		return this.lmsWftHop;
	}

	public void setLmsWftHop(LmsWftHop lmsWftHop) {
		this.lmsWftHop = lmsWftHop;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WF_REQUEST_TYPE_ID")
	public LmsWftRequestType getLmsWftRequestType() {
		return this.lmsWftRequestType;
	}

	public void setLmsWftRequestType(LmsWftRequestType lmsWftRequestType) {
		this.lmsWftRequestType = lmsWftRequestType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WF_ROLE_ID")
	public LmsWftRole getLmsWftRole() {
		return this.lmsWftRole;
	}

	public void setLmsWftRole(LmsWftRole lmsWftRole) {
		this.lmsWftRole = lmsWftRole;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsWftRequestHopRolePageMap") @JsonIgnore
	public Set<LmsWfRequestHop> getLmsWfRequestHops() {
		return this.lmsWfRequestHops;
	}

	public void setLmsWfRequestHops(Set<LmsWfRequestHop> lmsWfRequestHops) {
		this.lmsWfRequestHops = lmsWfRequestHops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsWftRequestHopRolePageMapByTrhmHopsId") @JsonIgnore
	public Set<LmsWftFlowControl> getLmsWftFlowControlsForTrhmHopsId() {
		return this.lmsWftFlowControlsForTrhmHopsId;
	}

	public void setLmsWftFlowControlsForTrhmHopsId(Set<LmsWftFlowControl> lmsWftFlowControlsForTrhmHopsId) {
		this.lmsWftFlowControlsForTrhmHopsId = lmsWftFlowControlsForTrhmHopsId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsWftRequestHopRolePageMapByTrhmDependedHopsId") @JsonIgnore
	public Set<LmsWftFlowControl> getLmsWftFlowControlsForTrhmDependedHopsId() {
		return this.lmsWftFlowControlsForTrhmDependedHopsId;
	}

	public void setLmsWftFlowControlsForTrhmDependedHopsId(
			Set<LmsWftFlowControl> lmsWftFlowControlsForTrhmDependedHopsId) {
		this.lmsWftFlowControlsForTrhmDependedHopsId = lmsWftFlowControlsForTrhmDependedHopsId;
	}

}
