import java.util.ArrayList;

<<<<<<< HEAD
public class Hand extends Deck{
	public Hand(){
		
=======

public class Hand extends ArrayList<Card>{
	private Deck drawPile;
	private Table table;
	private DealerHand dealer;
	public Hand(Table table){
		this.table=table;
		this.drawPile=table.getDrawPile();
		this.dealer=table.getDealer();
		this.clear();//clears cards generated in deck constructor(because hand extends deck, deck constructor is automatically called)
>>>>>>> refs/remotes/origin/master
	}
	public int getValue(){
		int calc=0;
		for (int i=0;i<this.size();i++ ){
			calc+=this.get(i).getValue();
		}
		return calc;
	}
	public void hit(){
		int random=(int)Math.random()*drawPile.size();
		if (this.size()>0)
			this.add(drawPile.remove(random));
	}
	public void dealersTurn(){
		dealer.resolveHand();
	}
}
