package events;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pieces.Board;
import tile.*;
//import events.Players;

public class Own extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton yes, no;
	JLabel status;
	String statustxt = "";
	
public Own() {
	setTitle("Own");
	setSize(209,254); //window size
	setLocation(50,100);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);
	setLayout(new BorderLayout());
	yes=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 50px 5px 50px;\"><u>G</u>et out of Arena<br/><span style=\"font-size: 9pt\">Use Get out of Jail card</span></div>");
	no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>S</u>tay in the Arena</div>");
	status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 10pt; padding: 5px;\">"+statustxt+"</div>");
	yes.setBackground(new Color(73,175,47));
	no.setBackground(new Color(128,0,0));
	
	add(yes, BorderLayout.CENTER);
	add(no, BorderLayout.CENTER);
	add(status);
	yes.setEnabled(false);
	no.setEnabled(false);
	yes.addActionListener(this);
	no.addActionListener(this);
}
	
public void purchase(Players [] play, Properties [] prop, int counter) {
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
		} else {
			System.out.println("You do not have enough money to buy this property");
			//change to print on Jframe
			}			
	}
	else {System.out.println("This property is already owned");
	//change to print on Jframe
	}
}

public void mortgage(Players [] play, Properties [] prop) {
	
	Players currentPlayer = null;
	Properties currentProperty = null;
	for(int i = 0; i < play.length; i++){
		if(play[i].getCurrentPlayer() == true){
			currentPlayer = play[i];
			break;
		}
	}
	
	for(int j = 0; j < prop.length; j++){
		int position = currentPlayer.getPosition();
		if(position == prop[j].getTile()){
			currentProperty = prop[j];
			break;
		}
	}
	
	int balance = currentPlayer.getBalance();
	int mortgageValue = currentProperty.getMortgage();
	
	int newBalance = balance + mortgageValue;
	if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
		System.out.println("You do not own this property");
		//change to print on Jframe
	}
	else if(currentProperty.getVillas() > 0 || currentProperty.getPantheons() > 0){
		System.out.println(currentProperty.getName() + " has Villas or Pantheons, you cannot mortgage it.");
		//change to print on Jframe
	}
	else if(currentProperty.getMortgaged() != 0){
		System.out.println("This property is already mortgaged");
		//change to print on Jframe
	}
	else{
		currentPlayer.setBalance(newBalance);
		currentProperty.setMortgaged(currentPlayer.getPlayerNumber());
		System.out.println(currentProperty.getName() + "is now mortgaged, you can no longer collect rent");
	}
}
public void unmortgage(Players [] play, Properties [] prop){
		
	Players currentPlayer = null;
	Properties currentProperty = null;
	
	for(int i = 0; i < play.length; i++){
		if(play[i].getCurrentPlayer()){
			currentPlayer = play[i];
			break;
		}
	}
	for(int j = 0; j < prop.length; j++){
		int position = currentPlayer.getPosition();
		if(position == prop[j].getTile()){
			currentProperty = prop[j];
			break;
		}
	}
	int newBalance = currentPlayer.getBalance() - currentProperty.getUnMortgaged();
	
	if(currentPlayer.getPlayerNumber() != currentProperty.getOwner()){
		System.out.println("You do not own this property");
		//change to print on Jframe
	}
	else if(currentProperty.getMortgaged() == 0){
		System.out.println("This property is not mortgaged");
		//change to print on Jframe
	}
	else if(currentPlayer.getBalance() < currentProperty.getUnMortgaged()){
		System.out.println("You do not have enough money to unmortgage this property");
		//change to print on Jframe
	}
	else{
		currentProperty.setMortgaged(0);
		currentPlayer.setBalance(newBalance);
		System.out.println(currentProperty.getName() + "is now unmortgaged");
		//change to print on Jframe
	}
}
public void buyImprovements(Players [] play, Properties [] prop){
	Players currentPlayer = null;
	Properties currentProperty = null;
	int houseCost;
	Properties match1 = null;
	Properties match2 = null;
	
	for(int i = 0; i < play.length; i++){
		if(play[i].getCurrentPlayer()){
			currentPlayer = play[i];
			break;
		}
	}
	for(int j = 0; j < prop.length; j++){
		int position = currentPlayer.getPosition();
		if(position == prop[j].getTile()){
			currentProperty = prop[j];
			break;
		}
	}
	
	int group = currentProperty.getGroup();
	if(group == 11 || group == 10 || group == 9){
		System.out.println("You cannot purchase villas on this property");
		//return;
	}
	else{
		for(int k = 0; k < prop.length; k ++){
			if(prop[k] != currentProperty){
			if(prop[k].getGroup() == group){
				match1 = prop[k];
				int j = k;
					if(prop[j].getGroup() == group){
						match2 = prop[j];
					}
				}
			}
		}
	}
	/*
		//boolean totalGroup = checkGroup(currentProperty, prop);
		if(totalGroup == true){
			if(group == 1 || group == 2){
				houseCost = 50;
				if(group == 1){
					System.out.println("You must buy villas/pantheons 2 at a time for this group, do you want to proceed?");
					//buttons for the answer
					//if(group == 2) { //yes button
						if(currentPlayer.getBalance() > (houseCost*2)){
							if(currentProperty.getVillas() > 3){
								currentProperty.setVillas(0);
								match1.setVillas(0);
								currentProperty.setPantheons(1);
								match1.setPantheons(1);
								int newBalance = currentPlayer.getBalance() - (houseCost*2);
								currentPlayer.setBalance(newBalance);
							}
							else if(currentProperty.getPantheons() > 0){
								System.out.println("You already have a Pantheon on these properties, you cannot improve them anymore");					
							}
							else{
								int addVilla = currentProperty.getVillas() + 1;
								currentProperty.setVillas(addVilla);
								match1.setVillas(addVilla);
								int newBalance = currentPlayer.getBalance() - (houseCost*2);
								currentPlayer.setBalance(newBalance);
							}
						}
						else{
							System.out.println("You do not have enough money to buy these villas/pantheon");
						}
					}
					else{
						//no back to last menu
					}
				}
				else if(group == 2) {
					System.out.println("You must buy villas/pantheons 3 at a time for this group, do you want to proceed?");
					//buttons for the answer
					String yes = "yes";
					if (yes == "yes"){
				if (group == 2){
						if(currentPlayer.getBalance() > (houseCost*3)){
							if(currentProperty.getVillas() > 3){
								currentProperty.setVillas(0);
								match1.setVillas(0);
								match2.setVillas(0);
								currentProperty.setPantheons(1);
								match1.setPantheons(1);
								match2.setPantheons(1);
								int newBalance = currentPlayer.getBalance() - (houseCost*3);
								currentPlayer.setBalance(newBalance);
							}
						}
						else if(currentProperty.getPantheons() > 0){
								System.out.println("You already have a Pantheon on these properties, you cannot improve them anymore");					
						}
				}
						else {
								int addVilla = currentProperty.getVillas() + 1;
								currentProperty.setVillas(addVilla);
								match1.setVillas(addVilla);
								match2.setMortgaged(addVilla);
								int newBalance = currentPlayer.getBalance() - (houseCost*3);
								currentPlayer.setBalance(newBalance);
						}
					
					else{System.out.println("You do not have enough money to buy these villas/pantheon");}
					/*
					else {//no back to last menu}
						}
				
					}
				}
			}
				else if(group == 3 || group == 4){
					houseCost = 100;
					System.out.println("You must buy villas/pantheons 3 at a time for this group, do you want to proceed?");
					//buttons for the answer
					if //yes
					{
						if(currentPlayer.getBalance() > (houseCost*3)){
							if(currentProperty.getVillas() > 3){
								currentProperty.setVillas(0);
								match1.setVillas(0);
								match2.setVillas(0);
								currentProperty.setPantheons(1);
								match1.setPantheons(1);
								match2.setPantheons(1);
								int newBalance = currentPlayer.getBalance() - (houseCost*3);
								currentPlayer.setBalance(newBalance);
							}
							else if(currentProperty.getPantheons() > 0){
								System.out.println("You already have a Pantheon on these properties, you cannot improve them anymore");					
							}
							else{
								int addVilla = currentProperty.getVillas() + 1;
								currentProperty.setVillas(addVilla);
								match1.setVillas(addVilla);
								match2.setMortgaged(addVilla);
								int newBalance = currentPlayer.getBalance() - (houseCost*3);
								currentPlayer.setBalance(newBalance);
							}
						}
						else{
							System.out.println("You do not have enough money to buy these villas/pantheon");
						}
					}
					else{
						//no back to last menu
					}
				}
				else if(group == 5 || group == 6){
					houseCost = 150;
					System.out.println("You must buy villas/pantheons 3 at a time for this group, do you want to proceed?");
					//buttons for the answer
					if //yes
					{
						if(currentPlayer.getBalance() > (houseCost*3)){
							if(currentProperty.getVillas() > 3){
								currentProperty.setVillas(0);
								match1.setVillas(0);
								match2.setVillas(0);
								currentProperty.setPantheons(1);
								match1.setPantheons(1);
								match2.setPantheons(1);
								int newBalance = currentPlayer.getBalance() - (houseCost*3);
								currentPlayer.setBalance(newBalance);
							}
							else if(currentProperty.getPantheons() > 0){
								System.out.println("You already have a Pantheon on these properties, you cannot improve them anymore");					
							}
							else{
								int addVilla = currentProperty.getVillas() + 1;
								currentProperty.setVillas(addVilla);
								match1.setVillas(addVilla);
								match2.setMortgaged(addVilla);
								int newBalance = currentPlayer.getBalance() - (houseCost*3);
								currentPlayer.setBalance(newBalance);
							}
						}
						else{
							System.out.println("You do not have enough money to buy these villas/pantheon");
						}
					}
					else{
						//no back to last menu
					}
				}
				else if(group == 7 || group == 8){
					houseCost = 200;
					if(group == 7){
						System.out.println("You must buy villas/pantheons 3 at a time for this group, do you want to proceed?");
						//buttons for the answer
						if //yes
						{
							if(currentPlayer.getBalance() > (houseCost*3)){
								if(currentProperty.getVillas() > 3){
									currentProperty.setVillas(0);
									match1.setVillas(0);
									currentProperty.setPantheons(1);
									match1.setPantheons(1);
									int newBalance = currentPlayer.getBalance() - (houseCost*2);
									currentPlayer.setBalance(newBalance);
								}
								else if(currentProperty.getPantheons() > 0){
									System.out.println("You already have a Pantheon on these properties, you cannot improve them anymore");					
								}
								else{
									int addVilla = currentProperty.getVillas() + 1;
									currentProperty.setVillas(addVilla);
									match1.setVillas(addVilla);
									int newBalance = currentPlayer.getBalance() - (houseCost*3);
									currentPlayer.setBalance(newBalance);
								}
							else{
								System.out.println("You do not have enough money to buy these villas/pantheon");
							}
						}
						else{
							//no back to last menu
						}
					}
					else if(group == 2){
						System.out.println("You must buy villas/pantheons 2 at a time for this group, do you want to proceed?");
						//buttons for the answer
						if //yes
						{
							if(currentPlayer.getBalance() > (houseCost*2)){
								if(currentProperty.getVillas() > 3){
									currentProperty.setVillas(0);
									match1.setVillas(0);
									match2.setVillas(0);
									currentProperty.setPantheons(1);
									match1.setPantheons(1);
									match2.setPantheons(1);
									int newBalance = currentPlayer.getBalance() - (houseCost*3);
									currentPlayer.setBalance(newBalance);
								}
								else if(currentProperty.getPantheons() > 0){
									System.out.println("You already have a Pantheon on these properties, you cannot improve them anymore");					
								}
								else{
									int addVilla = currentProperty.getVillas() + 1;
									currentProperty.setVillas(addVilla);
									match1.setVillas(addVilla);
									match2.setMortgaged(addVilla);
									int newBalance = currentPlayer.getBalance() - (houseCost*2);
									currentPlayer.setBalance(newBalance);
								}
							}
							else{
								System.out.println("You do not have enough money to buy these villas/pantheon");
							}
						}
						else{
							//no back to last menu
						}
					}
				}
				else{
					System.out.print("You do not own all of the properties in this group. You cannot buy houses or pantheons");
				}
			}
}
public boolean checkGroup(Properties prop, Properties [] arr){
	int propertyGroup = prop.getGroup();
	int owner = prop.getOwner();
	Properties test1;
	Properties test2;
	boolean returnValue = false;
	
	if(propertyGroup == 1 || propertyGroup == 8){
		for(int i = 0; i < arr.length; i++){
			test1 = arr[i];
			if(owner == test1.getOwner() && propertyGroup == test1.getGroup()){
				returnValue = true;
			}
		}
	}
	else{
		for(int j = 0; j < arr.length; j++){
			test1 = arr[j];
			if(owner == test1.getOwner() && propertyGroup == test1.getGroup()){
				for(int k = j; k < arr.length; k++){
					test2 = arr[k];
					if(owner == test2.getOwner() && propertyGroup == test2.getGroup()){
						returnValue = true;
					}
					else{
						returnValue = false;
					}
				}
			}
			else returnValue = false;
		}
		}
		return returnValue;
		*/
	}

@Override
public void actionPerformed(ActionEvent e) {

	
}
}