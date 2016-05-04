import javax.swing.JPanel;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	GameWindow window=new GameWindow();
	JPanel playerPanel=new JPanel();
	
		
		Deck deck =new Deck();
		Deck Hand =new Hand();
		deck.printDeck();
	}

}
