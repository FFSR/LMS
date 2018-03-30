package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsWftHop;

/**
 * Home object for domain model class LmsWftHop.
 * @see GEN.LmsWftHop
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftHopHome {

	private static final Log log = LogFactory.getLog(LmsWftHopHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftHop transientInstance) {
		log.debug("persisting LmsWftHop instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftHop persistentInstance) {
		log.debug("removing LmsWftHop instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftHop merge(LmsWftHop detachedInstance) {
		log.debug("merging LmsWftHop instance");
		try {
			LmsWftHop result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftHop findById(Integer id) {
		log.debug("getting LmsWftHop instance with id: " + id);
		try {
			LmsWftHop instance = entityManager.find(LmsWftHop.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
