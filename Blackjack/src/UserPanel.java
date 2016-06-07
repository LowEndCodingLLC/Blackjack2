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
	private JButton newGame;
	private String displayString="";
	public UserPanel(GamePanel gamePanel){
		this.gamePanel=gamePanel;
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		//this.setSize(100,200);
		this.setLayout(null);
		 this.setPreferredSize(new Dimension(1000, 40));
		buildBoard();
	}
	public void buildBoard(){
		hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		hit.setBounds(400,5,100,30);
		this.add(hit, BorderLayout.PAGE_END);
		
		stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		stay.setBounds(550,5,100,30);
		this.add(stay, BorderLayout.PAGE_END);
		
		
		newGame = new JButton("Next Game");
		newGame.setActionCommand("newGame");
		newGame.setBackground(Color.white);
		newGame.addActionListener(this);
		newGame.setBounds(850,5,100,30);
		this.add(newGame);
		newGame.setVisible(false);
	}
	public void setHitVisibility(Boolean temp){
		//displayString="hello";
		//repaint();
		hit.setVisible(temp);
		stay.setVisible(temp);
		newGame.setVisible(!temp);
	}
	public void setDisplayString(String string){
		displayString=string;
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
			Object newGameClicked = arg0.getSource();
			JButton newGamed=((JButton)newGameClicked);
			if(newGamed.getActionCommand().equals("newGame")){
				gamePanel.getDealer().newGame();
			
		}
		
		
	}
public void paintComponent(Graphics g) {
		super.paintComponent(g);// paints default background
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		g.drawString(displayString, 400, 30);
		
	}

}
