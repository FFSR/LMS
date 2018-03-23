package GEN;
// Generated Mar 23, 2018 5:31:25 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsTmplWfFlowControl.
 * @see GEN.LmsTmplWfFlowControl
 * @author Hibernate Tools
 */
@Stateless
public class LmsTmplWfFlowControlHome {

	private static final Log log = LogFactory.getLog(LmsTmplWfFlowControlHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsTmplWfFlowControl transientInstance) {
		log.debug("persisting LmsTmplWfFlowControl instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsTmplWfFlowControl persistentInstance) {
		log.debug("removing LmsTmplWfFlowControl instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsTmplWfFlowControl merge(LmsTmplWfFlowControl detachedInstance) {
		log.debug("merging LmsTmplWfFlowControl instance");
		try {
			LmsTmplWfFlowControl result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsTmplWfFlowControl findById(Integer id) {
		log.debug("getting LmsTmplWfFlowControl instance with id: " + id);
		try {
			LmsTmplWfFlowControl instance = entityManager.find(LmsTmplWfFlowControl.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
