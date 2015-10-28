package dao;

// Generated Feb 19, 2013 6:50:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dto.Cart;
import dto.User;

public class CartHome {

	private static final Log log = LogFactory.getLog(CartHome.class);

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

	public void persist(Cart transientInstance) {
		log.debug("persisting Cart instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cart instance) {
		log.debug("attaching dirty Cart instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cart instance) {
		log.debug("attaching clean Cart instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cart persistentInstance) {
		log.debug("deleting Cart instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cart merge(Cart detachedInstance) {
		log.debug("merging Cart instance");
		try {
			Cart result = (Cart) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cart findById(java.lang.Integer id) {
		log.debug("getting Cart instance with id: " + id);
		try {
			Cart instance = (Cart) sessionFactory.getCurrentSession().get(
					"dto.Cart", id);
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

	public Cart findByExample(User user) {
		log.debug("finding CartGame instance by example for each user ");
		try {
			Cart cart = (Cart) sessionFactory.getCurrentSession()
					.createCriteria(Cart.class)
					.createAlias("user", "user")
					.add(Restrictions.eq("user.email", user.getEmail())).uniqueResult();
			log.debug("get user cart succesfully");
			return cart;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByExample(Cart instance) {
		log.debug("finding Cart instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dto.Cart").add(Example.create(instance))
					.addOrder(Order.desc("name"))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public int getCartItemsCount(User user) {
		int count = 0;
		String query = "select count(games) from Cart c join c.cartGames games where c.user.id=?";
		List list = sessionFactory.getCurrentSession().createQuery(query)
				.setParameter(0, user.getId()).list();
		if (!list.isEmpty())
			count = (int) list.get(0);
		return count;
	}
}
