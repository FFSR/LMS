package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsTmplRequestHopsRoleMap;

/**
 * Home object for domain model class LmsTmplRequestHopsRoleMap.
 * @see com.web.lms.dao.LmsTmplRequestHopsRoleMap
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsTmplRequestHopsRoleMapHome {

	private static final Log log = LogFactory.getLog(LmsTmplRequestHopsRoleMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsTmplRequestHopsRoleMap transientInstance) {
		log.debug("persisting LmsTmplRequestHopsRoleMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsTmplRequestHopsRoleMap persistentInstance) {
		log.debug("removing LmsTmplRequestHopsRoleMap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsTmplRequestHopsRoleMap merge(LmsTmplRequestHopsRoleMap detachedInstance) {
		log.debug("merging LmsTmplRequestHopsRoleMap instance");
		try {
			LmsTmplRequestHopsRoleMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsTmplRequestHopsRoleMap findById(Integer id) {
		log.debug("getting LmsTmplRequestHopsRoleMap instance with id: " + id);
		try {
			LmsTmplRequestHopsRoleMap instance = entityManager.find(LmsTmplRequestHopsRoleMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
