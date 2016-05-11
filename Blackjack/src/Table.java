import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Table extends JPanel{

	private Deck drawPile=new Deck(this);
	private DealerHand dealer=new DealerHand(this);
	private Hand player=new Hand(this);

	public Table(){
		this.setVisible(true);
		this.setBackground(Color.green);
	}
	public Deck getDrawPile(){
		return drawPile;
	}
	public DealerHand getDealer(){
		return dealer;
	}
	public Hand getPlayer(){
		return player;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//paints default background
		drawPile.get(0).paintCard(g);//paints card on top of default background	
	}
}