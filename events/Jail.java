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
	String answer; //yes or no
	String btnyes; //yes or no button text
	String btnno;
	String statustxt = "Would you like to use your Get out of the Arena free card?";
	int k = 0;
	
	public Jail(Players play) {
			setTitle("Jail");
			setSize(200,250); //window size
			setLocation(255,290);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLayout(new BorderLayout());
			JPanel front = new JPanel(); //no layout storage for buttons
			front.setLayout(null);
			add(front, BorderLayout.CENTER);
			
			btnyes = "<u>G</u>et out of Arena";
			btnno = "<u>S</u>tay in the Arena";
			yes=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+btnyes+"</div>");
			no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+btnno+"</div>");
			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
			yes.setBackground(new Color(73,175,47));
			no.setBackground(new Color(128,0,0));
			
			front.add(status);
			front.add(yes);
			front.add(no);
			
			status.setBounds(20,0,150,50);
			yes.setBounds(20, 60, 150, 50);
			no.setBounds(20, 120, 150, 50);
			//yes.setEnabled(false); //not available till needed
			//no.setEnabled(false);
			
			yes.addActionListener(this);
			no.addActionListener(this);
			repaint(); //add all items to JFrame with refresh

		if (play.getOutJail() > 0) {
			//message with Jbutton to ask if they want to use their card
			if (answer == "yes") {//yes
				//int subtract = play.getOutJail() - 1;
				play.setPosition(10);
				play.setJailCounter(0);
				//message that they used their card
			}
			else{rollTheDice(play);}
		}
		else{rollTheDice(play);}
		//roll the dice 
		status.repaint();
	}
	public Jail(String statustxt) {
		this.statustxt = statustxt;
	}
public void rollTheDice(Players play) {
		Dice dice = new Dice();
		int die1 = dice.getDie1();
		int die2 = dice.getDie2();
		
		k = (die1 == die2) ? k++ : 0; //if matching: k++ otherwise zero
		k = k % 3; //doubles: 0 none, 1-2 doubles in a row, 3 jail
		play.setDoubles(k);
		
		if (k == 1) {statustxt = "Doubles! Roll again.";}
		if (k > 2) {
			statustxt = "You have rolled doubles 3 times, Go to the Arena.";
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
		if (k > 3) {k = 4 - k;} //stay in array bounds
		//doubles[k]++; //increment array
		status.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yes) {
			answer = "yes";
			
			status.setText("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
			dispose();
		}
		if(e.getSource() == no) {
			answer = "no";
			
			status.setText("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
			dispose();
		}
	}
	public String getJailtxt() {return statustxt;} //update text in stats frame on board
}
