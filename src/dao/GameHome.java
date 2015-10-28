package dao;

// Generated Feb 19, 2013 6:50:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
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

/**
 * Home object for domain model class Game.
 * @see dao.Game
 * @author Hibernate Tools
 */
public class GameHome {

	private static final Log log = LogFactory.getLog(GameHome.class);

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

	public void persist(Game transientInstance) {
		log.debug("persisting Game instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Game instance) {
		log.debug("attaching dirty Game instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Game instance) {
		log.debug("attaching clean Game instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Game persistentInstance) {
		log.debug("deleting Game instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Game merge(Game detachedInstance) {
		log.debug("merging Game instance");
		try {
			Game result = (Game) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Game findById(java.lang.Integer id) {
		log.debug("getting Game instance with id: " + id);
		try {
			Game instance = (Game) sessionFactory.getCurrentSession().get(
					"dto.Game", id);
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
	
	public Game findByName(String name) {
		try {
			Game instance = (Game) sessionFactory.getCurrentSession()
					.createCriteria(Game.class)
					.add(Restrictions.eq("name", name)).uniqueResult();
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

	public List findByExample(Game instance) {
		log.debug("finding Game instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("dto.Game").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findSimilarGames(Game game, int limit) {
		if(game == null)
			return new ArrayList();
		String query = "from Game game where game.category = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(query)
				.setParameter(0, game.getCategory()).setMaxResults(limit);
		return q.list();
	}
	public List getImage(String gameName)
	{
		 String queryString="select image from Game  where name like :gname";
	      
	      Query q=sessionFactory.getCurrentSession().createQuery(queryString).setString("gname", gameName);
	      return q.list();
	     
	     
	}
	public List getGamesByCategory(int id)
	{
		 final String queryString="from Game where category.id = :Game_ID";
		
		 Query q=sessionFactory.getCurrentSession().createQuery(queryString).setInteger("Game_ID",id);
		 return q.list();
	}
	
	
	
	public List getBestGames(int... i) {
		String query = "from Game where id in (";
		for (int j = 0; j < i.length; j++) {
			query += i[j];
			if(j == i.length - 1)
				query += ")";
			else
				query += ",";
		}
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	
	/*public Game getGameByName(String gameName)
	{
		 String queryString="from Game  where name like :gname";
		 Query q=sessionFactory.getCurrentSession().createQuery(queryString).setString("gname", gameName);
		 List returned=q.list();
		 Game returnedGame =(Game)returned.get(0);
		 return returnedGame;
	}*/
	
	public List getGames()
	{
		 String queryString="from Game  ";
		 Query q=sessionFactory.getCurrentSession().createQuery(queryString);
		 List returned=q.list();
		 return returned;
	}
	
	public List getCategories()
	{
		 String queryString="from category ";
		 Query q=sessionFactory.getCurrentSession().createQuery(queryString);
		 List returned=q.list();
		 return returned;
	}

	public Game getGameByName(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
}
