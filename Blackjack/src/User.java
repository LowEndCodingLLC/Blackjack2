
public class User extends Player {
	
	public User(Dealer myDealer){
		super();
		super.myDealer=myDealer;
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		myDealer.resolveHand();
	}
}
