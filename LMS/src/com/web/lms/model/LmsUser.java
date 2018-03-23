package com.web.lms.model;
// com.web.lms.modelerated Mar 23, 2018 5:44:35 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.com.web.lms.modeleratedValue;
import static javax.persistence.com.web.lms.modelerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LmsUser com.web.lms.modelerated by hbm2java
 */
@Entity
@Table(name = "lms_user", catalog = "lmsdb")
public class LmsUser implements java.io.Serializable {

	private Integer id;
	private LmsDepartment lmsDepartment;
	private LmsDesignation lmsDesignation;
	private LmsDivision lmsDivision;
	private LmsMinistry lmsMinistry;
	private LmsOfficeLocation lmsOfficeLocation;
	private LmsSection lmsSection;
	private LmsUser lmsUser;
	private String name;
	private String email;
	private String phone;
	private String passport;
	private String fax;
	private String mobilePersonal;
	private String mobileOffice;
	private String com.web.lms.modelder;
	private String address;
	private String nid;
	private String nationality;
	private Date joiningDate;
	private String status;
	private String password;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsAttachment> lmsAttachmentsForInsertBy = new HashSet<LmsAttachment>(0);
	private Set<LmsLeaveBalance> lmsLeaveBalancesForInsertBy = new HashSet<LmsLeaveBalance>(0);
	private Set<LmsLeaveBalance> lmsLeaveBalancesForUserId = new HashSet<LmsLeaveBalance>(0);
	private Set<LmsLeaveApplication> lmsLeaveApplicationsForInsertBy = new HashSet<LmsLeaveApplication>(0);
	private Set<LmsUser> lmsUsers = new HashSet<LmsUser>(0);
	private Set<LmsUserRoleMap> lmsUserRoleMaps = new HashSet<LmsUserRoleMap>(0);
	private Set<LmsLeaveApplication> lmsLeaveApplicationsForReliverEmailAddressUserId = new HashSet<LmsLeaveApplication>(
			0);
	private Set<LmsLeaveApplication> lmsLeaveApplicationsForUserId = new HashSet<LmsLeaveApplication>(0);
	private Set<LmsAttachment> lmsAttachmentsForUpdateBy = new HashSet<LmsAttachment>(0);
	private Set<LmsAttachment> lmsAttachmentsForUserId = new HashSet<LmsAttachment>(0);
	private Set<LmsLeaveBalance> lmsLeaveBalancesForUpdateBy = new HashSet<LmsLeaveBalance>(0);
	private Set<LmsLeaveApplication> lmsLeaveApplicationsForUpdateBy = new HashSet<LmsLeaveApplication>(0);
	private Set<LmsWfRequest> lmsWfRequests = new HashSet<LmsWfRequest>(0);

	public LmsUser() {
	}

	public LmsUser(Date insertDate) {
		this.insertDate = insertDate;
	}

