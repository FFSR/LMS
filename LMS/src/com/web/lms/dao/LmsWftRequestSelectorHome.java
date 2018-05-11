package com.web.lms.dao;
// Generated Mar 27, 2018 11:06:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWftRequestSelector;

/**
 * Home object for domain model class LmsWftRequestSelector.
 * @see GEN.LmsWftRequestSelector
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftRequestSelectorHome {

	private static final Log log = LogFactory.getLog(LmsWftRequestSelectorHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRequestSelector transientInstance) {
		log.debug("persisting LmsWftRequestSelector instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRequestSelector persistentInstance) {
		log.debug("removing LmsWftRequestSelector instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRequestSelector merge(LmsWftRequestSelector detachedInstance) {
		log.debug("merging LmsWftRequestSelector instance");
		try {
			LmsWftRequestSelector result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRequestSelector findById(Integer id) {
		log.debug("getting LmsWftRequestSelector instance with id: " + id);
		try {
			LmsWftRequestSelector instance = entityManager.find(LmsWftRequestSelector.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public LmsWftRequestSelector findRequestTypeByClassSectorLeaveType(Integer classid, Integer sectionid, Integer leaveTypeid) {
		
		try { // SELECT t.* FROM lms_wft_request_selector t WHERE t.CLASS_ID=2 AND t.SECTION_ID=3 AND t.LEAVE_TYPE_ID=1;
			
			Query query = entityManager.createQuery("SELECT e FROM LmsWftRequestSelector e WHERE e.lmsClass.id=:classid AND e.lmsSection.id=:sectionid AND e.lmsLeaveType.id=:leaveTypeid")
					.setParameter("classid", classid)
					.setParameter("sectionid", sectionid)
					.setParameter("leaveTypeid", leaveTypeid);
		
			LmsWftRequestSelector lmsWftRequestSelector = (LmsWftRequestSelector) query.getSingleResult();
		
			return lmsWftRequestSelector;
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public LmsWftRequestSelector findRequestTypeByClassSectorLeaveType(Integer classid, Integer leaveTypeid) {
		
		try { // SELECT t.* FROM lms_wft_request_selector t WHERE t.CLASS_ID=2 AND t.SECTION_ID=3 AND t.LEAVE_TYPE_ID=1;
			
			Query query = entityManager.createQuery("SELECT e FROM LmsWftRequestSelector e WHERE e.lmsClass.id=:classid AND e.lmsSection.id=:sectionid AND e.lmsLeaveType.id=:leaveTypeid")
					.setParameter("classid", classid)
					.setParameter("leaveTypeid", leaveTypeid);
		
			LmsWftRequestSelector lmsWftRequestSelector = (LmsWftRequestSelector) query.getSingleResult();
		
			return lmsWftRequestSelector;
		}
		catch(Exception ex) {			
			return null;			
		}
	}
}
