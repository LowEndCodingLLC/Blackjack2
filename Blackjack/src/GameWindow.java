import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameWindow extends JFrame{
	private GamePanel cardPanel = new GamePanel();
	private UserPanel userPanel = new UserPanel(cardPanel);
	
	public GameWindow(){
		setTitle("Blackjack");
		setBounds(0,0,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(cardPanel);
		setResizable(false);
		setVisible(true);
		this.getContentPane().add(userPanel);
	}
	public GamePanel getGamePanel(){
		return cardPanel;
	}
	public UserPanel getUserPanel(){
		return userPanel;
	}
	
}
