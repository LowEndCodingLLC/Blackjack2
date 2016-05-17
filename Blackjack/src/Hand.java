import java.awt.Graphics;
import java.util.ArrayList;


public class Hand extends ArrayList<Card>{
	private Deck drawPile;
	private Table table;
	private DealerHand dealer;
	private boolean canHit=false;
	public Hand(Table table){
		this.table=table;
		this.drawPile=table.getDrawPile();
		this.dealer=table.getDealer();
	}
	public boolean add(Card temp,Boolean faceUp){
		super.add(temp);
		temp.setFaceUp(faceUp);
		return true;
	}
	public void setCanHit(boolean temp){
		this.canHit=temp;
	}
	public boolean add(Card temp){
		super.add(temp);
		temp.setFaceUp(true);
		return true;
	}
	public int getValue(){
		int calc=0;
		
		for (int i=0;i<this.size();i++ ){
			int acenum=0;
			if (this.get(i).getValue()==0){
				
				Card temp=this.remove(i);
				System.out.println("recursion");
				if (this.getValue()>10)
					calc+=1;
				else
					calc+=11;
				this.add(i,temp);
				
			}
			else
				calc+=this.get(i).getValue();
		}
		
		
		return calc;
	}
	public void hit(){
	
		
		if(canHit){
		this.add(drawPile.remove(0),true);
		if (this.getValue()>21)
			this.bust();
		}
		if (this.getValue()==21)
			canHit=false;
		table.repaint();
		table.printStatus();
	}
	public void stay(){
		canHit=false;
		//dealer.resolveHand();
	}
	public void bust(){
		canHit=false;
		//dealer.resolveHand();
	}
	
	public void dealersTurn(){
		canHit=false;
		dealer.resolveHand();
	}
	public void print() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).toString());
		}
	}
	public void paintHand(Graphics g){
		for (int i =0;i<this.size();i++){
			this.get(i).paintCard(g, (i*120)+10, 300);
		}
		
	}
}
