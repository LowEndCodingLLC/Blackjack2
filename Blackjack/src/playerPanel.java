import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class playerPanel extends JPanel implements ActionListener{
	private Table table;
	public playerPanel(Table table){
		this.table=table;
		this.setVisible(true);
		this.setSize(100,200);
		this.setLayout(new GridLayout(1,2));
		buildBoard();
	}
	public void buildBoard(){
		JButton hit = new JButton("hit");
		hit.setActionCommand("hit");
		hit.setBackground(Color.white);
		hit.addActionListener(this);
		this.add(hit);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object hitClicked = arg0.getSource();
		JButton hited=((JButton)hitClicked);
		System.out.println(hited);
		if(hited.getActionCommand().equals("hit")){
		//	table.get();
		}
		
	}

}