	public LmsUser(LmsDepartment lmsDepartment, LmsDesignation lmsDesignation, LmsDivision lmsDivision,
			LmsMinistry lmsMinistry, LmsOfficeLocation lmsOfficeLocation, LmsSection lmsSection, LmsUser lmsUser,
			String name, String email, String phone, String passport, String fax, String mobilePersonal,
			String mobileOffice, String com.web.lms.modelder, String address, String nid, String nationality, Date joiningDate,
			String status, String password, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Set<LmsAttachment> lmsAttachmentsForInsertBy, Set<LmsLeaveBalance> lmsLeaveBalancesForInsertBy,
			Set<LmsLeaveBalance> lmsLeaveBalancesForUserId, Set<LmsLeaveApplication> lmsLeaveApplicationsForInsertBy,
			Set<LmsUser> lmsUsers, Set<LmsUserRoleMap> lmsUserRoleMaps,
			Set<LmsLeaveApplication> lmsLeaveApplicationsForReliverEmailAddressUserId,
			Set<LmsLeaveApplication> lmsLeaveApplicationsForUserId, Set<LmsAttachment> lmsAttachmentsForUpdateBy,
			Set<LmsAttachment> lmsAttachmentsForUserId, Set<LmsLeaveBalance> lmsLeaveBalancesForUpdateBy,
			Set<LmsLeaveApplication> lmsLeaveApplicationsForUpdateBy, Set<LmsWfRequest> lmsWfRequests) {
		this.lmsDepartment = lmsDepartment;
		this.lmsDesignation = lmsDesignation;
		this.lmsDivision = lmsDivision;
		this.lmsMinistry = lmsMinistry;
		this.lmsOfficeLocation = lmsOfficeLocation;
		this.lmsSection = lmsSection;
		this.lmsUser = lmsUser;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passport = passport;
		this.fax = fax;
		this.mobilePersonal = mobilePersonal;
		this.mobileOffice = mobileOffice;
		this.com.web.lms.modelder = com.web.lms.modelder;
		this.address = address;
		this.nid = nid;
		this.nationality = nationality;
		this.joiningDate = joiningDate;
		this.status = status;
		this.password = password;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsAttachmentsForInsertBy = lmsAttachmentsForInsertBy;
		this.lmsLeaveBalancesForInsertBy = lmsLeaveBalancesForInsertBy;
		this.lmsLeaveBalancesForUserId = lmsLeaveBalancesForUserId;
		this.lmsLeaveApplicationsForInsertBy = lmsLeaveApplicationsForInsertBy;
		this.lmsUsers = lmsUsers;
		this.lmsUserRoleMaps = lmsUserRoleMaps;
		this.lmsLeaveApplicationsForReliverEmailAddressUserId = lmsLeaveApplicationsForReliverEmailAddressUserId;
		this.lmsLeaveApplicationsForUserId = lmsLeaveApplicationsForUserId;
		this.lmsAttachmentsForUpdateBy = lmsAttachmentsForUpdateBy;
		this.lmsAttachmentsForUserId = lmsAttachmentsForUserId;
		this.lmsLeaveBalancesForUpdateBy = lmsLeaveBalancesForUpdateBy;
		this.lmsLeaveApplicationsForUpdateBy = lmsLeaveApplicationsForUpdateBy;
		this.lmsWfRequests = lmsWfRequests;
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
	@JoinColumn(name = "DEPARTMENT_ID")
	public LmsDepartment getLmsDepartment() {
		return this.lmsDepartment;
	}

	public void setLmsDepartment(LmsDepartment lmsDepartment) {
		this.lmsDepartment = lmsDepartment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESIGNATION_ID")
	public LmsDesignation getLmsDesignation() {
		return this.lmsDesignation;
	}

	public void setLmsDesignation(LmsDesignation lmsDesignation) {
		this.lmsDesignation = lmsDesignation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIVISION_ID")
	public LmsDivision getLmsDivision() {
		return this.lmsDivision;
	}

	public void setLmsDivision(LmsDivision lmsDivision) {
		this.lmsDivision = lmsDivision;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MINISTRY_ID")
	public LmsMinistry getLmsMinistry() {
		return this.lmsMinistry;
	}

	public void setLmsMinistry(LmsMinistry lmsMinistry) {
		this.lmsMinistry = lmsMinistry;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_LOCATION_ID")
	public LmsOfficeLocation getLmsOfficeLocation() {
		return this.lmsOfficeLocation;
	}

	public void setLmsOfficeLocation(LmsOfficeLocation lmsOfficeLocation) {
		this.lmsOfficeLocation = lmsOfficeLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECTION_ID")
	public LmsSection getLmsSection() {
		return this.lmsSection;
	}

	public void setLmsSection(LmsSection lmsSection) {
		this.lmsSection = lmsSection;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERVISOR_ID")
	public LmsUser getLmsUser() {
		return this.lmsUser;
	}

	public void setLmsUser(LmsUser lmsUser) {
		this.lmsUser = lmsUser;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONE", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PASSPORT", length = 50)
	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Column(name = "FAX", length = 50)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "MOBILE_PERSONAL", length = 50)
	public String getMobilePersonal() {
		return this.mobilePersonal;
	}

	public void setMobilePersonal(String mobilePersonal) {
		this.mobilePersonal = mobilePersonal;
	}

	@Column(name = "MOBILE_OFFICE", length = 50)
	public String getMobileOffice() {
		return this.mobileOffice;
	}

	public void setMobileOffice(String mobileOffice) {
		this.mobileOffice = mobileOffice;
	}

	@Column(name = "com.web.lms.modelDER", length = 50)
	public String getcom.web.lms.modelder() {
		return this.com.web.lms.modelder;
	}

	public void setcom.web.lms.modelder(String com.web.lms.modelder) {
		this.com.web.lms.modelder = com.web.lms.modelder;
	}

	@Column(name = "ADDRESS", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "NID", length = 50)
	public String getNid() {
		return this.nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	@Column(name = "NATIONALITY", length = 50)
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JOINING_DATE", length = 19)
	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Column(name = "STATUS", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "PASSWORD", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERT_DATE", nullable = false, length = 19)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByInsertBy")
	public Set<LmsAttachment> getLmsAttachmentsForInsertBy() {
		return this.lmsAttachmentsForInsertBy;
	}

	public void setLmsAttachmentsForInsertBy(Set<LmsAttachment> lmsAttachmentsForInsertBy) {
		this.lmsAttachmentsForInsertBy = lmsAttachmentsForInsertBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByInsertBy")
	public Set<LmsLeaveBalance> getLmsLeaveBalancesForInsertBy() {
		return this.lmsLeaveBalancesForInsertBy;
	}

	public void setLmsLeaveBalancesForInsertBy(Set<LmsLeaveBalance> lmsLeaveBalancesForInsertBy) {
		this.lmsLeaveBalancesForInsertBy = lmsLeaveBalancesForInsertBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByUserId")
	public Set<LmsLeaveBalance> getLmsLeaveBalancesForUserId() {
		return this.lmsLeaveBalancesForUserId;
	}

	public void setLmsLeaveBalancesForUserId(Set<LmsLeaveBalance> lmsLeaveBalancesForUserId) {
		this.lmsLeaveBalancesForUserId = lmsLeaveBalancesForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByInsertBy")
	public Set<LmsLeaveApplication> getLmsLeaveApplicationsForInsertBy() {
		return this.lmsLeaveApplicationsForInsertBy;
	}

	public void setLmsLeaveApplicationsForInsertBy(Set<LmsLeaveApplication> lmsLeaveApplicationsForInsertBy) {
		this.lmsLeaveApplicationsForInsertBy = lmsLeaveApplicationsForInsertBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUser")
	public Set<LmsUser> getLmsUsers() {
		return this.lmsUsers;
	}

	public void setLmsUsers(Set<LmsUser> lmsUsers) {
		this.lmsUsers = lmsUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUser")
	public Set<LmsUserRoleMap> getLmsUserRoleMaps() {
		return this.lmsUserRoleMaps;
	}

	public void setLmsUserRoleMaps(Set<LmsUserRoleMap> lmsUserRoleMaps) {
		this.lmsUserRoleMaps = lmsUserRoleMaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByReliverEmailAddressUserId")
	public Set<LmsLeaveApplication> getLmsLeaveApplicationsForReliverEmailAddressUserId() {
		return this.lmsLeaveApplicationsForReliverEmailAddressUserId;
	}

	public void setLmsLeaveApplicationsForReliverEmailAddressUserId(
			Set<LmsLeaveApplication> lmsLeaveApplicationsForReliverEmailAddressUserId) {
		this.lmsLeaveApplicationsForReliverEmailAddressUserId = lmsLeaveApplicationsForReliverEmailAddressUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByUserId")
	public Set<LmsLeaveApplication> getLmsLeaveApplicationsForUserId() {
		return this.lmsLeaveApplicationsForUserId;
	}

	public void setLmsLeaveApplicationsForUserId(Set<LmsLeaveApplication> lmsLeaveApplicationsForUserId) {
		this.lmsLeaveApplicationsForUserId = lmsLeaveApplicationsForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByUpdateBy")
	public Set<LmsAttachment> getLmsAttachmentsForUpdateBy() {
		return this.lmsAttachmentsForUpdateBy;
	}

	public void setLmsAttachmentsForUpdateBy(Set<LmsAttachment> lmsAttachmentsForUpdateBy) {
		this.lmsAttachmentsForUpdateBy = lmsAttachmentsForUpdateBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByUserId")
	public Set<LmsAttachment> getLmsAttachmentsForUserId() {
		return this.lmsAttachmentsForUserId;
	}

	public void setLmsAttachmentsForUserId(Set<LmsAttachment> lmsAttachmentsForUserId) {
		this.lmsAttachmentsForUserId = lmsAttachmentsForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByUpdateBy")
	public Set<LmsLeaveBalance> getLmsLeaveBalancesForUpdateBy() {
		return this.lmsLeaveBalancesForUpdateBy;
	}

	public void setLmsLeaveBalancesForUpdateBy(Set<LmsLeaveBalance> lmsLeaveBalancesForUpdateBy) {
		this.lmsLeaveBalancesForUpdateBy = lmsLeaveBalancesForUpdateBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUserByUpdateBy")
	public Set<LmsLeaveApplication> getLmsLeaveApplicationsForUpdateBy() {
		return this.lmsLeaveApplicationsForUpdateBy;
	}

	public void setLmsLeaveApplicationsForUpdateBy(Set<LmsLeaveApplication> lmsLeaveApplicationsForUpdateBy) {
		this.lmsLeaveApplicationsForUpdateBy = lmsLeaveApplicationsForUpdateBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsUser")
	public Set<LmsWfRequest> getLmsWfRequests() {
		return this.lmsWfRequests;
	}

	public void setLmsWfRequests(Set<LmsWfRequest> lmsWfRequests) {
		this.lmsWfRequests = lmsWfRequests;
	}

}
