import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Deck extends ArrayList<Card> {
	private String[] suits = { "heart", "diamond", "spade", "club" };

	public Deck() {
		for (String suit : suits) {
			for (int i = 1; i < 14; i++) {
				File temp=new File(suit+i+".jpg");
				try {
					Image temp2= ImageIO.read(temp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.add(new Card(i, suit, temp2));
			}
		}
	}

	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();
		for (int i = 0; i < 52; i++) {
			int num = (int) (Math.random() * this.size());
			temp.add(this.remove(num));
		}
		this.clear();
		for (int i = 0; i < 52; i++) {
			this.add(temp.get(i));
		}
	}

	public void printDeck() {
		for (int i = 0; i < 52; i++) {
			System.out.println(this.get(i).toString());
		}
	}
}
