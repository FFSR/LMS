package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsLeaveBalance.
 * @see GEN.LmsLeaveBalance
 * @author Hibernate Tools
 */
@Stateless
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
}
