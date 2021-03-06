package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsLeaveApplication;

/**
 * Home object for domain model class LmsLeaveApplication.
 * 
 * @see GEN.LmsLeaveApplication
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsLeaveApplicationHome {

	private static final Log log = LogFactory.getLog(LmsLeaveApplicationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public int persist(LmsLeaveApplication transientInstance) {
		log.debug("persisting LmsLeaveApplication instance");
		try {
			entityManager.persist(transientInstance);
			entityManager.flush();
			int lmsleaveapplicationId = transientInstance.getId();
			log.debug("persist successful");
			return lmsleaveapplicationId;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsLeaveApplication persistentInstance) {
		log.debug("removing LmsLeaveApplication instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsLeaveApplication merge(LmsLeaveApplication detachedInstance) {
		log.debug("merging LmsLeaveApplication instance");
		try {
			LmsLeaveApplication result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsLeaveApplication findById(Integer id) {
		log.debug("getting LmsLeaveApplication instance with id: " + id);
		try {
			LmsLeaveApplication instance = entityManager.find(LmsLeaveApplication.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LmsLeaveApplication> findLeaveApplicationByUserID(Integer userid) {
		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsLeaveApplication e WHERE e.lmsUserByUserId.id=:userid")
					.setParameter("userid", userid);

			List<LmsLeaveApplication> lmsLeaveApplications = query.getResultList();

			return lmsLeaveApplications;
		} catch (Exception ex) {
			return null;
		}
	}

	public List<LmsLeaveApplication> findLeaveApplicationByUserandLeaveTypeandYear(Integer userid, Integer leaveTypeId,
			String year) {
		try {
			String sDate = year + "-01-01 00:00:00";
			String eDate = year + "-12-31 23:59:59";

			Date sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDate);
			Date edate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(eDate);

			Query query = entityManager.createQuery(
					"SELECT e FROM LmsLeaveApplication e WHERE e.lmsUserByUserId.id=:userid AND e.lmsLeaveType.id=:leaveTypeId AND (e.fromDate BETWEEN :stDate AND :edDate OR e.toDate BETWEEN :stDate AND :edDate)")
					.setParameter("userid", userid).setParameter("leaveTypeId", leaveTypeId)
					.setParameter("stDate", sdate).setParameter("edDate", edate);

			List<LmsLeaveApplication> leaveApplications = query.getResultList();

			return leaveApplications;
		} catch (Exception ex) {
			return null;
		}
	}

	public List<LmsLeaveApplication> findLeaveApplicationByUserandLeaveType(Integer userid, Integer leaveTypeId) {
		try {
			Query query = entityManager.createQuery(
					"SELECT e FROM LmsLeaveApplication e WHERE e.lmsUserByUserId.id=:userid AND e.lmsLeaveType.id=:leaveTypeId")
					.setParameter("userid", userid).setParameter("leaveTypeId", leaveTypeId);

			List<LmsLeaveApplication> leaveApplications = query.getResultList();

			return leaveApplications;
		} catch (Exception ex) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LmsLeaveApplication> findAllLeaveApplications() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e");

			return (List<LmsLeaveApplication>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LmsLeaveApplication> findAllLeaveApplicationsGeaterThanCurrentDate() {
		try {

			// Both return same data
			// SELECT t.* FROM lms_leave_application t JOIN lms_wf_request r ON
			// r.LEAVE_APPLICATION_ID = t.ID WHERE r.STATUS='APPROVED' AND t.TO_DATE >
			// CURDATE();
			// SELECT r.* FROM lms_wf_request r JOIN lms_leave_application t ON
			// r.LEAVE_APPLICATION_ID = t.ID WHERE r.STATUS='APPROVED' AND t.TO_DATE >
			// CURDATE();

			Query query = entityManager.createQuery(
					"SELECT t FROM LmsWfRequest e JOIN e.lmsLeaveApplication t WHERE e.status='APPROVED' AND DATE(t.toDate) >= DATE(CURDATE())");

			return (List<LmsLeaveApplication>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LmsLeaveApplication> findAllLeaveApplicationsGeaterThanCurrentDate(Integer userid, Date startDate) {
		try {

			// SELECT t.id, t.FROM_DATE,t.TO_DATE FROM lms_leave_application t
			// JOIN lms_wf_request r ON r.LEAVE_APPLICATION_ID = t.ID
			// WHERE t.USER_ID =11
			// AND t.TO_DATE >= CURDATE()
			// AND ( r.STATUS = 'APPROVED' OR r.STATUS = 'INPROGRESS' )
			// ORDER BY t.FROM_DATE;

			Query query = entityManager.createQuery(
					"SELECT t FROM LmsWfRequest e JOIN e.lmsLeaveApplication t WHERE t.lmsUserByUserId.id=:userid AND DATE(t.toDate) >= DATE(:startDate) AND ( e.status='APPROVED' OR e.status='INPROGRESS' )")
					.setParameter("userid", userid)
					.setParameter("startDate", startDate);

			return (List<LmsLeaveApplication>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}
	}

}
