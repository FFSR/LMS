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

import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftFlowControl;

import freemarker.core.ReturnInstruction.Return;

/**
 * Home object for domain model class LmsWfRequestHop.
 * @see GEN.LmsWfRequestHop
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWfRequestHopHome {

	private static final Log log = LogFactory.getLog(LmsWfRequestHopHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWfRequestHop transientInstance) {
		log.debug("persisting LmsWfRequestHop instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWfRequestHop persistentInstance) {
		log.debug("removing LmsWfRequestHop instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWfRequestHop merge(LmsWfRequestHop detachedInstance) {
		log.debug("merging LmsWfRequestHop instance");
		try {
			LmsWfRequestHop result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWfRequestHop findById(Integer id) {
		log.debug("getting LmsWfRequestHop instance with id: " + id);
		try {
			LmsWfRequestHop instance = entityManager.find(LmsWfRequestHop.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<LmsWfRequestHop> findWfRequestHopByRequestIdAndRequestHopId(Integer wfRequestId, Integer wftRequestHopRolePageMapid) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsWfRequestHop e WHERE e.lmsWfRequest.id=:wfRequestId AND e.lmsWftRequestHopRolePageMap.id=:wftRequestHopRolePageMapid")
					.setParameter("wfRequestId", wfRequestId)
					.setParameter("wftRequestHopRolePageMapid", wftRequestHopRolePageMapid);
		
			List<LmsWfRequestHop> lmsWfRequestHops =  query.getResultList();
		
			return lmsWfRequestHops;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public List<LmsWfRequestHop> findWfRequestHopByRequestId(Integer wfRequestId) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsWfRequestHop e WHERE e.lmsWfRequest.id=:wfRequestId")
					.setParameter("wfRequestId", wfRequestId);
		
			List<LmsWfRequestHop> lmsWfRequestHops =  query.getResultList();
		
			return lmsWfRequestHops;
		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public List<LmsWfRequestHop> findByRoleMapAndStatus(String status, Integer wftRole){
		Query query;
		
		try {
			query = entityManager.createQuery("SELECT e FROM LmsWfRequestHop e WHERE e.wftRoleId=:wftRole AND e.status=:status");
			query.setParameter("wftRole", wftRole);
			query.setParameter("status", status);
			
			return (List<LmsWfRequestHop>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
