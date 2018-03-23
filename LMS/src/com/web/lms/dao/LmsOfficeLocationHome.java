package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsOfficeLocation;

/**
 * Home object for domain model class LmsOfficeLocation.
 * @see com.web.lms.dao.LmsOfficeLocation
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsOfficeLocationHome {

	private static final Log log = LogFactory.getLog(LmsOfficeLocationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsOfficeLocation transientInstance) {
		log.debug("persisting LmsOfficeLocation instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsOfficeLocation persistentInstance) {
		log.debug("removing LmsOfficeLocation instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsOfficeLocation merge(LmsOfficeLocation detachedInstance) {
		log.debug("merging LmsOfficeLocation instance");
		try {
			LmsOfficeLocation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsOfficeLocation findById(Integer id) {
		log.debug("getting LmsOfficeLocation instance with id: " + id);
		try {
			LmsOfficeLocation instance = entityManager.find(LmsOfficeLocation.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
