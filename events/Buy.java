package events;
//import events.Players;
//import pieces.Board;
import pieces.Board;
//import tile.Properties;
//import tile.Utilities;
//import tile.Vias;

public class Buy {
	int ttbuy = 0; //total cost
	//board spaces
	int buymort = 0; //counter for buy or mortgage
	int money = 0;   //
	int own = 0;
	int Bal;
	int titledeed;
	public int[] tdBuy = {60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400,150,150,200,200,200,200};
	public int[] owned = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //0=bank,1=owned,-1=mortgaged
public Buy() {	
			//System.out.println("Buy Class, Player's balance: "+thePlayer.getBalance());
}
public void purchase(int prevown) {
	if(prevown == 0) {
	own = 1;
	ttbuy = tdBuy[titledeed];
	
	money -= ttbuy;
	Bal += money;
	//thePlayer.setBalance(Bal); 
	//owned[titledeed] = own;
	System.out.println("Pay: "+Bal+" - "+money);
	//regions[0].setOwner(); //set to owned in tile objects, if statements based on titledeed?
	}
	//if( owned[titledeed] == 1) {
		//already owned, pay rent
	//}
}
public void mortgage(int prevown) {
	if(prevown == 0) {
	own = -1;
	//ttbuy = tdBuy[titledeed];
	money -= (ttbuy/2);
	Bal += money;
	//thePlayer.setBalance(Bal); //set to mortgaged in tile objects
	//owned[titledeed] = own;
	System.out.println("Mortgage: "+Bal+" - "+money);
	//regions[0].setOwner(); //set to owned in tile objects, if statements based on titledeed?
	}
	/*
	if(prevown == -1) {
		//ttbuy = tdBuy[titledeed];
		//ttbuy *= 0.60;
		//already Mortgaged, pay the 60% back
		if (thePlayer.getBalance() > ttbuy) {
			money -= (ttbuy);
			Bal += money;
			//thePlayer.setBalance(Bal);
			System.out.println("Pay to bank half of mortgage and 10% interest.");
			own = 1;
			//owned[titledeed] = own;
		} else {
			System.out.println("You do not have enough money to own property.");
		}
	}*/
}
}