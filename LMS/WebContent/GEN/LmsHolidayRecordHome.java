package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsHolidayRecord.
 * @see GEN.LmsHolidayRecord
 * @author Hibernate Tools
 */
@Stateless
public class LmsHolidayRecordHome {

	private static final Log log = LogFactory.getLog(LmsHolidayRecordHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsHolidayRecord transientInstance) {
		log.debug("persisting LmsHolidayRecord instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsHolidayRecord persistentInstance) {
		log.debug("removing LmsHolidayRecord instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsHolidayRecord merge(LmsHolidayRecord detachedInstance) {
		log.debug("merging LmsHolidayRecord instance");
		try {
			LmsHolidayRecord result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsHolidayRecord findById(Integer id) {
		log.debug("getting LmsHolidayRecord instance with id: " + id);
		try {
			LmsHolidayRecord instance = entityManager.find(LmsHolidayRecord.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
