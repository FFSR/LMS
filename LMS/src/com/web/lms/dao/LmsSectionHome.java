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

import com.web.lms.model.LmsSection;

/**
 * Home object for domain model class LmsSection.
 * @see GEN.LmsSection
 * @author Hibernate Tools
 */
@Repository
@Transactional
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
	
	@SuppressWarnings("unchecked")
	public List<LmsSection> getAllsection(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsSection e");
			
			return (List<LmsSection>) query.getResultList(); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
