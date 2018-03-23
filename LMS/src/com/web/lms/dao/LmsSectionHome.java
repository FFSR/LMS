package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsSection.
 * @see com.web.lms.dao.LmsSection
 * @author Hibernate Tools
 */
@Stateless
public class LmsSectionHome {

	private static final Log log = LogFactory.getLog(LmsSectionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsSection transientInstance) {
		log.debug("persisting LmsSection instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsSection persistentInstance) {
		log.debug("removing LmsSection instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsSection merge(LmsSection detachedInstance) {
		log.debug("merging LmsSection instance");
		try {
			LmsSection result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsSection findById(Integer id) {
		log.debug("getting LmsSection instance with id: " + id);
		try {
			LmsSection instance = entityManager.find(LmsSection.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
