package dao;

// Generated Feb 19, 2013 6:50:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import dto.Cart;
import dto.CartGame;
import dto.User;

/**
 * Home object for domain model class CartGame.
 * @see dao.CartGame
 * @author Hibernate Tools
 */
public class CartGameHome {

	private static final Log log = LogFactory.getLog(CartGameHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();
 
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CartGame transientInstance) {
		log.debug("persisting CartGame instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CartGame instance) {
		log.debug("attaching dirty CartGame instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(CartGame instance) {
		log.debug("attaching clean CartGame instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CartGame persistentInstance) {
		log.debug("deleting CartGame instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CartGame merge(CartGame detachedInstance) {
		log.debug("merging CartGame instance");
		try {
			CartGame result = (CartGame) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CartGame findById(int id) {
		log.debug("getting CartGame instance with id: " + id);
		try {
			CartGame instance = (CartGame) sessionFactory.getCurrentSession()
					.get("dto.CartGame", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CartGame instance) {
		log.debug("finding CartGame instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dto.CartGame")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<CartGame> findbyCart(Cart cart) {
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dto.CartGame")
					.add(Restrictions.eq("cart", cart)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
