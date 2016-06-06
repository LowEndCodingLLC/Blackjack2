
public class User extends Player {
	
	public User(Dealer myDealer){
		super();
		super.myDealer=myDealer;
		
		
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		System.out.println("user end turn");
		myDealer.resolveHand();
	}
}
