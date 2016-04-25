import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Card {
	private String suit;
	private int value;
	private String rank;
	private Image front;
	private Image back;
	public Card(int value,String suit,Image front){
		this.suit=suit;
		this.value=value;
		this.front=front;
		if (value==1)
			this.rank="ace";
		else if (value==2)
			this.rank="two";
		else if (value==3)
			this.rank="three";
		else if (value==4)
			this.rank="four";
		else if (value==5)
			this.rank="five";
		else if (value==6)
			this.rank="six";
		else if (value==7)
			this.rank="seven";
		else if (value==8)
			this.rank="eight";
		else if (value==9)
			this.rank="nine";
		else if (value==10)
			this.rank="ten";
		else if (value==11)
			this.rank="jack";
		else if (value==12)
			this.rank="queen";
		else if (value==13)
			this.rank="king";
	}
	public String toString(){
		return (rank+" of "+ suit);
	}
	public int getValue(){
		return value;
	}
	public void paintCard(Graphics g) {//when called, draws card image on table
		g.drawImage(front, 0, 0, null);
	}
}
