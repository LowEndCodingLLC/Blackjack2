import java.awt.Graphics;
import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	public Hand() {
		
	}

	public boolean add(Card temp, Boolean faceUp) {
		super.add(temp);
		temp.setFaceUp(faceUp);
		return true;
	}


	public boolean add(Card temp) {
		super.add(temp);
		temp.setFaceUp(true);
		return true;
	}

	public int getValue() {
		int calc = 0;

		for (int i = 0; i < this.size(); i++) {
			int acenum = 0;
			if (this.get(i).getValue() == 0) {

				Card temp = this.remove(i);

				if (this.getValue() > 10)
					calc += 1;
				else
					calc += 11;
				this.add(i, temp);

			} else
				calc += this.get(i).getValue();
		}

		return calc;
	}
	public void print() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).toString());
		}
	}
	public void paintHand(Graphics g,int startx,int starty){
		for (int i =0;i<this.size();i++){
			this.get(i).paintCard(g, (i*120)+startx, starty);
		}
		
	}


}