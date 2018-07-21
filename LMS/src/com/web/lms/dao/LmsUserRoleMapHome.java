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

import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsUserRoleMap;
import com.web.lms.model.LmsWftRoleUserMap;

/**
 * Home object for domain model class LmsUserRoleMap.
 * @see GEN.LmsUserRoleMap
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsUserRoleMapHome {

	private static final Log log = LogFactory.getLog(LmsUserRoleMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsUserRoleMap transientInstance) {
		log.debug("persisting LmsUserRoleMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsUserRoleMap persistentInstance) {
		log.debug("removing LmsUserRoleMap instance");
		try {
			persistentInstance = entityManager.merge(persistentInstance);
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsUserRoleMap merge(LmsUserRoleMap detachedInstance) {
		log.debug("merging LmsUserRoleMap instance");
		try {
			LmsUserRoleMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsUserRoleMap findById(Integer id) {
		log.debug("getting LmsUserRoleMap instance with id: " + id);
		try {
			LmsUserRoleMap instance = entityManager.find(LmsUserRoleMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
    public List<LmsUserRoleMap> findByUserID(Integer userid) {
		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsUserRoleMap e WHERE e.lmsUser.id =:userid")
					.setParameter("userid", userid);

			List<LmsUserRoleMap> listlmsUserRoleMap = query.getResultList();

			return listlmsUserRoleMap;
		} 
		catch (Exception ex) {
			return null;
		}
	}
    
    public LmsUserRoleMap findByRoleId(Integer roleid) {
		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsUserRoleMap e WHERE e.lmsRole.id =:roleid")
					.setParameter("roleid", roleid);

			LmsUserRoleMap lmsUserRoleMap = (LmsUserRoleMap)query.getSingleResult();

			return lmsUserRoleMap;
		} 
		catch (Exception ex) {
			return null;
		}
	}
    
	public List<LmsUserRoleMap> findRoleByUser(LmsUser user) {		
		try { 			
			Query query = entityManager.createQuery("SELECT e FROM LmsUserRoleMap e WHERE e.lmsUser=:user")
					.setParameter("user", user);
		
			List<LmsUserRoleMap> listLmsUserRoleMap =  query.getResultList();
		
			return listLmsUserRoleMap;
		}
		catch(Exception ex) {			
			return null;			
		}
	}
}
