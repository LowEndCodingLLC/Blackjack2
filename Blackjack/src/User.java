
public class User extends Player {
	
	public User(Dealer myDealer){
		super();
		super.myDealer=myDealer;
		System.out.println("hand is"+super.hand);
		System.out.println("userexists");
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		myDealer.resolveHand();
	}
}
