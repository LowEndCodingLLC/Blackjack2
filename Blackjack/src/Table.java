import java.awt.Graphics;
import javax.swing.JPanel;

public class Table extends JPanel{
	private Deck drawpile=new Deck();
	public Table(){

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//paints default background
		drawpile.get(0).paintCard(g);//paints card on top of default background
		
	}

}
