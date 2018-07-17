package com.web.lms.dao;
// Generated Jul 8, 2018 10:37:32 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsEventLog;
import com.web.lms.model.LmsWfRequest;

/**
 * Home object for domain model class LmsEventLog.
 * @see GEN.LmsEventLog
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsEventLogHome {

	private static final Log log = LogFactory.getLog(LmsEventLogHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsEventLog transientInstance) {
		log.debug("persisting LmsEventLog instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsEventLog persistentInstance) {
		log.debug("removing LmsEventLog instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsEventLog merge(LmsEventLog detachedInstance) {
		log.debug("merging LmsEventLog instance");
		try {
			LmsEventLog result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsEventLog findById(Integer id) {
		log.debug("getting LmsEventLog instance with id: " + id);
		try {
			LmsEventLog instance = entityManager.find(LmsEventLog.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
public List<LmsEventLog> findeventlogDateRange(Date startdate,Date enddate) {
		
		// used to find request for a particular date range so that user can see status
		// of all leave requests which are raised within this range. For checking 'My Leave Status' this will be used.

		try {
			/*Query query = entityManager
					.createQuery("SELECT e FROM LmsEventLog e WHERE date_format(e.eventTime,'%d/%m/%Y/%H:%i:%s') BETWEEN :startdate and :enddate")
					.setParameter("startdate", startdate).setParameter("enddate", enddate);*/
			Query query = entityManager
			.createQuery("SELECT e FROM LmsEventLog e WHERE e.eventTime BETWEEN :startdate and :enddate")
			.setParameter("startdate", startdate).setParameter("enddate", enddate);

			List<LmsEventLog> listLmsEventLog =  query.getResultList();

			return listLmsEventLog;

		} catch (Exception ex) {
			return null;
		}
	}
	
}
