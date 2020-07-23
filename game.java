package tic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/*pre: Purpose is to run a game of Tic Tac Toe either 1 or 2 player
 *post: outputs game of tic tac toe doe user to play
 */
public class game extends JFrame implements ActionListener {
	
	static JButton[][]b= new JButton[3][3];
	//2d array of buttons is initialized to to use as board in JFrame
	static String[][]board= {{"","",""},
                           	{"","",""},
							{"","",""}};
	//2D String array is initialized to store values of board (Either X or O)
	static String[]Dif= {"Easy","Medium","Impossible"};
	static JComboBox difficulty=new JComboBox(Dif);
	//ComboBox is made to choose between difficulties Easy, Medium and Hard.
	
	JButton reset= new JButton("Reset");
	//Reset Button is initialized
	public static int player=1;
	//Play is initialized and auto set to player 1 from start
	boolean player4=true;
	static int xs=0,os=0;
	//Variables are set to store X's score and O's score
	
	static JLabel scorex= new JLabel("X:     "+ xs);
	static JLabel scoreo= new JLabel("O:     "+ os);
	//Labels hold score for both X and O players
	static JLabel label= new JLabel("First Turn");
	//Informs the user on function of the button
	
	static JRadioButton fc= new JRadioButton("Computer",true);
	static JRadioButton fp= new JRadioButton("Person");
	ButtonGroup firstmove= new ButtonGroup();
	//Radio buttons are set for who makes the first move and computer is set to default
	static boolean c=true;
	//Determines if it is the computers move or not
	public game() {
		/*pre: purpose is to display game Frame of tic tac toe
		 * No parameters used
		 * Post: Displays game of tic tac toe
		 */
		JFrame frame= new JFrame("Tic Tac Toe");
		JPanel panel= new JPanel();
		//Frame is set and Panel is made for Tic Tac Toe Grid
		frame.setLayout(null);
		//layout is set to null to set bounds
		panel.setLayout(new GridLayout(3,3));
		//Grid layout is set to a 3 by 3 grid for out game of Tic Tac Toe
		
		difficulty.addActionListener(this);
		difficulty.setBounds(320, 30, 100, 25);
		//Actionslisteners and setbounds are set for difficulty
		reset.addActionListener(this);
		reset.setBounds(320, 270, 100, 25);
		//Actionslisteners and setbounds are set for reset button
		label.setBounds(320, 60, 100, 25);
		scorex.setBounds(320, 130, 200, 50);
		scoreo.setBounds(320, 150, 200, 50);
		//Scores bounds are set
		for (int x=0;x<3; x++) {
			for (int y=0; y<3; y++) {
				b[x][y]=new JButton();
				b[x][y].addActionListener(this);
				panel.add(b[x][y]);
				//all buttons are added to panel
			}
		}
		//Grid is initialized 9 buttons and actionlisteners are set
		fp.addActionListener(this);
		fc.addActionListener(this);
		//Actionlisteners are set for player buttons
		firstmove.add(fc);
		firstmove.add(fp);
		fc.setBounds(320, 85, 100, 20);
		fp.setBounds(320, 105, 100, 20);
		//Bounds are set for player buttons and they are added buttongroup
		panel.setBounds(5, 5, 300, 300);
		//bounds are set to panel
		frame.add(difficulty);
		frame.add(panel);
		frame.add(scorex);
		frame.add(scoreo);
		frame.add(reset);
		frame.add(label);
		frame.add(fc);
		frame.add(fp);
		//All components are added to frame
		frame.setSize(450, 350);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    //Characteristics of frame are set
		
	}
	public static int check(String board[][]) {
		/*Purpose: Calls check method without it being final check
		 * One 2D String parameter for board that holds all positions 
		 * Post: Returns check method value (-1 if user won, 1 if user lost, 0 if tie and -100 if game has not ended)
		 */
		return check(board,false);
	}
	public static int check(String board[][], boolean f) {
		/*Purpose: Checks for winner
		 * 2 parmaetrs are used one 2D String parameter for board that holds all positions and one boolean parameter to determine if this is the final check
		 * Post: Returns integer value (-1 if user won, 1 if user lost, 0 if tie and -100 if game has not ended) and changes color of winning buttons if last check
		 */
		int c=0;
		//Counts how many of the criteria were satisfied
		for (int x=0; x<3; x++) {
			if (board[x][0].equals(board[x][1]) && board[x][0].equals(board[x][2]) && !(board[x][0].equals(""))) {
				c++;
				if(board[x][0].equals("X")) {
					if (f) {
						//If f is true then game has ended
						b[x][0].setBackground(Color.red);
						b[x][1].setBackground(Color.red);
						b[x][2].setBackground(Color.red);
						//If game has ended and player has lost winning spaces will be highlighted red
					}
					return 1;
					//Player has lost board returns value of 1
				}
				else {
					if (f) {
						b[x][0].setBackground(Color.green);
						b[x][1].setBackground(Color.green);
						b[x][2].setBackground(Color.green);
						//If game has ended and player has won winning spaces will be highlighted green
					}
					return -1;
					//Player has won board returns value of -1
				}
			}
		}
		for (int x=0; x<3; x++) {
			if (board[0][x].equals(board[1][x]) && board[0][x].equals(board[2][x]) && !(board[0][x].equals(""))) {
				c++;
				if(board[0][x].equals("X")) {
					if (f) {
						b[0][x].setBackground(Color.red);
						b[1][x].setBackground(Color.red);
						b[2][x].setBackground(Color.red);
						//If game has ended and player has lost winning spaces will be highlighted red
					}
					return 1;
					//Player has lost board returns value of 1
				}
				else {
					if (f) {
						b[0][x].setBackground(Color.green);
						b[1][x].setBackground(Color.green);
						b[2][x].setBackground(Color.green);
						//If game has ended and player has won winning spaces will be highlighted green
					}
					return -1;
					//Player has won board returns value of -1
				}
			}
		}
			if (board[1][1].equals(board[2][2]) && board[0][0].equals(board[1][1]) && !(board[1][1].equals(""))) {
				c++;
				if(board[1][1].equals("X")) {
					if (f) {
						b[1][1].setBackground(Color.red);
						b[2][2].setBackground(Color.red);
						b[0][0].setBackground(Color.red);
						//If game has ended and player has lost winning spaces will be highlighted red
					}
					return 1;
					//Player has lost board returns value of 1
				}
				else {
					if (f) {
						b[1][1].setBackground(Color.green);
						b[2][2].setBackground(Color.green);
						b[0][0].setBackground(Color.green);
						//If game has ended and player has won winning spaces will be highlighted green
					}
					return -1;
					//Player has won board returns value of -1
				}
			}
			if (board[0][2].equals(board[1][1]) && board[2][0].equals(board[1][1]) && !(board[1][1].equals(""))) {
				c++;
				if(board[0][2].equals("X")) {
					if (f) {
						b[0][2].setBackground(Color.red);
						b[1][1].setBackground(Color.red);
						b[2][0].setBackground(Color.red);
						//If game has ended and player has lost winning spaces will be highlighted red
					}
					return 1;
					//Player has lost board returns value of 1
				}
				else {
					if (f) {
						b[0][2].setBackground(Color.green);
						b[1][1].setBackground(Color.green);
						b[2][0].setBackground(Color.green);
						//If game has ended and player has won winning spaces will be highlighted green
					}
					return -1;
					//Player has won board returns value of -1
				}
			}
			int i=0;
			//Counts empty spaces
			for (int x=0; x<3; x++) {
				for (int y=0; y<3; y++) {
					if (board[x][y].equals("")) {
						i++;
						//Checks every space on the board to see how many of them are empty
					}
				}
			}
			if(i==0 && c==0) {
				//If no spaces are empty and none of the previous criteria are satisfied it is a tie and 0 is returned
				return 0;
			}
			return -100;
			//If game is still going (there are no winners and there are still empty spaces) returns -100
	}
	public static void wins(String board[][]) {	
		/*Purpose: To display who wins game
		 * One 2D String parameter for board that holds all positions
		 * Post: Outputs end result of game
		 */
		if (check(board,true)==-1) {
			JOptionPane.showMessageDialog(null,"O Wins");
			os++;
			scoreo.setText("O:     "+ os);
			//If O wins then appropriate dialog is outputted
			//O's Score is set to +1 of its previous score
		}
		else if(check(board,true)==1) {
			JOptionPane.showMessageDialog(null,"X Wins");
			xs++;
			scorex.setText("X:     "+ xs);
			//If X wins then appropriate dialog is outputted
			//X's Score is set to +1 of its previous score
		}
		else {
			JOptionPane.showMessageDialog(null,"It's a tie");
			//if tie occurs appropriate dialog is outputted
		}
	}
	public void actionPerformed(ActionEvent e) {
		/*Pre: Purpose is to perform a specific action when button is pressed
		 * One actionEvent parameter is used (e) to determine which button is pressed
		 * Post: Sets difficulty or sets appropriate character to position or resets board
		 */
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				if (e.getSource()==b[x][y] && b[x][y].getText().equals("") && check(board)==-100) {
					//If button is clicked on board and space is avaliable and the game has not ended appropriate text is displayed
					if (player==4 && player4) {
						//if playing two players and player4 is true it is X's turn to play
						board[x][y]="X";
						b[x][y].setText("X");
						player4=false;
						//X is placed in the chosen position and player4 is set to false meaning that it is O's turn to play
						if (check(board)!=-100) {
							wins(board);
						}
						//Checks again to see if game was won
					}
					else {
						//if two player mode is not activated or it is O's turn code executes
						board[x][y]="O";
						b[x][y].setText("O");
						//O is placed in position chosen
						if (player==4) {
							//if 2 player mode is active
							player4=true;
							//It is not X's turn
							if (check(board)!=-100) {
								wins(board);
							}
							//Checks again for winner
						}
						else {
							new Ai2(board,b);
							//if 2 player mode is not active Ai (computer player) is called to make a move
						}
					}
				}
				}
			}
		if (e.getSource()==reset) {
			//if reset button is pushed
			for(int x=0; x<3; x++) {
				for(int y=0; y<3; y++) {
					board[x][y]="";
					b[x][y].setText("");
					b[x][y].setBackground(null);
					//All button text is cleared and board is set back to normal
					//All colour is also erased
				}
				}
			if (c && player!=4) {
				new Ai2(board,b);
				//If 2 player mode is not activated computer is called to make a move
			}
			player4=true;
			//If 2 player mode is activated then player4 is set to true meaning it is X's turn
		}
	
		if (e.getSource()==fp) {
			c=false;
			//if player is selected to go first computer first move (c) is set to false
		}
		if (e.getSource()==fc) {
			c=true;
			//if computer is selected to go first computer first move (c) is set to true
		}
		if (e.getSource()==difficulty) {
			//if difficulty combobox is chosen code executes
			if (e.getSource().toString().contains("Easy")) {
				player=1;
				//if easy mode is activated player is set to 1
			}
			if (e.getSource().toString().contains("Medium")){
				player=2;
				//if medium mode is activated player is set to 2
			}
			if (e.getSource().toString().contains("Impossible")){
				player=3;
				//If impossible mode is activated player is set to 3
			}
		}
	
}
	}
		
	

