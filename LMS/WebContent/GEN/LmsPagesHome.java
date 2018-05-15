package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsPages.
 * @see GEN.LmsPages
 * @author Hibernate Tools
 */
@Stateless
public class LmsPagesHome {

	private static final Log log = LogFactory.getLog(LmsPagesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsPages transientInstance) {
		log.debug("persisting LmsPages instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsPages persistentInstance) {
		log.debug("removing LmsPages instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsPages merge(LmsPages detachedInstance) {
		log.debug("merging LmsPages instance");
		try {
			LmsPages result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsPages findById(Integer id) {
		log.debug("getting LmsPages instance with id: " + id);
		try {
			LmsPages instance = entityManager.find(LmsPages.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
