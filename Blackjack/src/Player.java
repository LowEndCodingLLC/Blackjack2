import java.awt.Graphics;


public abstract class Player {
	Hand hand=new Hand();
	Dealer myDealer;
	Deck drawpile;
	private boolean canHit = false;
	public Player(){
		
	}
	
	public void setCanHit(boolean temp) {
		this.canHit = temp;
	}
	public boolean getCanHit(){
		return canHit;
	}
	public Hand getHand(){
		
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
	public void clearHand(){
		hand.clear();
	}
	public void stay(){
		if (canHit){
		this.setCanHit(false);
		endTurn();
		}
	}
	public abstract void endTurn();
	public void take(Card card){
		hand.add(card);
	}
	public void take(Card card, boolean faceUp){
		hand.add(card,faceUp);
	}
	
	public void printHand(){
		hand.print();
	}
	public int getScore(){
		return hand.getValue();
	}
}
