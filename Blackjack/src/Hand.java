import java.util.ArrayList;


public class Hand extends ArrayList<Card>{
	private Deck drawPile;
	private Table table;
	private DealerHand dealer;
	public Hand(Table table){
		this.table=table;
		this.drawPile=table.getDrawPile();
		this.dealer=table.getDealer();
		
	}
	public int getValue(){
		int calc=0;
		for (int i=0;i<this.size();i++ ){
			if (this.get(i).getValue()==0){
				Card temp=this.remove(i);
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
		
		
		this.add(drawPile.remove(0));
		if (this.getValue()>21)
			this.bust();
		
	}
	public void bust(){
		
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
