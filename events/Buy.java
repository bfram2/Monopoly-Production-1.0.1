package events;
//import events.Players;
//import pieces.Board;

public class Buy extends Turn {
	int ttbuy = 0;
	int tdmort = 0;
	
	//board spaces
	int titledeed = 0; //buy picks
	int tdplimg = 28; //titledeed card counter
	int buymort = 0; //counter for buy or mortgage
	int money = 0;
	int Bal; //player's balance
	int Prev; //player's position
	Players thePlayer = new Players();

	//buying price for title deeds
		int[] tdBuy = {60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400,150,150,200,200,200,200};
		//the name of the spaces with titledeeds
	    String[] tdPlaces = {"Germania Inferior","Germania Superior","Alpes Poeniae","Alpes Cottiae","Aples Maritimae","Aquitania","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia","Sewers","Aqueducts","Via Appia","Via Flaminia","Via Aemilia","Via Popillia",""};
		//title deed card image names
		String[] tdimages = {"Purple_GermaniaI","Purple_GermaniaS","BBlue_APoeniae","BBlue_ACottiae","BBlue_AMaritimae","DPink_Aquitania","DPink_Belgica","DPink_Raetia","Orange_AProconsularis","Orange_Asia","Orange_Britannia","Red_Cilicia","Red_Galatia","Red_Cappadocia","Yellow_Aegyptus","Yellow_APetraea","Yellow_Syria","Green_Macedonia","Green_Epirus","Green_Achaia","Blue_Sicilia", "Blue_Italia","Utility_Sewers","Utility_Aqueducts","Via_Appia","Via_Flaminia","Via_Aemilia","Via_Popillia",""};
	    
public Buy() {
			//ttbuy = tdBuy[titledeed];
			//set mortgage
			 if ((ttbuy != 0) && (buymort == 1)) {
				tdmort = (ttbuy/2);
				Bal -= tdmort;
				System.out.println("-Place: "+tdPlaces[titledeed]+", Mortgage: "+Bal+" - "+tdmort);
			} //balance cannot be lower than property
			 if(buymort == 0) {
				 //set buy
				System.out.println("-Place: "+tdPlaces[titledeed]+", Pay: "+Bal+" - "+ttbuy);
				Bal -= ttbuy;
			} //balance cannot be lower than property
			//lock the item as bought and by which player
			thePlayer.setBalance(Bal);
			System.out.println("Player's balance: "+thePlayer.getBalance());
		}
}