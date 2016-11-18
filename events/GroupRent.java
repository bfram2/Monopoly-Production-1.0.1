package events;
import events.Turn;
import events.Players;
import event.Buy;

//import tile.Properties;
//import tile.Utilities;
//import tile.Vias;

public class GroupRent {
	int owned = 0;
	int Pos;   //Pos in Turn
	int rent;  //regular rent
	int grent; //group rent
	int group; //group number
	int diet;  //total dice roll from Board, after Turn
	int bought;//make sure owner[Pos] == 1 in Board
	public GroupRent() {
		Paytheman();
	}
	public GroupRent(int grent) {
		this.grent = grent;
	}
	public void Paytheman() {
	owned = 0; //reset to blank
		if (Pos == 1) {
		group = 1; //Germania Inferior
		rent = 2;
		//owned = regions[Pos=1].owners + regions[Pos=3].owners; //or go by group number
		   if (owned == 2) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 3) {
		group = 1; //Germania Superior
		rent = 4;
		//owned = regions[Pos=1].owners + regions[Pos=3].owners; //or go by group number
		   if (owned == 2) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 6 || Pos == 8) {
		group = 2; //Alps Poeniae & Alps Cottiae
		rent = 6;
		//owned = regions[Pos=6].owners + regions[Pos=8].owners + regions[Pos=9].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 9) {
		group = 2; //Alps Maritimae
		rent = 8;
		//owned = regions[Pos=6].owners + regions[Pos=8].owners + regions[Pos=9].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 12 || Pos == 13) {
		group = 3; //Aquitina & Belgice
		rent = 10;
		//owned = regions[Pos=12].owners + regions[Pos=13].owners + regions[Pos=15].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 15) {
		group = 3; //Raetia
		rent = 12;
		//owned = regions[Pos=12].owners + regions[Pos=13].owners + regions[Pos=15].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 17 || Pos == 19) {
		group = 4; //Africa Proconsularis & Asia
		rent = 14;
		//owned = regions[Pos=17].owners + regions[Pos=19].owners + regions[Pos=20].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 20) {
		group = 4; //Britannia
		rent = 16;
		//owned = regions[Pos=1].owners + regions[Pos=3].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 22 || Pos == 24) {
		group = 5; //Cilicia & Galatia
		rent = 18;
		//owned = regions[Pos=22].owners + regions[Pos=24].owners + regions[Pos=25].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 25) {
		group = 5; //Cappadocia
		rent = 20;
		//owned = regions[Pos=22].owners + regions[Pos=24].owners + regions[Pos=25].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 27 || Pos == 28) {
		group = 6; //Aegyptus & Arabia Petraea
		rent = 22;
		//owned = regions[Pos=27].owners + regions[Pos=28].owners + regions[Pos=30].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 30) {
		group = 6; //Arabia Petraea
		rent = 24;
		//owned = regions[Pos=27].owners + regions[Pos=28].owners + regions[Pos=30].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 32 || Pos == 33) {
		group = 7; //Macedonia & Epirus
		rent = 26;
		//owned = regions[Pos=32].owners + regions[Pos=33].owners + regions[Pos=35].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 35) {
		group = 7; //Achaia
		rent = 28;
		//owned = regions[Pos=32].owners + regions[Pos=33].owners + regions[Pos=35].owners; //or go by group number
		   if (owned == 3) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 38) {
		group = 8; //Sicilia
		rent = 35;
		//owned = regions[Pos=38].owners + regions[Pos=40].owners; //or go by group number
		   if (owned == 2) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 40) {
		group = 8; //Italia
		rent = 50;
		//owned = regions[Pos=38].owners + regions[Pos=40].owners; //or go by group number
		   if (owned == 2) {
		   grent = 2*rent;
		   }
		}
		if (Pos == 5 || Pos == 16 || Pos == 26 || Pos == 36) {
		group = 9; //Vias
		rent = 25;
		//owned = regions[Pos=5].owners + regions[Pos=16].owners + regions[Pos=26].owners + regions[Pos=36].owners; //or go by group number
		   if (owned == 1) {
		   grent = rent;
		   }
		   if (owned == 2) {
		   grent = 2*rent;
		   }
		   if (owned == 3) {
		   grent = 4*rent;
		   }
		   if (owned == 4) {
		   grent = 8*rent;
		   }
		}
		if (Pos == 13 || Pos == 29) {
		group = 10; //Sewers & Aquaducts
		//owned = regions[Pos=1].owners + regions[Pos=3].owners; //or go by group number
		   if (owned == 1) {
		   grent = 4*diet;
		   }
		   if (owned == 2) {
		   grent = 10*diet;
		   }
		}
	}//end of pay the man
	public int getGRent() {return grent;}
}
