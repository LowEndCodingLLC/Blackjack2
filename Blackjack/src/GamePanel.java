import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel /*implements ActionListener*/ {
	private Dealer dealer;
	private User user;
	private JButton hit;
	private JButton stay;
	private UserPanel userPanel=new UserPanel(this);
	

	public GamePanel(Dealer dealer) {
		this.dealer = dealer;
		this.user=dealer.getUser();
		System.out.println("GamePanel constructor parameter"+dealer);
		System.out.println("GamePanel constructor"+this.dealer);
		this.setBackground(Color.green);
		this.add(userPanel);
		this.setVisible(true);
	}

	public void attachDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	public Dealer getDealer(){
		return dealer;
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);// paints default background
		(dealer.getHand()).paintHand(g,10,100);
		user.getHand().paintHand(g,10,300);
	}

	/*public void buildBoard() {
		this.setLayout(new GridLayout(1,2,10,10));
		hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		this.add(hit);

		stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		this.add(stay);
	}*/

	/*@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object hitClicked = arg0.getSource();
		JButton hited = ((JButton) hitClicked);
		if (hited.getActionCommand().equals("hit")) {
			user.hit();
			repaint();

		}
		Object stayClicked = arg0.getSource();
		JButton stayed = ((JButton) stayClicked);
		if (stayed.getActionCommand().equals("stay")) {
			user.stay();

		}
	}*/

}