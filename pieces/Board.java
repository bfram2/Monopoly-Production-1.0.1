package pieces;
//Loading the board [fonts for board.jpg: Verdana 8pt, 6pt, 8pt bold]
//position vs titledeed cards need to be fixed
//import java.lang.StringBuilder;
import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
//debugging tokens
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import menu.HelpMenu;
import menu.MainMenu;
//import tile.Properties;
//import tile.Utilities;
//import tile.Vias;

//import cards.Chance;
import events.*;
import pieces.Dice;
//import tile.Properties;
//import tile.Utilities;
//import tile.Vias;


public class Board extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton rolling, buying, mortgage, ending, mmenu, hmenu, spaces, plbtn, chabtn, statusbtn, dicez, dice2thereckoning, tdbtn;
	//final JButton dicez;
	//final JButton dice2thereckoning;
	//final JButton tdbtn;
	JFrame boardFrame = new JFrame("Stats");
	JPanel stats = new JPanel();
	
	public Players thePlayer = new Players(); //for token
	Turn theTurn = new Turn(); //pulling player's turn
	Buy theBuy = new Buy();
	int ttbuy = 0;
	//board spaces
	int tdPos = 0;
	public int titledeed = 28; //buy picks
	//int tdplimg; //titledeed card counter
	int buymort = 0; //counter for buy or mortgage
	int Pos = 0; //board positions
	int money = 0;
	public int Prev;
	public int Bal = 1500;
	int prevown; //owned[titledeed]
	int k = 0; //doubles counter
	int j = 0; //jail counter
	int jtotal = 0; //out of jail counter
	//int g = 0; //pass go counter
	String tdowned = " ";
	String tdmort = " ";
	int chacard;
	String chaimg;
	String chaout;
	int dice1 = 0; //called in ActionListener
	int dice2 = 0;
	int diet = dice1+dice2; //dice total
	
	//buying price for title deeds
	public int[] tdBuy = {60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400,150,150,200,200,200,200,0};
	public int[] owned = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //0=bank,1=owned,-1=mortgaged, owned[28] is a blank counter
	public int[] rent = {2,4,6,6,8,10,10,12,14,14,16,18,18,20,22,22,24,26,26,28,35,50,4,4,25,25,25,25,0};
	//the name of the spaces with title deeds
    String[] tdPlaces = {"Germania Inferior","Germania Superior","Alpes Poeniae","Alpes Cottiae","Aples Maritimae","Aquitania","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia","Sewers","Aqueducts","Via Appia","Via Flaminia","Via Aemilia","Via Popillia",""};
	//title deed card image names
	String[] tdimages = {"Purple_GermaniaI","Purple_GermaniaS","BBlue_APoeniae","BBlue_ACottiae","BBlue_AMaritimae","DPink_Aquitania","DPink_Belgica","DPink_Raetia","Orange_AProconsularis","Orange_Asia","Orange_Britannia","Red_Cilicia","Red_Galatia","Red_Cappadocia","Yellow_Aegyptus","Yellow_APetraea","Yellow_Syria","Green_Macedonia","Green_Epirus","Green_Achaia","Blue_Sicilia", "Blue_Italia","Utility_Sewers","Utility_Aqueducts","Via_Appia","Via_Flaminia","Via_Aemilia","Via_Popillia",""};
	//all spaces
	String[] board = {"Go","Germania Inferior","Community Chest","Germania Superior","Render unto Caesar","Via Appia","Alpes Poeniae","Chance","Alpes Cottiae","Alpes Maritimae","See a battle","Arena","Aquitania","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Community Chest","Asia","Britannia","Free Market","Cilicia","Chance","Galatia","Cappadocia","Via Aemilia","Aegyptus","Arabia Petraea","Aqueducts","Syria","Go to the Arena","Macedonia","Epirus","Community Chest","Achaia","Via Popillia","Chance","Sicilia","Citizens Tax","Italia"};
	//token movement setBounds(x[Pos],y[Pos])
    int[] x = {9,96,152,208,264,320,376,432,488,544,665,600,600,600,600,600,600,600,600,600,600,600,543,488,432,376,320,264,208,152,96,9,77,77,77,77,77,77,77,77,77};
    int[] y = {11,11,11,11,11,11,11,11,11,11,11,35,97,154,209,265,322,377,432,490,544,601,601,601,601,601,601,601,601,601,601,601,545,489,434,377,322,265,209,154,97};

	public Board() {
		//layout
		boardFrame.setVisible(true);
		boardFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		boardFrame.setResizable(false);
		boardFrame.setLocation(700, 0);
		boardFrame.setSize(351,728);
		boardFrame.setBackground(Color.WHITE);
		
	setTitle("Board");
	getContentPane();
	setLocation(0, 0);
	pack();
	//setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setSize(700,729);
	setResizable(false);
	setLayout(new BorderLayout());
	JPanel front = new JPanel();
	boardFrame.add(stats);
	stats.setOpaque(false);
	front.setOpaque(false);
	JLabel background=new JLabel(new ImageIcon("src/pieces/boardrotate.jpg"));
	add(background);
	background.setLayout(null);
	
	//if not applicable grey out buttons
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px 15px 5px 15px;\"><u>R</u>oll Dice</div>");
	buying = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>B</u>uy Property</div>");
	mortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>M</u>ortgage</div>");
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>E</u>nd Turn</div>");
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>H</u>elp Menu</div>");
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 0px 5px 0px 5px;\"><u>E</u>nd Game<br/><span style=\"font-size: 9pt\">Return to Main Menu</span></div>");
		rolling.setBackground(new Color(73,175,47));
		buying.setBackground(new Color(71,71,255));
		mortgage.setBackground(new Color(247, 153, 22));
		ending.setBackground(new Color(0, 0, 0));
		hmenu.setBackground(new Color(0, 0, 0));
		mmenu.setBackground(new Color(0, 0, 0));

	//dice, cards, and token images	
	JLabel die1=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice1+".png"));
	JLabel die2=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
	JLabel token1 = new JLabel(new ImageIcon("src/pieces/images/"+"Token_W1.png"));
	JLabel tdimg = new JLabel(new ImageIcon(""));
	JLabel chanceimg = new JLabel(new ImageIcon(chaimg));
	
	//where images are stored
	dicez = new JButton();
	dice2thereckoning = new JButton();
	spaces = new JButton();
	tdbtn = new JButton();
	chabtn = new JButton();
	plbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player 1<br/> Balance: "+thePlayer.getBalance()+
			" denarius <br/>Space: "+board[Pos]+
			"<br/>Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"<br/></div></html>");
	statusbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\"></div></html>");
	dicez.add(die1);
	dice2thereckoning.add(die2);
	
	rolling.addActionListener(this);
	buying.addActionListener(this);
	mortgage.addActionListener(this);
	ending.addActionListener(this);
	mmenu.addActionListener(this);
	hmenu.addActionListener(this);
	spaces.addActionListener(this);
	tdbtn.addActionListener(this);
	
	background.add(front);
	background.add(spaces);
	background.add(tdbtn);
	background.add(dicez);
	background.add(dice2thereckoning);
	stats.setBounds(60, 0, 300, 700);
	front.setBounds(120, 369, 450, 200);
	front.setBorder(null);
	spaces.setBorder(null);
	dicez.setBorder(null);
	tdbtn.setBorder(null);
	chabtn.setBorder(null);
	plbtn.setBorder(null);
	statusbtn.setBorder(null);
	dice2thereckoning.setBorder(null);
	spaces.setBounds(x[Pos],y[Pos], 50, 56); //move based on Position on the board
	
	dicez.setBounds(259, 266, 50, 50);
	dice2thereckoning.setBounds(309, 266, 50, 50);
	tdbtn.setBounds(98,98,155,230); //on board
	//tdbtn.setBounds(98,98,100,200);
	plbtn.setBounds(0,10,100,100);
	chabtn.setBounds(230,170,50,230);
	
	front.add(rolling);
	front.add(buying);
	front.add(mortgage);
	front.add(ending);
	front.add(hmenu);
	front.add(mmenu);
	stats.add(plbtn);
	stats.add(statusbtn);
	
	
	spaces.add(token1); //token movement
	tdbtn.add(tdimg); //title deed cards
	chabtn.add(chanceimg); //chance cards
	stats.add(chabtn);
	
	//nope totally not buttons
	dicez.setOpaque(false);
	dice2thereckoning.setOpaque(false);
	spaces.setOpaque(false);
	spaces.setFocusPainted(false);
	spaces.setContentAreaFilled(false);
	dicez.setFocusPainted(false);
	dicez.setContentAreaFilled(false);
	dice2thereckoning.setContentAreaFilled(false); //the sequel is never as good as the first
	dice2thereckoning.setFocusPainted(false);
	tdbtn.setContentAreaFilled(false); //totally not a button
	plbtn.setFocusPainted(false);
	plbtn.setContentAreaFilled(false);
	plbtn.setOpaque(false);
	statusbtn.setFocusPainted(false);
	statusbtn.setContentAreaFilled(false);
	statusbtn.setOpaque(false);
	
	rolling.setEnabled(true);
	buying.setEnabled(false);
	mortgage.setEnabled(false);
	ending.setEnabled(false);
	//plscreen.setEnabled(false); //in case of clicking

	//debugging, finding x,y positions on the board for every click
    background.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
		}
	});
	
	// refresh images after adding panels
    boardFrame.setSize(350,727);
	setSize(701,728);
	}
	//button actions
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rolling) {
			//start turn
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(false);
			tdowned = ""; //set to blank
			tdmort = "";
			for(int i=0; i<owned.length; i++) {
		         if(owned[i] == 1) {tdowned += (tdPlaces[i]+"<br/>");}
		         if(owned[i] == -1){tdmort += (tdPlaces[i]+"<br/>");}
		    } //checks for owned & mortgaged properties and outputs to stats jframe
			Prev = thePlayer.getPosition();
			j = theTurn.getTjail();
			if (j != 0 && theTurn.getOutJail() != 0) {
				j = 0; //escape from jail
				jtotal = theTurn.getJTotal();
				jtotal--;
			} //get out of jail free card, return card to bank
			
			Dice theDice = new Dice();
		    dice1 = theDice.getDie1();
		    dice2 = theDice.getDie2();
		    diet = dice1+dice2;
		    if (j == 0) {
			Pos = (Prev + dice1 + dice2) % 40;
			} //must not be in jail to move forward
			theTurn.setPos(Pos);
			theTurn.setDice1(dice1);
			theTurn.setDice2(dice2);
			theTurn.setJTotal(jtotal);
			//new Turn().TurnAction(Pos, Prev, dice1, dice2, jtotal);
			titledeed = theTurn.getTitleDeed();
			Pos = theTurn.getPos();
			chaimg = theTurn.getChaimg();
			money = theTurn.getMoney();
			
			Bal += money;
			if (Prev < 10 && Pos > 10) {
				Pos+= 1; //don't count 11, arena
				if (Pos > 39) {
					Pos = 40 - Pos; //don't go out of bounds
				}
			}
			if (Pos == 31) {
				Pos = 11; //go to jail
			}
			//System.out.println("Pos: "+Pos+", Prev: "+Prev+", Dice: "+dice1+"+"+dice2+", images: "+tdimages[titledeed]+", money: "+money+", j: "+j); //debugging
			dicez.setIcon(new ImageIcon("src/pieces/images/Dice"+dice1+".png")); //refresh img dice
			dice2thereckoning.setIcon(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
			spaces.setBounds(x[Pos], y[Pos], 50, 56);
			tdbtn.setIcon(new ImageIcon("src/cards/images/"+tdimages[titledeed]+".PNG"));
			chabtn.setIcon(new ImageIcon(chaimg));
			Prev = Pos;
			thePlayer.setPosition(Prev);
			thePlayer.setBalance(Bal);
			theTurn.setPrev(Prev);
			ttbuy = tdBuy[titledeed];
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player 1<br/> Balance: "+thePlayer.getBalance()+
					" denarius <br/>Space: "+board[Pos]+
					"<br/>Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
			statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+theTurn.getStatustxt()+"</div></html>");
			if (owned[titledeed] != 1 && titledeed != 28) {
				if (Bal < (ttbuy/2)) {
				mortgage.setEnabled(false);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">You do not have enough funds to mortgage this space.</div></html>");
				}
				if (Bal > (ttbuy/2)) {
				mortgage.setEnabled(true);
				}
				if (Bal < ttbuy) {
				buying.setEnabled(false);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">You do not have enough funds to purchase this space.</div></html>");
				}
				if (Bal > ttbuy) {
				buying.setEnabled(true);
				}
			} //check if bank owns, check for titledeed space
			if (owned[titledeed] == 1 && titledeed != 28) {
				if (Pos == 5 || Pos == 16 || Pos == 26 || Pos == 36) {
					prevown = owned[24]+owned[25]+owned[26]+owned[27];
					if (prevown == 1) {money -= rent[titledeed];}
					if (prevown == 2) {money -= (2*rent[titledeed]);}
					if (prevown == 3) {money -= (4*rent[titledeed]);}
					if (prevown == 4) {money -= (8*rent[titledeed]);}
				} //Vias, 4 spaces
				if (Pos == 13 || Pos == 29) {
					prevown = owned[22]+owned[23]; //titledeed = 22,23
					if (prevown == 1) {money -= (diet*4);}
					if (prevown == 2) {money -= (diet*10);}
				} //utilities, 2 spaces
				if (Pos == 1 || Pos == 3 || Pos == 38 || Pos == 40) {
					if (Pos == 1 || Pos == 3) {prevown = owned[0]+owned[1];} //group 1
					if (Pos == 38 || Pos == 40) {prevown = owned[20]+owned[21];} //group 8
					if (prevown == 2) {money -= (2*rent[titledeed]);}
					if (prevown != 2) {money -= rent[titledeed];}
				} //2 space groups
				if (Pos == 6 || Pos == 8 || Pos == 9  || Pos == 12 || Pos == 14 || Pos == 15 || Pos == 17 || Pos == 19 || Pos == 20 || Pos == 22 || Pos == 24 || Pos == 25 || Pos == 27 || Pos == 28 || Pos == 30 || Pos == 32 || Pos == 33 || Pos == 35) {
					if (Pos == 6 || Pos == 8 || Pos == 9) {prevown = owned[2]+owned[3]+owned[4];} //group 2
					if (Pos == 12 || Pos == 14 || Pos == 15) {prevown = owned[2]+owned[3]+owned[4];} //group 3
					if (Pos == 17 || Pos == 19 || Pos == 20) {prevown = owned[8]+owned[9]+owned[10];} //group 4
					if (Pos == 22 || Pos == 24 || Pos == 25) {prevown = owned[11]+owned[12]+owned[13];} //group 5
					if (Pos == 27 || Pos == 28 || Pos == 30) {prevown = owned[14]+owned[15]+owned[16];} //group 6
					if (Pos == 32 || Pos == 33 || Pos == 35) {prevown = owned[17]+owned[18]+owned[19];} //group 7
					if (prevown == 3) {money -= (2*rent[titledeed]);}
					if (prevown != 3) {money -= rent[titledeed];}
				}//three space groups
				Bal += money;
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+
				"You have landed on an owned space. Pay: "+(-money)+" denarius to the bank.</div></html>");
				thePlayer.setBalance(Bal); //set new Player Balance
			} //pay rent, on owned properties due to only having one player
			ending.setEnabled(true);
			if (thePlayer.getBalance() <= 0) {
				//System.out.println("Game over.");
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Game Over.</div></html>");
				rolling.setEnabled(false);
				buying.setEnabled(false);
				mortgage.setEnabled(false);
				ending.setEnabled(false);
				hmenu.setEnabled(false);
			}
		}
		if(e.getSource() == buying) {
			//buy property
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(true);
			
			prevown = owned[titledeed];
			//new Buy().purchase(prevown);
			if(prevown == 0) {
				prevown = 1;
				ttbuy = tdBuy[titledeed];
				money -= (ttbuy);
				Bal += money;
				thePlayer.setBalance(Bal); //set to mortgaged in tile objects
				owned[titledeed] = prevown;
				
				//System.out.println("Purchase: "+tdBuy[titledeed]+", "+titledeed+", "+money+", "+(ttbuy)+", "+prevown);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+
						"Pay the full purchase price of the title deed.<br>"+ttbuy+" denarius paid to the bank.</div></html>");
				}
		}
		if(e.getSource() == mortgage) {
			//mortgage property
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(true);
			
			prevown = owned[titledeed];
			//new Buy().mortgage(prevown);
			if(prevown == -1) {
				ttbuy = tdBuy[titledeed];
				ttbuy *= 0.60; //already Mortgaged, pay the 60% back
				if (thePlayer.getBalance() > ttbuy) {
					money -= (ttbuy);
					Bal += money;
					thePlayer.setBalance(Bal);
					System.out.println("Pay to bank half of the mortgage and 10% interest.");
					statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+
					"Pay to bank half of the mortgage and 10% interest.<br>"+ttbuy+" denarius paid to the bank.</div></html>");
					prevown = 1;
					owned[titledeed] = prevown;
				} else {
					System.out.println("You do not have enough money to own property.");
				}
			}
			if(prevown == 0) {
				prevown = -1;
				ttbuy = tdBuy[titledeed];
				money -= (ttbuy/2);
				Bal += money;
				thePlayer.setBalance(Bal); //set to mortgaged in tile objects
				owned[titledeed] = prevown;
				//System.out.println("Mortgage: "+tdBuy[titledeed]+", "+titledeed+", "+money+", "+(ttbuy/2)+", "+prevown);
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+
						"Pay to bank half of the mortgage.<br>"+(ttbuy/2)+" denarius paid to the bank.</div></html>");
				}
		}
		if(e.getSource() == hmenu) {
			//user guide
			new HelpMenu();
		}
		if(e.getSource()== mmenu){
			//exit for main menu
			dispose();
			new MainMenu();
		}
		if(e.getSource()== ending){
			//here it goes again
			rolling.setEnabled(true);
			tdbtn.setIcon(new ImageIcon("")); //you get nothing
			chabtn.setIcon(new ImageIcon(""));
			statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\"></div></html>");
		} //ends current turn
    } //ends Action	
} //end of class