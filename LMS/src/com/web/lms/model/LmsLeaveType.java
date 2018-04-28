package com.web.lms.model;
// Generated Apr 28, 2018 11:30:37 AM by Hibernate Tools 5.2.8.Final

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
 * LmsLeaveType generated by hbm2java
 */
@Entity
@Table(name = "lms_leave_type", catalog = "lmsdb")
public class LmsLeaveType implements java.io.Serializable {

	private Integer id;
	private String type;
	private String status;
	private Integer maximumDays;
	private String incremental;
	private String yearlyAllocated;
	private Integer maximumTimes;
	private Integer maximumAtATime;
	private Integer yearInterval;
	private Integer eligibleAfter;
	private Integer eligibleBefore;
	private String impactOnHoliday;
	private String extensible;
	private String impactOnEarnedLeave;
	private Integer insertBy;
	private Date insertDate;
	private Integer updateBy;
	private Date updateDate;
	private Integer minimumAtATime;
	private Integer applyDaysEachYear;
	private Integer dependentLeaveAc;
	private Set<LmsLeaveBalance> lmsLeaveBalances = new HashSet<LmsLeaveBalance>(0);
	private Set<LmsLeaveApplication> lmsLeaveApplications = new HashSet<LmsLeaveApplication>(0);
	private Set<LmsWftRequestSelector> lmsWftRequestSelectors = new HashSet<LmsWftRequestSelector>(0);

	public LmsLeaveType() {
	}

	public LmsLeaveType(String type, String status, Integer maximumDays, String incremental, String yearlyAllocated,
			Integer maximumTimes, Integer maximumAtATime, Integer yearInterval, Integer eligibleAfter,
			Integer eligibleBefore, String impactOnHoliday, String extensible, String impactOnEarnedLeave,
			Integer insertBy, Date insertDate, Integer updateBy, Date updateDate, Integer minimumAtATime,
			Integer applyDaysEachYear, Integer dependentLeaveAc, Set<LmsLeaveBalance> lmsLeaveBalances,
			Set<LmsLeaveApplication> lmsLeaveApplications, Set<LmsWftRequestSelector> lmsWftRequestSelectors) {
		this.type = type;
		this.status = status;
		this.maximumDays = maximumDays;
		this.incremental = incremental;
		this.yearlyAllocated = yearlyAllocated;
		this.maximumTimes = maximumTimes;
		this.maximumAtATime = maximumAtATime;
		this.yearInterval = yearInterval;
		this.eligibleAfter = eligibleAfter;
		this.eligibleBefore = eligibleBefore;
		this.impactOnHoliday = impactOnHoliday;
		this.extensible = extensible;
		this.impactOnEarnedLeave = impactOnEarnedLeave;
		this.insertBy = insertBy;
		this.insertDate = insertDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.minimumAtATime = minimumAtATime;
		this.applyDaysEachYear = applyDaysEachYear;
		this.dependentLeaveAc = dependentLeaveAc;
		this.lmsLeaveBalances = lmsLeaveBalances;
		this.lmsLeaveApplications = lmsLeaveApplications;
		this.lmsWftRequestSelectors = lmsWftRequestSelectors;
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

	@Column(name = "MAXIMUM_DAYS")
	public Integer getMaximumDays() {
		return this.maximumDays;
	}

	public void setMaximumDays(Integer maximumDays) {
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

	@Column(name = "MAXIMUM_TIMES")
	public Integer getMaximumTimes() {
		return this.maximumTimes;
	}

	public void setMaximumTimes(Integer maximumTimes) {
		this.maximumTimes = maximumTimes;
	}

	@Column(name = "MAXIMUM_AT_A_TIME")
	public Integer getMaximumAtATime() {
		return this.maximumAtATime;
	}

	public void setMaximumAtATime(Integer maximumAtATime) {
		this.maximumAtATime = maximumAtATime;
	}

	@Column(name = "YEAR_INTERVAL")
	public Integer getYearInterval() {
		return this.yearInterval;
	}

	public void setYearInterval(Integer yearInterval) {
		this.yearInterval = yearInterval;
	}

	@Column(name = "ELIGIBLE_AFTER")
	public Integer getEligibleAfter() {
		return this.eligibleAfter;
	}

	public void setEligibleAfter(Integer eligibleAfter) {
		this.eligibleAfter = eligibleAfter;
	}

	@Column(name = "ELIGIBLE_BEFORE")
	public Integer getEligibleBefore() {
		return this.eligibleBefore;
	}

	public void setEligibleBefore(Integer eligibleBefore) {
		this.eligibleBefore = eligibleBefore;
	}

	@Column(name = "IMPACT_ON_HOLIDAY", length = 50)
	public String getImpactOnHoliday() {
		return this.impactOnHoliday;
	}

	public void setImpactOnHoliday(String impactOnHoliday) {
		this.impactOnHoliday = impactOnHoliday;
	}

	@Column(name = "EXTENSIBLE", length = 50)
	public String getExtensible() {
		return this.extensible;
	}

	public void setExtensible(String extensible) {
		this.extensible = extensible;
	}

	@Column(name = "IMPACT_ON_EARNED_LEAVE", length = 50)
	public String getImpactOnEarnedLeave() {
		return this.impactOnEarnedLeave;
	}

	public void setImpactOnEarnedLeave(String impactOnEarnedLeave) {
		this.impactOnEarnedLeave = impactOnEarnedLeave;
	}

	@Column(name = "INSERT_BY")
	public Integer getInsertBy() {
		return this.insertBy;
	}

	public void setInsertBy(Integer insertBy) {
		this.insertBy = insertBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERT_DATE", length = 19)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Column(name = "UPDATE_BY")
	public Integer getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "MINIMUM_AT_A_TIME")
	public Integer getMinimumAtATime() {
		return this.minimumAtATime;
	}

	public void setMinimumAtATime(Integer minimumAtATime) {
		this.minimumAtATime = minimumAtATime;
	}

	@Column(name = "APPLY_DAYS_EACH_YEAR")
	public Integer getApplyDaysEachYear() {
		return this.applyDaysEachYear;
	}

	public void setApplyDaysEachYear(Integer applyDaysEachYear) {
		this.applyDaysEachYear = applyDaysEachYear;
	}

	@Column(name = "DEPENDENT_LEAVE_AC")
	public Integer getDependentLeaveAc() {
		return this.dependentLeaveAc;
	}

	public void setDependentLeaveAc(Integer dependentLeaveAc) {
		this.dependentLeaveAc = dependentLeaveAc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsLeaveType")
	@JsonIgnore
	public Set<LmsLeaveBalance> getLmsLeaveBalances() {
		return this.lmsLeaveBalances;
	}

	public void setLmsLeaveBalances(Set<LmsLeaveBalance> lmsLeaveBalances) {
		this.lmsLeaveBalances = lmsLeaveBalances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsLeaveType")
	@JsonIgnore
	public Set<LmsLeaveApplication> getLmsLeaveApplications() {
		return this.lmsLeaveApplications;
	}

	public void setLmsLeaveApplications(Set<LmsLeaveApplication> lmsLeaveApplications) {
		this.lmsLeaveApplications = lmsLeaveApplications;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsLeaveType")
	@JsonIgnore
	public Set<LmsWftRequestSelector> getLmsWftRequestSelectors() {
		return this.lmsWftRequestSelectors;
	}

	public void setLmsWftRequestSelectors(Set<LmsWftRequestSelector> lmsWftRequestSelectors) {
		this.lmsWftRequestSelectors = lmsWftRequestSelectors;
	}

}
