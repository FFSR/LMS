package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsPageRoleMap.
 * @see com.web.lms.dao.LmsPageRoleMap
 * @author Hibernate Tools
 */
@Stateless
public class LmsPageRoleMapHome {

	private static final Log log = LogFactory.getLog(LmsPageRoleMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsPageRoleMap transientInstance) {
		log.debug("persisting LmsPageRoleMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsPageRoleMap persistentInstance) {
		log.debug("removing LmsPageRoleMap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsPageRoleMap merge(LmsPageRoleMap detachedInstance) {
		log.debug("merging LmsPageRoleMap instance");
		try {
			LmsPageRoleMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsPageRoleMap findById(Integer id) {
		log.debug("getting LmsPageRoleMap instance with id: " + id);
		try {
			LmsPageRoleMap instance = entityManager.find(LmsPageRoleMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
