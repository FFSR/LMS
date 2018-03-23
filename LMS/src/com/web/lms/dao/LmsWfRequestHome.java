package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsWfRequest.
 * @see com.web.lms.dao.LmsWfRequest
 * @author Hibernate Tools
 */
@Stateless
public class LmsWfRequestHome {

	private static final Log log = LogFactory.getLog(LmsWfRequestHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWfRequest transientInstance) {
		log.debug("persisting LmsWfRequest instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWfRequest persistentInstance) {
		log.debug("removing LmsWfRequest instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWfRequest merge(LmsWfRequest detachedInstance) {
		log.debug("merging LmsWfRequest instance");
		try {
			LmsWfRequest result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWfRequest findById(Integer id) {
		log.debug("getting LmsWfRequest instance with id: " + id);
		try {
			LmsWfRequest instance = entityManager.find(LmsWfRequest.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
