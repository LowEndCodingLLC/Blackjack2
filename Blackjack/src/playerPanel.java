import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class playerPanel extends JPanel implements ActionListener{
	private Table table;
	private Hand player;
	public playerPanel(Table table){
		player=table.getPlayer();
		this.table=table;
		this.setVisible(true);
		this.setSize(100,200);
		
		buildBoard();
	}
	public void buildBoard(){
		JButton hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		this.add(hit, BorderLayout.PAGE_END);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object hitClicked = arg0.getSource();
		JButton hited=((JButton)hitClicked);
		if(hited.getActionCommand().equals("hit")){
			player.hit();
			player.print();
			System.out.println(player.getValue());
		}
		
	}

}
