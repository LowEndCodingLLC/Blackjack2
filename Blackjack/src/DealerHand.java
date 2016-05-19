
public class DealerHand extends Hand {
	private Table table;
	public DealerHand(Table table){
		super(table);
		this.table=table;
	}
	public void resolveHand(){
		while (this.getValue()<17){
			this.hit();
		}
		if (this.getValue()>21)
			this.bust();
		table.determineWinner();
		
	}
	public void bust(){
		for (Card card:this){
			card.setFaceUp(true);
		}
	}

	
}
