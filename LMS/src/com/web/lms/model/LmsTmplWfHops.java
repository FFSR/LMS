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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LmsTmplWfHops com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_tmpl_wf_hops", catalog = "lmsdb")
public class LmsTmplWfHops implements java.io.Serializable {

	private Integer id;
	private String name;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Integer wfRequestTypeId;
	private Set<LmsTmplRequestHopsRoleMap> lmsTmplRequestHopsRoleMaps = new HashSet<LmsTmplRequestHopsRoleMap>(0);

	public LmsTmplWfHops() {
	}

	public LmsTmplWfHops(String name, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Integer wfRequestTypeId, Set<LmsTmplRequestHopsRoleMap> lmsTmplRequestHopsRoleMaps) {
		this.name = name;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.wfRequestTypeId = wfRequestTypeId;
		this.lmsTmplRequestHopsRoleMaps = lmsTmplRequestHopsRoleMaps;
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

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "WF_REQUEST_TYPE_ID")
	public Integer getWfRequestTypeId() {
		return this.wfRequestTypeId;
	}

	public void setWfRequestTypeId(Integer wfRequestTypeId) {
		this.wfRequestTypeId = wfRequestTypeId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsTmplWfHops")
	public Set<LmsTmplRequestHopsRoleMap> getLmsTmplRequestHopsRoleMaps() {
		return this.lmsTmplRequestHopsRoleMaps;
	}

	public void setLmsTmplRequestHopsRoleMaps(Set<LmsTmplRequestHopsRoleMap> lmsTmplRequestHopsRoleMaps) {
		this.lmsTmplRequestHopsRoleMaps = lmsTmplRequestHopsRoleMaps;
	}

}
