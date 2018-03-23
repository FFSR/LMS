package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class LmsTmplWfRole.
 * @see com.web.lms.dao.LmsTmplWfRole
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsTmplWfRoleHome {

	private static final Log log = LogFactory.getLog(LmsTmplWfRoleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsTmplWfRole transientInstance) {
		log.debug("persisting LmsTmplWfRole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsTmplWfRole persistentInstance) {
		log.debug("removing LmsTmplWfRole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsTmplWfRole merge(LmsTmplWfRole detachedInstance) {
		log.debug("merging LmsTmplWfRole instance");
		try {
			LmsTmplWfRole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsTmplWfRole findById(Integer id) {
		log.debug("getting LmsTmplWfRole instance with id: " + id);
		try {
			LmsTmplWfRole instance = entityManager.find(LmsTmplWfRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
