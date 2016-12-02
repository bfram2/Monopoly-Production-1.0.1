package events;
import events.Players;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pieces.Dice;

import java.awt.*;
//import java.awt.Color;
//import java.awt.BorderLayout;


public class Jail extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton yes, no;
	JLabel status;
	String statustxt = "";
	int k = 0;
	
	public Jail(Players play) {
			setTitle("Monopoly");
			setSize(609,454); //window size
			setLocation(50,100);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			//pack();
			setLayout(new BorderLayout());
			yes=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 50px 5px 50px;\"><u>G</u>et out of Arena<br/><span style=\"font-size: 9pt\">use card</span></div>");
			no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>S</u>tay in the Arena</div>");
			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 10pt; padding: 5px;\">"+statustxt+"</div>");
			yes.setBackground(new Color(73,175,47));
			no.setBackground(new Color(128,0,0));
			
			add(yes, BorderLayout.CENTER);
			add(no, BorderLayout.CENTER);
			add(status);
			yes.setEnabled(false);
			no.setEnabled(false);
			yes.addActionListener(this);
			no.addActionListener(this);

		if(play.getOutJail() > 0) {
			//message with Jbutton to ask if they want to use their card
			String y = "yes";
			if (y == "yes") {//yes
				//int subtract = play.getOutJail() - 1;
				play.setPosition(10);
				play.setJailCounter(0);
				//message that they used their card
			}
			else{rollTheDice(play);}
		}
		else{rollTheDice(play);}
		//roll the dice 
		
	}	
public void rollTheDice(Players play){
		
		Dice dice = new Dice();
		int die1 = dice.getDie1();
		int die2 = dice.getDie2();
		//int[] doubles = new int[3];
		
		k = (die1 == die2) ? k++ : 0; //if matching: k++ otherwise zero
		k = k % 3; //doubles: 0 none, 3 jail
		play.setDoubles(k);
		
		if (k == 1) {System.out.println("Doubles! Roll again.");}
		if (k > 2) {
			System.out.println("You have rolled doubles 3 times, Go to the Arena.");
			play.setPosition(11); //go to the arena
			play.setDoubles(0);
			play.setJailCounter(1);
		}
	
		if(play.getPosition() == 11 && die1 == die2) {
			play.setPosition(10);
			play.setJailCounter(0);
			//display message that they rolled doubles and got out for free
		}
		else if (play.getPosition() == 11 && die1 != die2) {
			int increment = play.getJailCounter() + 1;
			play.setJailCounter(increment);
			if(play.getJailCounter() == 3){
				//display message that they paid and are now out of jail
				int changeBalance = play.getBalance() - 50;
				play.setPosition(10);
				play.setBalance(changeBalance);
				play.setJailCounter(0);
			}
			else if(play.getJailCounter() < 3){
				//display message that they did not roll doubles
			}
		}
		//if (k > 3) {k = 4 - k;} //stay in array bounds
		//doubles[k]++; //incrememnt array
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yes) {
			//play.setOutJail(play.getOutJail() - 1);
			//play.setJailCounter(0);
			//play.setPosition(10);
			status.setText("<html><center><div style=\"color: black; font-family: verdana; font-size: 10pt; padding: 5px;\">"+statustxt+"</div>");
		}
		if(e.getSource() == no) {
			//play.setJailCounter(play.getJailCounter() + 1);
			status.setText("<html><center><div style=\"color: black; font-family: verdana; font-size: 10pt; padding: 5px;\">"+statustxt+"</div>");
		}
	}
}
