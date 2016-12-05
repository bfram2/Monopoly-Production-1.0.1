//start the game
import menu.MainMenu;

import tile.Properties;

import events.*;
import pieces.*;

public class StartGame {
	//main
	public static void main(String args[]) {
		Properties [] regions = new Properties [41];
		regions [0] = new Properties(0,"Go",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [1] = new Properties(1,"Germania Inferior","Purple_GermaniaI.PNG",1,60,30,0,36,0,0,0,2,4,0,0,0,true,true);
	    regions [2] = new Properties(2,"Community Chest",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [3] = new Properties(3,"Germania Superior","Purple_GermaniaS.PNG",1,60,30,0,36,0,0,0,4,8,0,0,0,true,true);
	    regions [4] = new Properties(4,"Render Unto Ceasar",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [5] = new Properties(5,"Via Appia","Via_Appia.PNG",9,200,100,0,60,0,0,0,100,0,200,300,400,true,false);
	    regions [6] = new Properties(6,"Alps Poeniae","BBlue_APoeniae.PNG",2,100,50, 0,60,0,0,0,6,12,0,0,0,true,true);
	    regions [7] = new Properties(7,"Chance",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [8] = new Properties(8,"Alps Cottiae","BBlue_ACottiae.PNG",2,100,50,0,60,0,0,0,6,12,0,0,0,true,true);
	    regions [9] = new Properties(9,"Alps Maritimae","BBlue_AMaritimae.PNG",2,120,60,0,72,0,0,0,8,16,0,0,0,true,true);
	    regions [10] = new Properties(10,"See a battle",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [11] = new Properties(11,"Gladitorial Arena",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [12] = new Properties(12,"Aquitanina","DPink_Aquitania.PNG",3,140,70,0,84,0,0,0,10,20,0,0,0,true,true);
	    regions [13] = new Properties(13,"Sewers","Utility_Sewers.PNG",10,150,75,0,90,0,0,0,0,0,0,0,0,true,false);
	    regions [14] = new Properties(14,"Belgica","DPink_Belgica.PNG",3,140,70,0,84,0,0,0,10,20,0,0,0,true,true); 
	    regions [15] = new Properties(15,"Raetia","DPink_Raetia.PNG",3,160,80,0,96,0,0,0,12,24,0,0,0,true,true);
	    regions [16] = new Properties(16,"Via Flaminia","Via_Flaminia.PNG",9,200,100,0,60,0,0,0,100,0,200,300,400,true,false);
	    regions [17] = new Properties(17,"Africa Proconsularis","Orange_AProconsularis.PNG",4,180,90,0,108,0,0,0,14,28,0,0,0,true,true);
	    regions [18] = new Properties(18,"Community Chest",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false); 
	    regions [19] = new Properties(19,"Asia","Orange_Asia.PNG",4,180,90,0,108,0,0,0,14,28,0,0,0,true,true);
	    regions [20] = new Properties(20,"Britannia","Orange_Britannia.PNG",4,200,100,0,120,0,0,0,16,32,0,0,0,true,true); 
	    regions [21] = new Properties(21,"Free Market",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [22] = new Properties(22,"Cilicia","Red_Cilicia.PNG",5,220,110,0,132,0,0,0,18,32,0,0,0,true,true);
	    regions [23] = new Properties(23,"Chance",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [24] = new Properties(24,"Galatia","Red_Galatia.PNG",5,220,110,0,132,0,0,0,18,32,0,0,0,true,true);
	    regions [25] = new Properties(25,"Cappadocia","Red_Cappadocia.PNG",5,240,120,0,144,0,0,0,20,40,0,0,0,true,true);
	    regions [26] = new Properties(26,"Via Aemilia","Via_Aemilia.PNG",9,200,100,0,60,0,0,0,100,0,200,300,400,true,false);
	    regions [27] = new Properties(27,"Aegyptus","Yellow_Aegyptus.PNG",6,260,130,0,156,0,0,0,22,44,0,0,0,true,true);
	    regions [28] = new Properties(28,"Arabia Petraea","Yellow_APetraea.PNG",6,260,130,0,156,0,0,0,22,44,0,0,0,true,true);
	    regions [29] = new Properties(29,"Aquaducts","Utility_Aqueducts.PNG",10,150,75,0,90,0,0,0,0,0,0,0,0,true,false);
	    regions [30] = new Properties(30,"Syria","Yellow_Syria.PNG",6,280,140,0,168,0,0,0,24,48,0,0,0,true,true);
	    regions [31] = new Properties(31,"Go to the Arena",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [32] = new Properties(32,"Macedonia","Green_Macedonia.PNG",7,300,150,0,180,0,0,0,26,52,0,0,0,true,true);
	    regions [33] = new Properties(33,"Epirus","Green_Epirus.PNG",7,300,150,0,180,0,0,0,26,52,0,0,0,true,true);
	    regions [34] = new Properties(34,"Community Chest",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [35] = new Properties(35,"Achaia","Green_Achaia.PNG",7,320,160,0,192,0,0,0,28,56,0,0,0,true,true);
	    regions [36] = new Properties(36,"Via Popilia","Via_Popillia.PNG",9,200,100,0,60,0,0,0,100,0,200,300,400,true,false);
	    regions [37] = new Properties(38,"Chance",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [38] = new Properties(38,"Sicilia","Blue_Sicilia.PNG",8,350,175,0,280,0,0,0,35,70,0,0,0,true,true);
	    regions [39] = new Properties(21,"Citizen's Tax",null,11,0,0,0,0,0,0,0,0,0,0,0,0,false,false);
	    regions [40] = new Properties(40,"Italia","Blue_Italia.PNG",8,400,200,0,240,0,0,0,50,100,0,0,0,true,true);
	    //tileNumber = Pos, name, image name, group, cost, mortgage, owner, houses, hotels, rent, group rent
	    
	    
	    Players [] people = new Players [8];
	    people [0] = new Players("Player I", 1, "Token_E.png", 0,false, 0, 0, 0, 1500, true,0);
	    people [1] = new Players("Player II", 2, "Token_H.png", 0, false, 0, 0, 0, 1500, false,0);
	    people [2] = new Players("Player III", 3, "Token_S1.png", 0,false, 0, 0, 0, 1500, false,0);
	    people [3] = new Players("Player IV", 4, "Token_S2.png", 0, false,0, 0, 0, 1500, false,0);
	    people [4] = new Players("Player V", 5, "Token_S3.png", 0, false,0, 0, 0, 1500, false,0);
	    people [5] = new Players("Player VI", 6, "Token_Sen.png", 0,false, 0, 0, 0, 1500, false,0);
	    people [6] = new Players("Player VII", 7, "Token_W1.png", 0, false,0, 0, 0, 1500, false,0);
	    people [7] = new Players("Player VIII", 8, "Token_W2.png", 0,false,0,0,0, 1500, false,0);
	    
	//Turn theTurn = new Turn();
	@SuppressWarnings("unused")
	Board theBoad = new Board(regions, people);
	new MainMenu(); //open menu page
	}
	
}