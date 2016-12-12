package own;

//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;

import events.Players;
import tile.Properties;


public class Trade {	
	String statustxt;
	String button1, button2;
		
	public Trade(Players play1, Players play2, Properties prop1, Properties prop2){
		
		if(prop2.getOwner() == 0){
			statustxt = "This property is not owned. You cannot trade for it";	
		 	}
		else if (prop1.getVillas() != 0 && prop1.getPantheons() != 0 && prop2.getVillas() != 0 && prop2.getPantheons() != 0){
			statustxt = "This property has Villas or a Pantheon, you cannot buy it.";	

		}
		else if(prop2.getOwner() == play1.getPlayerNumber()) {
			statustxt = "You already own this property, you cannot trade it with another player.";	
		}
		else{
				statustxt = play1.getName() + " would like to trade " + prop1.getName() + " for " + play2.getName() + "'s property, " + prop2.getName() + ". Please press 'Confirm Trade' to make this trade.";	
		 		}
	}

public String getStatusTxt() {return statustxt;}
}
