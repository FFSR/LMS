package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsTmplWfRequestType.
 * @see com.web.lms.dao.LmsTmplWfRequestType
 * @author Hibernate Tools
 */
@Stateless
public class LmsTmplWfRequestTypeHome {

	private static final Log log = LogFactory.getLog(LmsTmplWfRequestTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsTmplWfRequestType transientInstance) {
		log.debug("persisting LmsTmplWfRequestType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsTmplWfRequestType persistentInstance) {
		log.debug("removing LmsTmplWfRequestType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsTmplWfRequestType merge(LmsTmplWfRequestType detachedInstance) {
		log.debug("merging LmsTmplWfRequestType instance");
		try {
			LmsTmplWfRequestType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsTmplWfRequestType findById(Integer id) {
		log.debug("getting LmsTmplWfRequestType instance with id: " + id);
		try {
			LmsTmplWfRequestType instance = entityManager.find(LmsTmplWfRequestType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
