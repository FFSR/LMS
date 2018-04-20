package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsDesignation;


/**
 * Home object for domain model class LmsDesignation.
 * @see GEN.LmsDesignation
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsDesignationHome {

	private static final Log log = LogFactory.getLog(LmsDesignationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsDesignation transientInstance) {
		log.debug("persisting LmsDesignation instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsDesignation persistentInstance) {
		log.debug("removing LmsDesignation instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsDesignation merge(LmsDesignation detachedInstance) {
		log.debug("merging LmsDesignation instance");
		try {
			LmsDesignation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsDesignation findById(Integer id) {
		log.debug("getting LmsDesignation instance with id: " + id);
		try {
			LmsDesignation instance = entityManager.find(LmsDesignation.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsDesignation> getAlldesignation(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsDesignation e");
			
			return (List<LmsDesignation>) query.getResultList(); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
