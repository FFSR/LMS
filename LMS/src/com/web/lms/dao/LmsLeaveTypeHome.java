package com.web.lms.dao;
// Generated Apr 23, 2018 12:29:31 AM by Hibernate Tools 5.2.8.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsLeaveType;

/**
 * Home object for domain model class LmsLeaveType.
 * @see GEN.LmsLeaveType
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsLeaveTypeHome {

	private static final Log log = LogFactory.getLog(LmsLeaveTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsLeaveType transientInstance) {
		log.debug("persisting LmsLeaveType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsLeaveType persistentInstance) {
		log.debug("removing LmsLeaveType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsLeaveType merge(LmsLeaveType detachedInstance) {
		log.debug("merging LmsLeaveType instance");
		try {
			LmsLeaveType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsLeaveType findById(Integer id) {
		log.debug("getting LmsLeaveType instance with id: " + id);
		try {
			LmsLeaveType instance = entityManager.find(LmsLeaveType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public LmsLeaveType findByType(String leavetype) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveType e WHERE e.type=:leavetype").setParameter("leavetype", leavetype);
			
			return (LmsLeaveType) query.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsLeaveType> findAllLeaveType() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveType e");
			
			return (List<LmsLeaveType>) query.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
}
