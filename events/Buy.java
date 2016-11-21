package events;
//import events.Players;
//import pieces.Board;

import tile.Properties;
import tile.Utilities;
import tile.Vias;

public class Buy {
		Properties [] regions = new Properties [22]; {
	    regions [0] = new Properties(1,"Germania Inferior","Purple_GermaniaI.PNG", 1, 60, 30, 0, 0, 0, 2, 4);
	    regions [1] = new Properties(3,"Germania Superior","Purple_GermaniaS.PNG",1,60,30,0,0,0,4,8);
	    regions [2] = new Properties(6,"Alps Poeniae","BBlue_APoeniae.PNG",2,100,50,0,0,0,6,12);
	    regions [3] = new Properties(8,"Alps Cottiae","BBlue_ACottiae.PNG",2,100,50,0,0,0,6,12);
	    regions [4] = new Properties(9,"Alps Maritimae","BBlue_AMaritimae.PNG",2,120,60,0,0,0,8,16);
	    regions [5] = new Properties(12,"Aquitina","DPink_Aquitania.PNG",3,140,70,0,0,0,10,20);
	    regions [6] = new Properties(13,"Belgice","DPink_Belgica.PNG",3,140,70,0,0,0,10,20);
	    regions [7] = new Properties(15,"Raetia","DPink_Raetia.PNG",3,160,80,0,0,0,12,24);
	    regions [8] = new Properties(17,"Africa Proconsularis","Orange_AProconsularis.PNG",4,180,90,0,0,0,14,28);
	    regions [9] = new Properties(19,"Asia","Orange_Asia.PNG",4,180,90,0,0,0,14,28);
	    regions [10] = new Properties(20,"Britannia","Orange_Britannia.PNG",4,200,100,0,0,0,16,32);  
	    regions [11] = new Properties(22,"Cilicia","Red_Cilicia.PNG",5,220,110,0,0,0,18,32);
	    regions [12] = new Properties(24,"Galatia","Red_Galatia.PNG",5,220,110,0,0,0,18,32);
	    regions [13] = new Properties(25,"Cappadocia","Red_Cappadocia.PNG",5,240,120,0,0,0,20,40);
	    regions [14] = new Properties(27,"Aegyptus","Yellow_Aegyptus.PNG",6,260,130,0,0,0,22,44);
	    regions [15] = new Properties(28,"Arabia Petraea","Yellow_APetraea.PNG",6,260,130,0,0,0,22,44);
	    regions [16] = new Properties(30,"Suria","Yellow_Syria.PNG",6,280,140,0,0,0,24,48);
	    regions [17] = new Properties(32,"Macedonia","Green_Macedonia.PNG",7,300,150,0,0,0,26,52);
	    regions [18] = new Properties(33,"Epirus","Green_Epirus.PNG",7,300,150,0,0,0,26,52);
	    regions [19] = new Properties(35,"Achaia","Green_Achaia.PNG",7,320,160,0,0,0,28,56);
	    regions [20] = new Properties(38,"Sicilia","Blue_Sicilia.PNG",8,350,175,0,0,0,35,70);
	    regions [21] = new Properties(40,"Italia","Blue_Italia.PNG",8,400,200,0,0,0,50,100);
	    //tileNumber = Pos, name, image name, group, cost, mortgage, owner, houses, hotels, rent, group rent
	    }
	    Vias [] roads = new Vias [4]; {
	    roads [0] = new Vias(5,"Via Appia","Via_Appia.PNG",10,200,100,0,100,200,300,400);
	    roads [1] = new Vias(16,"Via Flaminia","Via_Flaminia.PNG",10,200,100,0,100,200,300,400);
	    roads [2] = new Vias(26,"Via Aemilia","Via_Aemilia.PNG",10,200,100,0,100,200,300,400);
	    roads [3] = new Vias(36,"Via Popilia","Via_Popillia.PNG",10,200,100,0,100,200,300,400);
	    }
	    Utilities [] services = new Utilities [22]; { 
	    services [0] = new Utilities(13,"Sewers","Utility_Sewers.PNG",10,150,75,0);
	    services [1] = new Utilities(29,"Aquaducts","Utility_Aqueducts.PNG",10,150,75,0);
	    }
	    
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