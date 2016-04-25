import java.awt.Graphics;

import javax.swing.JPanel;


public class Table extends JPanel{
	private Deck deck=new Deck();
	public Table(){
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//paints default screen
		deck.get(0).paintCard(g);//paints card on top of default screen
		
	}
}
