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
 * LmsHolidayRecord generated by hbm2java
 */
@Entity
@Table(name = "lms_holiday_record", catalog = "supremet_lmsdb")
public class LmsHolidayRecord implements java.io.Serializable {

	private Integer id;
	private LmsUser lmsUser;
	private String leaveSubject;
	private Date leaveDate;
	private String optional;
	private String subjectToMoon;
	private Date insertDate;
	private Date updateDate;
	private Integer updateBy;

	public LmsHolidayRecord() {
	}

	public LmsHolidayRecord(LmsUser lmsUser, String leaveSubject, Date leaveDate, String optional, String subjectToMoon,
			Date insertDate, Date updateDate, Integer updateBy) {
		this.lmsUser = lmsUser;
		this.leaveSubject = leaveSubject;
		this.leaveDate = leaveDate;
		this.optional = optional;
		this.subjectToMoon = subjectToMoon;
		this.insertDate = insertDate;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INSERT_BY")
	public LmsUser getLmsUser() {
		return this.lmsUser;
	}

	public void setLmsUser(LmsUser lmsUser) {
		this.lmsUser = lmsUser;
	}

	@Column(name = "LEAVE_SUBJECT", length = 50)
	public String getLeaveSubject() {
		return this.leaveSubject;
	}

	public void setLeaveSubject(String leaveSubject) {
		this.leaveSubject = leaveSubject;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LEAVE_DATE", length = 19)
	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Column(name = "OPTIONAL", length = 50)
	public String getOptional() {
		return this.optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	@Column(name = "SUBJECT_TO_MOON", length = 50)
	public String getSubjectToMoon() {
		return this.subjectToMoon;
	}

	public void setSubjectToMoon(String subjectToMoon) {
		this.subjectToMoon = subjectToMoon;
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

	@Column(name = "UPDATE_BY")
	public Integer getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

}
