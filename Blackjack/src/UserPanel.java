import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements ActionListener{
	
	private GamePanel gamePanel;
	private JButton hit;
	public UserPanel(GamePanel gamePanel){
		this.gamePanel=gamePanel;
		
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
		
		JButton stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		this.add(stay, BorderLayout.PAGE_END);
	}
	public void setHitVisibility(Boolean temp){
		hit.setVisible(temp);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object hitClicked = arg0.getSource();
		JButton hited=((JButton)hitClicked);
		if(hited.getActionCommand().equals("hit")){
			//player.hit();
		}
			Object stayClicked = arg0.getSource();
			JButton stayed=((JButton)stayClicked);
			if(stayed.getActionCommand().equals("stay")){
				//player.stay();
			
			
		}
		
	}

}
