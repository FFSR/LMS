package GEN;
// Generated May 11, 2018 9:34:58 PM by Hibernate Tools 5.2.8.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LmsAttachment.
 * @see GEN.LmsAttachment
 * @author Hibernate Tools
 */
@Stateless
public class LmsAttachmentHome {

	private static final Log log = LogFactory.getLog(LmsAttachmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LmsAttachment transientInstance) {
		log.debug("persisting LmsAttachment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LmsAttachment persistentInstance) {
		log.debug("removing LmsAttachment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LmsAttachment merge(LmsAttachment detachedInstance) {
		log.debug("merging LmsAttachment instance");
		try {
			LmsAttachment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LmsAttachment findById(Integer id) {
		log.debug("getting LmsAttachment instance with id: " + id);
		try {
			LmsAttachment instance = entityManager.find(LmsAttachment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
