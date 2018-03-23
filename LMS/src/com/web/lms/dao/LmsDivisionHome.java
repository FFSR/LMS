package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsDivision;

/**
 * Home object for domain model class LmsDivision.
 * @see com.web.lms.dao.LmsDivision
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsDivisionHome {

	private static final Log log = LogFactory.getLog(LmsDivisionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsDivision transientInstance) {
		log.debug("persisting LmsDivision instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsDivision persistentInstance) {
		log.debug("removing LmsDivision instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsDivision merge(LmsDivision detachedInstance) {
		log.debug("merging LmsDivision instance");
		try {
			LmsDivision result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsDivision findById(Integer id) {
		log.debug("getting LmsDivision instance with id: " + id);
		try {
			LmsDivision instance = entityManager.find(LmsDivision.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
