package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsOfficeLocation.
 * @see GEN.LmsOfficeLocation
 * @author Hibernate Tools
 */
@Stateless
public class LmsOfficeLocationHome {

	private static final Log log = LogFactory.getLog(LmsOfficeLocationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsOfficeLocation transientInstance) {
		log.debug("persisting LmsOfficeLocation instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsOfficeLocation persistentInstance) {
		log.debug("removing LmsOfficeLocation instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsOfficeLocation merge(LmsOfficeLocation detachedInstance) {
		log.debug("merging LmsOfficeLocation instance");
		try {
			LmsOfficeLocation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsOfficeLocation findById(Integer id) {
		log.debug("getting LmsOfficeLocation instance with id: " + id);
		try {
			LmsOfficeLocation instance = entityManager.find(LmsOfficeLocation.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
