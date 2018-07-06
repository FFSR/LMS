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
import com.web.lms.model.LmsLeaveType;
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
			/*Query query = entityManager
					.createQuery("SELECT e FROM LmsUser e WHERE e.name=:uName AND e.password=:password")
					.setParameter("uName", uName).setParameter("password", password);*/
			// Updated by Feroj on 28th June,2018 to log in  with email id and password
			Query query = entityManager
			.createQuery("SELECT e FROM LmsUser e WHERE SUBSTRING_INDEX(e.email,'@',1)=:uName AND e.password=:password")
			.setParameter("uName", uName).setParameter("password", password);

			LmsUser lmsUser = (LmsUser) query.getSingleResult();

			return lmsUser;
		} 
		catch (Exception ex) {
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
	
	@SuppressWarnings("unchecked")
	public List<LmsUser> findAllUser() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsUser e WHERE LOWER(e.status)='active'");
			
			return (List<LmsUser>) query.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();			
			return null;
		}
	}
	
	public List<LmsUser> findAllUserConditional(String status) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsUser e WHERE LOWER(e.status) =:status")
										.setParameter("status", status.toLowerCase());
			
			List<LmsUser> lmsUsers =  query.getResultList();
			 return lmsUsers;
		}
		catch(Exception ex) {
			ex.printStackTrace();			
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
	 
    
  //public List<LmsUser> findByUnameandMobile(String uName, String mobile, String status) {
      public LmsUser findByUnameandMobile(String uName, String mobile, String status) {
		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsUser e WHERE lower(e.name) like :uName OR lower(e.mobilePersonal) like :mobile OR lower(e.mobileOffice) like :mobile OR e.status =:status")
					.setParameter("uName","%"+ uName +"%")
					.setParameter("mobile", "%"+ mobile +"%")					
					.setParameter("status", status);

	//	List<LmsUser> lmsUser = query.getResultList();
		LmsUser lmsUser = (LmsUser) query.getSingleResult();

			return lmsUser;
		} 
		catch (Exception ex) {
			return null;
		}
	}
      
    public List<LmsUser> findByUnameandMobileList(String uName, String mobile, String status) {
    //  public LmsUser findByUnameandMobile(String uName, String mobile, String status) {
		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsUser e WHERE lower(e.name) like :uName OR lower(e.phone) like :mobile OR lower(e.mobilePersonal) like :mobile OR lower(e.mobileOffice) like :mobile OR e.status =:status")
					.setParameter("uName","%"+ uName +"%")
					.setParameter("mobile", "%"+ mobile +"%")					
					.setParameter("status", status);

			List<LmsUser> lmsUser = query.getResultList();
		
			//LmsUser lmsUser = (LmsUser) query.getSingleResult();

			return lmsUser;
		} 
		catch (Exception ex) {
			return null;
		}
	}
    
    public LmsUser findByUserIDandPassword(String userid, String password) {

		try {
			Query query = entityManager
					.createQuery("SELECT e FROM LmsUser e WHERE e.id=:userid AND e.password=:password")
					.setParameter("userid", userid).setParameter("password", password);

			LmsUser lmsUser = (LmsUser) query.getSingleResult();

			return lmsUser;
		} 
		catch (Exception ex) {
			return null;
		}
	}
    
    public LmsUser findByNID(String nid) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsUser e WHERE e.nid=:nid").setParameter("nid", nid);
		
			LmsUser lmsUser = (LmsUser) query.getSingleResult();
		
			return lmsUser;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
    
  public List<LmsUser> findSupervisorID(Integer userid) {
		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsUser e WHERE e.lmsUser.id=:id").setParameter("id", userid);
		
			List<LmsUser> lmsUser = query.getResultList();
		
			return lmsUser;		
		}
		catch(Exception ex) {			
			return null;			
		}
	
    }
    
    
		
}
