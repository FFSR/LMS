package com.web.lms.model;
// Generated Mar 23, 2018 7:42:13 PM by Hibernate Tools 5.2.8.Final

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
 * LmsAttachment generated by hbm2java
 */
@Entity
@Table(name = "lms_attachment", catalog = "lmsdb")
public class LmsAttachment implements java.io.Serializable {

	private Integer id;
	private LmsLeaveApplication lmsLeaveApplication;
	private LmsUser lmsUser;
	private String documentName;
	private String filename;
	private String location;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsAttachment() {
	}

	public LmsAttachment(LmsLeaveApplication lmsLeaveApplication, LmsUser lmsUser, String documentName, String filename,
			String location, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy) {
		this.lmsLeaveApplication = lmsLeaveApplication;
		this.lmsUser = lmsUser;
		this.documentName = documentName;
		this.filename = filename;
		this.location = location;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LEAVE_APPLICATION_ID")
	public LmsLeaveApplication getLmsLeaveApplication() {
		return this.lmsLeaveApplication;
	}

	public void setLmsLeaveApplication(LmsLeaveApplication lmsLeaveApplication) {
		this.lmsLeaveApplication = lmsLeaveApplication;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public LmsUser getLmsUser() {
		return this.lmsUser;
	}

	public void setLmsUser(LmsUser lmsUser) {
		this.lmsUser = lmsUser;
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
