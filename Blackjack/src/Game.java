
public class Game {
	private Dealer dealer=new Dealer();
	private GameWindow window = new GameWindow();
	
	public Game(){
		window.getUserPanel().attachUser(dealer.getUser());
		window.getGamePanel().attachDealer(dealer);
	}
	public static void main(String[] args){
		new Game();
	}
}
