package dto;

// Generated Feb 22, 2013 7:43:53 PM by Hibernate Tools 3.4.0.CR1

/**
 * CartGame generated by hbm2java
 */
public class CartGame implements java.io.Serializable {

	private Integer id;
	private Game game;
	private Cart cart;
	private int quantity;

	public CartGame() {
	}

	public CartGame(int id, Game game, Cart cart, int quantity) {
		this.id = id;
		this.game = game;
		this.cart = cart;
		this.quantity = quantity;
	}
	
	public CartGame(Game game, Cart cart, int quantity) {
		this.game = game;
		this.cart = cart;
		this.quantity = quantity;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CartGame) {
			return getCart().equals(((CartGame) obj).getCart()) 
					&& getGame().equals(((CartGame) obj).getGame());
		}
		return super.equals(obj);
	}

}