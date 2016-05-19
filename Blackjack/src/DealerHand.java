
public class DealerHand extends Hand {
	
	public DealerHand(){
		super();
		
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
