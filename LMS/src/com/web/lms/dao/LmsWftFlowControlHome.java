package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsWftFlowControl;

/**
 * Home object for domain model class LmsWftFlowControl.
 * @see GEN.LmsWftFlowControl
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftFlowControlHome {

	private static final Log log = LogFactory.getLog(LmsWftFlowControlHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftFlowControl transientInstance) {
		log.debug("persisting LmsWftFlowControl instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftFlowControl persistentInstance) {
		log.debug("removing LmsWftFlowControl instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftFlowControl merge(LmsWftFlowControl detachedInstance) {
		log.debug("merging LmsWftFlowControl instance");
		try {
			LmsWftFlowControl result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftFlowControl findById(Integer id) {
		log.debug("getting LmsWftFlowControl instance with id: " + id);
		try {
			LmsWftFlowControl instance = entityManager.find(LmsWftFlowControl.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
