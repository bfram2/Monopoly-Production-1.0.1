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

public class Unmortgage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton close, yes, no;
	JLabel status;
	String statustxt;
	String button1, button2;
	Players currentPlayer;
	Properties currentProperty;
	
	public Unmortgage(Players play, Properties prop){
		this.currentPlayer = play;
		this.currentProperty = prop;
		
		if(currentPlayer.getPlayerNumber() != currentProperty.getOwner()){
			if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
				setTitle("Unmortgage");
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
			
				status.setBounds(20,0,150,50);
				close.setBounds(20, 60, 150, 50);
			
				close.addActionListener(this);
				repaint();
			}
		}
		else if(currentProperty.getMortgaged() == 0){
			if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
				setTitle("Unmortgage");
				setSize(200,250); //window size
				setLocation(255,290);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(true);
				setLayout(new BorderLayout());
				JPanel front = new JPanel();
				front.setLayout(null);
				add(front, BorderLayout.CENTER);

				statustxt = "This property is not mortgaged";
			
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
		}
		else if(currentPlayer.getBalance() < currentProperty.getUnMortgaged()){
			if(currentProperty.getOwner() != currentPlayer.getPlayerNumber()){
				setTitle("Unmortgage");
				setSize(200,250); //window size
				setLocation(255,290);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(true);
				setLayout(new BorderLayout());
				JPanel front = new JPanel();
				front.setLayout(null);
				add(front, BorderLayout.CENTER);

				statustxt = "You do not have enough money to unmortgage this property";
			
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
		}
		else{
			setTitle("Unmortgage");
			setSize(200,250); //window size
			setLocation(255,290);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLayout(new BorderLayout());
			JPanel front = new JPanel();
			front.setLayout(null);
			add(front, BorderLayout.CENTER);
			
			statustxt = "Do you want to unmortgage this property?";
			
			button1 = "<u>Y</u>es";
			button2 = "<u>N</u>0";
			yes=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
			no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
			status=new JLabel("<html><center><div style=\"color: black; font-family: verdana; font-size: 11pt; padding: 5px;\">"+statustxt+"</div>");
			close.setBackground(new Color(73,175,47));
			
			front.add(status);
			front.add(close);
			
			status.setBounds(20,0,150,50);
			close.setBounds(20, 60, 150, 50);
			
			close.addActionListener(this);
			}
		status.repaint();	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			dispose();
		}
		if(e.getSource() == yes){
			int newBalance = currentPlayer.getBalance() - currentProperty.getUnMortgaged();
			currentPlayer.setBalance(newBalance);
			currentProperty.setMortgaged(0);
			dispose();
		}
		if(e.getSource() == no) {
			dispose();
		}
	}
}
