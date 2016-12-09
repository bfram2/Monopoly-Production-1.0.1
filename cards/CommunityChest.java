package cards;
//import java.net.URL;

import events.Players;
import tile.Properties;
//For Community Chest Cards & images
//import events.Players;

public class CommunityChest {
	int Outjail = 0; //get out of jail counter
	int jail = 0;    //in jail, cannot pass go if(j=0)
	int chestno;
	String imgname;
	String outcome;
	
	public CommunityChest(Players p, Players [] play, Properties [] prop) {
		heartofcards(p, play, prop); //pick card
	}
	public CommunityChest(int chestno, String imgname, String outcome) {
		this.chestno = chestno;
		this.imgname = imgname;
		this.outcome = outcome;
	}
	public void heartofcards(Players p, Players [] play, Properties [] prop) {
		Players thePlayer = p;
		chestno = (int)(Math.random()*16) + 1;
		//imgname = "Chest"+chestno+".PNG";
			if (chestno == 1) {
				outcome = "Bank error in your favor. Collect 200 denarius.";
				int changeBalance = thePlayer.getBalance() + 200;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 2) {
				outcome = "Pay private physician fees of 100 denarius.";
				int changeBalance = thePlayer.getBalance() - 100;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 3) {
				outcome = "From sale of merchant carts, you get 50 denarius.";
				int changeBalance = thePlayer.getBalance() + 50;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 4) {	
				outcome = "You inherit a small Villa, gain 100 denarius.";
				int changeBalance = thePlayer.getBalance() + 100;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 5) {
				outcome = "Go to the Gladiatorial Arena. Go directly to the arena, DO NOT pass Rome, DO NOT collect 200 denarius.";
				thePlayer.setPosition(11);
				thePlayer.setJailCounter(1);
			}
			if (chestno == 6) {
				thePlayer.setPosition(0);
				outcome = "Advance to Rome. Collect 200 denarius.";
				int changeBalance = thePlayer.getBalance() + 200;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 7) {
				outcome = "Render too much unto Caesar, Collect 200 denarius.";
				int changeBalance = thePlayer.getBalance() + 200;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 8) {
				outcome = "Roman official assesses you for street repairs: 40 per villa, 115 per pantheon.";
				int villas = 0;
				int pantheon = 0;
				for(int i = 0; i < prop.length; i++){
					if(prop[i].getOwner()== thePlayer.getPlayerNumber()){
						villas += prop[i].getVillas();
						pantheon += prop[i].getPantheons();
					}
				}
				int changeBalance = thePlayer.getBalance() + (villas * 40) + (pantheon * 115);
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 9) {
				outcome = "You have won second place in the Campus Track & Field foot race. Collect 10 denarius.";
				int changeBalance = thePlayer.getBalance() + 10;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 10) {
				outcome = "Your properties and assets mature, join the Equestrian Order. Collect 100 denarius.";
				int changeBalance = thePlayer.getBalance() + 100;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 11) {
				outcome = "Sell bulk staples to the bank, receive 100 denarius.";
				int changeBalance = thePlayer.getBalance() + 100;
				thePlayer.setBalance(changeBalance);
			}
			if (chestno == 12) {
			outcome = "Pay farmer's tax of 25 denarius.";
			int changeBalance = thePlayer.getBalance() - 25;
			thePlayer.setBalance(changeBalance);
			}
			if (chestno == 13) {
			outcome = "You have a coming of age party, Collect 10 denarius from every player.";
			int changeBalance = thePlayer.getBalance() + 80;
			thePlayer.setBalance(changeBalance);//fine of 50
			for(int i = 0; i < play.length; i++){
				if(play[i].getCurrentPlayer() == false){
					play[i].setBalance(play[i].getBalance()-10);
				}
			} //pay each player 50 denarius
			}
			if (chestno == 14) {
			outcome = "Pay school fees of 50 denarius.";
			int changeBalance = thePlayer.getBalance() - 50;
			thePlayer.setBalance(changeBalance);
			}
			if (chestno == 15) {
			outcome = "Medical institution fees, pay 50 denarius.";
			int changeBalance = thePlayer.getBalance() - 50;
			thePlayer.setBalance(changeBalance);
			}
			if (chestno == 16) {
				outcome = "Gain a favor with a Senator, get out of the Gladiatorial Area for free. This card may be kept until needed or traded.";
				thePlayer.setOutJail(thePlayer.getOutJail()+1); //Set get out of jail to new value
			}
		} //chestno 1-16
	public int getChestNo() {return chestno;}
	public String getImgName() {return imgname;}
	public String getOutcome() {return outcome;}
	public int getOutJail() {return Outjail;}
}