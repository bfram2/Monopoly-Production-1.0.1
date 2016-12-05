package cards;
import events.Players;
import tile.Properties;
//import pieces.*;
//import events.Players;
//For image Chance Cards and their events


	public class Chance {
		int Outjail; //get out of jail counter
		int jail = 0;    //in jail, cannot pass go if(j=0)
		int chanceno;
		String imgname;
		String outcome;
		
		public Chance (Players p, Players [] play, Properties [] prop) {
			pull(p, play, prop); //pick card
		}
		public Chance(int chanceno, String imgname, String outcome) {
			chanceno = this.chanceno; //chanceno for random rolling 1-16
			imgname = this.imgname; //imgname is the image location
			outcome = this.outcome; //prints the text of the card
		}
		public void pull(Players p, Players [] play, Properties [] prop) {
		Players thePlayer = p;
		
		chanceno = (int)(Math.random()*16) + 1;
		imgname = "src/cards/images/Chance"+chanceno+".PNG"; // src/cards/images/Chance1-16.PNG
		if (jail == 0) {
			if (chanceno == 1) {
					if (thePlayer.getPosition()> 5) {
					int changeBalance = thePlayer.getBalance() + 200;
					thePlayer.setBalance(changeBalance);
					} //pass go
					thePlayer.setPosition(5); //Via Appia
					outcome = "Take a trip to Via Appia. If you pass Rome collect 200 denarius.";
			}
			if (chanceno == 2 || chanceno == 3) {
				outcome = "Advance to the nearest Via. If UNOWNED, you may buy it from the Bank. If OWNED, pay owner twice the rental to which they are otherwise entitled.";
				if (thePlayer.getPosition() > 35 || thePlayer.getPosition() < 5) {
					thePlayer.setPosition(5); //Via Appia
					int changeBalance = thePlayer.getBalance() + 200;
					thePlayer.setBalance(changeBalance);
				}
				if (thePlayer.getPosition() > 4 || thePlayer.getPosition() < 16) {
					thePlayer.setPosition(16); //Via Flaminia
				}
				if (thePlayer.getPosition() > 15 || thePlayer.getPosition() < 26) {
					thePlayer.setPosition(26); //Via Aemilia
				}
				if (thePlayer.getPosition()> 25 || thePlayer.getPosition() < 36) {
					thePlayer.setPosition(36); //Via Popillia
				}
			} //nearest Via, if owned: pay 2(rent), if unowned can buy
			if (chanceno == 4) {
				outcome = "Gain a favor with a Senator, get out of the Gladiatorial Arena for free. This card may be kept until needed or traded.";
				Outjail = thePlayer.getOutJail(); // get current player's get out of jail free card count
				Outjail++; //get out of jail for free
				thePlayer.setOutJail(Outjail); //Set get out of jail to new value
			} //changes
			if (chanceno == 5) {
				
				outcome = "Advance to the nearest Utility. If UNOWNED, you may buy it from the Bank. If OWNED, throw dice and pay owner a total ten times amount thrown.";
				if (thePlayer.getPosition() > 28 || thePlayer.getPosition() < 13) {
					thePlayer.setPosition(13); //sewers
				}
				if (thePlayer.getPosition() > 12 || thePlayer.getPosition() < 29) {
					thePlayer.setPosition(29); //aqueducts
				} 
			} //utilities
			if (chanceno == 6) {
				outcome = "Advance to Rome. Collect 200 denarius.";
				thePlayer.setPosition(0);
				int changeBalance = thePlayer.getBalance() + 200;
				thePlayer.setBalance(changeBalance);
			} //go to Rome
			if (chanceno == 7) {
				outcome = "A new road is built near your Villa raising its value, collect 150 denarius.";
				int changeBalance = thePlayer.getBalance() + 150;
				thePlayer.setBalance(changeBalance);
			}
			if (chanceno == 8) {
				outcome = "Go back 3 spaces.";
				int newPosition = thePlayer.getPosition() - 3;
				thePlayer.setPosition(newPosition);
			}
			if (chanceno == 9) {
				outcome = "Make general repairs on all of your properties: For villa pay 25 denarius, For pantheons pay 100 denarius. If no villas or pantheons are owned pay 100 denarius.";
				int changeBalance = thePlayer.getBalance() - 100;
				thePlayer.setBalance(changeBalance);
				//a fine for now
				//Make general repairs on all of your properties:
				//player's villas times 25
				//player's pantheons times 100
			}
			if (chanceno == 10) {
				outcome = "Advance to Italia.";
				thePlayer.setPosition(40); //go to Italia
			}
			if (chanceno == 11) {
				outcome = "Recent investment in more merchant carts gains you 50 denarius.";
				int changeBalance = thePlayer.getBalance() + 50;
				thePlayer.setBalance(changeBalance);
			}
			if (chanceno == 12) {
				outcome = "Your horses escape into the city. Pay a 15 denarius fine.";
				int changeBalance = thePlayer.getBalance() - 15;
				thePlayer.setBalance(changeBalance);//fine of 15
			}
			if (chanceno == 13) {
				outcome = "Go to the Gladiatorial Arena. Go directly to the arena, DO NOT pass Rome, DO NOT collect 200 denarius.";
				thePlayer.setPosition(11);
				jail = 1; //go to jail
			}
			if (chanceno == 14) {
				outcome = "Advance to Aquitania. If you pass Rome, Collect 200 denarius.";
					if (thePlayer.getPosition() > 12) {
						int changeBalance = thePlayer.getBalance() + 200;
						thePlayer.setBalance(changeBalance);
						} //pass go
					thePlayer.setPosition(12); //Aquitania
			}
			if (chanceno == 15) {
				outcome = "Advance to Cappadocia. If you pass Rome, Collect 200 denarius.";
					if (thePlayer.getPosition() > 25) {
						int changeBalance = thePlayer.getBalance() + 200;
						thePlayer.setBalance(changeBalance);
						}//pass go
					thePlayer.setPosition(25);  //Cappadocia
			}
			if (chanceno == 16) {
				outcome = "You have been elected a Senator, pay each player 50 denarius.";
				int changeBalance = thePlayer.getBalance() - 50;
				thePlayer.setBalance(changeBalance);//fine of 50
			} //pay each player 50 later, count Players array
		 } //can't be in jail
		}  //end pull
		public int getChanceNo() {return chanceno;}
		public String getImgName() {return imgname;} 
		public String getOutcome() {return outcome;}
		public int getOutJail() {return Outjail;}
		
}
	
	/*
	1.Take a trip to Via Appia. If you pass Rome collect $200.
	2,3. Advance to the nearest Via. If UNOWNED, you may buy it from the Bank. 
	If OWNED, pay owner twice the rental to which they are otherwise entitled.
	4. Gain a favor with a Senator, get out of the Gladiatorial Arena for free. This card may be kept until needed or traded.
	5. Advance to the nearest Utility. If UNOWNED, you may buy it from the Bank. 
	If OWNED, throw dice and pay owner a total ten times amount thrown.
	6. Advance to Rome. Collect $200.
	7. A new road is built near your Villa raising its value, collect $150.
	8. Go back 3 spaces.
	9. Make general repairs on all of your properties: For villa pay $25, For pantheons pay $100.
	10. Advance to Italia.
	11. Recent investment in more merchant carts gains you $50.
	12. Your horses escape into the city. Pay a $15 fine.
	13. Go to the Gladiatorial Arena. Go directly to the arena, DO NOT pass Rome, DO NOT collect $200.
	14. Advance to Aquitania. If you pass Rome, Collect $200.
	15. Advance to Cappadocia. If you pass Rome, Collect $200.
	16. You have been elected a Senator, pay each player $50.
	*/