package tile;
import pieces.*;


public class Utilities {

	public int tileNumber;
	private String name;
	private String imageName;
	private int group;
	private int cost;
	private int mortgage;
	private int owner;
	
	public Utilities(int tn, String n, String in, int g, int c, int m, int o){
		//tileNumber is the number of the property in order starting with Go as 0
		//name is the name of the property
		//group is the color grouping which have been assigned numbers 1-10
		//cost is the initial purchase price
		//mortgage is the amount a player can have added to their bank by mortgaging the property
		//owner is the player that owns the property with 0 as the default no owner/bank owned
		
		this.tileNumber = tn;
		this.name = n;
		this.imageName = in;
		this.group = g;
		this.cost = c;
		this.mortgage = m;
		this.owner = o;
	}
	public  int getTile(){
		return this.tileNumber;
	}
	public String getName(){
		return this.name;
	}
	public String getImageName(){
		return this.imageName;
	}
	public int getGroup(){
		return this.group;
	}
	public int getCost(){
		return this.cost;
	}
	public int getMortgage(){
		return this.mortgage;
	}
	public int getOwner(){
		return this.owner;
	}
	public int setOnwer(){
		return this.owner;
		//this will have to be changed to take info to change the owner
	}
	public static int calcSingleRent(Dice currentRoll){
		int totalValue = currentRoll.getTotal();
		int singleRent = totalValue * 4;
		return singleRent;
	}
	public static int calcGroupRent(Dice currentRoll){
		int totalValue = currentRoll.getTotal();
		int groupRent = totalValue * 10;
		return groupRent;
	}
}