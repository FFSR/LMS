package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsClass.
 * @see GEN.LmsClass
 * @author Hibernate Tools
 */
@Stateless
public class LmsClassHome {

	private static final Log log = LogFactory.getLog(LmsClassHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsClass transientInstance) {
		log.debug("persisting LmsClass instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsClass persistentInstance) {
		log.debug("removing LmsClass instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsClass merge(LmsClass detachedInstance) {
		log.debug("merging LmsClass instance");
		try {
			LmsClass result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsClass findById(Integer id) {
		log.debug("getting LmsClass instance with id: " + id);
		try {
			LmsClass instance = entityManager.find(LmsClass.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
