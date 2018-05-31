package com.web.lms.dao;
// Generated May 31, 2018 10:59:04 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsWftRoleUserMapHistory;

/**
 * Home object for domain model class LmsWftRoleUserMapHistory.
 * @see GEN.LmsWftRoleUserMapHistory
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftRoleUserMapHistoryHome {

	private static final Log log = LogFactory.getLog(LmsWftRoleUserMapHistoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRoleUserMapHistory transientInstance) {
		log.debug("persisting LmsWftRoleUserMapHistory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRoleUserMapHistory persistentInstance) {
		log.debug("removing LmsWftRoleUserMapHistory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRoleUserMapHistory merge(LmsWftRoleUserMapHistory detachedInstance) {
		log.debug("merging LmsWftRoleUserMapHistory instance");
		try {
			LmsWftRoleUserMapHistory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRoleUserMapHistory findById(Integer id) {
		log.debug("getting LmsWftRoleUserMapHistory instance with id: " + id);
		try {
			LmsWftRoleUserMapHistory instance = entityManager.find(LmsWftRoleUserMapHistory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
