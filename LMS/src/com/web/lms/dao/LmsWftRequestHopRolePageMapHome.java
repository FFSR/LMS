package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsWftRequestHopRolePageMap;

/**
 * Home object for domain model class LmsWftRequestHopRolePageMap.
 * @see GEN.LmsWftRequestHopRolePageMap
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftRequestHopRolePageMapHome {

	private static final Log log = LogFactory.getLog(LmsWftRequestHopRolePageMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRequestHopRolePageMap transientInstance) {
		log.debug("persisting LmsWftRequestHopRolePageMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRequestHopRolePageMap persistentInstance) {
		log.debug("removing LmsWftRequestHopRolePageMap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRequestHopRolePageMap merge(LmsWftRequestHopRolePageMap detachedInstance) {
		log.debug("merging LmsWftRequestHopRolePageMap instance");
		try {
			LmsWftRequestHopRolePageMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRequestHopRolePageMap findById(Integer id) {
		log.debug("getting LmsWftRequestHopRolePageMap instance with id: " + id);
		try {
			LmsWftRequestHopRolePageMap instance = entityManager.find(LmsWftRequestHopRolePageMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
