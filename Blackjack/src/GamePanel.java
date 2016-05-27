import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private Dealer dealer;


	public GamePanel(){
		
		this.setBackground(Color.green);
		this.setVisible(true);
	}
	public void attachDealer(Dealer dealer){
		this.dealer=dealer;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//paints default background
		dealer.getHand().paintHand(g);
		dealer.getUser().getHand().paintHand(g);

	}

}