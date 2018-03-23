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
 * LmsPageRoleMap com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_page_role_map", catalog = "lmsdb")
public class LmsPageRoleMap implements java.io.Serializable {

	private Integer id;
	private LmsRole lmsRole;
	private String pacom.web.lms.modelame;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsPageRoleMap() {
	}

	public LmsPageRoleMap(LmsRole lmsRole, String pacom.web.lms.modelame, Date insertDate, Integer insertBy, Date updateDate,
			Integer updateBy) {
		this.lmsRole = lmsRole;
		this.pacom.web.lms.modelame = pacom.web.lms.modelame;
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
	@JoinColumn(name = "ROLE_ID")
	public LmsRole getLmsRole() {
		return this.lmsRole;
	}

	public void setLmsRole(LmsRole lmsRole) {
		this.lmsRole = lmsRole;
	}

	@Column(name = "PAGE_NAME", length = 50)
	public String getPacom.web.lms.modelame() {
		return this.pacom.web.lms.modelame;
	}

	public void setPacom.web.lms.modelame(String pacom.web.lms.modelame) {
		this.pacom.web.lms.modelame = pacom.web.lms.modelame;
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
