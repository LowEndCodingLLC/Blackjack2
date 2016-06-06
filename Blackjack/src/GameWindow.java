import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameWindow extends JFrame{
	private Dealer dealer;
	private GamePanel cardPanel;

	
	public GameWindow(Dealer dealer){
	
		
		this.dealer=dealer;	
		cardPanel= new GamePanel(dealer);
		setTitle("Blackjack");
		setBounds(0,0,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(cardPanel);
		setResizable(false);
		setVisible(true);
		//this.getContentPane().add(userPanel);
	}
	public GamePanel getGamePanel(){
		return cardPanel;
	}
	
	
}
