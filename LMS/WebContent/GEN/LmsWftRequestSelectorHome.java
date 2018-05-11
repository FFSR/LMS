package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsWftRequestSelector.
 * @see GEN.LmsWftRequestSelector
 * @author Hibernate Tools
 */
@Stateless
public class LmsWftRequestSelectorHome {

	private static final Log log = LogFactory.getLog(LmsWftRequestSelectorHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRequestSelector transientInstance) {
		log.debug("persisting LmsWftRequestSelector instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRequestSelector persistentInstance) {
		log.debug("removing LmsWftRequestSelector instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRequestSelector merge(LmsWftRequestSelector detachedInstance) {
		log.debug("merging LmsWftRequestSelector instance");
		try {
			LmsWftRequestSelector result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRequestSelector findById(Integer id) {
		log.debug("getting LmsWftRequestSelector instance with id: " + id);
		try {
			LmsWftRequestSelector instance = entityManager.find(LmsWftRequestSelector.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
