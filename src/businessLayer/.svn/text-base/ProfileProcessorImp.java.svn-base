package businessLayer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CartHome;
import dao.UserHome;
import dto.Cart;
import dto.User;

class ProfileProcessorImp implements ProfileProcessor {

	UserHome home = new UserHome();
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public User login(User user) {
		Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
		user = home.findToLogin(user);
		return user;
	}

	@Override
	public boolean registerUser(User user) {
		sessionFactory.getCurrentSession().beginTransaction();
		CartHome carthome = new CartHome();

		Cart cart = new Cart();
		cart.setUser(user);
		
		user.setCredit(0f);
		home.persist(user);
//		sessionFactory.getCurrentSession().createSQLQuery("insert into game_store.cart values ( )")
		carthome.persist(cart);
		user.setCart(cart);
		
		sessionFactory.getCurrentSession().getTransaction().commit();
		return false;
	}

	@Override
	public void updateUser(User user) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		home.attachDirty(user);
		tx.commit();
	}
	@Override
	public List getAllUSers() {
		// TODO Auto-generated method stub
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		return home.getAllUsers();
		
	}
	
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		return home.findByEmail(email);
		
	}

}
