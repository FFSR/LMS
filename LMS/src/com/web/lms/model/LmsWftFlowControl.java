package com.web.lms.model;
// Generated Mar 27, 2018 11:06:48 PM by Hibernate Tools 5.2.8.Final

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
 * LmsWftFlowControl generated by hbm2java
 */
@Entity
@Table(name = "lms_wft_flow_control", catalog = "supremet_lmsdb")
public class LmsWftFlowControl implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMapByTrhmHopsId;
	private LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMapByTrhmDependedHopsId;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsWftFlowControl() {
	}

	public LmsWftFlowControl(LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMapByTrhmHopsId,
			LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMapByTrhmDependedHopsId, Date insertDate,
			Integer insertBy, Date updateDate, Integer updateBy) {
		this.lmsWftRequestHopRolePageMapByTrhmHopsId = lmsWftRequestHopRolePageMapByTrhmHopsId;
		this.lmsWftRequestHopRolePageMapByTrhmDependedHopsId = lmsWftRequestHopRolePageMapByTrhmDependedHopsId;
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
	@JoinColumn(name = "TRHM_HOPS_ID")
	public LmsWftRequestHopRolePageMap getLmsWftRequestHopRolePageMapByTrhmHopsId() {
		return this.lmsWftRequestHopRolePageMapByTrhmHopsId;
	}

	public void setLmsWftRequestHopRolePageMapByTrhmHopsId(
			LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMapByTrhmHopsId) {
		this.lmsWftRequestHopRolePageMapByTrhmHopsId = lmsWftRequestHopRolePageMapByTrhmHopsId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TRHM_DEPENDED_HOPS_ID")
	public LmsWftRequestHopRolePageMap getLmsWftRequestHopRolePageMapByTrhmDependedHopsId() {
		return this.lmsWftRequestHopRolePageMapByTrhmDependedHopsId;
	}

	public void setLmsWftRequestHopRolePageMapByTrhmDependedHopsId(
			LmsWftRequestHopRolePageMap lmsWftRequestHopRolePageMapByTrhmDependedHopsId) {
		this.lmsWftRequestHopRolePageMapByTrhmDependedHopsId = lmsWftRequestHopRolePageMapByTrhmDependedHopsId;
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
