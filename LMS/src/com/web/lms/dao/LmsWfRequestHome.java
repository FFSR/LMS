package com.web.lms.dao;
// Generated Mar 30, 2018 1:16:28 PM by Hibernate Tools 5.2.8.Final

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
import com.web.lms.model.LmsWfRequest;

/**
 * Home object for domain model class LmsWfRequest.
 * @see GEN.LmsWfRequest
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWfRequestHome {

	private static final Log log = LogFactory.getLog(LmsWfRequestHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public int persist(LmsWfRequest transientInstance) {
		log.debug("persisting LmsWfRequest instance");
		try {
			entityManager.persist(transientInstance);
			entityManager.flush();
			int requestId = transientInstance.getId();			
			log.debug("persist successful");			
			return requestId;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWfRequest persistentInstance) {
		log.debug("removing LmsWfRequest instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWfRequest merge(LmsWfRequest detachedInstance) {
		log.debug("merging LmsWfRequest instance");
		try {
			LmsWfRequest result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWfRequest findById(Integer id) {
		log.debug("getting LmsWfRequest instance with id: " + id);
		try {
			LmsWfRequest instance = entityManager.find(LmsWfRequest.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public LmsWfRequest findRequestByUserAndDate(Integer userid, Date date) {

		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsWfRequest e WHERE e.lmsUser.id=:userid AND e.startDate)=:date")
					.setParameter("userid", userid).setParameter("date", date);

			LmsWfRequest lmsWfRequest = (LmsWfRequest) query.getSingleResult();

			return lmsWfRequest;

		} catch (Exception ex) {
			return null;
		}
	}
	
	public List<LmsWfRequest> findRequestByUserAndDateRange(Integer userid, Date startdate,Date enddate) {
		
		// used to find request for a particular date range so that user can see status
		// of all leave requests which are raised within this range. For checking 'My Leave Status' this will be used.

		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsWfRequest e WHERE e.lmsUserByUserId.id=:userid AND e.startDate BETWEEN :startdate and :enddate")
					.setParameter("userid", userid).setParameter("startdate", startdate).setParameter("enddate", enddate);

			List<LmsWfRequest> listLmsWfRequest =  query.getResultList();

			return listLmsWfRequest;

		} catch (Exception ex) {
			return null;
		}
	}
	
	
	public List<LmsWfRequest> findRequestByUserID(Integer userid) {

		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsWfRequest e WHERE e.lmsUserByUserId.id=:userid")
					.setParameter("userid", userid);

			List<LmsWfRequest> listLmsWfRequest = query.getResultList();

			return listLmsWfRequest;

		} catch (Exception ex) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsWfRequest> findAllLeaveApplicationsGeaterThanCurrentDate() {
		try {

			// Both are same mysql query
			// SELECT t.* FROM lms_leave_application t JOIN lms_wf_request r ON r.LEAVE_APPLICATION_ID = t.ID WHERE r.STATUS='APPROVED' AND t.TO_DATE > CURDATE();
			// SELECT r.* FROM lms_wf_request r JOIN lms_leave_application t ON r.LEAVE_APPLICATION_ID = t.ID WHERE r.STATUS='APPROVED' AND t.TO_DATE > CURDATE();

			// Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e RIGHT JOIN LmsWfRequest.lmsLeaveApplication t WHERE t.status='APPROVED' AND
			// e.toDate >=CURDATE()");

			Query query = entityManager.createQuery("SELECT e FROM LmsWfRequest e JOIN e.lmsLeaveApplication t WHERE e.status='APPROVED' AND t.toDate >=CURDATE()");

			return (List<LmsWfRequest>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}
	}
}
