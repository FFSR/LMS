package com.web.lms.model;
// Generated Mar 27, 2018 11:06:48 PM by Hibernate Tools 5.2.8.Final

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
 * LmsLeaveApplication generated by hbm2java
 */
@Entity
@Table(name = "lms_leave_application", catalog = "lmsdb")
public class LmsLeaveApplication implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private LmsLeaveType lmsLeaveType;
	private LmsUser lmsUserByReliverEmailAddressUserId;
	private LmsUser lmsUserByUserId;
	private Date year;
	private Integer leaveAvailable;
	private Integer leaveTaken;
	private Integer leaveBalance;
	private String eligibility;
	private Date fromDate;
	private Date toDate;
	private Integer totalDayCount;
	private String totalDayText;
	private String reasonForLeave;
	private String taskNeedToPerformed;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsAttachment> lmsAttachments = new HashSet<LmsAttachment>(0);

	public LmsLeaveApplication() {
	}

	public LmsLeaveApplication(LmsLeaveType lmsLeaveType, LmsUser lmsUserByReliverEmailAddressUserId,
			LmsUser lmsUserByUserId, Date year, Integer leaveAvailable, Integer leaveTaken, Integer leaveBalance,
			String eligibility, Date fromDate, Date toDate, Integer totalDayCount, String totalDayText,
			String reasonForLeave, String taskNeedToPerformed, Date insertDate, Integer insertBy, Date updateDate,
			Integer updateBy, Set<LmsAttachment> lmsAttachments) {
		this.lmsLeaveType = lmsLeaveType;
		this.lmsUserByReliverEmailAddressUserId = lmsUserByReliverEmailAddressUserId;
		this.lmsUserByUserId = lmsUserByUserId;
		this.year = year;
		this.leaveAvailable = leaveAvailable;
		this.leaveTaken = leaveTaken;
		this.leaveBalance = leaveBalance;
		this.eligibility = eligibility;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalDayCount = totalDayCount;
		this.totalDayText = totalDayText;
		this.reasonForLeave = reasonForLeave;
		this.taskNeedToPerformed = taskNeedToPerformed;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsAttachments = lmsAttachments;
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
	@JoinColumn(name = "LEAVE_TYPE_ID")
	public LmsLeaveType getLmsLeaveType() {
		return this.lmsLeaveType;
	}

	public void setLmsLeaveType(LmsLeaveType lmsLeaveType) {
		this.lmsLeaveType = lmsLeaveType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RELIVER_EMAIL_ADDRESS_USER_ID")
	public LmsUser getLmsUserByReliverEmailAddressUserId() {
		return this.lmsUserByReliverEmailAddressUserId;
	}

	public void setLmsUserByReliverEmailAddressUserId(LmsUser lmsUserByReliverEmailAddressUserId) {
		this.lmsUserByReliverEmailAddressUserId = lmsUserByReliverEmailAddressUserId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUserByUserId() {
		return this.lmsUserByUserId;
	}

	public void setLmsUserByUserId(LmsUser lmsUserByUserId) {
		this.lmsUserByUserId = lmsUserByUserId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "YEAR", length = 19)
	public Date getYear() {
		return this.year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	@Column(name = "LEAVE_AVAILABLE")
	public Integer getLeaveAvailable() {
		return this.leaveAvailable;
	}

	public void setLeaveAvailable(Integer leaveAvailable) {
		this.leaveAvailable = leaveAvailable;
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
	@Column(name = "FROM_DATE", length = 19)
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TO_DATE", length = 19)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Column(name = "TOTAL_DAY_COUNT")
	public Integer getTotalDayCount() {
		return this.totalDayCount;
	}

	public void setTotalDayCount(Integer totalDayCount) {
		this.totalDayCount = totalDayCount;
	}

	@Column(name = "TOTAL_DAY_TEXT", length = 50)
	public String getTotalDayText() {
		return this.totalDayText;
	}

	public void setTotalDayText(String totalDayText) {
		this.totalDayText = totalDayText;
	}

	@Column(name = "REASON_FOR_LEAVE", length = 3000)
	public String getReasonForLeave() {
		return this.reasonForLeave;
	}

	public void setReasonForLeave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}

	@Column(name = "TASK_NEED_TO_PERFORMED", length = 3000)
	public String getTaskNeedToPerformed() {
		return this.taskNeedToPerformed;
	}

	public void setTaskNeedToPerformed(String taskNeedToPerformed) {
		this.taskNeedToPerformed = taskNeedToPerformed;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsLeaveApplication")
	@JsonIgnore
	public Set<LmsAttachment> getLmsAttachments() {
		return this.lmsAttachments;
	}

	public void setLmsAttachments(Set<LmsAttachment> lmsAttachments) {
		this.lmsAttachments = lmsAttachments;
	}

}
