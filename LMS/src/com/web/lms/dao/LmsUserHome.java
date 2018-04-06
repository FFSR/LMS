package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsUser;

/**
 * Home object for domain model class LmsUser.
 * 
 * @see com.web.lms.dao.LmsUser
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsUserHome {

	private static final Log log = LogFactory.getLog(LmsUserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public int persist(LmsUser transientInstance) {
		log.debug("persisting LmsUser instance");
		try {
			entityManager.persist(transientInstance);
			entityManager.flush();
			int lmsuserId = transientInstance.getId();
			log.debug("persist successful");
			return lmsuserId;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsUser persistentInstance) {
		log.debug("removing LmsUser instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsUser merge(LmsUser detachedInstance) {
		log.debug("merging LmsUser instance");
		try {
			LmsUser result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsUser findById(Integer id) {
		log.debug("getting LmsUser instance with id: " + id);
		try {
			LmsUser instance = entityManager.find(LmsUser.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public LmsUser findByUnameandPassword(String uName, String password) {

		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsUser e WHERE e.name=:uName AND e.password=:password")
					.setParameter("uName", uName).setParameter("password", password);

			LmsUser lmsUser = (LmsUser) query.getSingleResult();

			return lmsUser;

		} catch (Exception ex) {

			return null;

		}

	}

	public LmsUser findByEmailID(String emailid) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsUser e WHERE e.email=:emailid").setParameter("emailid", emailid);
		
			LmsUser lmsUser = (LmsUser) query.getSingleResult();
		
			return lmsUser;
		
		}
		catch(Exception ex) {
			
			return null;
			
		}
	}
	
public List<LmsUser> findUserByUserID(Integer userid) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsUser e WHERE e.id=:userid").setParameter("userid", userid);
		
			List<LmsUser> lmsUser = query.getResultList();
		
			return lmsUser;
		
		}
		catch(Exception ex) {
			
			return null;
			
		}
	}
		
}
