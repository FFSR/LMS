package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsWfRequestHops;

/**
 * Home object for domain model class LmsWfRequestHops.
 * @see com.web.lms.dao.LmsWfRequestHops
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWfRequestHopsHome {

	private static final Log log = LogFactory.getLog(LmsWfRequestHopsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWfRequestHops transientInstance) {
		log.debug("persisting LmsWfRequestHops instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWfRequestHops persistentInstance) {
		log.debug("removing LmsWfRequestHops instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWfRequestHops merge(LmsWfRequestHops detachedInstance) {
		log.debug("merging LmsWfRequestHops instance");
		try {
			LmsWfRequestHops result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWfRequestHops findById(Integer id) {
		log.debug("getting LmsWfRequestHops instance with id: " + id);
		try {
			LmsWfRequestHops instance = entityManager.find(LmsWfRequestHops.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
