
public class DealerHand extends Hand {
	public DealerHand(){
		super();
	}
	public void resoveHand(){
		while (this.getValue()<17){
			this.hit();
		}
		this.stay();
	}

}
