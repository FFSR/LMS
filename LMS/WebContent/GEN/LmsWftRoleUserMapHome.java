package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsWftRoleUserMap.
 * @see GEN.LmsWftRoleUserMap
 * @author Hibernate Tools
 */
@Stateless
public class LmsWftRoleUserMapHome {

	private static final Log log = LogFactory.getLog(LmsWftRoleUserMapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsWftRoleUserMap transientInstance) {
		log.debug("persisting LmsWftRoleUserMap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsWftRoleUserMap persistentInstance) {
		log.debug("removing LmsWftRoleUserMap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsWftRoleUserMap merge(LmsWftRoleUserMap detachedInstance) {
		log.debug("merging LmsWftRoleUserMap instance");
		try {
			LmsWftRoleUserMap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsWftRoleUserMap findById(Integer id) {
		log.debug("getting LmsWftRoleUserMap instance with id: " + id);
		try {
			LmsWftRoleUserMap instance = entityManager.find(LmsWftRoleUserMap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
