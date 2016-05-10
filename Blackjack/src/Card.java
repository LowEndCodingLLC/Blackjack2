import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Card {
	private String suit;
	private int value;
	private int cardID;
	private String rank;
	private Image front;
	private Image back;
	private Boolean faceUp;

	public Card(int cardID,String suit,Image front,Image back){
		this.suit=suit;
		this.cardID=cardID;
		this.front=front;
		this.back=back;
		if (cardID==1){
			this.rank="ace";
			this.value=0;
		}
		else if (cardID==2){
			this.rank="two";
			this.value=2;
		}
		else if (cardID==3){
			this.rank="three";
		this.value=3;
	}
		else if (cardID==4){
			this.rank="four";
		this.value=4;
}
		else if (cardID==5){
			this.rank="five";
		this.value=5;
	}
		else if (cardID==6){
			this.rank="six";
		this.value=6;
	}
		else if (cardID==7){
			this.rank="seven";
		this.value=7;
	}
		else if (cardID==8){
			this.rank="eight";
		this.value=8;
	}
		else if (cardID==9){
			this.rank="nine";
		this.value=9;
	}
		else if (cardID==10){
			this.rank="ten";
		this.value=10;
	}
		else if (cardID==11){
			this.rank="jack";
		this.value=10;
	}
		else if (cardID==12){
			this.rank="queen";
		this.value=10;
	}
		else if (cardID==13){
			this.rank="king";
		this.value=10;
	}
	}
	public void setFaceUp(Boolean temp){
		this.faceUp=temp;
	}
	public String toString(){
		return (rank+" of "+ suit);
	}
	public int getValue(){
		return value;
	}
	public void paintCard(Graphics g) {//when called, draws card image on table
		if(faceUp)
			g.drawImage(front, 0, 0, null);
		else
			g.drawImage(back,0,0,null);
	}
}
