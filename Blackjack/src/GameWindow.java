import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameWindow extends JFrame{
	
	private Table table=new Table(this);
	private playerPanel player = new playerPanel(table);
	public GameWindow(){
		setTitle("Blackjack");
		setBounds(0,0,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(table);
		setResizable(false);
		setVisible(true);
		this.getContentPane().add(player);
	}
	public Table getTable(){
		return table;
	}
	public playerPanel getPlayerPanel(){
		return player;
	}
	
}
