package com.web.lms.dao;
// Generated Mar 17, 2018 12:06:37 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.Myguests;

/**
 * Home object for domain model class Myguests.
 * @see GEN.Myguests
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class MyguestsHome {

	private static final Log log = LogFactory.getLog(MyguestsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Myguests transientInstance) {
		log.debug("persisting Myguests instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Myguests persistentInstance) {
		log.debug("removing Myguests instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Myguests merge(Myguests detachedInstance) {
		log.debug("merging Myguests instance");
		try {
			Myguests result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Myguests findById(Integer id) {
		log.debug("getting Myguests instance with id: " + id);
		try {
			Myguests instance = entityManager.find(Myguests.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
