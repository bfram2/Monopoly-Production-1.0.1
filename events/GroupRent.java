package events;
//import events.Turn;
//import events.Players;
//import events.Buy;
import tile.Properties;
import tile.Utilities;
import tile.Vias;

//import tile.Properties;
//import tile.Utilities;
//import tile.Vias;

public class GroupRent {
	int owned = 0; //counts owned poperties in group
	int Pos;   //Pos in Turn
	int rent;  //regular rent
	int group; //group number
	int diet;  //total dice roll from Board, after Turn
	
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
	public GroupRent() {
		Paytheman();
	}
	public GroupRent(int rent) {
		this.rent = rent;
	}
	public void Paytheman() {
	owned = 0; //reset to blank
		if (Pos == 1) {
		group = 1; //Germania Inferior
		owned = regions[0].getOwner() + regions[1].getOwner(); //or go by group number
		   if (owned == 2) {
			   rent = 2*2;
		   } else {
			   rent = 2;
		   }
		}
		if (Pos == 3) {
		group = 1; //Germania Superior
		//owned = regions[Pos=1].owners + regions[Pos=3].owners; //or go by group number
		owned = regions[0].getOwner() + regions[1].getOwner(); //or go by group number
		   if (owned == 2) {
			   rent = 2*4;
		   } else {
			   rent = 4;
		   }
		
		}
		if (Pos == 6 || Pos == 8) {
		group = 2; //Alps Poeniae & Alps Cottiae
		owned = regions[2].getOwner() + regions[3].getOwner() + regions[4].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*6;
		   } else {
			   rent = 6;
		   }
		}
		if (Pos == 9) {
		group = 2; //Alps Maritimae
		owned = regions[2].getOwner() + regions[3].getOwner() + regions[4].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*8;
		   } else {
			   rent = 8;
		   }
		}
		if (Pos == 12 || Pos == 13) {
		group = 3; //Aquitina & Belgice
		owned = regions[5].getOwner() + regions[6].getOwner() + regions[7].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*10;
		   } else {
			   rent = 10;
		   }
		}
		if (Pos == 15) {
		group = 3; //Raetia
		owned = regions[5].getOwner() + regions[6].getOwner() + regions[7].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*12;
		   } else {
			   rent = 12;
		   }
		}
		if (Pos == 17 || Pos == 19) {
		group = 4; //Africa Proconsularis & Asia
		owned = regions[8].getOwner() + regions[9].getOwner() + regions[10].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*14;
		   } else {
			   rent = 14;
		   }
		}
		if (Pos == 20) {
		group = 4; //Britannia
		owned = regions[8].getOwner() + regions[9].getOwner() + regions[10].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*16;
		   } else {
			   rent = 16;
		   }
		}
		if (Pos == 22 || Pos == 24) {
		group = 5; //Cilicia & Galatia
		owned = regions[11].getOwner() + regions[12].getOwner() + regions[13].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*18;
		   } else {
			   rent = 18;
		   }
		}
		if (Pos == 25) {
		group = 5; //Cappadocia
		owned = regions[11].getOwner() + regions[12].getOwner() + regions[13].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*20;
		   } else {
			   rent = 20;
		   }
		}
		if (Pos == 27 || Pos == 28) {
		group = 6; //Aegyptus & Arabia Petraea
		owned = regions[14].getOwner() + regions[15].getOwner() + regions[16].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*22;
		   } else {
			   rent = 22;
		   }
		}
		if (Pos == 30) {
		group = 6; //Arabia Petraea
		owned = regions[14].getOwner() + regions[15].getOwner() + regions[16].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*24;
		   } else {
			   rent = 24;
		   }
		}
		if (Pos == 32 || Pos == 33) {
		group = 7; //Macedonia & Epirus
		owned = regions[17].getOwner() + regions[18].getOwner() + regions[19].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*26;
		   } else {
			   rent = 26;
		   }
		}
		if (Pos == 35) {
		group = 7; //Achaia
		owned = regions[17].getOwner() + regions[18].getOwner() + regions[19].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*28;
		   } else {
			   rent = 28;
		   }
		}
		if (Pos == 38) {
		group = 8; //Sicilia
		owned = regions[20].getOwner() + regions[21].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*35;
		   } else {
			   rent = 35;
		   }
		}
		if (Pos == 40) {
		group = 8; //Italia
		owned = regions[20].getOwner() + regions[21].getOwner(); //or go by group number
		   if (owned == 3) {
			   rent = 2*50;
		   } else {
			   rent = 50;
		   }
		}
		if (Pos == 5 || Pos == 16 || Pos == 26 || Pos == 36) {
		group = 10; //Vias
		owned = roads[0].getOwner() + roads[1].getOwner() + roads[2].getOwner() + roads[3].getOwner(); //or go by group number
		   if (owned == 1) {
			   rent = 25;
		   }
		   if (owned == 2) {
			   rent = 2*25;
		   }
		   if (owned == 3) {
			   rent = 4*25;
		   }
		   if (owned == 4) {
			   rent = 8*25;
		   }
		}
		if (Pos == 13 || Pos == 29) {
		group = 10; //Sewers & Aquaducts
		owned = services[0].getOwner() + services[1].getOwner(); //or go by group number
		   if (owned == 1) {
		   rent = 4*diet; //pull in dice total
		   }
		   if (owned == 2) {
		   rent = 10*diet;
		   }
		}
	}//end of pay the man
	public int getRent() {return rent;}
}