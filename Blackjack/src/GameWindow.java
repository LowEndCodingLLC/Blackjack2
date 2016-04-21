import javax.swing.JFrame;


public class GameWindow extends JFrame{
	private Table table=new Table();
	public GameWindow(){
		setTitle("Blackjack");
		setBounds(0,0,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(table);
		setResizable(false);
		setVisible(true);
	}
}
