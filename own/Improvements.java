package own;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import events.Players;
import tile.Properties;

public class Improvements extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton close,no,yesG1, yesG2,yesG3,yesG5, yesG7, yesG8;
	JLabel status;
	String statustxt;
	String button1, button2;
	Players currentPlayer;
	Properties currentProperty;
	Properties [] prArray;
	Players [] plArray;
	Properties m1, m2;
	
	public Improvements(Players play, Properties prop, Players [] playArr, Properties [] propArr){
		this.currentPlayer = play;
		this.currentProperty = prop;
		this.plArray = playArr;
		this.prArray = propArr;
		Properties match1 = null;
		Properties match2 = null;		
		
		int group = currentProperty.getGroup();
		System.out.println(currentProperty.getName()+", "+currentProperty.getGroup());
		if(group == 11 || group == 10 || group == 9){
			setTitle("Improvements");
			setSize(200,250); //window size
			setLocation(255,290);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLayout(new BorderLayout());
			JPanel front = new JPanel();
			front.setLayout(null);
			add(front, BorderLayout.CENTER);

			statustxt = "You cannot purchase villas or pantheons on this property.";
		
			button1 = "<u>C</u>lose";
			close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
			close.setBackground(new Color(73,175,47));
		
			front.add(status);
			front.add(close);
		
			status.setBounds(20,0,150,50);
			close.setBounds(20, 60, 150, 50);
		
			close.addActionListener(this);
			repaint();
		}
		else{
			for(int k = 0; k < propArr.length; k ++){
				if(propArr[k] != currentProperty){
				if(propArr[k].getGroup() == group){
					match1 = propArr[k];
					this.m1 = match1;
					int j = k;
						if(propArr[j].getGroup() == group){
							match2 = propArr[j];
							this.m2 = match2;
						}
					}
				}
			}
		}
		
		
		boolean totalGroup = checkGroup(currentProperty, propArr);
			if(totalGroup == true) {
				if(currentProperty.getPantheons() > 0){
					setTitle("Improvements");
					setSize(200,250); //window size
					setLocation(255,290);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					setVisible(true);
					setLayout(new BorderLayout());
					JPanel front = new JPanel();
					front.setLayout(null);
					add(front, BorderLayout.CENTER);

					statustxt = "You already have a Pantheon on these properties, you cannot improve them anymore";	
				
					button1 = "<u>C</u>lose";
					close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
					status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
					close.setBackground(new Color(73,175,47));
				
					front.add(status);
					front.add(close);
				
					status.setBounds(20,0,150,50);
					close.setBounds(20, 60, 150, 50);
				
					close.addActionListener(this);
					repaint();
				}
				else if(group == 1 || group == 2) {
					if(group == 1){
						setTitle("Improvements");
						setSize(200,250); //window size
						setLocation(255,290);
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						setVisible(true);
						setLayout(new BorderLayout());
						JPanel front = new JPanel();
						front.setLayout(null);
						add(front, BorderLayout.CENTER);
							
						statustxt = "You must buy villas/pantheons 2 at a time for this group, do you want to proceed?";
							
						button1 = "<u>Y</u>es Property";
						button2 = "<u>N</u>0 Property";
						yesG1=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
						no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
						status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
						close.setBackground(new Color(73,175,47));
						
						front.add(status);
						front.add(close);
							
						status.setBounds(20,0,150,50);
						close.setBounds(20, 60, 150, 50);
							
						close.addActionListener(this);
						}
					else if(group == 2) {
						setTitle("Improvements");
						setSize(200,250); //window size
						setLocation(255,290);
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						setVisible(true);
						setLayout(new BorderLayout());
						JPanel front = new JPanel();
						front.setLayout(null);
						add(front, BorderLayout.CENTER);
								
						statustxt = "You must buy villas/pantheons 3 at a time for this group, do you want to proceed?";
								
						button1 = "<u>Y</u>es Property";
						button2 = "<u>N</u>0 Property";
						yesG2=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
						no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
						status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
						close.setBackground(new Color(73,175,47));
							
						front.add(status);
						front.add(close);
							
						status.setBounds(20,0,150,50);
						close.setBounds(20, 60, 150, 50);
								
						close.addActionListener(this);
						}
				}
				if (group == 3 || group == 4){
						setTitle("Improvements");
						setSize(200,250); //window size
						setLocation(255,290);
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						setVisible(true);
						setLayout(new BorderLayout());
						JPanel front = new JPanel();
						front.setLayout(null);
						add(front, BorderLayout.CENTER);
								
						statustxt = "You must buy villas/pantheons 3 at a time for this group, do you want to proceed?";
								
						button1 = "<u>Y</u>es Property";
						button2 = "<u>N</u>0 Property";
						yesG3=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
						no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
						status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
						close.setBackground(new Color(73,175,47));
							
						front.add(status);
						front.add(close);
							
						status.setBounds(20,0,150,50);
						close.setBounds(20, 60, 150, 50);
								
						close.addActionListener(this);
					}
					else if(group == 5 || group == 6) {
						setTitle("Improvements");
						setSize(200,250); //window size
						setLocation(255,290);
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						setVisible(true);
						setLayout(new BorderLayout());
						JPanel front = new JPanel();
						front.setLayout(null);
						add(front, BorderLayout.CENTER);
								
						statustxt = "You must buy villas/pantheons 3 at a time for this group, do you want to proceed?";
								
						button1 = "<u>Y</u>es Property";
						button2 = "<u>N</u>0 Property";
						yesG5=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
						no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
						status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
						close.setBackground(new Color(73,175,47));
							
						front.add(status);
						front.add(close);
							
						status.setBounds(20,0,150,50);
						close.setBounds(20, 60, 150, 50);
								
						close.addActionListener(this);
					}
					else if(group == 7 || group == 8) {
						if(group == 7){
							setTitle("Improvements");
							setSize(200,250); //window size
							setLocation(255,290);
							setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							setVisible(true);
							setLayout(new BorderLayout());
							JPanel front = new JPanel();
							front.setLayout(null);
							add(front, BorderLayout.CENTER);
								
							statustxt = "You must buy villas/pantheons 3 at a time for this group, do you want to proceed?";
								
							button1 = "<u>Y</u>es Property";
							button2 = "<u>N</u>0 Property";
							yesG7=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
							no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
							status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
							close.setBackground(new Color(73,175,47));
							
							front.add(status);
							front.add(close);
								
							status.setBounds(20,0,150,50);
							close.setBounds(20, 60, 150, 50);
								
							close.addActionListener(this);
							}
						else if(group == 8) {
							setTitle("Improvements");
							setSize(200,250); //window size
							setLocation(255,290);
							setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							setVisible(true);
							setLayout(new BorderLayout());
							JPanel front = new JPanel();
							front.setLayout(null);
							add(front, BorderLayout.CENTER);
									
							statustxt = "You must buy villas/pantheons 2 at a time for this group, do you want to proceed?";
									
							button1 = "<u>Y</u>es Property";
							button2 = "<u>N</u>0 Property";
							yesG2=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
							no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
							status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
							close.setBackground(new Color(73,175,47));
								
							front.add(status);
							front.add(close);
								
							status.setBounds(20,0,150,50);
							close.setBounds(20, 60, 150, 50);
									
							close.addActionListener(this);
							}
					}
				}
				else{
					System.out.print("You do not own all of the properties in this group. You cannot buy houses or pantheons");
				}
			}
	public boolean checkGroup(Properties prop, Properties [] arr) {
		int propertyGroup = prop.getGroup();
		int owner = prop.getOwner();
		Properties test1;
		Properties test2;
		boolean returnValue = false;
		
		if(propertyGroup == 1 || propertyGroup == 8){
			for(int i = 0; i < arr.length; i++){
				test1 = arr[i];
				if(owner == test1.getOwner() && propertyGroup == test1.getGroup()){
					returnValue = true;
				}
			}
		}
		else{
			for(int j = 0; j < arr.length; j++){
				test1 = arr[j];
				if(owner == test1.getOwner() && propertyGroup == test1.getGroup()){
					for(int k = j; k < arr.length; k++){
						test2 = arr[k];
						if(owner == test2.getOwner() && propertyGroup == test2.getGroup()){
							returnValue = true;
						}
						else{
							returnValue = false;
						}
					}
				}
				else returnValue = false;
			}
		}
		repaint();	
		return returnValue;	
	} //end of buy improvements

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			dispose();
		}
		else if(e.getSource() == yesG1){
			int houseCost = 50;
			if(currentPlayer.getBalance() > (houseCost*2)){
				if(currentProperty.getVillas() > 3){
					currentProperty.setVillas(0);
					m1.setVillas(0);
					currentProperty.setPantheons(1);
					m1.setPantheons(1);
					int newBalance = currentPlayer.getBalance() - (houseCost*2);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				else{
					int addVilla = currentProperty.getVillas() + 1;
					currentProperty.setVillas(addVilla);
					m1.setVillas(addVilla);
					int newBalance = currentPlayer.getBalance() - (houseCost*2);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				status.repaint();
			}
			else{
				statustxt = "You do not have enough money to buy these villas/pantheon";
				//fix
			}
		}
		else if(e.getSource() == yesG2){
			int houseCost = 50;
			if(currentPlayer.getBalance() > (houseCost*3)){
				if(currentProperty.getVillas() > 3){
					currentProperty.setVillas(0);
					m1.setVillas(0);
					m2.setVillas(0);
					currentProperty.setPantheons(1);
					m1.setPantheons(1);
					m2.setPantheons(1);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				else {
					int addVilla = currentProperty.getVillas() + 1;
					currentProperty.setVillas(addVilla);
					m1.setVillas(addVilla);
					m2.setVillas(addVilla);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				status.repaint();
			}
			else{
				statustxt = "You do not have enough money to buy these villas/pantheon";
				//fix
			}
		}
		else if(e.getSource() == yesG3){
			int houseCost = 100;
			if(currentPlayer.getBalance() > (houseCost*3)){
				if(currentProperty.getVillas() > 3){
					currentProperty.setVillas(0);
					m1.setVillas(0);
					m2.setVillas(0);
					currentProperty.setPantheons(1);
					m1.setPantheons(1);
					m2.setPantheons(1);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				else {
					int addVilla = currentProperty.getVillas() + 1;
					currentProperty.setVillas(addVilla);
					m1.setVillas(addVilla);
					m2.setVillas(addVilla);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				status.repaint();
			}
			else{
				statustxt = "You do not have enough money to buy these villas/pantheon";
				//fix
			}
		}
		else if(e.getSource() == yesG3){
			int houseCost = 150;
			if(currentPlayer.getBalance() > (houseCost*3)){
				if(currentProperty.getVillas() > 3){
					currentProperty.setVillas(0);
					m1.setVillas(0);
					m2.setVillas(0);
					currentProperty.setPantheons(1);
					m1.setPantheons(1);
					m2.setPantheons(1);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				else {
					int addVilla = currentProperty.getVillas() + 1;
					currentProperty.setVillas(addVilla);
					m1.setVillas(addVilla);
					m2.setVillas(addVilla);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				status.repaint();
			}
			else{
				statustxt = "You do not have enough money to buy these villas/pantheon";
				//fix
			}
		}
		else if(e.getSource() == yesG7){
			int houseCost = 200;
			if(currentPlayer.getBalance() > (houseCost*3)){
				if(currentProperty.getVillas() > 3){
					currentProperty.setVillas(0);
					m1.setVillas(0);
					m2.setVillas(0);
					currentProperty.setPantheons(1);
					m1.setPantheons(1);
					m2.setPantheons(1);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				else {
					int addVilla = currentProperty.getVillas() + 1;
					currentProperty.setVillas(addVilla);
					m1.setVillas(addVilla);
					m2.setVillas(addVilla);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				status.repaint();
			}
		}
		else if(e.getSource() == yesG8){
			int houseCost = 200;
			if(currentPlayer.getBalance() > (houseCost*2)){
				if(currentProperty.getVillas() > 3){
					currentProperty.setVillas(0);
					m1.setVillas(0);
					m2.setVillas(0);
					currentProperty.setPantheons(1);
					m1.setPantheons(1);
					m2.setPantheons(1);
					int newBalance = currentPlayer.getBalance() - (houseCost*3);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				else {
					int addVilla = currentProperty.getVillas() + 1;
					currentProperty.setVillas(addVilla);
					m1.setVillas(addVilla);
					m2.setVillas(addVilla);
					int newBalance = currentPlayer.getBalance() - (houseCost*2);
					currentPlayer.setBalance(newBalance);
					dispose();
				}
				status.repaint();
			}
		}
		else if(e.getSource() == no){
			dispose();
		}
	}
} //end of action

