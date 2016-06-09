import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel  {
	private Dealer dealer;
	private User user;
	private Image bg;
	
	private UserPanel userPanel=new UserPanel(this);
	

	public GamePanel(Dealer dealer) {
		this.dealer = dealer;
		this.user=dealer.getUser();
	this.setLayout(new BorderLayout());
		File temp = new File("bg.png");
		try {
			Image temp2 = ImageIO.read(temp);
			bg=temp2;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(userPanel, BorderLayout.PAGE_END);
		this.setVisible(true);
	}

	/*public void attachDealer(Dealer dealer) {
		this.dealer = dealer;
	}*/
	public Dealer getDealer(){
		return dealer;
	}
	public UserPanel getUserPanel(){
		return userPanel;
	}

	public void paintComponent(Graphics g) {
		if (!dealer.getGameOver()){
			userPanel.setHitVisibility(dealer.getUser().getCanHit());
			userPanel.setNewGameVisibility(!dealer.getUser().getCanHit());
		}
		else
			userPanel.setNewGameVisibility(false);
		
		super.paintComponent(g);// paints default background
		g.drawImage(bg, 0, 0, null);
		(dealer.getHand()).paintHand(g,10,5);
		user.getHand().paintHand(g,10,375);
	}



}