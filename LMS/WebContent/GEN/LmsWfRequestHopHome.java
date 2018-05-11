package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsWfRequestHop.
 * @see GEN.LmsWfRequestHop
 * @author Hibernate Tools
 */
@Stateless
public class LmsWfRequestHopHome {

	private static final Log log = LogFactory.getLog(LmsWfRequestHopHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWfRequestHop transientInstance) {
		log.debug("persisting LmsWfRequestHop instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWfRequestHop persistentInstance) {
		log.debug("removing LmsWfRequestHop instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWfRequestHop merge(LmsWfRequestHop detachedInstance) {
		log.debug("merging LmsWfRequestHop instance");
		try {
			LmsWfRequestHop result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWfRequestHop findById(Integer id) {
		log.debug("getting LmsWfRequestHop instance with id: " + id);
		try {
			LmsWfRequestHop instance = entityManager.find(LmsWfRequestHop.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
