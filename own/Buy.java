package own;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import events.Players;
import tile.Properties;

public class Buy extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton close, buy, trade, yesBuy, yesTrade, noBuy, noTrade;
	JLabel status;
	String statustxt;
	String button1, button2;
	Players currentPlayer;
	Players secondPlayer;
	Players [] pla;
	Properties currentProperty;
	Properties secondProperty;
	Properties [] pa;
	

	public Buy(Players play1, Players play2, Players [] playArr, Properties prop, Properties [] propArr){
		this.currentPlayer = play1;
		this.secondPlayer = play2;
		this.currentProperty = prop;
		this.pa = propArr;
		
		if(prop.getOwner() == 0){
			
		}
		if(prop.getOwner() != 0){
			if(prop.getOwner() == play1.getPlayerNumber()){
				
				String[] choices = { "Germania Inferior", "Germania Superior", "Alps Poeniae", "Alps Cottiae", "Alps Maritimae", "Aquitanina","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
		        String input = (String) JOptionPane.showInputDialog(null, "Player "+currentPlayer.getPlayerNumber() +" what property would you like to trade for" + currentProperty.getName() + "?","Properties", JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); // Initial choice
		        
		 		
		 		for(int i = 0; i<pa.length; i++){
		 			if(pa[i].getName() == input){
		 				secondProperty = pa[i];
		 			}
		 		}
		 		for(int j = 0; j< pla.length; j++){
		 			if(pla[j].getPlayerNumber() == secondProperty.getOwner()){
		 				secondPlayer = pla[j];
		 			}
		 		}
		 		if(secondProperty.getOwner() == 0){
		 			setTitle("Trade");
					setSize(200,250); //window size
					setLocation(255,290);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					setVisible(true);
					setLayout(new BorderLayout());
					JPanel front = new JPanel();
					front.setLayout(null);
					add(front, BorderLayout.CENTER);

					statustxt = "This property is not owned. You cannot trade for it";	
				
					button1 = "<u>C</u>lose";
					close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
					status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
					close.setBackground(new Color(73,175,47));
				
					front.add(status);
					front.add(close);
				
					status.setBounds(20,0,150,50);
					close.setBounds(20, 60, 150, 50);
				
					close.addActionListener(this);
		 		}
		 		else{
		 			setTitle("Improvements");
		 			setSize(200,250); //window size
		 			setLocation(255,290);
		 			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 			setVisible(true);
		 			setLayout(new BorderLayout());
		 			JPanel front = new JPanel();
		 			front.setLayout(null);
		 			add(front, BorderLayout.CENTER);

		 			statustxt = "Player " +currentPlayer + " would like to buy "+ currentProperty.getName() + " from" + secondPlayer.getName() + " if " +secondPlayer + " would like to sell for " +currentProperty.getCost()+ " press Sell on the MainBoard";;	
			
		 			button1 = "<u>C</u>lose";
		 			close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
		 			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
		 			close.setBackground(new Color(73,175,47));
			
		 			front.add(status);
		 			front.add(close);
			
		 			status.setBounds(20,0,150,50);
		 			close.setBounds(20, 60, 150, 50);
			
		 			close.addActionListener(this);
		 		}
			repaint();
			}
		}
	}
	
		 		public void actionPerformed(ActionEvent e) {
		 			if(e.getSource() == close) {
		 				dispose();
		 			}
		 		}
}
