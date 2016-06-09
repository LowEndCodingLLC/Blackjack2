public class Dealer extends Player {
	private User user;
	private Deck drawpile = new Deck();
	private GamePanel panel;
	private Boolean gameOver=false;

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
	public GamePanel getPanel(){
		return panel;
	}
	public void newGame() {
		drawpile = new Deck();
		this.clearHand();
		user.clearHand();
		panel.getUserPanel().setDisplayString("");
		panel.repaint();
		user.askForBet();
		dealCard(user);
		dealCard(user);
		dealCard(this, false);
		dealCard(this);
		printStatus();
		panel.repaint();
	}
	public boolean getGameOver(){
		return gameOver;
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
//	public void repaintPanel(){
//		panel.repaint();
//	}
	public void startGame() {
		user.askForBet();
		dealCard(user);
		dealCard(user);
		dealCard(this, false);
		dealCard(this);
		printStatus();
		
		

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
				if(user.getScore()==21)
					user.chipMultiplier(1.5);
				else
					user.chipMultiplier(1);
			} else if (user.getScore() < this.getScore()) {// dealer wins
				temp = "You Lose";
				user.clearChipsBet();
			} else {// tie
				temp = "It's a tie";
				user.chipMultiplier(0);
			}
		} else if (user.getScore() > 21 && this.getScore() > 21) {// everyone
																	// bust
			temp = "Everyone busts. No winner.";
			user.chipMultiplier(0);
		} else if (user.getScore() <= 21) {// dealer bust,player wins
			temp = "You Win!";
			if(user.getScore()==21)
				user.chipMultiplier(1.5);
			else
				user.chipMultiplier(1);
		} else {// player bust, dealer wins
			temp = "You Lose";
			user.clearChipsBet();
		}
		if (user.getChipPile()==0){
			temp="You Lose. Game Over";
			gameOver=true;
			
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
