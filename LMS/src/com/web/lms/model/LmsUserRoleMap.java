package com.web.lms.model;
// Generated Mar 23, 2018 6:28:47 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LmsUserRoleMap generated by hbm2java
 */
@Entity
@Table(name = "lms_user_role_map", catalog = "lmsdb")
public class LmsUserRoleMap implements java.io.Serializable {

	private Integer id;
	private LmsRole lmsRole;
	private LmsUser lmsUser;
	private Integer wfRoleId;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsUserRoleMap() {
	}

	public LmsUserRoleMap(LmsRole lmsRole, LmsUser lmsUser, Integer wfRoleId, Date insertDate, Integer insertBy,
			Date updateDate, Integer updateBy) {
		this.lmsRole = lmsRole;
		this.lmsUser = lmsUser;
		this.wfRoleId = wfRoleId;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public LmsRole getLmsRole() {
		return this.lmsRole;
	}

	public void setLmsRole(LmsRole lmsRole) {
		this.lmsRole = lmsRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUser() {
		return this.lmsUser;
	}

	public void setLmsUser(LmsUser lmsUser) {
		this.lmsUser = lmsUser;
	}

	@Column(name = "WF_ROLE_ID")
	public Integer getWfRoleId() {
		return this.wfRoleId;
	}

	public void setWfRoleId(Integer wfRoleId) {
		this.wfRoleId = wfRoleId;
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
