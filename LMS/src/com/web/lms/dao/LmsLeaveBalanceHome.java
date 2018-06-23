package com.web.lms.dao;
// Generated Apr 24, 2018 4:15:02 PM by Hibernate Tools 5.2.8.Final

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.lms.model.LmsLeaveBalance;

/**
 * Home object for domain model class LmsLeaveBalance.
 * @see GEN.LmsLeaveBalance
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class LmsLeaveBalanceHome {

	private static final Log log = LogFactory.getLog(LmsLeaveBalanceHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsLeaveBalance transientInstance) {
		log.debug("persisting LmsLeaveBalance instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsLeaveBalance persistentInstance) {
		log.debug("removing LmsLeaveBalance instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsLeaveBalance merge(LmsLeaveBalance detachedInstance) {
		log.debug("merging LmsLeaveBalance instance");
		try {
			LmsLeaveBalance result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsLeaveBalance findById(Integer id) {
		log.debug("getting LmsLeaveBalance instance with id: " + id);
		try {
			LmsLeaveBalance instance = entityManager.find(LmsLeaveBalance.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<LmsLeaveBalance> findLeaveBalanceByUserID(Integer userid) {		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveBalance e WHERE e.lmsUser.id=:userid")
										.setParameter("userid", userid);
		
			List<LmsLeaveBalance> lmsLeaveBalances = query.getResultList();
		
			return lmsLeaveBalances;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public LmsLeaveBalance findLeaveCountbyUserAndLeaveType(Integer userid, Integer leaveTypeId, String acStatus ) {		
		try {
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveBalance e WHERE e.lmsUser.id=:userid AND e.lmsLeaveType.id=:leaveTypeId AND e.acstatus=:acStatus")
					.setParameter("userid", userid)
					.setParameter("leaveTypeId", leaveTypeId)
					.setParameter("acStatus", acStatus);
		
			LmsLeaveBalance lmsLeaveBalances = (LmsLeaveBalance) query.getSingleResult();
		
			return lmsLeaveBalances;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public LmsLeaveBalance findLeaveCountbyUserAndLeaveTypeAndYear(Integer userid, Integer leaveTypeId, String startyear, String endyear, String acStatus) {		
		try {
						
			String sDate= startyear +"-01-01 00:00:00";
			String eDate= endyear +"-12-31 23:59:59"; 
			
		    Date sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDate); 
		    Date edate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(eDate);			
			
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveBalance e WHERE e.lmsUser.id=:userid AND e.lmsLeaveType.id=:leaveTypeId AND e.year BETWEEN :stDate AND :edDate AND e.acstatus=:acStatus")
					.setParameter("userid", userid)
					.setParameter("leaveTypeId", leaveTypeId)
					.setParameter("stDate", sdate)
					.setParameter("edDate", edate)
					.setParameter("acStatus", acStatus);
		
			LmsLeaveBalance lmsLeaveBalance = (LmsLeaveBalance) query.getSingleResult();
		
			return lmsLeaveBalance;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public LmsLeaveBalance findLeavebalacebyUserAndLeaveTypeAndACStatus(Integer userid, Integer leaveTypeId, String acStatus) {		
		try {			
			
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveBalance e WHERE e.lmsUser.id=:userid AND e.lmsLeaveType.id=:leaveTypeId AND e.acstatus=:acStatus")
					.setParameter("userid", userid)
					.setParameter("leaveTypeId", leaveTypeId)
					.setParameter("acStatus", acStatus);
		
			LmsLeaveBalance lmsLeaveBalance = (LmsLeaveBalance) query.getSingleResult();
		
			return lmsLeaveBalance;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public List<LmsLeaveBalance> findLeavebalacebyUserAndACStatus(Integer userid, String acStatus) {		
		try {			
			
			Query query = entityManager.createQuery("SELECT e FROM LmsLeaveBalance e WHERE e.lmsUser.id=:userid AND e.acstatus=:acStatus")
					.setParameter("userid", userid)
					.setParameter("acStatus", acStatus);
		
			List<LmsLeaveBalance> lmsLeaveBalances = query.getResultList();
		
			return lmsLeaveBalances;		
		}
		catch(Exception ex) {			
			return null;			
		}
	}
	
	public long findSumOfLeaveTakenImpactOnEarnLeave(Integer userid) {		
		try {	
			
			// SELECT SUM(e.leave_taken) 
			// FROM lms_leave_balance e
			// JOIN lms_leave_type t ON e.leave_type_id = t.id
			// WHERE t.impact_on_earned_leave ='YES'
			// AND e.user_id=1;
			
			Query query = entityManager.createQuery("SELECT SUM(e.leaveTaken) FROM LmsLeaveBalance e WHERE e.lmsUser.id =:userid AND e.lmsLeaveType.impactOnEarnedLeave ='YES'")
										.setParameter("userid", userid);
		
			long sumleaveTaken = (long) query.getSingleResult();
		
			return sumleaveTaken;		
		}
		catch(Exception ex) {			
			return 0;			
		}
	}
}
