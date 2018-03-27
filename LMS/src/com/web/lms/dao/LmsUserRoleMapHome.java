package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsUserRoleMap;

/**
 * Home object for domain model class LmsUserRoleMap.
 * @see GEN.LmsUserRoleMap
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsUserRoleMapHome {

	private static final Log log = LogFactory.getLog(LmsUserRoleMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsUserRoleMap transientInstance) {
		log.debug("persisting LmsUserRoleMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsUserRoleMap persistentInstance) {
		log.debug("removing LmsUserRoleMap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsUserRoleMap merge(LmsUserRoleMap detachedInstance) {
		log.debug("merging LmsUserRoleMap instance");
		try {
			LmsUserRoleMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsUserRoleMap findById(Integer id) {
		log.debug("getting LmsUserRoleMap instance with id: " + id);
		try {
			LmsUserRoleMap instance = entityManager.find(LmsUserRoleMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
