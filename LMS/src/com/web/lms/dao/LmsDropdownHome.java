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

import com.web.lms.model.LmsDropdown;


/**
 * Home object for domain model class LmsDropdown.
 * @see com.web.lms.dao.LmsDropdown
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsDropdownHome {

	private static final Log log = LogFactory.getLog(LmsDropdownHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsDropdown transientInstance) {
		log.debug("persisting LmsDropdown instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsDropdown persistentInstance) {
		log.debug("removing LmsDropdown instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsDropdown merge(LmsDropdown detachedInstance) {
		log.debug("merging LmsDropdown instance");
		try {
			LmsDropdown result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsDropdown findById(Integer id) {
		log.debug("getting LmsDropdown instance with id: " + id);
		try {
			LmsDropdown instance = entityManager.find(LmsDropdown.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsDropdown> findByDropdownName(String dropdownName) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsDropdown e WHERE e.dropdown=:dropdownName and LOWER(e.status)='active' order by e.slno").setParameter("dropdownName", dropdownName);
			
			return (List<LmsDropdown>) query.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
