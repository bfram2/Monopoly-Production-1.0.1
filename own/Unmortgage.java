package own;

import events.Players;
import tile.Properties;

public class Unmortgage {
	String statustxt = "";
	Players currentPlayer;
	Properties currentProperty;
	
	public Unmortgage(Players play, Properties prop){
		this.currentPlayer = play;
		this.currentProperty = prop;
		
		if(currentPlayer.getPlayerNumber() != currentProperty.getOwner()){
			if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
				statustxt = "You do not own this property.";
			}
		}
		else if(currentProperty.getMortgaged() == false){
			if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
				statustxt = "This property is not mortgaged.";
			}
		}
		else if(currentPlayer.getBalance() < currentProperty.getUnMortgaged()){
			if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
				statustxt = "You do not have enough money to unmortgage this property.";
			}
		}
		else{
			statustxt = "You have unmortgaged "+currentProperty.getName()+".";
			int newBalance = currentPlayer.getBalance() - currentProperty.getUnMortgaged();
			currentPlayer.setBalance(newBalance);
			currentProperty.setMortgaged(false);
			}	
	}
	public String getStatusTxt() {return statustxt;}
}
