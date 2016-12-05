package pieces;
//Loading the board [fonts for board.jpg: Verdana 8pt, 6pt, 8pt bold]
//position vs titledeed cards need to be fixed
import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;

//debugging tokens
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import menu.HelpMenu;
import events.*;
import own.*;
import pieces.Dice;
import tile.Properties;


public class Board extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton rolling, buying, mortgage, unmortgage, improve, ending, mmenu, hmenu, token1, token2, token3, token4, token5, token6, token7, token8, plbtn, chabtn, statusbtn, dicez, dice2thereckoning, tdbtn;
	//JButton sell;

	JFrame boardFrame = new JFrame("Stats");
	JPanel stats = new JPanel();
	Turn theTurn = new Turn(); //pulling player's turn

	int turnCounter = 0;
	//public int titledeed = 28; //buy picks
	int buymort = 0; //counter for buy or mortgage
	//board positions
	public int Prev;
	int k = 0; //doubles counter
	int j = 0; //jail counter
	int td = 0; //count owned items
	String tdowned = " "; //print owned spaces
	String tdmort = " "; //print mortgaged spaces
	int chacard;
	String chaimg;
	String chaout;
	int dice1 = 0;
	int dice2 = 0;
	int diet;
	Properties [] prop;
	Players [] play;
    
	//the name of the spaces with title deeds
    String[] tdPlaces = {"Germania Inferior","Germania Superior","Alpes Poeniae","Alpes Cottiae","Aples Maritimae","Aquitania","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia","Sewers","Aqueducts","Via Appia","Via Flaminia","Via Aemilia","Via Popillia",""};
	//title deed card image names
	String[] tdimages = {"Purple_GermaniaI","Purple_GermaniaS","BBlue_APoeniae","BBlue_ACottiae","BBlue_AMaritimae","DPink_Aquitania","DPink_Belgica","DPink_Raetia","Orange_AProconsularis","Orange_Asia","Orange_Britannia","Red_Cilicia","Red_Galatia","Red_Cappadocia","Yellow_Aegyptus","Yellow_APetraea","Yellow_Syria","Green_Macedonia","Green_Epirus","Green_Achaia","Blue_Sicilia", "Blue_Italia","Utility_Sewers","Utility_Aqueducts","Via_Appia","Via_Flaminia","Via_Aemilia","Via_Popillia",""};
	//all spaces
	String[] board = {"Go","Germania Inferior","Community Chest","Germania Superior","Render unto Caesar","Via Appia","Alpes Poeniae","Chance","Alpes Cottiae","Alpes Maritimae","See a battle","Arena","Aquitania","Sewers","Belgica","Raetia","Via Flaminia","Africa Proconsularis","Community Chest","Asia","Britannia","Free Market","Cilicia","Chance","Galatia","Cappadocia","Via Aemilia","Aegyptus","Arabia Petraea","Aqueducts","Syria","Go to the Arena","Macedonia","Epirus","Community Chest","Achaia","Via Popillia","Chance","Sicilia","Citizens Tax","Italia"};
	//token movement setBounds(x[Pos],y[Pos])
    int[] x = {9,96,152,208,264,320,376,432,488,544,660,600,600,600,600,600,600,600,600,600,600,600,543,488,432,376,320,264,208,152,96,9,52,52,52,52,52,52,52,52,52};
    int[] y = {11,11,11,11,11,11,11,11,11,11,1,35,97,154,209,265,322,377,432,490,544,601,601,601,601,601,601,601,601,601,601,601,545,489,434,377,322,265,209,154,97};
	
    
	public Board(Properties [] propArr, Players [] playArr) {	
		this.prop = propArr;
		this.play = playArr;
		
		Players thePlayer = playArr[turnCounter]; 
		//Properties theProperty = propArr[thePlayer.getPosition()];
		
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
	unmortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>U</u>nMortgage</div>");
	improve = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>I</u>mprovements</div>");
	//sell = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>S</u>ell</div>");
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>E</u>nd Turn</div>");
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>H</u>elp Menu</div>");
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>E</u>xit Game</div>");
		rolling.setBackground(new Color(73,175,47));
		buying.setBackground(new Color(167,39,88));
		mortgage.setBackground(new Color(247, 153, 22));
		unmortgage.setBackground(new Color(247, 153, 22));
		improve.setBackground(new Color(68, 35, 90));
		//sell.setBackground(new Color(71,71,255));
		ending.setBackground(new Color(0, 0, 0));
		hmenu.setBackground(new Color(0, 0, 0));
		mmenu.setBackground(new Color(226, 40, 53));

	//dice, cards, and token images	
	JLabel die1=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice1+".png"));
	JLabel die2=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
	//JLabel token1 = new JLabel(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
	JLabel tdimg = new JLabel(new ImageIcon(""));
	JLabel chanceimg = new JLabel(new ImageIcon(chaimg));
	
	//where images are stored
	dicez = new JButton();
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
	plbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName() + "<br/>" + "Balance: "+thePlayer.getBalance()+
			" denarius <br/>Space: "+board[thePlayer.getPosition()]+
			", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+thePlayer.getJail()+", Doubles Counter: "+thePlayer.getDoubles()+"</div></html>");
	statusbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\"></div></html>");
	dicez.add(die1);
	dice2thereckoning.add(die2);
	
	rolling.addActionListener(this);
	buying.addActionListener(this);
	mortgage.addActionListener(this);
	unmortgage.addActionListener(this);
	improve.addActionListener(this);
	//sell.addActionListener(this);
	ending.addActionListener(this);
	mmenu.addActionListener(this);
	hmenu.addActionListener(this);
	tdbtn.addActionListener(this);
	token1.addActionListener(this); //tokens 1-8, add to ActionListener
	token2.addActionListener(this);
	token3.addActionListener(this);
	token4.addActionListener(this);
	token5.addActionListener(this);
	token6.addActionListener(this);
	token7.addActionListener(this);
	token8.addActionListener(this);
	
	background.add(token1); //add to the board in the jframe background
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
	stats.setBounds(60, 0, 300, 700);
	front.setBounds(120, 369, 450, 200);
	front.setBorder(null);
	dicez.setBorder(null);
	tdbtn.setBorder(null);
	chabtn.setBorder(null);
	plbtn.setBorder(null);
	statusbtn.setBorder(null);
	dice2thereckoning.setBorder(null);
	token1.setBorder(null); //remove black border
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
	
	dicez.setBounds(259, 266, 50, 50);
	dice2thereckoning.setBounds(309, 266, 50, 50);
	tdbtn.setBounds(98,98,155,230); //on board
	plbtn.setBounds(0,10,100,100);
	chabtn.setBounds(230,170,50,230);
	
	front.add(rolling);
	front.add(buying);
	front.add(mortgage);
	front.add(unmortgage);
	front.add(improve);
	//front.add(sell);
	front.add(ending);
	front.add(hmenu);
	front.add(mmenu);
	stats.add(plbtn);
	stats.add(statusbtn);
	
	tdbtn.add(tdimg); //title deed cards
	chabtn.add(chanceimg); //chance cards
	stats.add(chabtn);
	
	//nope totally not buttons
	token1.setOpaque(false);
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
	if(thePlayer.getOwner() == true);
	{
		mortgage.setEnabled(true);
	}
	unmortgage.setEnabled(false);
	improve.setEnabled(true);
	//sell.setEnabled(false);
	ending.setEnabled(false);

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
		
		Players thePlayer = play[turnCounter];
		Properties theProperty = prop[thePlayer.getPosition()];
		
		if(e.getSource() == rolling) {
			//start turn
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			if(thePlayer.getOwner() == true);
			{
				mortgage.setEnabled(true);
			}
			ending.setEnabled(false);
			
			tdowned = ""; //set to blank
			tdmort = "";
			td = 0;
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getMortgaged() != 0) {
		        	 tdmort += (prop[i].getName()+" - "+play[prop[i].getMortgaged()-1].getName()+"<br/>"); td++;
		        }
		    }
			
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getPurchaseAllowed() != false) {
		        	 tdowned += (prop[i].getName()+" - "+play[prop[i].getOwner()-1].getName()+"<br/>"); td++;
		        }
		    }  
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		 //checks for owned properties and outputs to stats jframe

			Prev = thePlayer.getPosition();
			Dice theDice = new Dice();
		    dice1 = theDice.getDie1();
		    dice2 = theDice.getDie2();
		    if (j == 0) {
			thePlayer.setPosition((Prev + dice1 + dice2) % 40);
		    } //prevent token from moving out of jail, dice still need to roll
			theTurn.TurnAction(prop, play, Prev, dice1, dice2, j, turnCounter);
			j = theTurn.getTjail();
		    
			theTurn.setDice1(dice1);
			theTurn.setDice2(dice2);
			chaimg = theTurn.getChaimg();
			
			if (Prev < 10 && thePlayer.getPosition() > 10) {
				thePlayer.setPosition(12);
				if (thePlayer.getPosition()> 39) {
					thePlayer.setPosition(0);
				}
			}
			if (thePlayer.getPosition() == 31) {
				thePlayer.setPosition(11); 
			}
			
			dicez.setIcon(new ImageIcon("src/pieces/images/Dice"+dice1+".png")); //refresh img dice
			dice2thereckoning.setIcon(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
			tdbtn.setIcon(new ImageIcon("src/cards/images/"+prop[thePlayer.getPosition()].getImageName()));
			if (turnCounter == 0) {
			token1.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
			token1.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 1 update token movement
			if (turnCounter == 1) {
				token2.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token2.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 2 update token movement
			if (turnCounter == 2) {
				token3.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token3.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 3 update token movement
			if (turnCounter == 3) {
				token4.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token4.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 4 update token movement
			if (turnCounter == 4) {
				token5.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token5.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 5 update token movement
			if (turnCounter == 5) {
				token6.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token6.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 6 update token movement
			if (turnCounter == 6) {
				token7.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token7.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 7 update token movement
			if (turnCounter == 7) {
				token8.setBounds(x[thePlayer.getPosition()], y[thePlayer.getPosition()], 50, 56);
				token8.setIcon(new ImageIcon("src/pieces/images/"+play[turnCounter].getToken()));
			} //player 8 update token movement
			
			chabtn.setIcon(new ImageIcon(chaimg)); //doesn't work right now without a loop to update it
			Prev = thePlayer.getPosition();
			thePlayer.setPosition(Prev);
			theTurn.setPrev(Prev);
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
			
			statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+theTurn.getStatustxt()+"</div></html>");
			
			if (prop[thePlayer.getPosition()].getPurchaseAllowed() != false && prop[thePlayer.getPosition()].getOwner() == 0) {
				if (thePlayer.getBalance() >= prop[thePlayer.getPosition()].getCost()) {
						buying.setEnabled(true);
				} //if space isn't already purchased
			} //must be ownable and not owned
			/*
			if (prop[thePlayer.getPosition()].getPurchaseAllowed() != false){
				mortgage.setEnabled(true);
				}*/
            if (thePlayer.getBalance() >= prop[thePlayer.getPosition()].getMortgage()) {
            	if (thePlayer.getBalance() < prop[thePlayer.getPosition()].getMortgage()) {
    				mortgage.setEnabled(false);
    				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">You do not have enough funds to mortgage this space.</div></html>");
    				}
            }
            
			if (prop[thePlayer.getPosition()].getPurchaseAllowed() != false) {
				if(thePlayer.getPlayerNumber() != prop[thePlayer.getPosition()].getOwner()){
					if(prop[thePlayer.getPosition()].getOwner() != 0 && prop[thePlayer.getPosition()].getMortgaged() == 0) {
						Rent theRent = new Rent(play, prop, turnCounter,(dice1+dice2));
						statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">"+theRent.getRenttxt()+"</div></html>");
					} //if not owned by current person and is not mortgaged
				}
			} //pay rent
			ending.setEnabled(true);
			if (thePlayer.getBalance() <= 0) {
				//System.out.println("Game over.");
				statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Game Over.</div></html>");
				rolling.setEnabled(false);
				buying.setEnabled(false);
				mortgage.setEnabled(false);
				if(thePlayer.getOwner() == true);
				{
					mortgage.setEnabled(true);
				}
				ending.setEnabled(false);
				hmenu.setEnabled(false);
			}
		}
		if(e.getSource() == buying) {
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			if(thePlayer.getOwner() == true);
			{
				mortgage.setEnabled(true);
			}
			ending.setEnabled(true);
			
			new Purchase(thePlayer, prop[thePlayer.getPosition()], thePlayer.getBalance());
			tdowned = ""; //set to blank
			td = 0;
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getPurchaseAllowed() != false) {
		        	 tdowned += (prop[i].getName()+" - "+play[prop[i].getOwner()-1].getName()+"<br/>"); td++;
		        }
		    }
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		} //buy property
		if(e.getSource() == mortgage) {
            rolling.setEnabled(false);
            buying.setEnabled(false);
            mortgage.setEnabled(false);
            if(thePlayer.getOwner() == true);
        	{
        		mortgage.setEnabled(true);
        	}
            ending.setEnabled(true);
            
            if(e.getSource() == mortgage) {
                //mortgage property
                rolling.setEnabled(false);
                buying.setEnabled(false);
                mortgage.setEnabled(false);
                ending.setEnabled(true);

                String[] choices = { "Germania Inferior", "Germania Superior", "Alps Poeniae", "Alps Cottiae", "Alps Maritimae", "Aquitanina","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia"};
                String input = (String) JOptionPane.showInputDialog(null, "Choose a property to mortgage","Properties", JOptionPane.QUESTION_MESSAGE, null,choices,choices[1]); // Initial choice
                String propName = input;
                Properties mortProp = null;
                for(int i = 0; i < prop.length; i++){
                    if(propName == prop[i].getName()){
                        mortProp = prop[i]; 
                    } 
                new Mortgage(thePlayer, mortProp);
                }

                plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+    " denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
                        ", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
            }
   	    } //find all unowned properties
		if(e.getSource() == hmenu) {
			//user guide
			new HelpMenu();
		}
		if(e.getSource()== mmenu){
			System.exit(0); //exit
		}
		if(e.getSource()== unmortgage){

		}
		if(e.getSource()== improve) {
			new Improvements(thePlayer, theProperty, play, prop);
		} //villas and pantheons
		//if(e.getSource()== sell) {}
		if(e.getSource()== ending) {
			//here it goes again
			rolling.setEnabled(true);
			ending.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			if(thePlayer.getOwner() == true);
			{
				mortgage.setEnabled(true);
			}
			tdbtn.setIcon(new ImageIcon("")); //you get nothing
			chabtn.setIcon(new ImageIcon(""));
			statusbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\"></div></html>");
			
			if(turnCounter < 7){
				turnCounter++;
			} else {
				turnCounter = 0;
			}
			tdowned = ""; //set to blank
			tdmort = "";
			td = 0;
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getMortgaged() != 0) {
		        	 tdmort += (prop[i].getName()+" - "+play[prop[i].getMortgaged()-1].getName()+"<br/>"); td++;
		        }
		    }
			
			for(int i=0; i<prop.length; i++) {
		         if(prop[i].getOwner() != 0 && prop[i].getPurchaseAllowed() != false) {
		        	 tdowned += (prop[i].getName()+" - "+play[prop[i].getOwner()-1].getName()+"<br/>"); td++;
		        }
		    }  
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 267px; font-size: 11pt; padding-left: 10px;\">Player: " +thePlayer.getName()+  "<br/>" + "Balance: "+thePlayer.getBalance()+	" denarius <br/>Space: "+prop[thePlayer.getPosition()].getName()+
					", <br/>Buy cost: "+prop[thePlayer.getPosition()].getCost()+" denarius <br/>Jail Counter: "+play[turnCounter].getJail()+", Doubles Counter: "+play[turnCounter].getDoubles()+"<br/><br/>Owned properties: <br/>"+tdowned+"<br/>Mortgaged properties: <br/>"+tdmort+"<br/><br/></div></html>");
		}//ends current turn
		
    } //ends Action	
	public int getTurnCounter(){
		return this.turnCounter;
	}
} //end of class