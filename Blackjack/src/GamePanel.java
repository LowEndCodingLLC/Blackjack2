import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	private Dealer thedealer;
	private User user;
	private JButton hit;
	private JButton stay;

	public GamePanel(Dealer dealer) {
		this.thedealer = dealer;
		System.out.println("GamePanel constructor parameter"+dealer);
		System.out.println("GamePanel constructor"+this.thedealer);
		//System.out.println(this.dealer);
		//this.user = this.thedealer.getUser();
		this.setBackground(Color.green);
		this.setVisible(true);
	}

	public void attachDealer(Dealer dealer) {
		this.thedealer = dealer;
	}

	public void paintComponent(Graphics g) {
		//System.out.println(thedealer);
		super.paintComponent(g);// paints default background
		(thedealer.getHand()).paintHand(g);
		(user.getHand()).paintHand(g);

	}

	public void buildBoard() {
		this.setLayout(null);
		hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		this.add(hit, 0, 0);

		stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		this.add(stay, 100, 100);
	}

	@Override
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
	}

}