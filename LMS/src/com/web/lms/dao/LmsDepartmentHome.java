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

import com.web.lms.model.LmsDepartment;


/**
 * Home object for domain model class LmsDepartment.
 * @see GEN.LmsDepartment
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsDepartmentHome {

	private static final Log log = LogFactory.getLog(LmsDepartmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsDepartment transientInstance) {
		log.debug("persisting LmsDepartment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsDepartment persistentInstance) {
		log.debug("removing LmsDepartment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsDepartment merge(LmsDepartment detachedInstance) {
		log.debug("merging LmsDepartment instance");
		try {
			LmsDepartment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsDepartment findById(Integer id) {
		log.debug("getting LmsDepartment instance with id: " + id);
		try {
			LmsDepartment instance = entityManager.find(LmsDepartment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsDepartment> getAlldepartment(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsDepartment e");
			
			return (List<LmsDepartment>) query.getResultList(); 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
