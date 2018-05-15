package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsUser.
 * @see GEN.LmsUser
 * @author Hibernate Tools
 */
@Stateless
public class LmsUserHome {

	private static final Log log = LogFactory.getLog(LmsUserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsUser transientInstance) {
		log.debug("persisting LmsUser instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
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
}
