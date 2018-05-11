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

import com.web.lms.model.LmsAttachment;

/**
 * Home object for domain model class LmsAttachment.
 * @see com.web.lms.dao.LmsAttachment
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsAttachmentHome {

	private static final Log log = LogFactory.getLog(LmsAttachmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsAttachment transientInstance) {
		log.debug("persisting LmsAttachment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsAttachment persistentInstance) {
		log.debug("removing LmsAttachment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsAttachment merge(LmsAttachment detachedInstance) {
		log.debug("merging LmsAttachment instance");
		try {
			LmsAttachment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsAttachment findById(Integer id) {
		log.debug("getting LmsAttachment instance with id: " + id);
		try {
			LmsAttachment instance = entityManager.find(LmsAttachment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LmsAttachment> findByApplicationID(Integer applicationID){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e.filename FROM LmsAttachment e WHERE e.lmsLeaveApplication.id=:applicationID").setParameter("applicationID", applicationID);
			return (List<LmsAttachment>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}
