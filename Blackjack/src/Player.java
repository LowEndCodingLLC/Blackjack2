import java.awt.Graphics;


public abstract class Player {
	Hand hand=new Hand();
	Dealer myDealer;
	Deck drawpile;
	private boolean canHit = false;
	public Player(){
		System.out.println("hand in player constructor:"+hand);
	}
	
	public void setCanHit(boolean temp) {
		this.canHit = temp;
	}
	public boolean getCanHit(){
		return canHit;
	}
	public Hand getHand(){
		System.out.println(hand);
		return hand;
	}
	public void hit(){

		if(canHit){
		myDealer.dealCard(this);
		if (hand.getValue()>21)
			this.bust();
		
		myDealer.printStatus();
		}
	}
	public void bust(){
		this.setCanHit(false);
		this.endTurn();
	}
	public void stay(){
		this.setCanHit(false);
		endTurn();
	}
	public abstract void endTurn();
	public void take(Card card){
		hand.add(card);
	}
	
	public void printHand(){
		hand.print();
	}
	public int getScore(){
		return hand.getValue();
	}
}
