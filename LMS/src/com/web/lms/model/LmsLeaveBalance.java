package com.web.lms.model;
// com.web.lms.modelerated Mar 23, 2018 5:44:35 PM by Hibernate Tools 5.2.8.Final

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
 * LmsLeaveBalance com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_leave_balance", catalog = "lmsdb")
public class LmsLeaveBalance implements java.io.Serializable {

	private Integer id;
	private LmsLeaveType lmsLeaveType;
	private LmsUser lmsUserByInsertBy;
	private LmsUser lmsUserByUserId;
	private LmsUser lmsUserByUpdateBy;
	private Date year;
	private Integer leaveTotal;
	private Integer leaveTaken;
	private Integer leaveBalance;
	private String eligibility;
	private Date insertDate;
	private Date updateDate;

	public LmsLeaveBalance() {
	}

	public LmsLeaveBalance(LmsLeaveType lmsLeaveType, LmsUser lmsUserByInsertBy, LmsUser lmsUserByUserId,
			LmsUser lmsUserByUpdateBy, Date year, Integer leaveTotal, Integer leaveTaken, Integer leaveBalance,
			String eligibility, Date insertDate, Date updateDate) {
		this.lmsLeaveType = lmsLeaveType;
		this.lmsUserByInsertBy = lmsUserByInsertBy;
		this.lmsUserByUserId = lmsUserByUserId;
		this.lmsUserByUpdateBy = lmsUserByUpdateBy;
		this.year = year;
		this.leaveTotal = leaveTotal;
		this.leaveTaken = leaveTaken;
		this.leaveBalance = leaveBalance;
		this.eligibility = eligibility;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
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
	@JoinColumn(name = "LEAVE_TYPE_ID")
	public LmsLeaveType getLmsLeaveType() {
		return this.lmsLeaveType;
	}

	public void setLmsLeaveType(LmsLeaveType lmsLeaveType) {
		this.lmsLeaveType = lmsLeaveType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSERT_BY")
	public LmsUser getLmsUserByInsertBy() {
		return this.lmsUserByInsertBy;
	}

	public void setLmsUserByInsertBy(LmsUser lmsUserByInsertBy) {
		this.lmsUserByInsertBy = lmsUserByInsertBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUserByUserId() {
		return this.lmsUserByUserId;
	}

	public void setLmsUserByUserId(LmsUser lmsUserByUserId) {
		this.lmsUserByUserId = lmsUserByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATE_BY")
	public LmsUser getLmsUserByUpdateBy() {
		return this.lmsUserByUpdateBy;
	}

	public void setLmsUserByUpdateBy(LmsUser lmsUserByUpdateBy) {
		this.lmsUserByUpdateBy = lmsUserByUpdateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "YEAR", length = 19)
	public Date getYear() {
		return this.year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	@Column(name = "LEAVE_TOTAL")
	public Integer getLeaveTotal() {
		return this.leaveTotal;
	}

	public void setLeaveTotal(Integer leaveTotal) {
		this.leaveTotal = leaveTotal;
	}

	@Column(name = "LEAVE_TAKEN")
	public Integer getLeaveTaken() {
		return this.leaveTaken;
	}

	public void setLeaveTaken(Integer leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	@Column(name = "LEAVE_BALANCE")
	public Integer getLeaveBalance() {
		return this.leaveBalance;
	}

	public void setLeaveBalance(Integer leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	@Column(name = "ELIGIBILITY", length = 50)
	public String getEligibility() {
		return this.eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERT_DATE", length = 19)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
