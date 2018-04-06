package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

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
	
	
	
public List<LmsLeaveApplication> findLeaveBalanceByUserID(Integer userid) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveApplication e WHERE e.lmsUser.id=:userid").setParameter("userid", userid);
		
			List<LmsLeaveApplication> LmsLeaveApplication = query.getResultList();
		
			return LmsLeaveApplication;
		
		}
		catch(Exception ex) {
			
			return null;
			
		}
	}
}
