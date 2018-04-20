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

import com.web.lms.model.LmsDivision;

/**
 * Home object for domain model class LmsDivision.
 * @see GEN.LmsDivision
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
	
	@SuppressWarnings("unchecked")
	public List<LmsDivision> getAlldivision(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsDivision e");
			
			return (List<LmsDivision>) query.getResultList(); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
