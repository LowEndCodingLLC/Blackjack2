import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements ActionListener{
	
	private GamePanel gamePanel;
	private JButton hit;
	private JButton stay;
	private String displayString="";
	public UserPanel(GamePanel gamePanel){
		this.gamePanel=gamePanel;
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.setSize(100,200);
		
		buildBoard();
	}
	public void buildBoard(){
		hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		this.add(hit, BorderLayout.PAGE_END);
		
		stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		this.add(stay, BorderLayout.PAGE_END);
	}
	public void setHitVisibility(Boolean temp){
		repaint();
		//hit.setVisible(temp);
		//stay.setVisible(temp);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object hitClicked = arg0.getSource();
		JButton hited=((JButton)hitClicked);
		if(hited.getActionCommand().equals("hit")){
			gamePanel.getDealer().getUser().hit();
			gamePanel.repaint();
		}
			Object stayClicked = arg0.getSource();
			JButton stayed=((JButton)stayClicked);
			if(stayed.getActionCommand().equals("stay")){
				gamePanel.getDealer().getUser().stay();
				gamePanel.repaint();
			
		}
		
	}
public void paintComponent(Graphics g) {
		super.paintComponent(g);// paints default background
		g.setColor(Color.RED);
		g.drawString(displayString, 475, 25);
		
	}

}
