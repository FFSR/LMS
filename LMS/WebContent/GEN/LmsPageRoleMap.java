package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

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
 * LmsPageRoleMap generated by hbm2java
 */
@Entity
@Table(name = "lms_page_role_map", catalog = "lmsdb")
public class LmsPageRoleMap implements java.io.Serializable {

	private Integer id;
	private LmsPages lmsPages;
	private LmsRole lmsRole;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;

	public LmsPageRoleMap() {
	}

	public LmsPageRoleMap(LmsPages lmsPages, LmsRole lmsRole, Date insertDate, Integer insertBy, Date updateDate,
			Integer updateBy) {
		this.lmsPages = lmsPages;
		this.lmsRole = lmsRole;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGE_ID")
	public LmsPages getLmsPages() {
		return this.lmsPages;
	}

	public void setLmsPages(LmsPages lmsPages) {
		this.lmsPages = lmsPages;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public LmsRole getLmsRole() {
		return this.lmsRole;
	}

	public void setLmsRole(LmsRole lmsRole) {
		this.lmsRole = lmsRole;
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
