public class Dealer extends Player {
	private User user;
	private Deck drawpile = new Deck();
	private GamePanel panel;

	public Dealer() {
		super();
		user = new User(this);
		// this.panel=panel;
		super.myDealer = this;
		startGame();
	}

	public void resolveHand() {
	
		setCanHit(true);
		while (hand.getValue() < 17) {
			this.hit();
		}
		if (hand.getValue() > 21) {

			bust();
		} else
			endTurn();

	}

	public void newGame() {
		drawpile = new Deck();
		this.clearHand();
		user.clearHand();
		panel.getUserPanel().setDisplayString("");
		panel.repaint();
		this.startGame();
	}

	public void attachGamePanel(GamePanel panel) {
		this.panel = panel;
	}

	public void dealCard(Player recipient) {
		recipient.take(drawpile.remove(0));
	}

	public void dealCard(Player recipient, boolean faceUp) {
		recipient.take(drawpile.remove(0), faceUp);
	}

	public void startGame() {

		dealCard(user);
		dealCard(user);
		dealCard(this, false);
		dealCard(this);
		printStatus();
		user.askForBet();

	}

	public User getUser() {

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
		String temp = "";
		if (user.getScore() <= 21 && this.getScore() <= 21) {
			if (user.getScore() > this.getScore()) {// player wins
				temp = "You Win!";
				user.chipMultiplier(0);
			} else if (user.getScore() < this.getScore()) {// dealer wins
				temp = "You Lose";
				user.chipMultiplier(0);
			} else {// tie
				temp = "It's a tie";
				user.chipMultiplier(1);
			}
		} else if (user.getScore() > 21 && this.getScore() > 21) {// everyone
																	// bust
			temp = "Everyone busts. No winner.";
			user.chipMultiplier(1);
		} else if (user.getScore() <= 21) {// dealer bust,player wins
			temp = "You Win!";
			if(user.getScore()==21)
				user.chipMultiplier(2.5);
		} else {// player bust, dealer wins
			temp = "You Lose";
			user.chipMultiplier(0);
		}
		
		panel.getUserPanel().setDisplayString(temp);
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		for (Card card : hand) {
			card.setFaceUp(true);
		}
		determineWinner();
	}
}
