import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameWindow extends JFrame{

	public GameWindow(){
		setTitle("Blackjack");
		setBounds(0,0,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
}
