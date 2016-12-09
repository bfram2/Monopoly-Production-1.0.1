package pieces;
//Loading the board [fonts for board.jpg: Verdana 8pt, 6pt, 11pt bold]
import javax.swing.*;
import java.awt.*;
//import java.awt.event.MouseAdapter; //debugging tokens
//import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import menu.HelpMenu;
import events.*;
import own.*;
import pieces.Dice;
import tile.Properties;

public class Board extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton rolling, buying, mortgage, unmortgage, improve, simprove, ending, mmenu, hmenu, token1, token2, token3, token4, token5, token6, token7, token8, plbtn, chabtn, statusbtn, dicez, dice2thereckoning, tdbtn, sell, trade;

	JFrame boardFrame = new JFrame("Stats");
	JPanel stats = new JPanel();
	Turn theTurn = new Turn(); //pulling player's turn

	int turnCounter = 0; //counter to switch players
	int buymort = 0; //counter for buy or mortgage
	int Pos;
	public int Prev; //board positions
	int k = 0; //doubles counter
	//int j = 0; //jail counter
	String statustxt = " ";
	String tdowned = " "; //print owned spaces
	String tdmort = " "; //print mortgaged spaces
	String printVillas = " "; //print the properties with villas
	int newSecondPlayerBalance = 0; //sell and trade secondary player
	int dice1 = 1; //dice 1 and 2 updated by dice class
	int dice2 = 1;
	int diet; //total of dice 1 and dice2
	Properties [] prop; //property objects, 41
	Players [] play; //players objects, 8
     
	//token movement setBounds(x[Pos],y[Pos])
    int[] x = {9,96,152,208,264,320,376,432,488,544,660,600,600,600,600,600,600,600,600,600,600,600,543,488,432,376,320,264,208,152,96,9,52,52,52,52,52,52,52,52,52};
    int[] y = {11,11,11,11,11,11,11,11,11,11,1,35,97,154,209,265,322,377,432,490,544,601,601,601,601,601,601,601,601,601,601,601,545,489,434,377,322,265,209,154,97};
	    
	public Board(Properties [] propArr, Players [] playArr) {	
	this.prop = propArr;
	this.play = playArr;	
	Players thePlayer = playArr[turnCounter]; 

	boardFrame.setVisible(true); //layout starts here
	boardFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	boardFrame.setResizable(false);
	boardFrame.setLocation(700, 0);
	boardFrame.setSize(351,728);
	boardFrame.setBackground(Color.WHITE);
		
	setTitle("Board");
	getContentPane();
	setLocation(0, 0);
	pack();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setSize(700,729);
	setResizable(false);
	setLayout(new BorderLayout());
	JPanel front = new JPanel();
	boardFrame.add(stats);
	stats.setOpaque(false);
	front.setOpaque(false);
	URL brd = Board.class.getResource("/pieces/boardrotate.jpg");
	JLabel background=new JLabel(new ImageIcon(brd));
	add(background);
	background.setLayout(null);

	//if not applicable grey out buttons
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px 15px 5px 15px;\"><u>R</u>oll Dice</div>");
	buying = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>B</u>uy Property</div>");
	mortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>M</u>ortgage</div>");
	unmortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>U</u>nMortgage</div>");
	improve = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>I</u>mprovements</div>");
	simprove = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>S</u>ell Improvements</div>");
	sell = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>S</u>ell Property</div>");
	trade = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>T</u>rade</div>");
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>E</u>nd Turn</div>");
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>H</u>elp Menu</div>");
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>E</u>xit Game</div>");
		rolling.setBackground(new Color(73,175,47)); //set the color of the buttons in rgb
		buying.setBackground(new Color(167,39,88));
		mortgage.setBackground(new Color(247, 153, 22));
		unmortgage.setBackground(new Color(247, 153, 22));
		improve.setBackground(new Color(68, 35, 90));
		simprove.setBackground(new Color(68, 35, 90));
		sell.setBackground(new Color(71,71,255));
		trade.setBackground(new Color(71,71,255));
		ending.setBackground(new Color(0, 0, 0));
		hmenu.setBackground(new Color(0, 0, 0));
		mmenu.setBackground(new Color(226, 40, 53));

	JLabel die1=new JLabel(new ImageIcon("")); //dice images default
	JLabel die2=new JLabel(new ImageIcon(""));
	JLabel tdimg = new JLabel(new ImageIcon("")); //title deed image default
	JLabel chanceimg = new JLabel(new ImageIcon("")); //Chance and Chest images default

	//where images are stored
	dicez = new JButton(); //dice
	dice2thereckoning = new JButton();
	token1 = new JButton(); //players 1-8, play[turnCounter].get array 0-7
	token2 = new JButton();
	token3 = new JButton();
	token4 = new JButton();
	token5 = new JButton();
	token6 = new JButton();
	token7 = new JButton();
	token8 = new JButton();
	tdbtn = new JButton();
	chabtn = new JButton();
	
	plbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName() + "<br/>" + "Balance: "+thePlayer.getBalance()+" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
			", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/></div></html>");
	statusbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\"><br/><br/>Player 1, click 'Roll Dice' to start the game.</div></html>"); //set status updates to default
	dicez.add(die1);
	dice2thereckoning.add(die2);

	rolling.addActionListener(this); //ActionListerners for the board and updating in ActionListener
	buying.addActionListener(this);
	mortgage.addActionListener(this);
	unmortgage.addActionListener(this);
	improve.addActionListener(this);
	simprove.addActionListener(this);
	sell.addActionListener(this);
	trade.addActionListener(this);
	ending.addActionListener(this);
	mmenu.addActionListener(this);
	hmenu.addActionListener(this);
	tdbtn.addActionListener(this);
	token1.addActionListener(this);
	token2.addActionListener(this);
	token3.addActionListener(this);
	token4.addActionListener(this);
	token5.addActionListener(this);
	token6.addActionListener(this);
	token7.addActionListener(this);
	token8.addActionListener(this);
	
	background.add(token1); //add to the board in the jFrame background
	background.add(token2);
	background.add(token3);
	background.add(token4);
	background.add(token5);
	background.add(token6);
	background.add(token7);
	background.add(token8);
	background.add(front);
	background.add(tdbtn);
	background.add(dicez);
	background.add(dice2thereckoning);
	stats.setBounds(60, 0, 300, 700); //set the size and position
	front.setBounds(96, 369, 500, 200);
	front.setBorder(null); //remove black border
	dicez.setBorder(null);
	tdbtn.setBorder(null);
	chabtn.setBorder(null);
	plbtn.setBorder(null);
	statusbtn.setBorder(null);
	dice2thereckoning.setBorder(null);
	token1.setBorder(null);
	token2.setBorder(null);
	token3.setBorder(null);
	token4.setBorder(null);
	token5.setBorder(null);
	token6.setBorder(null);
	token7.setBorder(null);
	token8.setBorder(null);
	
	token1.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56); //move based on Position on the board
	token2.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	token3.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	token4.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	token5.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	token6.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	token7.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	token8.setBounds(x[thePlayer.getPosition()],y[thePlayer.getPosition()], 50, 56);
	
	dicez.setBounds(259, 266, 50, 50); //set size and position
	dice2thereckoning.setBounds(309, 266, 50, 50);
	tdbtn.setBounds(98,98,155,230); //on board
	plbtn.setBounds(0,10,100,100);
	chabtn.setBounds(230,170,50,230);
	
	front.add(rolling); //add to JPanel in middle of the board
	front.add(buying);
	front.add(mortgage);
	front.add(unmortgage);
	front.add(improve);
	front.add(simprove);
	front.add(sell);
	front.add(trade);
	front.add(ending);
	front.add(hmenu);
	front.add(mmenu);
	stats.add(plbtn);
	stats.add(statusbtn);
	
	tdbtn.add(tdimg); //title deed cards
	chabtn.add(chanceimg); //chance cards
	stats.add(chabtn);
	
	
	rolling.setFocusPainted(false);
	hmenu.setFocusPainted(false);
	ending.setFocusPainted(false);
	sell.setFocusPainted(false);
	trade.setFocusPainted(false);
	improve.setFocusPainted(false);
	simprove.setFocusPainted(false);
	buying.setFocusPainted(false);
	mortgage.setFocusPainted(false);
	unmortgage.setFocusPainted(false);
	
	token1.setOpaque(false); //nope totally not buttons
	token1.setFocusPainted(false);
	token1.setContentAreaFilled(false);
	token2.setOpaque(false);
	token2.setFocusPainted(false);
	token2.setContentAreaFilled(false);
	token3.setOpaque(false);
	token3.setFocusPainted(false);
	token3.setContentAreaFilled(false);
	token4.setOpaque(false);
	token4.setFocusPainted(false);
	token4.setContentAreaFilled(false);
	token5.setOpaque(false);
	token5.setFocusPainted(false);
	token5.setContentAreaFilled(false);
	token6.setOpaque(false);
	token6.setFocusPainted(false);
	token6.setContentAreaFilled(false);
	token7.setOpaque(false);
	token7.setFocusPainted(false);
	token7.setContentAreaFilled(false);
	token8.setOpaque(false);
	token8.setFocusPainted(false);
	token8.setContentAreaFilled(false);
	dicez.setOpaque(false);
	dice2thereckoning.setOpaque(false);
	dicez.setFocusPainted(false);
	dicez.setContentAreaFilled(false);
	dice2thereckoning.setContentAreaFilled(false); //the sequel is never as good as the first
	dice2thereckoning.setFocusPainted(false);
	tdbtn.setContentAreaFilled(false);
	plbtn.setFocusPainted(false);
	plbtn.setContentAreaFilled(false);
	plbtn.setOpaque(false);
	statusbtn.setFocusPainted(false);
	statusbtn.setContentAreaFilled(false);
	statusbtn.setOpaque(false);
	
	rolling.setEnabled(true); //default button, before the first roll
	ending.setEnabled(false);
	buying.setEnabled(false);
	mortgage.setEnabled(false);
	improve.setEnabled(false);
	simprove.setEnabled(false);
	sell.setEnabled(false);
	trade.setEnabled(false);
	unmortgage.setEnabled(false);

	//debugging, finding x,y positions on the board for every click
    /*background.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
		}
    });
	*/
	// refresh images after adding panels
    boardFrame.setSize(350,727);
	setSize(701,728);
	}
	//button actions
	@SuppressWarnings("null")
	public void actionPerformed(ActionEvent e) {
		
		Players thePlayer = play[turnCounter];
		
		if(e.getSource() == rolling) {
			rolling.setEnabled(false); //start turn
			buying.setEnabled(false);
			ending.setEnabled(true);
			
			if(thePlayer.getOwner() == true){
				mortgage.setEnabled(true);
				unmortgage.setEnabled(true);
				improve.setEnabled(true);
				simprove.setEnabled(true);
				sell.setEnabled(true);
				trade.setEnabled(true);
			}
			if(thePlayer.getOwner() == false){
				mortgage.setEnabled(false);
				unmortgage.setEnabled(false);
				improve.setEnabled(false);
				simprove.setEnabled(false);
				sell.setEnabled(false);
				trade.setEnabled(false);
			}
			
			tdowned = ""; //set to blank
			tdmort = "";
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getMortgaged() == true) {
		        	 tdmort += (prop[i].getName()+"<br/>");
		        }
		    } //populate owned items
			
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getPurchaseAllowed() != false) {
		        	 tdowned += (prop[i].getName()+" - "+play[prop[i].getOwner()-1].getName()+"<br/>");
		        }
		    }  //populate mortgaged items
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>"); //checks for owned properties and outputs to stats jFrame

			Prev = thePlayer.getPosition(); //get current player's previous position
			Dice theDice = new Dice();
		    dice1 = theDice.getDie1();
		    dice2 = theDice.getDie2();

			Pos = (Prev + dice1 + dice2) % 40;
			if (Pos == 11) {Pos = 10; thePlayer.setPosition(10);} //if rolls into jail put into see a battle
		    thePlayer.setPosition(Pos); //add to the player's position to move them forward
			theTurn.TurnAction(prop, play, Prev, dice1, dice2, turnCounter); //activate turn
			statustxt = theTurn.getStatustxt();
			if (thePlayer.getPosition() == 11) {
				new Jail(play, turnCounter, dice1, dice2);
			} //activate jail class
	

			
			 if (thePlayer.getPosition() != 11 && Pos != thePlayer.getPosition()) {
				 if (thePlayer.getPosition() != 2 || thePlayer.getPosition() != 18 || thePlayer.getPosition() != 34 || thePlayer.getPosition() != 7 || thePlayer.getPosition() != 23 || thePlayer.getPosition() != 37) {
					 theTurn.TurnAction(prop, play, Prev, dice1, dice2, turnCounter); //activate turn
					 statustxt += "<br/>"+theTurn.getStatustxt();
				 }
					
				} //if you go back 3 spaces run turn again
			
			URL diw1 = Board.class.getResource("/pieces/images/Dice"+dice1+".png"); //update dice images number
			URL diw2 = Board.class.getResource("/pieces/images/Dice"+dice2+".png");
			dicez.setIcon(new ImageIcon(diw1)); //refresh img dice
			dice2thereckoning.setIcon(new ImageIcon(diw2));

			URL td1 = Board.class.getResource("/cards/images/"+prop[thePlayer.getPosition()].getImageName());
			if (td1 != null) {tdbtn.setIcon(new ImageIcon(td1));} //if image is null do not update and show the image
			

			if (theTurn.getChest() != 0 && theTurn.getChest() > 16) {
				if (thePlayer.getPosition() == 2 || thePlayer.getPosition() == 18 || thePlayer.getPosition() == 34) {
					URL chimg = Board.class.getResource("cards/images/Chest"+theTurn.getChest()+".PNG"); //Chest
					chabtn.setIcon(new ImageIcon(chimg)); 
				}
			}
			if (theTurn.getChance() != 0 && theTurn.getChance() > 16) {
				if (thePlayer.getPosition() == 7 || thePlayer.getPosition() == 23 || thePlayer.getPosition() == 37) {
					URL chimg = Board.class.getResource("cards/images/Chance"+theTurn.getChance()+".PNG");
					chabtn.setIcon(new ImageIcon(chimg)); //doesn't work right now without a loop to update it
				}
			}
			
			if (turnCounter == 0) { 
				token1.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				URL tok1 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); 
				token1.setIcon(new ImageIcon(tok1));
			} //player 1-8 token movement
			if (turnCounter == 1) {token2.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			if (turnCounter == 2) {token3.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			if (turnCounter == 3) {token4.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			if (turnCounter == 4) {token5.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			if (turnCounter == 5) {token6.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			if (turnCounter == 6) {token7.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			if (turnCounter == 7) {token8.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);}
			
			Prev = thePlayer.getPosition();
			theTurn.setPrev(Prev);
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
					"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
			statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+statustxt+"</div></html>"); //print the status text in Turn

			if (prop[thePlayer.getPosition()].getPurchaseAllowed() != false && prop[thePlayer.getPosition()].getOwner() == 0) {
				if (thePlayer.getBalance() >= prop[thePlayer.getPosition()].getCost()) {
						buying.setEnabled(true);
				} //if space isn't already purchased
			} //must be ownable and not owned 
			
			if (prop[thePlayer.getPosition()].getPurchaseAllowed() != false) {
				if(thePlayer.getPlayerNumber() != prop[thePlayer.getPosition()].getOwner()){
					if(prop[thePlayer.getPosition()].getOwner() != 0 && prop[thePlayer.getPosition()].getMortgaged() == false) {
						Rent theRent = new Rent(play, prop, turnCounter,(dice1+dice2));
						statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+theRent.getRenttxt()+"</div></html>");
					} //if not owned by current person and is not mortgaged
				}
			} //pay rent
			if (dice1 == dice2) {
				if (thePlayer.getPosition() == 11 || thePlayer.getPosition() == 31) {
					rolling.setEnabled(false);
					ending.setEnabled(true);
				
				} else {
					rolling.setEnabled(true);
					statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+statustxt+"<br/>Doubles! Click 'Roll Dice' to take another turn.</div></html>");
					ending.setEnabled(false);
				}
			}
			if (dice1 != dice2) {
			rolling.setEnabled(false);
			ending.setEnabled(true); 
			} //enable the player to end their turn
			
			
			
		} //end rolling
		if(e.getSource() == buying) {
			buying.setEnabled(false); //buy a property		
			new Purchase(thePlayer, prop[thePlayer.getPosition()], thePlayer.getBalance());
			thePlayer.setOwner(true);
			tdowned = ""; //set to blank
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getPurchaseAllowed() != false) {
		        	 tdowned += (prop[i].getName()+" - "+play[prop[i].getOwner()-1].getName()+"<br/>");
		        }
		    } //find all owned properties and update
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
					"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		} //buy property
		if(e.getSource() == mortgage) {		
                Properties mortProp = null;
                String[] choices = {
                	    "Germania Inferior","Germania Superior","Via Appia","Alps Poeniae","Alps Cottiae","Alps Maritimae",
				"Aquitanina","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia",
				"Via Aemilia","Aegyptus","Arabia Petraea","Aquaducts","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
                String input = (String) JOptionPane.showInputDialog(null, "Choose a property to mortgage","Properties", JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); 
                
                if(input == "Germania Inferior"){mortProp = prop[1];}
                else if(input == "Germania Superior"){mortProp = prop[3];}
                else if(input == "Via Appia"){mortProp = prop[5];}
                else if(input == "Alps Poeniae"){mortProp = prop[6];}
                else if(input == "Alps Cottiae"){mortProp = prop[8];}
                else if(input == "Alps Maritimae"){mortProp = prop[9];}
                else if(input == "Aquitanina"){mortProp = prop[12];}
                else if(input == "Sewers"){mortProp = prop[13];}
                else if(input == "Belgica"){mortProp = prop[14];}
                else if(input == "Raetia"){mortProp = prop[15];}
                else if(input == "Via Flaminia"){mortProp = prop[16];}
                else if(input == "Africa Proconsularis"){mortProp = prop[17];}
                else if(input == "Asia"){mortProp = prop[19];}
                else if(input == "Britannia"){mortProp = prop[20];}
                else if(input == "Cilicia"){mortProp = prop[22];}
                else if(input == "Galatia"){mortProp = prop[24];}
                else if(input == "Cappadocia"){mortProp = prop[25];}
                else if(input == "Via Aemilia"){mortProp = prop[26];}
                else if(input == "Aegyptus"){mortProp = prop[27];}
                else if(input == "Arabia Petraea"){mortProp = prop[28];}
                else if(input == "Aquaducts"){mortProp = prop[29];}
                else if(input == "Syria"){mortProp = prop[30];}
                else if(input == "Macedonia"){mortProp = prop[32];}
                else if(input == "Epirus"){mortProp = prop[33];}
                else if(input == "Achaia"){mortProp = prop[35];}
                else if(input == "Via Popilia"){mortProp = prop[36];}
                else if(input == "Sicilia"){mortProp = prop[38];}
                else if(input == "Italia"){mortProp = prop[40];}
				
				if (mortProp != null) {
                new Mortgage(thePlayer,mortProp);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+" "+"</div></html>"); //set to blank
				} //if item is selected from the dialog box activate mortgage
				else {
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+"You have cancelled mortgaging a property to the bank."+"</div></html>");
				} //otherwise print status
				
                for(int i = 0; i< prop.length;i++){
                	Properties mortgage = null;
                	if(prop[i].getMortgaged() == true){
                		mortgage = prop[i];
                		tdmort += mortgage.getName();
                	}
                } //update mortgaged properties
                plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
    					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
    					"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
   	    }
		if(e.getSource() == hmenu){
			//user guide
			new HelpMenu();
		}
		if(e.getSource()== mmenu){
			//ask if you would like to exit
			System.exit(0); //exit
		}
		if(e.getSource()== unmortgage){
            Properties unmortProp = null;
            String[] choices = {
            	    "Germania Inferior","Germania Superior","Via Appia","Alps Poeniae","Alps Cottiae","Alps Maritimae",
			"Aquitanina","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia",
			"Via Aemilia","Aegyptus","Arabia Petraea","Aquaducts","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
            String input = (String) JOptionPane.showInputDialog(null, "Choose a property to unmortgage","Properties", JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); 
            
            if(input == "Germania Inferior"){unmortProp = prop[1];}
            else if(input == "Germania Superior"){unmortProp = prop[3];}
            else if(input == "Via Appia"){unmortProp = prop[5];}
            else if(input == "Alps Poeniae"){unmortProp = prop[6];}
            else if(input == "Alps Cottiae"){unmortProp = prop[8];}
            else if(input == "Alps Maritimae"){unmortProp = prop[9];}
            else if(input == "Aquitanina"){unmortProp = prop[12];}
            else if(input == "Sewers"){unmortProp = prop[13];}
            else if(input == "Belgica"){unmortProp = prop[14];}
            else if(input == "Raetia"){unmortProp = prop[15];}
            else if(input == "Via Flaminia"){unmortProp = prop[16];}
            else if(input == "Africa Proconsularis"){unmortProp = prop[17];}
            else if(input == "Asia"){unmortProp = prop[19];}
            else if(input == "Britannia"){unmortProp = prop[20];}
            else if(input == "Cilicia"){unmortProp = prop[22];}
            else if(input == "Galatia"){unmortProp = prop[24];}
            else if(input == "Cappadocia"){unmortProp = prop[25];}
            else if(input == "Via Aemilia"){unmortProp = prop[26];}
            else if(input == "Aegyptus"){unmortProp = prop[27];}
            else if(input == "Arabia Petraea"){unmortProp = prop[28];}
            else if(input == "Aquaducts"){unmortProp = prop[29];}
            else if(input == "Syria"){unmortProp = prop[30];}
            else if(input == "Macedonia"){unmortProp = prop[32];}
            else if(input == "Epirus"){unmortProp = prop[33];}
            else if(input == "Achaia"){unmortProp = prop[35];}
            else if(input == "Via Popilia"){unmortProp = prop[36];}
            else if(input == "Sicilia"){unmortProp = prop[38];}
            else if(input == "Italia"){unmortProp = prop[40];}
			
			if (unmortProp != null) {
                new Unmortgage(thePlayer,unmortProp);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+" "+"</div></html>"); //set to blank
				} //if item is selected from the dialog box activate mortgage
				else {
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+"You have cancelled unmortgaging a property from the bank."+"</div></html>");
				} //otherwise print status
            
            for(int i = 0; i< prop.length;i++){
            	Properties mortProp = null;
            	if(prop[i].getMortgaged() == true){
            		mortProp = prop[i];
            		tdmort += mortProp.getName();
            	}
            } //check for item getting unmortgaged, it should become owned again
            
            plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
					"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		}
		if(e.getSource()== simprove) {
		//sell improvements
		}
		if(e.getSource()== improve) {
			 Properties improveProp = null;
	            String[] choices = {
	            	    "Germania Inferior","Germania Superior","Via Appia","Alps Poeniae","Alps Cottiae","Alps Maritimae",
				"Aquitanina","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia",
				"Via Aemilia","Aegyptus","Arabia Petraea","Aquaducts","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
	            String input = (String) JOptionPane.showInputDialog(null, "Choose a property to improve","Properties", JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); 
	            
	            if(input == "Germania Inferior"){improveProp = prop[1];}
	            else if(input == "Germania Superior"){improveProp = prop[3];}
	            else if(input == "Via Appia"){improveProp = prop[5];}
	            else if(input == "Alps Poeniae"){improveProp = prop[6];}
	            else if(input == "Alps Cottiae"){improveProp = prop[8];}
	            else if(input == "Alps Maritimae"){improveProp = prop[9];}
	            else if(input == "Aquitanina"){improveProp = prop[12];}
	            else if(input == "Sewers"){improveProp = prop[13];}
	            else if(input == "Belgica"){improveProp = prop[14];}
	            else if(input == "Raetia"){improveProp = prop[15];}
	            else if(input == "Via Flaminia"){improveProp = prop[16];}
	            else if(input == "Africa Proconsularis"){improveProp = prop[17];}
	            else if(input == "Asia"){improveProp = prop[19];}
	            else if(input == "Britannia"){improveProp = prop[20];}
	            else if(input == "Cilicia"){improveProp = prop[22];}
	            else if(input == "Galatia"){improveProp = prop[24];}
	            else if(input == "Cappadocia"){improveProp = prop[25];}
	            else if(input == "Via Aemilia"){improveProp = prop[26];}
	            else if(input == "Aegyptus"){improveProp = prop[27];}
	            else if(input == "Arabia Petraea"){improveProp = prop[28];}
	            else if(input == "Aquaducts"){improveProp = prop[29];}
	            else if(input == "Syria"){improveProp = prop[30];}
	            else if(input == "Macedonia"){improveProp = prop[32];}
	            else if(input == "Epirus"){improveProp = prop[33];}
	            else if(input == "Achaia"){improveProp = prop[35];}
	            else if(input == "Via Popilia"){improveProp = prop[36];}
	            else if(input == "Sicilia"){improveProp = prop[38];}
	            else if(input == "Italia"){improveProp = prop[40];}
				
				if (improveProp != null) {
                new Improvements(thePlayer, improveProp, play, prop);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+" "+"</div></html>"); //set to blank
				} //if item is selected from the dialog box activate mortgage
				else {
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+"You have cancelled improving a property."+"</div></html>");
				} //otherwise print status
				
				printVillas = "";
				for(int i = 0; i< prop.length; i++){
                	if(prop[i].getVillas() > 0 || prop[i].getPantheons() > 0){
                		printVillas += prop[i].getName()+" - Villas: "+prop[i].getVillas()+", Pantheons: "+prop[i].getPantheons()+"<br/>";
                	}
                } //update and print improved properties
			
				plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
						", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
						"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/>Properties with Villas/Pantheons: "+printVillas+"<br/><br/></div></html>");
		} //villas and pantheons
		if(e.getSource()== sell) {
			int buyCounter = 0;
			Properties buyProp = null;
			Players secondPlayer = null;
	            String[] ownedProperty = {
	            		"Germania Inferior","Germania Superior","Via Appia","Alps Poeniae","Alps Cottiae","Alps Maritimae",
				"Aquitanina","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia",
				"Via Aemilia","Aegyptus","Arabia Petraea","Aquaducts","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
	            String input = (String) JOptionPane.showInputDialog(null, "Choose a property to buy from another Player","Properties", JOptionPane.QUESTION_MESSAGE, null,ownedProperty,ownedProperty[1]); 
	            
	            if(input == "Germania Inferior"){buyProp = prop[1];}
	            else if(input == "Germania Superior"){buyProp = prop[3];}
	            else if(input == "Via Appia"){buyProp = prop[5];}
	            else if(input == "Alps Poeniae"){buyProp = prop[6];}
	            else if(input == "Alps Cottiae"){buyProp = prop[8];}
	            else if(input == "Alps Maritimae"){buyProp = prop[9];}
	            else if(input == "Aquitanina"){buyProp = prop[12];}
	            else if(input == "Sewers"){buyProp = prop[13];}
	            else if(input == "Belgica"){buyProp = prop[14];}
	            else if(input == "Raetia"){buyProp = prop[15];}
	            else if(input == "Via Flaminia"){buyProp = prop[16];}
	            else if(input == "Africa Proconsularis"){buyProp = prop[17];}
	            else if(input == "Asia"){buyProp = prop[19];}
	            else if(input == "Britannia"){buyProp = prop[20];}
	            else if(input == "Cilicia"){buyProp = prop[22];}
	            else if(input == "Galatia"){buyProp = prop[24];}
	            else if(input == "Cappadocia"){buyProp = prop[25];}
	            else if(input == "Via Aemilia"){buyProp = prop[26];}
	            else if(input == "Aegyptus"){buyProp = prop[27];}
	            else if(input == "Arabia Petraea"){buyProp = prop[28];}
	            else if(input == "Aquaducts"){buyProp= prop[29];}
	            else if(input == "Syria"){buyProp = prop[30];}
	            else if(input == "Macedonia"){buyProp = prop[32];}
	            else if(input == "Epirus"){buyProp = prop[33];}
	            else if(input == "Achaia"){buyProp = prop[35];}
	            else if(input == "Via Popilia"){buyProp = prop[36];}
	            else if(input == "Sicilia"){buyProp = prop[38];}
	            else if(input == "Italia"){buyProp= prop[40];}
				
				int ownerNumber = buyProp.getOwner();
				if (input != null) {
                new Buy(thePlayer,secondPlayer, play, buyProp,prop);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+" "+"</div></html>"); //set to blank
				} //if item is selected from the dialog box activate mortgage
				else {
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+"You have cancelled selling a property."+"</div></html>");
				} //otherwise print status
	            
	            if(e.getSource() == sell){buyCounter = 1;}
	            if(buyCounter == 1){
	            	buyCounter = 0;
	            	buyProp.setOwner(thePlayer.getPlayerNumber());
	            	int newPlayerBalance = thePlayer.getBalance() - buyProp.getCost();
	            	newSecondPlayerBalance = secondPlayer.getBalance() + buyProp.getCost();
	            	thePlayer.setBalance(newPlayerBalance);
	            	secondPlayer.setBalance(newSecondPlayerBalance);
	            	thePlayer.setOwner(true);
	            	for(int k = 0; k<prop.length; k++){
	            		if(secondPlayer.getPlayerNumber() == prop[k].getOwner()){
	            			secondPlayer.setOwner(true);
	            			break;
	            		} else{secondPlayer.setOwner(false);}
	            	}
	            }
				
	            for(int j = 0 ; j < play.length; j ++){
	            	if(ownerNumber == play[j].getPlayerNumber()){
	            		secondPlayer = play[j];
	            	}
	            } //find the player to sell to
	            
	            tdowned = ""; //set to blank
				for(int i=0; i<prop.length; i++) {
		         if(prop[i].getMortgaged() == true) {
		        	 tdmort += (prop[i].getName()+"<br/>");
					}
				} //populate owned items
	           
				plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
						", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
						"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		} //sell property
		if(e.getSource()== trade){			
			int tradeCounter = 0;
			Properties tradeProp = null;
			Players secondPlayer = null;
			Properties getProp = null;
			if(tradeCounter == 0){
	            String[] ownedProperty = {
	            		"Germania Inferior","Germania Superior","Via Appia","Alps Poeniae","Alps Cottiae","Alps Maritimae",
				"Aquitanina","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia",
				"Via Aemilia","Aegyptus","Arabia Petraea","Aquaducts","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
	            String input1 = (String) JOptionPane.showInputDialog(null, "Choose a property to trade with another Player","Properties", JOptionPane.QUESTION_MESSAGE, null,ownedProperty,ownedProperty[1]); 
	            
	            if(input1 == "Germania Inferior"){tradeProp  = prop[1];}
	            else if(input1 == "Germania Superior"){tradeProp  = prop[3];}
	            else if(input1 == "Via Appia"){tradeProp  = prop[5];}
	            else if(input1 == "Alps Poeniae"){tradeProp  = prop[6];}
	            else if(input1 == "Alps Cottiae"){tradeProp  = prop[8];}
	            else if(input1 == "Alps Maritimae"){tradeProp = prop[9];}
	            else if(input1 == "Aquitanina"){tradeProp = prop[12];}
	            else if(input1 == "Sewers"){tradeProp = prop[13];}
	            else if(input1 == "Belgica"){tradeProp = prop[14];}
	            else if(input1 == "Raetia"){tradeProp = prop[15];}
	            else if(input1 == "Via Flaminia"){tradeProp = prop[16];}
	            else if(input1 == "Africa Proconsularis"){tradeProp = prop[17];}
	            else if(input1 == "Asia"){tradeProp = prop[19];}
	            else if(input1 == "Britannia"){tradeProp = prop[20];}
	            else if(input1 == "Cilicia"){tradeProp = prop[22];}
	            else if(input1 == "Galatia"){tradeProp = prop[24];}
	            else if(input1 == "Cappadocia"){tradeProp = prop[25];}
	            else if(input1 == "Via Aemilia"){tradeProp = prop[26];}
	            else if(input1 == "Aegyptus"){tradeProp = prop[27];}
	            else if(input1 == "Arabia Petraea"){tradeProp = prop[28];}
	            else if(input1 == "Aquaducts"){tradeProp = prop[29];}
	            else if(input1 == "Syria"){tradeProp = prop[30];}
	            else if(input1 == "Macedonia"){tradeProp = prop[32];}
	            else if(input1 == "Epirus"){tradeProp = prop[33];}
	            else if(input1 == "Achaia"){tradeProp = prop[35];}
	            else if(input1 == "Via Popilia"){tradeProp = prop[36];}
	            else if(input1 == "Sicilia"){tradeProp = prop[38];}
	            else if(input1 == "Italia"){tradeProp = prop[40];}
				
	            String[] desiredProperty = {
	            		"Germania Inferior","Germania Superior","Via Appia","Alps Poeniae","Alps Cottiae","Alps Maritimae",
				"Aquitanina","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia",
				"Via Aemilia","Aegyptus","Arabia Petraea","Aquaducts","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
	            String input2 = (String) JOptionPane.showInputDialog(null, "Choose a property to trade with another Player","Properties", JOptionPane.QUESTION_MESSAGE, null,desiredProperty,desiredProperty[1]); 
	            
	            if(input2 == "Germania Inferior"){getProp = prop[1];}
	            else if(input2 == "Germania Superior"){getProp  = prop[3];}
	            else if(input2 == "Via Appia"){getProp = prop[5];}
	            else if(input2 == "Alps Poeniae"){getProp = prop[6];}
	            else if(input2 == "Alps Cottiae"){getProp  = prop[8];}
	            else if(input2 == "Alps Maritimae"){getProp = prop[9];}
	            else if(input2 == "Aquitanina"){getProp = prop[12];}
	            else if(input2 == "Sewers"){getProp = prop[13];}
	            else if(input2 == "Belgica"){getProp = prop[14];}
	            else if(input2 == "Raetia"){getProp = prop[15];}
	            else if(input2 == "Via Flaminia"){getProp = prop[16];}
	            else if(input2 == "Africa Proconsularis"){getProp = prop[17];}
	            else if(input2 == "Asia"){getProp = prop[19];}
	            else if(input2 == "Britannia"){getProp = prop[20];}
	            else if(input2 == "Cilicia"){getProp = prop[22];}
	            else if(input2 == "Galatia"){getProp = prop[24];}
	            else if(input2 == "Cappadocia"){getProp = prop[25];}
	            else if(input2 == "Via Aemilia"){getProp = prop[26];}
	            else if(input2 == "Aegyptus"){getProp = prop[27];}
	            else if(input2 == "Arabia Petraea"){getProp = prop[28];}
	            else if(input2 == "Aquaducts"){getProp = prop[29];}
	            else if(input2 == "Syria"){getProp = prop[30];}
	            else if(input2 == "Macedonia"){getProp = prop[32];}
	            else if(input2 == "Epirus"){getProp = prop[33];}
	            else if(input2 == "Achaia"){getProp = prop[35];}
	            else if(input2 == "Via Popilia"){getProp = prop[36];}
	            else if(input2 == "Sicilia"){getProp = prop[38];}
	            else if(input2 == "Italia"){getProp = prop[40];}
				
	            int getPropCurrentOwner = getProp.getOwner();
	            for(int i = 0; i<play.length; i++){
	            	if(getPropCurrentOwner == play[i].getPlayerNumber()){
	            		play[i] = secondPlayer;
	            	}
	            }
	            if (input1 != null && input2 != null) {
	            new Trade(thePlayer, secondPlayer, play, tradeProp, getProp, prop);
	            }
			}
			if(e.getSource() == trade){
	            if(tradeCounter == 1){
	            	tradeCounter = 0;
	            	tradeProp.setOwner(secondPlayer.getPlayerNumber());
	            	getProp.setOwner(thePlayer.getPlayerNumber());
	            	thePlayer.setOwner(true);
	            }	            
	            tdowned = ""; //set to blank
				for(int i=0; i<prop.length; i++) {
		         if(prop[i].getMortgaged() == true) {
		        	 tdmort += (prop[i].getName()+"<br/>");
					}
				} //populate owned items
			}
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
					"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
			
		} //trade property
		if(e.getSource()== ending) {
			ending.setEnabled(false);
			rolling.setEnabled(true); //here it goes again
			buying.setEnabled(false);
			
			if(thePlayer.getOwner() == true){
				mortgage.setEnabled(true);
				unmortgage.setEnabled(true);
				improve.setEnabled(true);
				simprove.setEnabled(true);
				sell.setEnabled(true);
				trade.setEnabled(true);
			}
			if(thePlayer.getOwner() == false){
				mortgage.setEnabled(false);
				unmortgage.setEnabled(false);
				improve.setEnabled(false);
				simprove.setEnabled(false);
				sell.setEnabled(false);
				trade.setEnabled(false);
			}
			
			tdbtn.setIcon(new ImageIcon("")); //you get nothing
			chabtn.setIcon(new ImageIcon(""));
			statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\"></div></html>");
			
			if(turnCounter < 7){turnCounter++;} //set the turnCounter to the next player
			else {turnCounter = 0;}
			
			//player 1-8 update token images to dark versions
			tok1 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token1.setIcon(new ImageIcon(tok1));
			URL tok2 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token2.setIcon(new ImageIcon(tok2));
			URL tok3 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token3.setIcon(new ImageIcon(tok3));
			URL tok4 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token4.setIcon(new ImageIcon(tok4));
			URL tok5 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token5.setIcon(new ImageIcon(tok5));
			URL tok6 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token6.setIcon(new ImageIcon(tok6));
			URL tok7 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token7.setIcon(new ImageIcon(tok7));
			URL tok8 = Board.class.getResource("/pieces/images/D"+play[turnCounter].getToken()); token8.setIcon(new ImageIcon(tok8));

			//update tokens to brighter versions
if (turnCounter == 0) {tok1 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token1.setIcon(new ImageIcon(tok1));} 
if (turnCounter == 1) {tok2 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token2.setIcon(new ImageIcon(tok2));}
if (turnCounter == 2) {tok3 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token3.setIcon(new ImageIcon(tok3));}
if (turnCounter == 3) {tok4 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token4.setIcon(new ImageIcon(tok4));}
if (turnCounter == 4) {tok5 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token5.setIcon(new ImageIcon(tok5));}
if (turnCounter == 5) {tok6 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token6.setIcon(new ImageIcon(tok6));}
if (turnCounter == 6) {tok7 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token7.setIcon(new ImageIcon(tok7));}
if (turnCounter == 7) {tok8 = Board.class.getResource("/pieces/images/"+play[turnCounter].getToken()); token8.setIcon(new ImageIcon(tok8));}
			
			if (thePlayer.getBalance() < 0) {
				setTitle("Mortgage");
				setSize(200,250); //window size
				setLocation(255,290);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(true);
				setLayout(new BorderLayout());
				JPanel front = new JPanel();
				front.setLayout(null);
				add(front, BorderLayout.CENTER);
				
				JLabel status;
				String statustxt = "You owe money, if you end the turn you will loose and the game will end, are you sure?";
			
				String button1 = "<u>Y</u>es";
				String button2 = "<u>N</u>o";
				JButton yes =new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
				JButton no =new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button2+"</div>");
				status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
				yes.setBackground(new Color(73,175,47));
				no.setBackground(new Color(73,175,47));
				
				front.add(status);
				front.add(yes);
				front.add(no);
			
				status.setBounds(20,0,150,50);
				yes.setBounds(20, 60, 150, 50);
				no.setBounds(20, 60, 150, 50);
			
				yes.addActionListener(this);
				no.addActionListener(this);
				repaint();
				
				if(e.getSource() == yes){
					statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Game Over. <br/>Please click the exit button to close the game.</div></html>");
					rolling.setEnabled(false);
					buying.setEnabled(false);
					mortgage.setEnabled(false);
					improve.setEnabled(false);
					simprove.setEnabled(false);
					sell.setEnabled(false);
					trade.setEnabled(false);
					unmortgage.setEnabled(false);
				}
				if(e.getSource() == no){
					statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Please sell, trade or mortgage a property to continue the game.</div></html>");
					dispose();
					rolling.setEnabled(false);
					buying.setEnabled(false);
					mortgage.setEnabled(true);
					improve.setEnabled(false);
					simprove.setEnabled(false);
					sell.setEnabled(false);
					trade.setEnabled(false);
					unmortgage.setEnabled(false);
				}
			}
			else if(thePlayer.getBalance() >= 0){
				rolling.setEnabled(true);
				ending.setEnabled(false);
				if(play[turnCounter].getOwner() == false){
					mortgage.setEnabled(false);
					improve.setEnabled(false);
					simprove.setEnabled(false);
					sell.setEnabled(false);
					trade.setEnabled(false);
					unmortgage.setEnabled(false);
				}
				else if(play[turnCounter].getOwner() == true){
					mortgage.setEnabled(true);
					improve.setEnabled(true);
					simprove.setEnabled(true);
					sell.setEnabled(true);
					trade.setEnabled(true);
					unmortgage.setEnabled(true);
				}
			}
			
			tdowned = ""; //set to blank
			tdmort = "";
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getMortgaged() == true) {
		        	 tdmort += (prop[i].getName()+"<br/>");
		        }
		    } //owners print to stats
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getPurchaseAllowed() != false) {
		        	 tdowned += (prop[i].getName()+" - "+play[prop[i].getOwner()-1].getName()+"<br/>");
		        }
		    }  //mortgaged print to stats
			
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/>Get out of the Arena cards: "+thePlayer.getOutJail()+
					"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		} //ends current turn
    } //ends Action	
	public int getTurnCounter(){return this.turnCounter;} //pull turnCounter into other classes	
} //end of class
