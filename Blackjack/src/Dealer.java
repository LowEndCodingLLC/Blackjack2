
public class Dealer extends Player {
	private User user = new User(this);
	private Deck drawpile = new Deck();
	private GamePanel panel;
	public Dealer(){
		super();
		//this.panel=panel;
		super.myDealer=this;
		startGame();
	}
	public void resolveHand(){
		setCanHit(true);
		while (hand.getValue()<17){
			this.hit();
		}
		if (hand.getValue()>21)
			bust();
		else
			endTurn();
		
	}
	public void dealCard(Player recipient){
		recipient.take(drawpile.remove(0));
	}
	public void startGame() {

		dealCard(user);
		dealCard(user);
		dealCard(this);
		dealCard(this);
		printStatus();
		user.setCanHit(true);
		
	}
	public User getUser(){
		return user;
	}
	public void printStatus() {
		System.out.println("**************************");
		System.out.println("Deck size: " + drawpile.size());
		System.out.println("-------------------------");
		System.out.println("Player Hand:");
		user.printHand();
		System.out.println("Player score: " + user.getScore());
		System.out.println("-------------------------");
		System.out.println("Dealer Hand:");
		this.printHand();
		System.out.println("Dealer score: " + this.getScore());
		System.out.println("-------------------------");
	}
	public void determineWinner() {
		if (user.getScore() <= 21 && this.getScore() <= 21) {
			if (user.getScore() > this.getScore()) {// player wins
				System.out.println("player wins");
			} else if (user.getScore() < this.getScore()) {// dealer wins
				System.out.println("dealer wins");
			} else {// tie
				System.out.println("tie");
			}
		} else if (user.getScore() <= 21) {// dealer bust,player wins
			System.out.println("player wins by default");
		} else {// player bust, dealer wins
			System.out.println("dealer wins by default");
		}

	}
	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		determineWinner();
	}
}
