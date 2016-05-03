
public class Hand extends Deck{
	
	public Hand(){
		
	}
	public int getValue(){
		int calc=0;
		for (int i=0;i<this.size();i++ ){
			calc+=this.get(i).getValue();
		}
		return calc;
	}
	public void hit(){
		
	}
	public void stay(){
		
	}
}
