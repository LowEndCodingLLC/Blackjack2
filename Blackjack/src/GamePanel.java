import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{



	public GamePanel(){
		this.setVisible(true);
		this.setBackground(Color.green);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//paints default background
		player.paintHand(g);	

	}

}
