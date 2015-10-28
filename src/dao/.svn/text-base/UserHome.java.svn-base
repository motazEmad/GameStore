package dao;

// Generated Feb 19, 2013 6:50:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import dto.Game;
import dto.User;

/**
 * Home object for domain model class User.
 * @see dao.User
 * @author Hibernate Tools
 */
public class UserHome {

	private static final Log log = LogFactory.getLog(UserHome.class);

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

//	public void beginTransaction(){
//		sessionFactory.getCurrentSession().beginTransaction();
//	}
//	
//	public void commitTransaction(){
//		sessionFactory.getCurrentSession().getTransaction().commit();
//	}
	
	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) sessionFactory.getCurrentSession().get(
					"dto.User", id);
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
	
	public User findByEmail(String email) {
		try {
			 User instance = (User) sessionFactory.getCurrentSession()
					.createCriteria(User.class)
					.add(Restrictions.eq("email", email)).uniqueResult();
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
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dto.User").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public User findToLogin(User user) {
		String query = "from User user where user.email= ? and user.password = ?";
		return (User) sessionFactory.getCurrentSession().createQuery(query)
				.setParameter(0, user.getEmail())
				.setParameter(1, user.getPassword()).uniqueResult();

	}
	public float updateCredit(float value,String Email)
	{
		
		String query="select credit from User user where user.email = ?";
		Query currentCreditQuery=sessionFactory.getCurrentSession().createQuery(query);
		currentCreditQuery.setParameter(0, Email);//("userEmail",Email);
		float currentCredit=(float)currentCreditQuery.list().get(0);
		float updatedCredit=currentCredit+value;
		query = "update User set credit = :newCredit where email = :userEmail";
		Query updatedCreditQuery=sessionFactory.getCurrentSession().createQuery(query).setString("userEmail",Email).setFloat("newCredit",updatedCredit);
		int x=updatedCreditQuery.executeUpdate();
		System.out.println("Number of records = "+x);
		query="select credit from User where email = :userEmail";
		
		
		Query afterUpdate=sessionFactory.getCurrentSession().createQuery(query).setString("userEmail",Email);
		float currentValue=(float)afterUpdate.list().get(0);
		return currentValue;
	}
	public List getAllUsers()
	{
		String query = "from User u where u.type = ?";
		Query currentusers=sessionFactory.getCurrentSession().createQuery(query).setParameter(0, User.USER_TYPE);
		List usersList=currentusers.list();
		
		return usersList;
	}
}
