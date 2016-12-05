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

public class Sell extends JFrame implements ActionListener{
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
	

	public Sell(Players play1, Players play2, Players [] playArr, Properties prop, Properties [] propArr){
		this.currentPlayer = play1;
		this.secondPlayer = play2;
		this.currentProperty = prop;
		this.pa = propArr;
		
		if(prop.getOwner() != 0){
			if(prop.getOwner() == play1.getPlayerNumber()){
				setTitle("Purchase");
				setSize(200,250); //window size
				setLocation(255,290);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(true);
				setLayout(new BorderLayout());
				JPanel front = new JPanel();
				front.setLayout(null);
				add(front, BorderLayout.CENTER);
				
				statustxt = "Player " +currentPlayer + " would you like to buy or trade this property?";
				
				button1 = "<u>T</u>rade";
				button2 = "<u>S</u>ell";
				buy=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
				trade=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
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
	
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == close) {
		dispose();
	}
	if(e.getSource() == buy){
		setTitle("Sell");
		setSize(200,250); //window size
		setLocation(255,290);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		JPanel front = new JPanel();
		front.setLayout(null);
		add(front, BorderLayout.CENTER);
		
		statustxt = "Player " + secondPlayer.getPlayerNumber() + " would you like to sell this property for " + currentProperty.getCost()+ "?";
			
		button1 = "<u>Y</u>es";
		button2 = "<u>N</u>o";
		yesBuy=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
		noBuy=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
		status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
		close.setBackground(new Color(73,175,47));
			
		front.add(status);
		front.add(close);
			
		status.setBounds(20,0,150,50);
		close.setBounds(20, 60, 150, 50);
			
		close.addActionListener(this);
		
		repaint();
	}
	if(e.getSource() == trade) {
		setTitle("Purchase");
		setSize(200,250); //window size
		setLocation(255,290);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		JPanel front = new JPanel();
		front.setLayout(null);
		add(front, BorderLayout.CENTER);
		
		Properties tradeProp = null;
		
		String[] choices = { "Germania Inferior", "Germania Superior", "Alps Poeniae", "Alps Cottiae", "Alps Maritimae", "Aquitanina","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
        String input = (String) JOptionPane.showInputDialog(null, "Player "+currentPlayer.getPlayerNumber() +" what property would you like to trade for" + currentProperty.getName() + "?","Properties", JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); // Initial choice
        String propName = input;
 		
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
 		setTitle("Sell");
		setSize(200,250); //window size
		setLocation(255,290);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		JPanel front1 = new JPanel();
		front.setLayout(null);
		add(front, BorderLayout.CENTER);
		
		statustxt = "Player " + secondPlayer.getPlayerNumber() + " would you like to trade" +secondProperty+ " for " + currentProperty.getName()+ "?";
			
		button1 = "<u>Y</u>es";
		button2 = "<u>N</u>o";
		yesTrade=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
		noTrade=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
		status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
		close.setBackground(new Color(73,175,47));
			
		front.add(status);
		front.add(close);
			
		status.setBounds(20,0,150,50);
		close.setBounds(20, 60, 150, 50);
			
		close.addActionListener(this);
		
		repaint();
         	
	}
	if(e.getSource() == yesBuy){
		int newBalance1 = currentPlayer.getBalance() - currentProperty.getCost();
		int newBalance2 = secondPlayer.getBalance() + currentProperty.getCost();
		currentProperty.setOwner(currentPlayer.getPlayerNumber());
		repaint();
		dispose();
	}
	if(e.getSource() == noBuy){
		dispose();
	}
	if(e.getSource() == yesTrade){
		int owner1 = currentPlayer.getPlayerNumber();
		int owner2 = secondPlayer.getPlayerNumber();
		currentProperty.setOwner(owner2);
		secondProperty.setOwner(owner1);
		repaint();
		dispose();
	}
}
}
