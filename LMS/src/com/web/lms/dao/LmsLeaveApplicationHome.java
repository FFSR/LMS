package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

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
	
@SuppressWarnings("unchecked")	
public List<LmsLeaveApplication> findLeaveApplicationByUserID(String user_name, Integer userid) {
	
	String userName = "";
	String userID = "";
	
	if(user_name != null) {
		userName = "AND lmsuser.NAME = '"+user_name+"'";
	}
	else {
		userName = " ";
	}
	if(userid != 0) {
		userID = "lapp.USER_ID = " + userid;
	}
	else {
		userID = " ";
	}
		
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM lms_leave_application lapp " + 
					"LEFT JOIN lms_user lmsuser ON lmsuser.ID = lapp.USER_ID " + 
					"WHERE "+userID+ " " + userName);
		
			List<LmsLeaveApplication> lmsLeaveApplication = query.getResultList();
		
			return lmsLeaveApplication;
		
		}
		catch(Exception ex) {
			
			return null;
			
		}
	}

@SuppressWarnings("unchecked")
public List<LmsLeaveApplication> findAllLeaveApplications() {
	try {
		Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e");
		
		return (List<LmsLeaveApplication>) query.getResultList();
	}
	catch(Exception ex) {
		ex.printStackTrace();
		
		return null;
	}
}

@SuppressWarnings("unchecked")
public List<LmsLeaveApplication> findAllLeaveApplicationsGeaterThanCurrentDate() {
	try {
		Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e WHERE e.toDate >=CURDATE()");
		
		return (List<LmsLeaveApplication>) query.getResultList();
	}
	catch(Exception ex) {
		ex.printStackTrace();
		
		return null;
	}
}
}
