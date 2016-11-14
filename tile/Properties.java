package tile;

public class Properties {
	
	public int tileNumber;
	public String name;
	private String imgname;
	private int group;
	private int cost;
	private int mortgage;
	private int owner;
	private int villas;
	private int pantheons;
	private int singleRent;
	private int groupRent;
	
	
	
	public Properties(int tileNumber,String name, String imgname, int group,int cost,int mortgage,int owner,int villas,int pantheons,int singleRent,int groupRent){
		//tileNumber is the number of the property in order starting with Go as 0
		//name is the name of the property
		//group is the color grouping which have been assigned numbers 1-10
		//cost is the initial purchase price
		//mortgage is the amount a player can have added to their bank by mortgaging the property
		//owner is the player who currently owns the property, which is broken down into numbers so this will have to reflect somewhere in the player class
		//houses is the number of houses on the property defaulted to 0
		//hotels is the number of hotels on the property defaulted to 0
		//rent is the amount of rent for the single property without houses, hotels or grouping bonus
		tileNumber = this.tileNumber;
		name = this.name;
		imgname = this.imgname;
		group = this.group;
		cost = this.cost;
		mortgage = this.mortgage;
		owner = this.owner;
		villas = this.villas;
		pantheons = this.pantheons;
		singleRent = this.singleRent;
		groupRent =this.groupRent;
	}
	public static int getTile(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int tn= findByIndex.tileNumber;
		return tn;
	}
	public static String getImgName(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		String in= findByIndex.imgname;
		return in;
	}
	public static String getName(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		String n= findByIndex.name;
		return n;
	}
	public static int getGroup(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int g= findByIndex.group;
		return g;
	}
	public static int getCost(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int c= findByIndex.cost;
		return c;
	}
	public static int getMortgage(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int m= findByIndex.mortgage;
		return m;
	}
	public static int getOwner(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int o = findByIndex.owner;
		return o;
	}
	public static int getVillas(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int v= findByIndex.villas;
		return v;
	}
	public static int getPantheons(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int p= findByIndex.pantheons;
		return p;
	}
}
//Title Deed Cards
/*
Title Deed Colors
Purple #44235A rgb(68,35,90)
Baby Blue #C4C8E5 (196,200,229)
Dark Pink #A72758 (167,39,88)
Orange #F19749 (241,151,73)
Red #E22835 (226,40,53)
Yellow #F8F37B (248,243,123)
Green #448364 (68,131,100)
Blue #413382 (65,51,130)
*/

