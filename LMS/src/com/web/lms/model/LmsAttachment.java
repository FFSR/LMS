package com.web.lms.model;
// com.web.lms.modelerated Mar 23, 2018 5:44:35 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * LmsAttachment com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_attachment", catalog = "lmsdb")
public class LmsAttachment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private LmsLeaveApplication lmsLeaveApplication;
	private LmsUser lmsUserByInsertBy;
	private LmsUser lmsUserByUpdateBy;
	private LmsUser lmsUserByUserId;
	private String documentName;
	private String filename;
	private String location;
	private Date insertDate;
	private Date updateDate;

	public LmsAttachment() {
	}

	public LmsAttachment(LmsLeaveApplication lmsLeaveApplication, LmsUser lmsUserByInsertBy, LmsUser lmsUserByUpdateBy,
			LmsUser lmsUserByUserId, String documentName, String filename, String location, Date insertDate,
			Date updateDate) {
		this.lmsLeaveApplication = lmsLeaveApplication;
		this.lmsUserByInsertBy = lmsUserByInsertBy;
		this.lmsUserByUpdateBy = lmsUserByUpdateBy;
		this.lmsUserByUserId = lmsUserByUserId;
		this.documentName = documentName;
		this.filename = filename;
		this.location = location;
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
	@JoinColumn(name = "LEAVE_APPLICATION_ID")
	public LmsLeaveApplication getLmsLeaveApplication() {
		return this.lmsLeaveApplication;
	}

	public void setLmsLeaveApplication(LmsLeaveApplication lmsLeaveApplication) {
		this.lmsLeaveApplication = lmsLeaveApplication;
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
	@JoinColumn(name = "UPDATE_BY")
	public LmsUser getLmsUserByUpdateBy() {
		return this.lmsUserByUpdateBy;
	}

	public void setLmsUserByUpdateBy(LmsUser lmsUserByUpdateBy) {
		this.lmsUserByUpdateBy = lmsUserByUpdateBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUserByUserId() {
		return this.lmsUserByUserId;
	}

	public void setLmsUserByUserId(LmsUser lmsUserByUserId) {
		this.lmsUserByUserId = lmsUserByUserId;
	}

	@Column(name = "DOCUMENT_NAME", length = 50)
	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column(name = "FILENAME", length = 50)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "LOCATION", length = 1000)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
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
