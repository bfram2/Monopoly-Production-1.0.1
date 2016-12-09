package menu;
//The Main Menu for the game to start and to pick the players, type of game, citation, and help.
/* Trademark of Hasboro and Parker Brothers */

//guide to implement folders into master
//import pieces.*;
//import menu.*;
//import events.*;
//import cards.*;

//import pieces.Board;
import tile.Properties;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import events.Players;
//import pieces.Board;

import java.awt.BorderLayout;


public class MainMenu extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
JButton game, set, help, bear;

	public MainMenu() {
	
	setTitle("Monopoly");
	setSize(609,454); //window size
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setLocation(40, 150);
	//pack();
	setLayout(new BorderLayout());
	URL mnu = MainMenu.class.getResource("/menu/menu.jpg");
	JLabel background=new JLabel(new ImageIcon(mnu));
	add(background);
	background.setLayout(new FlowLayout());
	
	//style and location of buttons
	game=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 50px 5px 50px;\"><u>S</u>tart New Game</div>");
	help=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>H</u>elp</div>");
	bear=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>E</u>xit</div>");
	game.setBackground(new Color(73,175,47));
	help.setBackground(Color.BLACK);
	bear.setBackground(new Color(244,31,31));
	
	//add listeners
	game.addActionListener(this);
	help.addActionListener(this);
	bear.addActionListener(this);
	
	
	//add buttons
	background.add(game);
	background.add(help);
	background.add(bear);
	
	game.setFocusPainted(false); //disable focus border
	help.setFocusPainted(false);
	bear.setFocusPainted(false);
	
	// refresh, DO NOT remove
	setSize(610,455);
	}
	
	public void actionPerformed(ActionEvent e)
    {
		if(e.getSource() == game) {
			//start game button
			//activate Board.java, close menu
			dispose();
		}
		else if(e.getSource() == help) {
			//settings for user guide
			new HelpMenu();
			//System.out.println("Monopoly is Awesome, help!");
		}
		else if(e.getSource() == bear) {
			//close the program.. exit bear, stage left
			dispose();
            System.exit(0);
		}
        //applies to all buttons for debugging
    }
	public void createBoard(Players [] playArr, Properties [] propArr ){
		
	}
	
}
	