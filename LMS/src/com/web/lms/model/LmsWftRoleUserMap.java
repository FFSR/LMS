package com.web.lms.model;
// Generated May 31, 2018 6:04:48 PM by Hibernate Tools 5.2.8.Final

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
 * LmsWftRoleUserMap generated by hbm2java
 */
@Entity
@Table(name = "lms_wft_role_user_map", catalog = "supremet_lmsdb")
public class LmsWftRoleUserMap implements java.io.Serializable {

	private Integer id;
	private LmsUser lmsUserByDelegateBy;
	private LmsUser lmsUserByUserId;
	private LmsWftRole lmsWftRole;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer undateBy;

	public LmsWftRoleUserMap() {
	}

	public LmsWftRoleUserMap(LmsUser lmsUserByDelegateBy, LmsUser lmsUserByUserId, LmsWftRole lmsWftRole,
			Date insertDate, Integer insertBy, Date updateDate, Integer undateBy) {
		this.lmsUserByDelegateBy = lmsUserByDelegateBy;
		this.lmsUserByUserId = lmsUserByUserId;
		this.lmsWftRole = lmsWftRole;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.undateBy = undateBy;
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
	@JoinColumn(name = "DELEGATE_BY")
	public LmsUser getLmsUserByDelegateBy() {
		return this.lmsUserByDelegateBy;
	}

	public void setLmsUserByDelegateBy(LmsUser lmsUserByDelegateBy) {
		this.lmsUserByDelegateBy = lmsUserByDelegateBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUserByUserId() {
		return this.lmsUserByUserId;
	}

	public void setLmsUserByUserId(LmsUser lmsUserByUserId) {
		this.lmsUserByUserId = lmsUserByUserId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WFT_ROLE_ID")
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

	@Column(name = "UNDATE_BY")
	public Integer getUndateBy() {
		return this.undateBy;
	}

	public void setUndateBy(Integer undateBy) {
		this.undateBy = undateBy;
	}

}
