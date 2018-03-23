package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsTmplWfHops;

/**
 * Home object for domain model class LmsTmplWfHops.
 * @see com.web.lms.dao.LmsTmplWfHops
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsTmplWfHopsHome {

	private static final Log log = LogFactory.getLog(LmsTmplWfHopsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsTmplWfHops transientInstance) {
		log.debug("persisting LmsTmplWfHops instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsTmplWfHops persistentInstance) {
		log.debug("removing LmsTmplWfHops instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsTmplWfHops merge(LmsTmplWfHops detachedInstance) {
		log.debug("merging LmsTmplWfHops instance");
		try {
			LmsTmplWfHops result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsTmplWfHops findById(Integer id) {
		log.debug("getting LmsTmplWfHops instance with id: " + id);
		try {
			LmsTmplWfHops instance = entityManager.find(LmsTmplWfHops.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
