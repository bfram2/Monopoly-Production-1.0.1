package own;

import events.Players;
import tile.Properties;

public class Mortgage {
	String statustxt = "";

	Players currentPlayer;
	Properties currentProperty;
	
	public Mortgage(Players play, Properties prop) {
		this.currentPlayer = play;
		this.currentProperty = prop;
		
		if(play.getPlayerNumber() != prop.getOwner()){
			statustxt = "You do not own this property.";
		}
		else if(currentProperty.getVillas() > 0 || currentProperty.getPantheons() > 0){
			statustxt = currentProperty.getName() + " has Villas or Pantheons, you cannot mortgage it.";
		}
		else if(currentProperty.getMortgaged() == true) {
			statustxt = currentProperty.getName() + " is already mortgaged.";
		}
		else{
			int newBalance = currentPlayer.getBalance() - currentProperty.getMortgage();
			currentPlayer.setBalance(newBalance);
			currentProperty.setMortgaged(true);
		}
	}
	public String getStatusTxt() {return statustxt;}
}
