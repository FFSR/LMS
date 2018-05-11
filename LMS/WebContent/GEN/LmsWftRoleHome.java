package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsWftRole.
 * @see GEN.LmsWftRole
 * @author Hibernate Tools
 */
@Stateless
public class LmsWftRoleHome {

	private static final Log log = LogFactory.getLog(LmsWftRoleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRole transientInstance) {
		log.debug("persisting LmsWftRole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRole persistentInstance) {
		log.debug("removing LmsWftRole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRole merge(LmsWftRole detachedInstance) {
		log.debug("merging LmsWftRole instance");
		try {
			LmsWftRole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRole findById(Integer id) {
		log.debug("getting LmsWftRole instance with id: " + id);
		try {
			LmsWftRole instance = entityManager.find(LmsWftRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
