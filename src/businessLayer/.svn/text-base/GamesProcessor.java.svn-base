package businessLayer;

import java.util.List;

import dto.CartGame;
import dto.Game;
import dto.Order;
import dto.User;


public interface GamesProcessor {
	

    void addGame (Game game);
 
    void deleteGame (Game game);

 	void editGame(Game game,float price,int quantity);
 	
    Game getGame(Game game);
	
	List<Game> getSimilarGames(Game game, int limit);
	
	byte [] getImage(String imageName);
	
	List getGamesByCategory(int id);
	
	Game getGameByName(String gname);
	
	boolean gameAvailability(Game game, int quantity);
	
	boolean isEnough(User user,Game game);
	
	float newUserCredit(User user,Game game, int quantity);
	
	void quantityDeduction(Game game, int quantity);

	public List<Game> getBestGames();

	void buy(CartGame cartGame, boolean isNewCartGame) throws DmException;
	
	List<Order> getOrders();

}
