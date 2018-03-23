package com.web.lms.dao;
// com.web.lms.daoerated Mar 23, 2018 5:44:36 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsDepartment;

/**
 * Home object for domain model class LmsDepartment.
 * @see com.web.lms.dao.LmsDepartment
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
}
