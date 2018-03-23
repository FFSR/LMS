package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsLeaveType.
 * @see com.web.lms.dao.LmsLeaveType
 * @author Hibernate Tools
 */
@Stateless
public class LmsLeaveTypeHome {

	private static final Log log = LogFactory.getLog(LmsLeaveTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsLeaveType transientInstance) {
		log.debug("persisting LmsLeaveType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsLeaveType persistentInstance) {
		log.debug("removing LmsLeaveType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsLeaveType merge(LmsLeaveType detachedInstance) {
		log.debug("merging LmsLeaveType instance");
		try {
			LmsLeaveType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsLeaveType findById(Integer id) {
		log.debug("getting LmsLeaveType instance with id: " + id);
		try {
			LmsLeaveType instance = entityManager.find(LmsLeaveType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
