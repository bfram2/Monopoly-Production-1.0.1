package events;

import tile.*;

//import events.Turn;
//import events.Players;
//import events.Buy;
//import tile.*;

public class Rent {
	public Rent() {
		
	}
	public Rent(Players[] playArr, Properties [] propArr, int counter, int dice) {
		int playerNumber = counter;
		int ownerNumber;
		Players currentPlayer;
		Players ownerPlayer;
		Properties currentProperty;
		
		currentPlayer = playArr[playerNumber];
		int position = currentPlayer.getPosition();
		currentProperty = propArr[position];
		ownerNumber = propArr[position].getOwner()-1; //-1 is bank, 0 is player 1
		ownerPlayer = playArr[ownerNumber];
		
		System.out.println("current: "+playArr[playerNumber].getName()+", owned player #: "+playArr[ownerNumber].getName()+", rent: "+currentProperty.getSingleRent()+" "+currentProperty.getGroupRent());
		if(counter > 7){counter = counter-7;} 
		if(ownerNumber > 7){ownerNumber = ownerNumber-7;}	
		
		int playerBalance;
		int ownerBalance;
		int rent;
		Properties sewers = propArr[13];
		Properties aquaducts = propArr[29];
		int singleRent = currentProperty.getSingleRent();
		int groupRent = currentProperty.getGroupRent();
		boolean group = checkGroup(currentProperty, propArr);
		
		if(currentProperty.getTile() == 13 || currentProperty.getTile() == 29){
			if(sewers.getOwner() == aquaducts.getOwner()){
				rent = dice * 10;
				ownerBalance = rent + ownerPlayer.getBalance();
				ownerPlayer.setBalance(ownerBalance);
				playerBalance = currentPlayer.getBalance() - rent;
				currentPlayer.setBalance(playerBalance);
			}
			else{
				rent = dice * 4;
				ownerBalance = rent + ownerPlayer.getBalance();
				ownerPlayer.setBalance(ownerBalance);
				playerBalance = currentPlayer.getBalance() - rent;
				currentPlayer.setBalance(playerBalance);
			}
		}
		else if(group == true){
			ownerBalance = groupRent + ownerPlayer.getBalance();
			ownerPlayer.setBalance(ownerBalance);
			playerBalance = currentPlayer.getBalance() - groupRent;
			currentPlayer.setBalance(playerBalance);
		}
		else if(group == false){
			ownerBalance = singleRent + ownerPlayer.getBalance();
			ownerPlayer.setBalance(ownerBalance);
			playerBalance = currentPlayer.getBalance() - singleRent;
			currentPlayer.setBalance(playerBalance);
		}
		
	}//end of pay the man
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
		}
	
}