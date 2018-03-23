package com.web.lms.model;
// Generated Mar 23, 2018 7:42:13 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * LmsRole generated by hbm2java
 */
@Entity
@Table(name = "lms_role", catalog = "lmsdb")
public class LmsRole implements java.io.Serializable {

	private Integer id;
	private String name;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsPageRoleMap> lmsPageRoleMaps = new HashSet<LmsPageRoleMap>(0);
	private Set<LmsUserRoleMap> lmsUserRoleMaps = new HashSet<LmsUserRoleMap>(0);

	public LmsRole() {
	}

	public LmsRole(String name, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Set<LmsPageRoleMap> lmsPageRoleMaps, Set<LmsUserRoleMap> lmsUserRoleMaps) {
		this.name = name;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsPageRoleMaps = lmsPageRoleMaps;
		this.lmsUserRoleMaps = lmsUserRoleMaps;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsRole")
	@JsonIgnore
	public Set<LmsPageRoleMap> getLmsPageRoleMaps() {
		return this.lmsPageRoleMaps;
	}

	public void setLmsPageRoleMaps(Set<LmsPageRoleMap> lmsPageRoleMaps) {
		this.lmsPageRoleMaps = lmsPageRoleMaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsRole")
	@JsonIgnore
	public Set<LmsUserRoleMap> getLmsUserRoleMaps() {
		return this.lmsUserRoleMaps;
	}

	public void setLmsUserRoleMaps(Set<LmsUserRoleMap> lmsUserRoleMaps) {
		this.lmsUserRoleMaps = lmsUserRoleMaps;
	}

}
