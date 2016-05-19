public class Controller {
	private GameWindow gameWindow = new GameWindow();
	private GamePanel cardPanel = new GamePanel();
	private PlayerPanel playerPanel = new PlayerPanel(this);
	private Deck drawpile = new Deck();
	private Hand player = new Hand();
	private DealerHand dealer = new DealerHand();

	public Controller() {

	}

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	public void printStatus() {
		System.out.println("Deck size: " + drawpile.size());
		System.out.println("-------------------------");
		System.out.println("Player Hand:");
		player.print();
		System.out.println("Player score: " + player.getValue());
		System.out.println("-------------------------");
		System.out.println("Dealer Hand:");
		dealer.print();
		System.out.println("Dealer score: " + dealer.getValue());
		System.out.println("-------------------------");
	}

	public void startGame() {

		player.add(drawPile.remove(0));
		player.add(drawPile.remove(0));
		dealer.add(drawPile.remove(0));
		dealer.add(drawPile.remove(0), false);
		if (player.getValue() == 21)
			player.setCanHit(false);
		else
			player.setCanHit(true);
		this.printStatus();
	}

	public void determineWinner() {
		if (player.getValue() <= 21 && dealer.getValue() <= 21) {
			if (player.getValue() > dealer.getValue()) {// player wins
				System.out.println("player wins");
			} else if (player.getValue() < dealer.getValue()) {// dealer wins
				System.out.println("dealer wins");
			} else {// tie
				System.out.println("tie");
			}
		} else if (player.getValue() <= 21) {// dealer bust,player wins
			System.out.println("player wins by default");
		} else {// player bust, dealer wins
			System.out.println("dealer wins by default");
		}

	}
	public void playerHit(){

		if(canHit){
		this.add(drawPile.remove(0),true);
		if (this.getValue()>21)
			this.bust();
		
		if (this.getValue()==21)
			this.setCanHit(false);
		table.repaint();
		table.printStatus();
		}
	}
	public void playerStay(){
		this.setCanHit(false);
		//dealer.resolveHand();
	}
	public void setPlayerCanHit(boolean temp){
		player.setCanHit(temp);
		playerPanel.setHitVisibility(temp);
	}
}
