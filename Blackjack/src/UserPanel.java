import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserPanel extends JPanel implements ActionListener, KeyListener{
	
	private GamePanel gamePanel;
	private JButton hit;
	private JButton stay;
	private JTextField betBox;
	private JButton newGame;
	private String displayString="";
	private Image pile;
	private Image bet;
	Font x = new Font("Comic Sans MS",Font.PLAIN,12);
	public UserPanel(GamePanel gamePanel){
		this.gamePanel=gamePanel;
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		//this.setSize(100,200);
		this.setLayout(null);
		 this.setPreferredSize(new Dimension(1000, 40));
		 File temp = new File("pile.png");
		 File temp2 = new File("bet.png");
		 try {
			pile = ImageIO.read(temp);
			bet = ImageIO.read(temp2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buildBoard();
	}
	public void buildBoard(){
		hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		hit.setBounds(400,5,100,30);
		hit.setVisible(false);
		this.add(hit, BorderLayout.PAGE_END);
		
		stay = new JButton("stay");
		stay.setActionCommand("stay");
		stay.setBackground(Color.white);
		stay.addActionListener(this);
		stay.setBounds(550,5,100,30);
		stay.setVisible(false);
		this.add(stay, BorderLayout.PAGE_END);

		betBox = new JTextField("",5);
		this.add(betBox,BorderLayout.PAGE_END);

		betBox.setBounds(745,5,100,30);

		betBox.setBackground(Color.WHITE);
		betBox.setFont(x);
		betBox.addKeyListener(this);
		betBox.setVisible(true);
		
		newGame = new JButton("Deal");
		newGame.setActionCommand("newGame");
		newGame.setBackground(Color.white);
		newGame.addActionListener(this);
		newGame.setBounds(850,5,100,30);
		this.add(newGame);
		newGame.setVisible(true);
	}
	public void setConfiguration(int config){
		if (config==1){//hit or stay
			hit.setVisible(true);
			stay.setVisible(true);
			betBox.setVisible(false);
			newGame.setVisible(false);
		}
		if (config==2){//Game over
			hit.setVisible(false);
			stay.setVisible(false);
			betBox.setVisible(false);
			newGame.setVisible(false);
		}
		if (config==3){//enter bet
			hit.setVisible(false);
			stay.setVisible(false);
			newGame.setVisible(true);
			betBox.setVisible(true);
		}
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
				String s=betBox.getText();
				betBox.setText("");
		    	int i=Integer.parseInt(s);
		    	////System.out.println(i);
		    	if (i<=gamePanel.getDealer().getUser().getChipPile()){
		    		gamePanel.getUser().bet(i);
		    		gamePanel.getDealer().newGame();
		    	}
		}
		
		
	}
public void paintComponent(Graphics g) {
		super.paintComponent(g);// paints default background
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		g.drawImage(pile,0,0,null);
		g.drawString(""+gamePanel.getDealer().getUser().getChipPile(), 50, 30);
		if (displayString.length()>10)
			g.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		else
			g.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		g.drawString(displayString, 125, 30);
g.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		if(betBox.isVisible()==true){
		g.drawString("Enter Bet Amount:", 500, 30);
		}
		else if (hit.isVisible()){
			g.drawImage(bet,725,0,null);
			g.drawString("Bet: "+gamePanel.getDealer().getUser().getChipsBet(), 800, 30);
		}

	}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	// When Enter is pressed, the text in the JTextField named hitBox is parsed for integers and fed into the bet method in the gamePanel class.
 //   if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
 //   	String s=betBox.getText();
 //   	int i=Integer.parseInt(s);
 //   	////System.out.println(i);
 //   	gamePanel.getUser().bet(i);
 //  }
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
