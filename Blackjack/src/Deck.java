import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Deck extends ArrayList<Card> {
	private String[] suits = { "heart", "diamond", "spade", "club" };
	private Table table;
	public Deck(Table table) {
		for (String suit : suits) {//goes through all four suits
			for (int i = 1; i < 14; i++) {//creates 14 cards for each suit
				//File temp=new File(suit+i+".png");//creates file object for front image
				
				//try {
					//Image temp2= ImageIO.read(temp);//creates image object for front image
					this.add(new Card(i, suit, null/**temp2**/));//adds card to deck
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
				
			}
		}
		this.shuffle();
		this.table=table;
	}

	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();//makes temporary arraylist
		for (int i = 0; i < 52; i++) {//repeat 52 times
			
			int num = (int) (Math.random() * this.size());//choose random number from 0 to number of cards remaining in original
			
			temp.add(this.remove(num));//remove card from random location in original and add to end of temp
			
		}
		//this.clear();
		for (int i = 0; i < 52; i++) {
			this.add(temp.get(i));//copy temp back to original
		}
	}

	public void print() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).toString());
		}
	}
}