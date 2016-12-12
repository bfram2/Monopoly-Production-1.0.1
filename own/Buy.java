package own;
/*
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
*/
import events.Players;
import tile.Properties;

public class Buy {
	String statustxt;
	Players currentPlayer;
	Players secondPlayer;
	Players [] pla;
	Properties currentProperty;
	Properties secondProperty;
	Properties [] pa;
	

	public Buy(Players play1, Players play2,Properties prop){
		this.currentPlayer = play1;
		this.secondPlayer = play2;
		this.currentProperty = prop;
		
		if(prop.getOwner() == 0){
			statustxt = "This property is not owned. You cannot buy it from another player";	

		}
		else if(prop.getVillas() != 0 || prop.getPantheons() != 0){
			statustxt = "This property has Villas or a Pantheon, you cannot buy it";	
		}
		else if(prop.getOwner() == currentPlayer.getPlayerNumber()){

			statustxt = "You already own this property, you cannot buy it from another player.";
		}
		else if(prop.getOwner() != 0){

		 			statustxt = currentPlayer.getName() + " would like to buy "+ currentProperty.getName() + " from " + secondPlayer.getName() + ". <br/>If " +secondPlayer.getName() + " would like to sell for " +currentProperty.getCost()+ " denarius press 'Confirm Buy' below.";	
		 		}
			}
	
	public String getStatusTxt() {return statustxt;}

}
