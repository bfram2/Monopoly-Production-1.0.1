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

public class Mortgage extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton close, yes, no;
	JLabel status;
	String statustxt;
	String button1; //yes or no button text
	String button2;
	Players currentPlayer;
	Properties currentProperty;
	
	public Mortgage(Players play, Properties prop) {
		this.currentPlayer = play;
		this.currentProperty = prop;
		
		//System.out.println(currentProperty.getOwner());
		
		if(currentPlayer.getPlayerNumber() != currentProperty.getOwner()){
			setTitle("Mortgage");
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
		else if(currentProperty.getVillas() > 0 || currentProperty.getPantheons() > 0){
			setTitle("Mortgage");
			setSize(200,250); //window size
			setLocation(255,290);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLayout(new BorderLayout());
			JPanel front = new JPanel();
			front.setLayout(null);
			add(front, BorderLayout.CENTER);

			statustxt = currentProperty.getName() + " has Villas or Pantheons, you cannot mortgage it.";
		
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
		else if(currentProperty.getMortgaged() != 0){
			setTitle("Mortgage");
			setSize(200,250); //window size
			setLocation(255,290);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLayout(new BorderLayout());
			JPanel front = new JPanel();
			front.setLayout(null);
			add(front, BorderLayout.CENTER);

			statustxt = currentProperty.getName() + " is already mortgaged";
		
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
			setTitle("Mortgage");
			setSize(200,250); //window size
			setLocation(255,290);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			setLayout(new BorderLayout());
			JPanel front = new JPanel();
			front.setLayout(null);
			add(front, BorderLayout.CENTER);
			
			button1 = "<u>B</u>uy Property";
			button2 = "<u>L</u>eave Property";
			yes=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 10px 5px 10px;\">"+button1+"</div>");
			no=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\">"+button2+"</div>");
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
			repaint();			
		}
		status.repaint(); //refresh status text
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			dispose();
		}
		else if(e.getSource() == yes){
			int balance = currentPlayer.getBalance();
			int mortgageValue = currentProperty.getMortgage();
			int newBalance = balance - mortgageValue;
			currentPlayer.setBalance(newBalance);
			currentProperty.setMortgaged(currentPlayer.getPlayerNumber());
			dispose();
		}
		else if(e.getSource() == no) {
			dispose();
		}
	}	
}
