package dao;

// Generated Feb 19, 2013 6:50:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import java.util.Set;

import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import dto.Cart;
import dto.CartGame;
import dto.Category;
import dto.Game;
import dto.User;

/**
 * Home object for domain model class Category.
 * @see dao.Category
 * @author Hibernate Tools
 */
public class CategoryHome {

	private static final Log log = LogFactory.getLog(CategoryHome.class);

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

	public void persist(Category transientInstance) {
		log.debug("persisting Category instance");
		try {
			sessionFactory.openSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			sessionFactory.openSession().getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	
	public void attachDirty(Category instance) {
		log.debug("attaching dirty Category instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Category instance) {
		log.debug("attaching clean Category instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = (Category) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Category findById(java.lang.Integer id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Category instance = (Category) sessionFactory.getCurrentSession()
					.get("dto.Category", id);
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

	public List findByExample(Category instance) {
		log.debug("finding Category instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dto.Category")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	public List getAllCategories()
	{
		
		log.debug("finding Category instance by example");
		try {
			List Categoryset = sessionFactory.getCurrentSession().createCriteria("dto.Category").list();
			log.debug("get all categories in db ");;
			return Categoryset;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
	}
		
	}
	public boolean isFound(String catName)
	{
		try {
			Category instance = (Category) sessionFactory.getCurrentSession()
					.createCriteria(Category.class)
					.add(Restrictions.eq("name", catName)).uniqueResult();
			if (instance == null) {
				log.debug("get successful, no instance found");
				return false;
			} else {
				log.debug("get successful, instance found");
				return true;
			}
		
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		
	}
	
	public Category getByName(String catName)
	{
		try {
			Category instance = (Category) sessionFactory.getCurrentSession()
					.createCriteria(Category.class)
					.add(Restrictions.eq("name", catName)).uniqueResult();
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
	
}
