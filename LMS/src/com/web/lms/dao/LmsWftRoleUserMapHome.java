package com.web.lms.dao;
// Generated Apr 28, 2018 3:31:02 PM by Hibernate Tools 5.2.8.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWftRequestSelector;
import com.web.lms.model.LmsWftRoleUserMap;

/**
 * Home object for domain model class LmsWftRoleUserMap.
 * @see GEN.LmsWftRoleUserMap
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsWftRoleUserMapHome {

	private static final Log log = LogFactory.getLog(LmsWftRoleUserMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRoleUserMap transientInstance) {
		log.debug("persisting LmsWftRoleUserMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRoleUserMap persistentInstance) {
		log.debug("removing LmsWftRoleUserMap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRoleUserMap merge(LmsWftRoleUserMap detachedInstance) {
		log.debug("merging LmsWftRoleUserMap instance");
		try {
			LmsWftRoleUserMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRoleUserMap findById(Integer id) {
		log.debug("getting LmsWftRoleUserMap instance with id: " + id);
		try {
			LmsWftRoleUserMap instance = entityManager.find(LmsWftRoleUserMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsWftRoleUserMap> findByUserID(Integer userID ) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsWftRoleUserMap e WHERE e.lmsUser.id=:userID").setParameter("userID", userID);
			
			return (List<LmsWftRoleUserMap>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsWftRoleUserMap> findDelegationByUser(Integer userID ) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsWftRoleUserMap e WHERE e.delegateBy=:userID").setParameter("userID", userID);
			
			return (List<LmsWftRoleUserMap>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	public List<LmsWftRoleUserMap> findRoleByUser(LmsUser user) {		
		try { 			
			Query query = entityManager.createQuery("SELECT e FROM LmsWftRoleUserMap e WHERE e.lmsUser=:user")
					.setParameter("user", user);
		
			List<LmsWftRoleUserMap> listLmsWftRoleUserMap =  query.getResultList();
		
			return listLmsWftRoleUserMap;
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public List<LmsWftRoleUserMap> findRoleByDelegateUser(Integer delegateBy ) {		
		try { 			
			Query query = entityManager.createQuery("SELECT e FROM LmsWftRoleUserMap e WHERE e.delegateBy=:delegateBy")
					.setParameter("delegateBy", delegateBy);
		
			List<LmsWftRoleUserMap> listLmsWftRoleUserMap =  query.getResultList();
		
			return listLmsWftRoleUserMap;
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public List<LmsWftRoleUserMap> findByUserIDAndDelegateID(Integer userID, Integer delegateBy) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM LmsWftRoleUserMap e WHERE e.lmsUser.id=:userID AND e.delegateBy=:delegateBy")
					.setParameter("userID", userID)
					.setParameter("delegateBy", delegateBy);
			
			return (List<LmsWftRoleUserMap>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}
