package events;
import cards.Chance;
import cards.CommunityChest;
import tile.Properties;
//import pieces.Dice;
//import pieces.Board;

public class Turn {
	//Players thePlayers = new Players(); //add Player to board
	int dice1 = 0;    //dice class
	int dice2 = 0;    //0 is no visible dice image
	int Prev;        //previous position in Board
	         //current rolled position from Board
	int j = 0;        //jail
	int escha = 0; //get out of jail free chance card counter
	int esche = 0; //get out of jail free chest card counter
	int jtotal = 0; //total get out of jail counter
	int k = 0;        //doubles
	String statustxt = ""; //Pos status text
	int chacard;      //theChance.getChanceNo
	String chaimg;    //         .getImgName
	String chaout;    //         .getOutcome
	int chaadj;       //         .getAdjust
	int checard;      //theChest.getChestNo
	String cheimg;    //        .getImgName
	String cheout;    //        .getOutcome
	int cheadj;       //        .getAdjust
	String spacename;
	String spaceimg;
	int counter;
	Properties [] prop;
	Players [] play;
	
	
	public Turn() {
	}
	public Turn(Properties [] prop, Players [] play,  String statustxt, int dice1, int dice2, int j, String chaimg, int counter) {
		this.statustxt = statustxt;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.j = j;
		this.chaimg = chaimg;
		this.counter = counter;
	}
	public void setTurn(int counter) {this.counter = counter;}
	public void setPrev(int Prev) {this.Prev = Prev;}
	public void setDice1(int dice1) {this.dice1 = dice1;}
	public void setDice2(int dice2) {this.dice2 = dice2;}
	public void setJTotal(int jtotal) {this.jtotal = jtotal;}
	
	public void TurnAction(Properties [] prop, Players [] play, int Prev, int dice1, int dice2, int jtotal, int counter) {
		for (int i=0; i<1; i++) {
		int pno = counter;
		Players p = play[pno];
		statustxt = "";
		System.out.println(play[pno].getName()+", Position: "+p.getPosition());
		int[] doubles = new int[3]; //test for errors when doubles > 3
		
		k = p.getDoubles();
		
	    k = (dice1 == dice2) ? k++ : 0; //if matching dice roles: k++
		k = k % 3; //doubles 0 none, 3 jail
		
		if (k == 1) {
		statustxt = "Doubles! Roll again.";
		//disable all, but rolling in board
		}
		if (k > 2 && k < 1) {
			statustxt = "You have rolled doubles 3 times, Go to the Arena.";
			p.setPosition(11);
			k = 0;    //roll doubles within 3 turns
		}
		if (j == 0) {
	    	if (Prev < 10 && p.getPosition()> 10) {
	    		int currentPos = p.getPosition();
	    		p.setPosition(currentPos+1);
				
			} //if Pos is less than 10 and will become greater than 10, add one to skip jail (Pos = 11)
	    	if (p.getPosition() > 39) {
				p.setPosition(40-p.getPosition());
			}
			if (p.getPosition() != 0 && Prev != 0) {
			    if (Prev > p.getPosition()) {
			    int currentBal = p.getBalance();
			    statustxt = "Pass Rome, Collect 200 denarius.";
				p.setBalance(currentBal + 200);
			    }
		    } //pass go
			if (p.getPosition() == 0) {
				int currentBal = p.getBalance();
				statustxt = "Enter Rome, Collect 200 denarius.";
				 p.setBalance(currentBal + 200);
			} //Rome
			if (p.getPosition() == 10) {statustxt = "See a battle.";} //see a battle
			if (p.getPosition() == 21) {statustxt = "Free market.";} //free market
			if (p.getPosition() == 31) {
				statustxt = "Go to the Arena.";
				p.setPosition(11);
	    		j = 1;
			}
			if (p.getPosition() == 39) {
				int currentBal = p.getBalance();
				p.setBalance(currentBal - 100);
				statustxt = "Citizen's Tax";
			}
			if (p.getPosition() == 4) {
				int currentBal = p.getBalance();
				p.setBalance(currentBal - 200);
				statustxt = "Render 200 denarius unto Caesar.";
			}
			if (p.getPosition() == 2 || p.getPosition() == 18 || p.getPosition() == 34) {
				CommunityChest theChest = new CommunityChest(p, play, prop); //community class
				checard = theChest.getChestNo();
				cheimg = theChest.getImgName();
				cheout = theChest.getOutcome();
				esche += theChest.getOutJail();
				
				int currentBalance = p.getBalance();
				p.setBalance(currentBalance + cheadj);
				statustxt = "Draw a Community Chest card. "+cheout;
			} //chest card
			if (p.getPosition() == 7 || p.getPosition() == 23 || p.getPosition() == 37) {
				Chance theChance = new Chance(p); //chance class
				chacard = theChance.getChanceNo();
				chaimg = theChance.getImgName();
				chaout = theChance.getOutcome();
				escha += theChance.getOutJail();
				int currentBalance = p.getBalance();
				p.setBalance(currentBalance + chaadj);
				statustxt = "Draw a Chance card. "+chaout;
			} //chance card
			
		} //j=0; if not in jail
		if(j > 0 && j < 4) {
			statustxt = "You are in the Arena. Turns until free: "+(4-j);
			j++;
			if (k == 1) {
				statustxt = "You rolled a double, escape the Arena.";
				j = 0;
			}
			p.setPosition(11);
		}
		if (j > 3) {
			statustxt = "You paid a fine, leave the Arena.";
			int currentBalance = p.getBalance();
			p.setBalance(currentBalance -  50);
			j = 0;
		}
		if (k > 3) {
			k = 4 - k;
		} //keep doubles from going out of bounds
		Prev = p.getPosition();
	    doubles[k]++;
	    p.setDoubles(k);
	    jtotal += (escha+esche);
		} //end of loop
	} //end of turn
	//get & set
	public int getJTotal() {return jtotal;}
	public int getOutJail() {return escha+esche;}
	public int getTjail() {return j;}
	public String getStatustxt() {return statustxt;}
	public int getDice1() {return dice1;}
	public int getDice2() {return dice2;}
	public String getChaimg() {
		//TurnAction(prop, play, Prev, dice1, dice2, jtotal, counter); 
		return chaimg;}
}