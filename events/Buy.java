package events;
//import events.Players;
//import pieces.Board;

public class Buy {
	Players thePlayer = new Players();
	Board theBoard = new Board();
	int ttbuy = 0;
	int tdmort = 0;
	
	//board spaces
	int titledeed = 0; //buy picks
	int tdplimg = 28; //titledeed card counter
	int buymort = 0; //counter for buy or mortgage
	int money = 0;
	int Bal; //player's balance
	int Prev; //player's position
	String statustxt; //board jframe status
	
	//buying price for title deeds
		int[] tdBuy = {60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400,150,150,200,200,200,200};
		int[] owner = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //0=bank, 1=player 1, -1=player 1: mortgaged
		//the name of the spaces with titledeeds
	    String[] tdPlaces = {"Germania Inferior","Germania Superior","Alpes Poeniae","Alpes Cottiae","Aples Maritimae","Aquitania","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia","Sewers","Aqueducts","Via Appia","Via Flaminia","Via Aemilia","Via Popillia",""};
		//title deed card image names
		String[] tdimages = {"Purple_GermaniaI","Purple_GermaniaS","BBlue_APoeniae","BBlue_ACottiae","BBlue_AMaritimae","DPink_Aquitania","DPink_Belgica","DPink_Raetia","Orange_AProconsularis","Orange_Asia","Orange_Britannia","Red_Cilicia","Red_Galatia","Red_Cappadocia","Yellow_Aegyptus","Yellow_APetraea","Yellow_Syria","Green_Macedonia","Green_Epirus","Green_Achaia","Blue_Sicilia", "Blue_Italia","Utility_Sewers","Utility_Aqueducts","Via_Appia","Via_Flaminia","Via_Aemilia","Via_Popillia",""};
		
public Buy() {
			//ttbuy = tdBuy[titledeed];
			//set mortgage
			if (owner[titledeed] == 0) {
			 if ((ttbuy != 0) && (buymort == 1)) {
				tdmort = (ttbuy/2);
				Bal -= tdmort;
				System.out.println("-Place: "+tdPlaces[titledeed]+", Mortgage: "+Bal+" - "+tdmort);
				owner[titledeed]=-1;
			 } //balance cannot be lower than property
			
			 if(buymort == 0) {
				 //set buy
				System.out.println("-Place: "+tdPlaces[titledeed]+", Pay: "+Bal+" - "+ttbuy);
				Bal -= ttbuy;
				owner[titledeed]=1;
			 } //balance cannot be lower than property
			}
			 if (owner[titledeed] == -1) {
				System.out.println("You have mortgaged this property pay 60% back to the bank.");
				statustxt = "You have mortgaged this property pay 60% back to the bank.";
				tdmort = (ttbuy*0.60) //60% of cost
				Bal -=(tdmort);
			 }
			 if (owner[titledeed] == 1) {
				System.out.println("You own this property.");
				statustxt = "You own this property.";
			 }
			//lock the item as bought and by which player
			//theBoard.setBalance(Bal); //change to board
			System.out.println("Player's balance: "+theBoard.getBalance()); //change to board
		}
}
