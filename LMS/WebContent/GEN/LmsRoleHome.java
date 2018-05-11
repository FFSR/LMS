package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsRole.
 * @see GEN.LmsRole
 * @author Hibernate Tools
 */
@Stateless
public class LmsRoleHome {

	private static final Log log = LogFactory.getLog(LmsRoleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsRole transientInstance) {
		log.debug("persisting LmsRole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsRole persistentInstance) {
		log.debug("removing LmsRole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsRole merge(LmsRole detachedInstance) {
		log.debug("merging LmsRole instance");
		try {
			LmsRole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsRole findById(Integer id) {
		log.debug("getting LmsRole instance with id: " + id);
		try {
			LmsRole instance = entityManager.find(LmsRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
