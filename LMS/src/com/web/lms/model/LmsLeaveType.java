package com.web.lms.model;
// com.web.lms.modelerated Mar 23, 2018 5:44:35 PM by Hibernate Tools 5.2.8.Final

import java.math.BigDecimal;
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
 * LmsLeaveType com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_leave_type", catalog = "lmsdb")
public class LmsLeaveType implements java.io.Serializable {

	private Integer id;
	private String type;
	private String status;
	private BigDecimal maximumDays;
	private String incremental;
	private String yearlyAllocated;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsLeaveBalance> lmsLeaveBalances = new HashSet<LmsLeaveBalance>(0);
	private Set<LmsLeaveApplication> lmsLeaveApplications = new HashSet<LmsLeaveApplication>(0);

	public LmsLeaveType() {
	}

	public LmsLeaveType(String type, String status, BigDecimal maximumDays, String incremental, String yearlyAllocated,
			Date insertDate, Integer insertBy, Date updateDate, Integer updateBy, Set<LmsLeaveBalance> lmsLeaveBalances,
			Set<LmsLeaveApplication> lmsLeaveApplications) {
		this.type = type;
		this.status = status;
		this.maximumDays = maximumDays;
		this.incremental = incremental;
		this.yearlyAllocated = yearlyAllocated;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsLeaveBalances = lmsLeaveBalances;
		this.lmsLeaveApplications = lmsLeaveApplications;
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

	@Column(name = "TYPE", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "STATUS", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "MAXIMUM_DAYS", precision = 50, scale = 0)
	public BigDecimal getMaximumDays() {
		return this.maximumDays;
	}

	public void setMaximumDays(BigDecimal maximumDays) {
		this.maximumDays = maximumDays;
	}

	@Column(name = "INCREMENTAL", length = 50)
	public String getIncremental() {
		return this.incremental;
	}

	public void setIncremental(String incremental) {
		this.incremental = incremental;
	}

	@Column(name = "YEARLY_ALLOCATED", length = 50)
	public String getYearlyAllocated() {
		return this.yearlyAllocated;
	}

	public void setYearlyAllocated(String yearlyAllocated) {
		this.yearlyAllocated = yearlyAllocated;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsLeaveType")
	public Set<LmsLeaveBalance> getLmsLeaveBalances() {
		return this.lmsLeaveBalances;
	}

	public void setLmsLeaveBalances(Set<LmsLeaveBalance> lmsLeaveBalances) {
		this.lmsLeaveBalances = lmsLeaveBalances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsLeaveType")
	public Set<LmsLeaveApplication> getLmsLeaveApplications() {
		return this.lmsLeaveApplications;
	}

	public void setLmsLeaveApplications(Set<LmsLeaveApplication> lmsLeaveApplications) {
		this.lmsLeaveApplications = lmsLeaveApplications;
	}

}
