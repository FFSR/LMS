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

import com.web.lms.model.LmsRole;
import com.web.lms.model.LmsSection;

/**
 * Home object for domain model class LmsRole.
 * @see GEN.LmsRole
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsRoleHome {

	private static final Log log = LogFactory.getLog(LmsRoleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsRole transientInstance) {
		log.debug("persisting LmsRole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsRole persistentInstance) {
		log.debug("removing LmsRole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsRole merge(LmsRole detachedInstance) {
		log.debug("merging LmsRole instance");
		try {
			LmsRole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsRole findById(Integer id) {
		log.debug("getting LmsRole instance with id: " + id);
		try {
			LmsRole instance = entityManager.find(LmsRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsRole> getAllrole(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsRole e");
			
			return (List<LmsRole>) query.getResultList(); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
}
