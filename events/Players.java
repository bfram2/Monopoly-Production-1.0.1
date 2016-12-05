package events;
//Switch between player and computer player
//Use images of the dollar bills or money counter with just the digits ie. 100.00 denarius
//int k = 0; //doubles counter
//int j = 0; //jail counter
//int oj = 0; //out of jail counter
public class Players {
	private String name;
	private int playerNumber;
	private String token;
	private int position;
	private boolean owner;
	private int balance;
	private int k, j;
	private int oj;
	boolean currentPlayer;
	int jailCounter;
	String player;

	public Players() {
        name = "Player";       //default name, update from menu
        token = "Token_W1.png"; //default image, update from menu
        position = 0;          //update from Prev in Board
        balance = 1500;        //update from Bal in Board
        k = 0;                 //counters
        j = 0;
        oj = 0;	
        
        player = (name+token+position+balance);
	}
	
	public Players(String name, int playerNumber, String token, int position, boolean owner, int k, int j, int oj, int balance, boolean currentPlayer, int jailCounter) {
	        this.name = name;
	        this.playerNumber = playerNumber;
	        this.token = token;
	        this.position = position;
	        this.balance = balance;
	        this.owner = owner;
	        this.k = k;
	        this.j = j;
	        this.oj = oj;
	        this.currentPlayer = currentPlayer;
	        this.jailCounter = jailCounter;
	}
	public int getDoubles() {return k;}
	public void setDoubles(int k) {this.k = k;}
	
	public int getJail() {return j;}
	public void setJail(int j) {this.j = j;}
	
	public int getOutJail() {return oj;}
	public void setOutJail(int oj) {this.oj = oj;}
		
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getPlayerNumber(){
		return this.playerNumber;
	}
	public String getToken() {return token;}
	public void setToken(String token) {this.token = token;}
	
	public int getK(){
		return this.k;
	}
	public int getJ(){
		return this.j;
	}
	public int getOJ(){
		return this.oj;
	}
	public int getPosition() {return position;}
	public void setPosition(int position) {this.position = position;}
	
	public boolean getOwner() {
		return owner;
	}
	public void setOwner(boolean owner) {
		this.owner = owner;
	}
	
	public int getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
	
	public boolean getCurrentPlayer(){
		return currentPlayer;
	}
	public int getJailCounter(){
		return jailCounter;
	}
	public void setJailCounter(int jailCounter){
		this.jailCounter = jailCounter;
	}
}

//Switching between Player and Computer Players in the amount choosen in the main menu
//each player starts with 1500 denarius
//Player 1 is first
//Start at Rome
//Roll, move that number of spaces
//buy, pay rent, draw card, pay taxes or go to the arena
//buy villas or pantheon
//end turn button
//Player 2, repeat onward
/* Later may have multiple players with computer players */