package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsClass;

/**
 * Home object for domain model class LmsClass.
 * @see GEN.LmsClass
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsClassHome {

	private static final Log log = LogFactory.getLog(LmsClassHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsClass transientInstance) {
		log.debug("persisting LmsClass instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsClass persistentInstance) {
		log.debug("removing LmsClass instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsClass merge(LmsClass detachedInstance) {
		log.debug("merging LmsClass instance");
		try {
			LmsClass result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsClass findById(Integer id) {
		log.debug("getting LmsClass instance with id: " + id);
		try {
			LmsClass instance = entityManager.find(LmsClass.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
