package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsWftRequestType;

/**
 * Home object for domain model class LmsWftRequestType.
 * @see GEN.LmsWftRequestType
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftRequestTypeHome {

	private static final Log log = LogFactory.getLog(LmsWftRequestTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRequestType transientInstance) {
		log.debug("persisting LmsWftRequestType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRequestType persistentInstance) {
		log.debug("removing LmsWftRequestType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRequestType merge(LmsWftRequestType detachedInstance) {
		log.debug("merging LmsWftRequestType instance");
		try {
			LmsWftRequestType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRequestType findById(Integer id) {
		log.debug("getting LmsWftRequestType instance with id: " + id);
		try {
			LmsWftRequestType instance = entityManager.find(LmsWftRequestType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
