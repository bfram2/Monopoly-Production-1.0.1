package own;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import events.Players;
import tile.Properties;

public class Purchase extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
		JButton close;
		JLabel status;
		String statustxt;
		String button1, button2;
		
				
	public Purchase(Players play, Properties prop, int balance) {
		
		if(prop.getOwner() == 0){
			if (balance < prop.getCost()) {
				setTitle("Purchase");
				setSize(200,250); //window size
				setLocation(255,290);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(true);
				setLayout(new BorderLayout());
				JPanel front = new JPanel();
				front.setLayout(null);
				add(front, BorderLayout.CENTER);
				
				statustxt = "You do not have enough money to buy this property";
				
				close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">Close</div>");
				status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
				close.setBackground(new Color(73,175,47));
				
				front.add(status);
				front.add(close);
				
				status.setBounds(20,0,150,150);
				close.setBounds(20, 160, 150, 50);
								
				close.addActionListener(this);
				
				repaint();
			} 
			
		else{
			balance = play.getBalance() - prop.getCost(); 
			play.setBalance(balance);
			play.setOwner(true);
			prop.setOwner(play.getPlayerNumber());
			play.setBalance(play.getBalance());
		}
			
	}
}
		public String getStatusTxt() {return statustxt;}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == close) {
				dispose();
			}
		}
}