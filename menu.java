package tic;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*purpose: To display a menu for user with a few options to select
 * outputs frame with pictures and the option to choose between 1 and 2 players
 */
public class menu extends JFrame implements ActionListener{
	
	ImageIcon tic = new ImageIcon ("Tic-Tac-Toe.jpg");
	//Tic Tac Toe image is inserted in menu
	 Image img1 =tic.getImage() ;   
	 Image newimg1 = img1.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH ) ; 
	 ImageIcon ticpic1 = new ImageIcon( newimg1 );
	 JLabel ticlbl = new JLabel(ticpic1);
	 //Tic Tac Toe image is added to label
	 
	 ImageIcon tic2 = new ImageIcon ("tic.jpg");
	 Image img2 =tic2.getImage() ;   
	 Image newimg2 = img2.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	 ImageIcon ticpic2 = new ImageIcon( newimg2 );
	 JLabel tic2lbl = new JLabel(ticpic2);
	
	
	 JButton b1= new JButton("Two Player");
	 JButton b2= new JButton("One Player");
	 //Buttons are set to choose between game modes of 1 or 2 players
		JFrame menu= new JFrame();
		
	public menu() {
		/*pre: Purpose is to create the menu frame for the game
		 * Parameters: No parameters are used
		 * output: Outputs menu frame
		 */
		menu.setLayout(null);
		//No layout is selected to setbounds and put everything precisely into place
		ticlbl.setBounds(5,110,200,200);
		tic2lbl.setBounds(5,5,200,100);
		//Pictures are put into place
		b1.setBounds(5, 330, 100, 50);
		b2.setBounds(110, 330, 100, 50);
		//Buttons for gamemodes are set into place
		b1.addActionListener(this);
		b2.addActionListener(this);
		//ActionListeners are set to detect when button is pressed
		ticlbl.setVisible(true);
		tic2lbl.setVisible(true);
		//Pictures are made visible
		menu.add(tic2lbl);
		menu.add(ticlbl);
		menu.add(b1);
		menu.add(b2);
		//All components are added to frame
		menu.setSize(230,430);
		
	    menu.setVisible(true);
	    menu.setResizable(false);
	    JOptionPane.showMessageDialog(null,"1. The game is played on a grid that's 3 squares by 3 squares.\r\n" + 
				"2. You are O, your friend or the computer is X. Players take turns putting their marks in empty squares.\r\n" + 
				"3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.\r\n" + 
				"4. When all 9 squares are full, the game is over.");
	    //instructions
	    //Size of frame is set and made visible
	    //frame is not Resizeable to maintain size of the menu
	}
	public static void main(String[] args) {
		new menu();
		//menu is called
	}
	public void actionPerformed(ActionEvent e) {
		/*pre: Purpose is to call the game with the settings selected by player
		 * One actionEvent parameter is used (e) to determine which button is pressed
		 * Post: Calls game for either 2 player mode or 1 player
		 */
		//Option 1 is selected which is two player mode
	if (e.getSource()==b1) {
		new game();
		//Actual game is called
		game.player=4;
		//Player is set to 4 which is the 2 player option
		game.difficulty.setVisible(false);
		game.fc.setVisible(false);
		game.fp.setVisible(false);
		game.label.setVisible(false);
		//Game components used for the computer are hidden
		
	menu.setVisible(false);
	menu.dispose();
	//menu is removed
		}
	//Option 2 is selected which is one player mode
		if (e.getSource()==b2) {
			new game();
			//Actual game is called
			new Ai2(game.board,game.b);
			//Computer Ai is called to make first move
		menu.setVisible(false);
		menu.dispose();
		//menu is removed
		}
		
	}

}
