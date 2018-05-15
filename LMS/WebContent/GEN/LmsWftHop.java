package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

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

/**
 * LmsWftHop generated by hbm2java
 */
@Entity
@Table(name = "lms_wft_hop", catalog = "lmsdb")
public class LmsWftHop implements java.io.Serializable {

	private Integer id;
	private String name;
	private Date insertDate;
	private Integer insertBy;
	private Date updateDate;
	private Integer updateBy;
	private Set<LmsWftRequestHopRolePageMap> lmsWftRequestHopRolePageMaps = new HashSet<LmsWftRequestHopRolePageMap>(0);

	public LmsWftHop() {
	}

	public LmsWftHop(String name, Date insertDate, Integer insertBy, Date updateDate, Integer updateBy,
			Set<LmsWftRequestHopRolePageMap> lmsWftRequestHopRolePageMaps) {
		this.name = name;
		this.insertDate = insertDate;
		this.insertBy = insertBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.lmsWftRequestHopRolePageMaps = lmsWftRequestHopRolePageMaps;
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

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lmsWftHop")
	public Set<LmsWftRequestHopRolePageMap> getLmsWftRequestHopRolePageMaps() {
		return this.lmsWftRequestHopRolePageMaps;
	}

	public void setLmsWftRequestHopRolePageMaps(Set<LmsWftRequestHopRolePageMap> lmsWftRequestHopRolePageMaps) {
		this.lmsWftRequestHopRolePageMaps = lmsWftRequestHopRolePageMaps;
	}

}
