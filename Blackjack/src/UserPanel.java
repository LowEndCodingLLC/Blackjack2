import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements ActionListener {
	private JButton hit;
	private User user;
	private GamePanel gamePanel;
	
	public UserPanel(GamePanel gamePanel) {
		this.setVisible(true);
		this.setSize(100, 200);
		this.gamePanel=gamePanel;
		buildBoard();
	}
	public void attachUser(User user){
		this.user=user;
	}
	public void buildBoard() {
		this.setLayout(null);
		hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		this.add(hit, 0);

		JButton stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		//this.add(stay, 100,100);
	}

	public void setHitVisibility(Boolean temp) {
		hit.setVisible(temp);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object hitClicked = arg0.getSource();
		JButton hited = ((JButton) hitClicked);
		if (hited.getActionCommand().equals("hit")) {
			user.hit();
			gamePanel.repaint();
			
		}
		Object stayClicked = arg0.getSource();
		JButton stayed = ((JButton) stayClicked);
		if (stayed.getActionCommand().equals("stay")) {
			user.stay();

		}

	}
}