/* 
Germania Inferior: Rent $2, With 1 Villa $10, With 2 Villas $30, With 3 Villas $90 With 4 Villas $160, with Pantheon $250, Mortgage Value $30, Houses cost $50 each, Hotels: $50 each plus 4 houses
Germania Superior: Rent $4, With 1 Villa $20, With 2 Villas $60, With 3 Villas $180 With 4 Villas $320, with Pantheon $450, Mortgage Value $30, Houses cost $50 each, Hotels: $50 each plus 4 houses
Alpes Poeniae: Rent $6, With 1 Villa $30, With 2 Villas $90, With 3 Villas $270 With 4 Villas $400, with Pantheon $550, Mortgage Value $50, Houses cost $50 each, Hotels: $50 each plus 4 houses
Alpes Cottiae: Rent $6, With 1 Villa $30, With 2 Villas $90, With 3 Villas $270 With 4 Villas $400, with Pantheon $550, Mortgage Value $50, Houses cost $50 each, Hotels: $50 each plus 4 houses
Aples Maritimae: Rent $8, With 1 Villa $40, With 2 Villas $100, With 3 Villas $300 With 4 Villas $450, with Pantheon $600, Mortgage Value $60, Houses cost $50 each, Hotels: $50 each plus 4 houses
Aquitania: Rent $10, With 1 Villa $50, With 2 Villas $150, With 3 Villas $450 With 4 Villas $625, with Pantheon $750, Mortgage Value $70, Houses cost $100 each, Hotels: $100 each plus 4 houses
Belgica: Rent $10, With 1 Villa $50, With 2 Villas $150, With 3 Villas $450 With 4 Villas $625, with Pantheon $750, Mortgage Value $70, Houses cost $100 each, Hotels: $100 each plus 4 houses
Raetia: Rent $12, With 1 Villa $60, With 2 Villas $180, With 3 Villas $500 With 4 Villas $700, with Pantheon $900, Mortgage Value $80, Houses cost $100 each, Hotels: $100 each plus 4 houses
Africa Proconsularis: Rent $14, With 1 Villa $70, With 2 Villas $200, With 3 Villas $550 With 4 Villas $750, with Pantheon $950, Mortgage Value $90, Houses cost $100 each, Hotels: $100 each plus 4 houses
Asia: Rent $14, With 1 Villa $70, With 2 Villas $200, With 3 Villas $550 With 4 Villas $750, with Pantheon $950, Mortgage Value $90, Houses cost $100 each, Hotels: $100 each plus 4 houses
Britannia: Rent $16, With 1 Villa $80, With 2 Villas $220, With 3 Villas $600 With 4 Villas $800, with Pantheon $1000, Mortgage Value $100, Houses cost $100 each, Hotels: $100 each plus 4 houses
Cilicia: Rent $18, With 1 Villa $90, With 2 Villas $250, With 3 Villas $700 With 4 Villas $875, with Pantheon $1050, Mortgage Value $110, Houses cost $150 each, Hotels: $150 each plus 4 houses
Galatia: Rent $18, With 1 Villa $90, With 2 Villas $250, With 3 Villas $700 With 4 Villas $875, with Pantheon $1050, Mortgage Value $110, Houses cost $150 each, Hotels: $150 each plus 4 houses
Cappadocia: Rent $20, With 1 Villa $100, With 2 Villas $300, With 3 Villas $750 With 4 Villas $925, with Pantheon $1100, Mortgage Value $120, Houses cost $150 each, Hotels: $150 each plus 4 houses
Aegyptus: Rent $22, With 1 Villa $110, With 2 Villas $330, With 3 Villas $800 With 4 Villas $975, with Pantheon $1150, Mortgage Value $130, Houses cost $150 each, Hotels: $150 each plus 4 houses 
Arabia Petraea: Rent $22, With 1 Villa $110, With 2 Villas $330, With 3 Villas $800 With 4 Villas $975, with Pantheon $1150, Mortgage Value $130, Houses cost $150 each, Hotels: $150 each plus 4 houses
Syria: Rent $24, With 1 Villa $120, With 2 Villas $360, With 3 Villas $850 With 4 Villas $1025, with Pantheon $1200, Mortgage Value $140, Houses cost $150 each, Hotels: $150 each plus 4 houses
Macedonia: Rent $26, With 1 Villa $130, With 2 Villas $390, With 3 Villas $900 With 4 Villas $1100, with Pantheon $1275, Mortgage Value $150, Houses cost $200 each, Hotels: $200 each plus 4 houses
Epirus: Rent $26, With 1 Villa $130, With 2 Villas $390, With 3 Villas $900 With 4 Villas $1100, with Pantheon $1275, Mortgage Value $150, Houses cost $200 each, Hotels: $200 each plus 4 houses
Achaia: Rent $28, With 1 Villa $150, With 2 Villas $450, With 3 Villas $1000 With 4 Villas $1200, with Pantheon $1400, Mortgage Value $160, Houses cost $200 each, Hotels: $200 each plus 4 houses
Sicilia: Rent $35, With 1 Villa $175, With 2 Villas $500, With 3 Villas $1100 With 4 Villas $1300, with Pantheon $1500, Mortgage Value $175, Houses cost $200 each, Hotels: $200 each plus 4 houses 
Italia: Rent $50, With 1 Villa $200, With 2 Villas $600, With 3 Villas $1400 With 4 Villas $1700, with Pantheon $2000, Mortgage Value $200, Houses cost $200 each, Hotels: $200 each plus 4 houses 
*/