package businessLayer;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CartGameHome;
import dao.CartHome;
import dto.Cart;
import dto.CartGame;
import dto.User;

class CartProcessorImp implements CartProcessor {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	CartHome carthome = new CartHome();
	CartGameHome cartGameHome = new CartGameHome();
	
	@Override
	public Cart getCart(User user) {
		sessionFactory.getCurrentSession().beginTransaction();
		return carthome.findByExample(user);
	}
	
	@Override
	public void save(Cart cart) {
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		carthome.attachDirty(cart);
		for (Iterator<CartGame> iterator = cart.getCartGames().iterator(); iterator.hasNext();) {
			CartGame cartGame = (CartGame) iterator.next();
			cartGameHome.attachDirty(cartGame);
		}
		transaction.commit();
	}
	
	@Override
	public void save(CartGame cartGame) {
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		Cart cart = cartGame.getCart();
		cartGameHome.attachDirty(cartGame);
//		sessionFactory.getCurrentSession().refresh(cart);
		transaction.commit();
	}
	
	@Override
	public void delete(CartGame cartGame) {
		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
		Cart cart = cartGame.getCart();
		cartGameHome.delete(cartGame);
//		sessionFactory.getCurrentSession().refresh(cart);
		transaction.commit();
	}
	
	
	@Override
	public List<CartGame> getGamesInCart(Cart cart) {
		sessionFactory.getCurrentSession().beginTransaction();
		return cartGameHome.findbyCart(cart);
	}
}
