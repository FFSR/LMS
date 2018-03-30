package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsLeaveApplication;

/**
 * Home object for domain model class LmsLeaveApplication.
 * @see com.web.lms.dao.LmsLeaveApplication
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
}
