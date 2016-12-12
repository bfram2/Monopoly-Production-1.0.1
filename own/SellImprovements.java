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

public class SellImprovements extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		JButton close;
		JLabel status;
		String statustxt;
		String button1, button2;
		int group, sellPrice, newBalance, currentVillas;
		Properties prop2 = null;
		Properties prop3 = null;
		
		public SellImprovements(Properties prop1, Properties [] propArr, Players play){
			group = prop1.getGroup();
			currentVillas = prop1.getVillas();
			if(prop1.getOwner() != play.getPlayerNumber()){
				setTitle("Sell Improvments");
	 			setSize(200,250); //window size
	 			setLocation(255,290);
	 			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 			setVisible(true);
	 			setLayout(new BorderLayout());
	 			JPanel front = new JPanel();
	 			front.setLayout(null);
	 			add(front, BorderLayout.CENTER);

	 			statustxt = "You do not own this property";	
		
	 			button1 = "<u>C</u>lose";
	 			close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
	 			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
	 			close.setBackground(new Color(73,175,47));
		
	 			front.add(status);
	 			front.add(close);
		
	 			status.setBounds(20,0,150,150);
				close.setBounds(20, 160, 150, 50);
		
	 			close.addActionListener(this);
			}
			else if(prop1.getVillas() == 0 || prop1.getPantheons() == 0){
				setTitle("Sell Improvments");
	 			setSize(200,250); //window size
	 			setLocation(255,290);
	 			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 			setVisible(true);
	 			setLayout(new BorderLayout());
	 			JPanel front = new JPanel();
	 			front.setLayout(null);
	 			add(front, BorderLayout.CENTER);

	 			statustxt = "There are not any improvements on this property to sell";	
		
	 			button1 = "<u>C</u>lose";
	 			close=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
	 			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
	 			close.setBackground(new Color(73,175,47));
		
	 			front.add(status);
	 			front.add(close);
		
	 			status.setBounds(20,0,150,150);
				close.setBounds(20, 160, 150, 50);
		
	 			close.addActionListener(this);
			}
			else{
				if(prop1.getPantheons() == 1){
					if(group == 1){
						prop1.setPantheons(0);
						prop1.setVillas(4);
						for(int i = 0; i < propArr.length; i++){
							if(propArr[i] != prop1 && propArr[i].getGroup() == group){
								prop2.setPantheons(0);
								prop2.setVillas(4);
								propArr[i] = prop2;
								newBalance = play.getBalance() + 50;
								play.setBalance(newBalance);
								break;
							}
						}
					}
					else if(group == 2){
						prop1.setPantheons(0);
						prop1.setVillas(4);
						for(int i = 0; i < propArr.length; i++){
							if(propArr[i] != prop1 && propArr[i].getGroup() == group){
								prop2.setPantheons(0);
								prop2.setVillas(4);
								propArr[i] = prop2;
								for(int j = i++; j<propArr.length; j++){
									prop3.setPantheons(0);
									prop3.setVillas(4);
									propArr[j] = prop3;
									newBalance = play.getBalance() + 75;
									play.setBalance(newBalance);
								}
							}
						}
					}
					else if(group == 3 || group == 4){
						prop1.setPantheons(0);
						prop1.setVillas(4);
						for(int i = 0; i < propArr.length; i++){
							if(propArr[i] != prop1 && propArr[i].getGroup() == group){
								prop2.setPantheons(0);
								prop2.setVillas(4);
								propArr[i] = prop2;
								for(int j = i++; j<propArr.length; j++){
									prop3.setPantheons(0);
									prop3.setVillas(4);
									propArr[j] = prop3;
									newBalance = play.getBalance() + 150;
									play.setBalance(newBalance);
								}
							}
						}
					}
					else if(group == 5 || group == 6){
						prop1.setPantheons(0);
						prop1.setVillas(4);
						for(int i = 0; i < propArr.length; i++){
							if(propArr[i] != prop1 && propArr[i].getGroup() == group){
								prop2.setPantheons(0);
								prop2.setVillas(4);
								propArr[i] = prop2;
								for(int j = i++; j<propArr.length; j++){
									prop3.setPantheons(0);
									prop3.setVillas(4);
									propArr[j] = prop3;
									newBalance = play.getBalance() + 225;
									play.setBalance(newBalance);
								}
							}
						}
					}
					else if(group == 7){
						prop1.setPantheons(0);
						prop1.setVillas(4);
						for(int i = 0; i < propArr.length; i++){
							if(propArr[i] != prop1 && propArr[i].getGroup() == group){
								prop2.setPantheons(0);
								prop2.setVillas(4);
								propArr[i] = prop2;
								for(int j = i++; j<propArr.length; j++){
									prop3.setPantheons(0);
									prop3.setVillas(4);
									propArr[j] = prop3;
									newBalance = play.getBalance() + 300;
									play.setBalance(newBalance);
								}
							}
						}
					}
					else if(group == 8){
						prop1.setPantheons(0);
						prop1.setVillas(4);
						for(int i = 0; i < propArr.length; i++){
							if(propArr[i] != prop1 && propArr[i].getGroup() == group){
								prop2.setPantheons(0);
								prop2.setVillas(4);
								propArr[i] = prop2;
								newBalance = play.getBalance() + 200;
								play.setBalance(newBalance);
								break;
							}
						}
					}
				}
			else if(prop1.getPantheons() == 0){
				if(group == 1){
					prop1.setVillas(currentVillas - 1);
					for(int i = 0; i < propArr.length; i++){
						if(propArr[i] != prop1 && propArr[i].getGroup() == group){
							prop2.setVillas(currentVillas - 1);
							propArr[i] = prop2;
							newBalance = play.getBalance() + 50;
							play.setBalance(newBalance);
							break;
						}
					}
				}
				else if(group == 2){
					prop1.setVillas(currentVillas - 1);
					for(int i = 0; i < propArr.length; i++){
						if(propArr[i] != prop1 && propArr[i].getGroup() == group){
							prop2.setPantheons(0);
							prop2.setVillas(4);
							propArr[i] = prop2;
							for(int j = i++; j<propArr.length; j++){
								prop3.setVillas(currentVillas - 1);
								propArr[j] = prop3;
								newBalance = play.getBalance() + 75;
								play.setBalance(newBalance);
							}
						}
					}
				}
				else if(group == 3 || group == 4){
					prop1.setVillas(currentVillas - 1);
					for(int i = 0; i < propArr.length; i++){
						if(propArr[i] != prop1 && propArr[i].getGroup() == group){
							prop2.setPantheons(0);
							prop2.setVillas(4);
							propArr[i] = prop2;
							for(int j = i++; j<propArr.length; j++){
								prop3.setVillas(currentVillas - 1);
								propArr[j] = prop3;
								newBalance = play.getBalance() + 150;
								play.setBalance(newBalance);
							}
						}
					}
				}
				else if(group == 5 || group == 6){
					prop1.setVillas(currentVillas - 1);
					for(int i = 0; i < propArr.length; i++){
						if(propArr[i] != prop1 && propArr[i].getGroup() == group){
							prop2.setPantheons(0);
							prop2.setVillas(4);
							propArr[i] = prop2;
							for(int j = i++; j<propArr.length; j++){
								prop3.setVillas(currentVillas - 1);
								propArr[j] = prop3;
								newBalance = play.getBalance() + 225;
								play.setBalance(newBalance);
							}
						}
					}
				}
				else if(group == 7){
					prop1.setVillas(currentVillas - 1);
					for(int i = 0; i < propArr.length; i++){
						if(propArr[i] != prop1 && propArr[i].getGroup() == group){
							prop2.setPantheons(0);
							prop2.setVillas(4);
							propArr[i] = prop2;
							for(int j = i++; j<propArr.length; j++){
								prop3.setVillas(currentVillas - 1);
								propArr[j] = prop3;
								newBalance = play.getBalance() + 300;
								play.setBalance(newBalance);
							}
						}
					}
				}
				else if(group == 8){
					prop1.setVillas(currentVillas - 1);
					for(int i = 0; i < propArr.length; i++){
						if(propArr[i] != prop1 && propArr[i].getGroup() == group){
							prop2.setVillas(currentVillas - 1);
							propArr[i] = prop2;
							newBalance = play.getBalance() + 200;
							play.setBalance(newBalance);
							break;
						}
					}
				}
			}
		}
	}
		public void actionPerformed(ActionEvent e) {
 			if(e.getSource() == close) {
 				dispose();
 			}
 		}
}
