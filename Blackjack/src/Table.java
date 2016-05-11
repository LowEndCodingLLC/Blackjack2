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
	public void startGame(){
		player.add(drawPile.remove(0));
		player.add(drawPile.remove(0));
		dealer.add(drawPile.remove(0));
		dealer.add(drawPile.remove(0),false);
		player.setCanHit(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//paints default background
		player.paintHand(g);	

	}
	public void printStatus(){
		System.out.println("Deck size: "+drawPile.size());
		System.out.println("-------------------------");
		System.out.println("Player Hand:");
		player.print();
		System.out.println("Player score: "+player.getValue());
		System.out.println("-------------------------");
		System.out.println("Dealer Hand:");
		dealer.print();
		System.out.println("Dealer score: "+dealer.getValue());
		System.out.println("-------------------------");
	}
	public void determineWinner() {
		if (player.getValue()<=21&&dealer.getValue()<=21){		
			if (player.getValue()>dealer.getValue()){//player wins
				
			}
			else if(player.getValue()<dealer.getValue()){//dealer wins
				
			}
			else{//tie
				
			}
		}
		else if (player.getValue()<=21){//dealer bust,player wins
			
		}
		else{//player bust, dealer wins
			
		}
			
	}

}
