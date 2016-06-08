import javax.swing.JOptionPane;


public class User extends Player {
	private int chipPile=100;
	private int chipsBet;
	public User(Dealer myDealer){
		super();
		super.myDealer=myDealer;
		
		
	}
	public void askForBet(){
		//chipsBet=JOptionPane.showInputDialog(null, chipPile, null, chipPile);
	}
	public void bet(int betAmount){
		if (betAmount>chipPile)
			this.askForBet();
		else{
			chipPile-=betAmount;
			chipsBet=betAmount;
			this.setCanHit(true);
		}
		
	}
	public void chipMultiplier(double multiplier){
		chipPile+=(int)(chipsBet*multiplier)/1;
		chipsBet=0;
	}
	
	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		System.out.println("user end turn");
		myDealer.resolveHand();
	}
}
