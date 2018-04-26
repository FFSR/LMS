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
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsUser;

/**
 * Home object for domain model class LmsLeaveApplication.
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
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e WHERE e.lmsUserByUserId.id=:userid").setParameter("userid",userid);
		
			List<LmsLeaveApplication> lmsLeaveApplications = query.getResultList();
			
			return lmsLeaveApplications;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public List<LmsLeaveApplication> findLeaveApplicationByUserandLeaveTypeandYear(Integer userid, Integer leaveTypeId, String year) {		
		try {
			String sDate= year +"-01-01 00:00:00";
			String eDate= year +"-12-31 23:59:59"; 
			
		    Date sdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDate); 
		    Date edate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(eDate);
			
			
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e WHERE e.lmsUserByUserId.id=:userid AND e.lmsLeaveType.id=:leaveTypeId AND (e.fromDate BETWEEN :stDate AND :edDate OR e.toDate BETWEEN :stDate AND :edDate)")
					.setParameter("userid", userid)
					.setParameter("leaveTypeId", leaveTypeId)
					.setParameter("stDate", sdate)
					.setParameter("edDate", edate);
		
			List<LmsLeaveApplication> leaveApplications = query.getResultList();
		
			return leaveApplications;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
}
