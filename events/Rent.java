package events;
//import events.Turn;
//import events.Players;
//import events.Buy;
//import tile.*;

public class Rent {
	int Pos;   //Pos in Turn
	int rent;  //regular rent
	int grent; //group rent
	int group; //group number
	int diet;  //total dice roll from Board, after Turn
	int bought;//make sure owner[Pos] == 1 in Board
	public Rent() {
		Paytheman();
	}
	public Rent(int group, int rent, int grent) {
		this.group = group;
		this.rent = rent;
		this.grent = grent;
	}
	public void Paytheman() {
	// Pos, name, group, rent, group rent
		if (Pos == 1) {
		group = 1;
		rent = 2;
		grent = 2*rent; //Germania Inferior
		}
		if (Pos == 3) {
		group = 1;
		rent = 4;
		grent = 2*rent; //Germania Superior
		}
		if (Pos == 6) {
		group = 2;
		rent = 6;
		grent = 2*rent; //Alps Poeniae
		}
	    if (Pos == 8) {
		group = 2;
		rent = 6;
		grent = 2*rent; //Alps Cottiae
		}
		if (Pos == 9) {
		group = 2;
		rent = 8;
		grent = 2*rent; //Alps Maritimae
		}
		if (Pos == 12) {
		group = 3;
		rent = 10;
		grent = 2*rent; //Aquitina
		}
		if (Pos == 13) {
		group = 3;
		rent = 10;
		grent = 2*rent; //Belgice
		}
		if (Pos == 15) {
		group = 3;
		rent = 12;
		grent = 2*rent; //Raetia
		}
		if (Pos == 17) {
		group = 4;
		rent = 14;
		grent = 2*rent; //Africa Proconsularis
		}
		if (Pos == 19) {
		group = 4;
		rent = 14;
		grent = 2*rent; //Asia
		}
		if (Pos == 20) {
		group = 4;
		rent = 16;
		grent = 2*rent; //Britannia
		}
		if (Pos == 22) {
		group = 5;
		rent = 18;
		grent = 2*rent; //Cilicia
		}
		if (Pos == 24) {
		group = 5;
		rent = 18;
		grent = 2*rent; //Galatia
		}
		if (Pos == 25) {
		group = 5;
		rent = 20;
		grent = 2*rent; //Cappadocia
		}
		if (Pos == 27) {
		group = 6;
		rent = 22;
		grent = 2*rent; //Aegyptus
		}
		if (Pos == 28) {
		group = 6;
		rent = 22;
		grent = 2*rent; //Arabia Petraea
		}
		if (Pos == 30) {
		group = 6;
		rent = 24;
		grent = 2*rent; //Arabia Petraea
		}
		if (Pos == 32) {
		group = 7;
		rent = 26;
		grent = 2*rent; //Macedonia
		}
		if (Pos == 33) {
		group = 7;
		rent = 26;
		grent = 2*rent; //Epirus
		}
		if (Pos == 35) {
		group = 7;
		rent = 28;
		grent = 2*rent; //Achaia
		}
		if (Pos == 38) {
		group = 8;
		rent = 35;
		grent = 2*rent; //Sicilia
		}
		if (Pos == 40) {
		group = 8;
		rent = 50;
		grent = 2*rent; //Italia
		}
		if (Pos == 5 || Pos == 16 || Pos == 26 || Pos == 36) {
		group = 9;
		rent = 25;  //50, 100, 200
		grent = 2*rent; //Vias
		}
		if (Pos == 13) {
		group = 10;
		rent = 4*diet;
		grent = 10*diet; //Sewers
		}
		if (Pos == 29) {
		group = 10;
		rent = 4*diet;
		grent = 10*diet; //Aquaducts
		}
	}//end of pay the man
	public int getGroup() {return group;}
	public int getRent() {return rent;}
	public int getGRent() {return grent;}
}