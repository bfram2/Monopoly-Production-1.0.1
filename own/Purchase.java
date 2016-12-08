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
		JButton close, yes, no;
		JLabel status;
		String statustxt;
		String button1, button2;
		private int currentBalance;
		Players currentPlayer;
		Properties currentProperty;
				
	public Purchase(Players play, Properties prop, int balance) {
		this.currentBalance = balance;
		this.currentPlayer = play;
		this.currentProperty = prop;	
		
		if(currentProperty.getOwner() == 0){
			if (balance < currentProperty.getCost()) {
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
				
				status.setBounds(20,0,150,50);
				close.setBounds(20, 60, 150, 50);
								
				close.addActionListener(this);
				
				repaint();
			} 
			
		else{
			currentBalance = currentPlayer.getBalance() - currentProperty.getCost(); 
			currentPlayer.setBalance(currentBalance);
			currentPlayer.setOwner(true);
			prop.setOwner(currentPlayer.getPlayerNumber());
			play.setBalance(currentPlayer.getBalance());
		}
			
	}
}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == close) {
				dispose();
			}
		}
}

/*package own;
import events.Players;
import tile.Properties;

public class Purchase {
		String statustxt;
		int counter;

				
	public Purchase(Players [] play, Properties [] prop, int counter) {
		int playerNumber = counter;
		Players currentPlayer = null;
		Properties currentProperty = null;
		currentPlayer = play[playerNumber];
		//System.out.println(currentPlayer);
		
		for(int j = 0; j < prop.length; j++){
			int position = currentPlayer.getPosition();
			if(position == prop[j].getTile()){
				currentProperty = prop[j];
			}
		}
		int balance = currentPlayer.getBalance();
		int newBalance = balance - currentProperty.getCost();
		if(currentProperty.getOwner() == 0){
			if (balance > currentProperty.getCost()) {
				currentPlayer.setBalance(newBalance);
				currentProperty.setOwner(playerNumber+1);
			} else {statustxt = "You do not have enough money to buy this property";}			
		}
		else {statustxt = "This property is already owned";
		}
	}
}
*/