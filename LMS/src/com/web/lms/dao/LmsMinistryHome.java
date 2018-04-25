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


import com.web.lms.model.LmsMinistry;

/**
 * Home object for domain model class LmsMinistry.
 * @see GEN.LmsMinistry
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsMinistryHome {

	private static final Log log = LogFactory.getLog(LmsMinistryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public int persist(LmsMinistry transientInstance) {
		log.debug("persisting LmsUser instance");
		try {
			entityManager.persist(transientInstance);
			entityManager.flush();
			int lmsuserId = transientInstance.getId();
			log.debug("persist successful");
			return lmsuserId;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsMinistry persistentInstance) {
		log.debug("removing LmsMinistry instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsMinistry merge(LmsMinistry detachedInstance) {
		log.debug("merging LmsMinistry instance");
		try {
			LmsMinistry result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsMinistry findById(Integer id) {
		log.debug("getting LmsMinistry instance with id: " + id);
		try {
			LmsMinistry instance = entityManager.find(LmsMinistry.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsMinistry> getAllministry(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsMinistry e");
			
			return (List<LmsMinistry>) query.getResultList(); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
