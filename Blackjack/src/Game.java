
public class Game {
	private Dealer thedealer=new Dealer();
	private GameWindow window = new GameWindow(thedealer);
	
	public Game(){
		
	}
	public static void main(String[] args){
		new Game();
	}
}
