import javax.swing.JOptionPane;


public class User extends Player {
	private int chipPile=100;
	private int chipsBet;
	public User(Dealer myDealer){
		super();
		super.myDealer=myDealer;
		
		
	}
	
	public int bet(int betAmount){
		if (!(betAmount>chipPile)){
			chipPile-=betAmount;
			chipsBet=betAmount;
			this.setCanHit(true);
		}
		return betAmount;
		
	}
	public void chipMultiplier(double multiplier){
		chipPile+=(int)(chipsBet*multiplier)/1;
		chipsBet=0;
	}
	public int getChipPile(){
		return chipPile;
	}
	public int getChipsBet(){
		return chipsBet;
	}
	
	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		////System.out.println("user end turn");
		myDealer.resolveHand();
	}
}
