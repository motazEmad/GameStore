package businessLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CartGameHome;
import dao.GameHome;
import dao.OrderHome;
import dto.CartGame;
import dto.Game;
import dto.Order;
import dto.User;

class GamesProcessorImp implements GamesProcessor {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private GameHome gameHome = new GameHome();
	
	@Override
	public Game getGame(Game game) {
		sessionFactory.getCurrentSession().beginTransaction();
		return gameHome.findByName(game.getName());
	}

	@Override
	public List<Game> getSimilarGames(Game game, int limit) {
		sessionFactory.getCurrentSession().beginTransaction();
		if(game == null)
			return new ArrayList<Game>();
		game = gameHome.findById(game.getId());
		return gameHome.findSimilarGames(game, limit);
	}
	
	@Override
	public byte[] getImage(String gameName) {
		sessionFactory.getCurrentSession().beginTransaction();
		List list =gameHome.getImage(gameName);
		if(list.isEmpty())
			return null;
		return (byte [])list.get(0) ;
	}
	
	@Override
	public List getGamesByCategory(int id) {
		sessionFactory.getCurrentSession().beginTransaction();
		return gameHome.getGamesByCategory(id);
	}

	@Override
	public Game getGameByName(String gname) {
		sessionFactory.getCurrentSession().beginTransaction();
		Game game=gameHome.findByName(gname);
		return game;
	}
	@Override
	public boolean gameAvailability(Game game, int quantity) {
		if(game.getQuantity()>=quantity)
		{
			
			return true;
		}
	
			return false;
	}

	@Override
	public boolean isEnough(User user, Game game) {
		if(user.getCredit()<game.getPrice())
		{
			return false;
		}
		else
		{
		    //return (int) (user.getCredit()-game.getPrice());
			return true;
		}
	}
	
	@Override
	public float newUserCredit(User user, Game game, int quantity) {
		user.setCredit(user.getCredit()-game.getPrice()*quantity);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return (user.getCredit());
	}
	
	 @Override
	public void quantityDeduction(Game game, int quantity) {
		 game.setQuantity(game.getQuantity() - quantity);
			sessionFactory.getCurrentSession().saveOrUpdate(game);
		
	}
	@Override
	public void addGame(Game game) {
		sessionFactory.getCurrentSession().getTransaction().begin();
		gameHome.persist(game);
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void deleteGame(Game game) {
		sessionFactory.getCurrentSession().getTransaction().begin();
		gameHome.delete(game);
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
	@Override
	public void editGame(Game game, float price, int quantity) {
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		game.setPrice(price);
		game.setQuantity(quantity);
		sessionFactory.getCurrentSession().saveOrUpdate(game);
		tx.commit();
	}
	
	@Override
	public List<Game> getBestGames() {
		sessionFactory.getCurrentSession().beginTransaction();
		return gameHome.getBestGames(2, 3, 4);
	}
	
	@Override
	public void buy(CartGame cartGame, boolean isNewCartGame) throws DmException {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		if(!isEnough(cartGame.getCart().getUser(), cartGame.getGame()))
			throw new DmException("Your Credit is not enough to buy this game .. Please recharge and try again");
		if(!gameAvailability(cartGame.getGame(), cartGame.getQuantity()))
			throw new DmException("This Game Is Not Available Now");
		quantityDeduction(cartGame.getGame(), cartGame.getQuantity());
		newUserCredit(cartGame.getCart().getUser(), cartGame.getGame(), cartGame.getQuantity());
		if(!isNewCartGame)
			new CartGameHome().delete(cartGame);
		
		new OrderHome().persist(new Order(cartGame.getCart().getUser(),
				cartGame.getGame(), cartGame.getQuantity(), new Date()));
		
		tx.commit();
	}

	@Override
	public List<Order> getOrders() {
		OrderHome orderHome = new OrderHome();
		sessionFactory.getCurrentSession().beginTransaction();
		return orderHome.findAll();
	}
	
}
