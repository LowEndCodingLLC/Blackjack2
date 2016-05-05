import java.util.ArrayList;


public class Hand extends ArrayList<Card>{
	private Deck drawPile;
	private Table table;
	private DealerHand dealer;
	public Hand(Table table){
		this.table=table;
		this.drawPile=table.getDrawPile();
		this.dealer=table.getDealer();
		this.clear();//clears cards generated in deck constructor(because hand extends deck, deck constructor is automatically called)
	}
	public int getValue(){
		int calc=0;
		for (int i=0;i<this.size();i++ ){
			calc+=this.get(i).getValue();
		}
		return calc;
	}
	public void hit(){
		this.add(drawPile.remove(0));
	}
	public void dealersTurn(){
		dealer.resolveHand();
	}
	public void print() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).toString());
		}
	}
}