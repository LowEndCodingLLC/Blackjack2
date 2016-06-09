import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class User extends Player {
	private int chipPile=100;
	private int chipsBet;
	public User(Dealer myDealer){
		super();
		super.myDealer=myDealer;
		
		
	}
	public void askForBet(){
		JDialog dialog=new JDialog();
		
	String chipsBetString = (String)JOptionPane.showInputDialog(dialog,"You have "+chipPile+" chips. How many would you like to bet?","Manage Bet",JOptionPane.PLAIN_MESSAGE,null,null,"Type numeric value here");
	bet(Integer.parseInt(chipsBetString));
	
	}
	public void bet(int betAmount){
		if (betAmount>chipPile)
			this.askForBet();
		else{
			chipPile-=betAmount;
			chipsBet=betAmount;
			System.out.println("setcanhittrue");
			this.setCanHit(true);
			
		}
		
	}
	public int getChipPile(){
		return chipPile;
	}
	public void chipMultiplier(double multiplier){
		chipPile+=chipsBet;
		chipPile+=(int)(chipsBet*multiplier)/1;
		clearChipsBet();
	}
	public void clearChipsBet(){
		chipsBet=0;
	}
	
	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		System.out.println("user end turn");
		myDealer.resolveHand();
	}
}
