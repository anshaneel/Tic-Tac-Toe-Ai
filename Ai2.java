package tic;

import javax.swing.JButton;
/*Purpose: To make an make an Ai that plays Tic Tac Toe
 * Post: Computer makes moves determined on the difficulty selected 
 */
public class Ai2 {
	static int xc,yc;
	//Used to store coordinates of the move computer will make
	
	public Ai2(String board[][], JButton b[][]) {
		/*Pre: Purpose To make a move for computer player
		 * 2 parameters are used one 2D array string parameter board that holds all the positions of the game and one 2D array JButton parameter b for the buttons on the 3x3 grid
		 * Post: Move is made for the computer player
		 */
	if(game.check(board)==-100) {
		//Checks to see if game is finished
		if (game.player==3) {
		hotfix(board);
		//If impossible difficulty is selected (player 3) hotfix method will be called which has the full insight of the minimax method allowing the compute to make the optimal move
		}
		else if (game.player==1) {
		random(board);
		//If difficulty is set to Easy computer is set to player 1 which calls the random method placing its move randomly allowing the player to easily win
		}
		else if (game.player==2) {
		minimax(board,true);
		//If medium difficulty is selected 
		}
		
		board[xc][yc]="X";
		b[xc][yc].setText("X");
		//Computer Sets X to the position of the coordinates determined by the method used
		if(game.check(board)!=-100) {
			game.wins(board);
			//Checks again if the game has been completed and outputs appropriate dialog
		}
	}
	else {
		game.wins(board);
		//If game is finished then wins method is called displaying the winner or whether it was a tie
	}
		}
	public static void hotfix(String board[][]) {
		/*Purpose : To find the best possible move for the computer to make
		 * 1 2D array string parameter for board which holds all positions of game
		 * Post: Determines the best position for the computer and sets xc (x coordinate) and yc (y coordinate) to that position
		 */
		int best=-100000;
		int score=-100000;
		//We are trying to determine the highest possible score so we set values very low so even if we get negative values they will be better than the current best
		for (int x=0; x<3; x++) {
			for (int y=0; y<3; y++) {
				if (board[x][y].equals("")) {
					//Checks if position is available
					board[x][y]="X";
					//temporarily places X in position
					if(game.check(board)!=-100) {
					score=game.check(board);
					//if game has ended then score is set to value of board
					}
					else {
					score=minimax(board,false);
					//If game has not ended we continue but now it is the opposing players turn
					}
					board[x][y]="";
					if (score>best) {
						best=score;
						xc=x;
						yc=y;
						//Best score is determined and cordinates are set based on that score
					}
				}
			}
		}
	}
	static int minimax(String board[][],boolean Xturn) {
		/*Purpose : To find the best sore that the computer can achieve
		 * 2 parameters one 2D array parameter board that holds all positions of the game and one boolean parameter Xturn to determine which players turn it is
		 * Post: Returns integer value best representing best score
		 */
		if(Xturn) {
			int best=-100000;
			int score=-100000;
		//Score is set at -100000 so we can determine the best possible score (highest score)
			for (int x=0; x<3; x++) {
				for (int y=0; y<3; y++) {
					if (board[x][y].equals("")) {
						//We check if the space is available on the board
						board[x][y]="X";
						//If the space is available we temporarily put an X in that position
						if(game.check(board)!=-100) {
							//We check if the game has ended
							//if the game ends the value returned will not be -100
						score=game.check(board);
						//If the game has ended score is whatever score the check method returns
						}
						else {
						score=minimax(board,false);
						//if the game has not ended the method will call itself but this time it is the opposing players move
						}
						board[x][y]="";
						//The positions on the board are set back to normal
						if (score>best) {
							best=score;
							//If score is greater than best score best score will become the current score
							//greatest score because X is trying to win or stop O from winning
							if (game.player==2) {
								xc=x;
								yc=y;
							//If difficulty is medium (player 2) coordinates are determined here not giving it the full insight of the minimax program
							}
						}
					}
				}
			}
			return best;
			//Best score for the player is returned (highest score)
		}
		else {
			//Computer assumes player will play optimally so computer will try to determine the best move for the player to make so it can win
			//Note: Even if the player does not play optimally this just works on the computers favor and it will be easier for the computer to win
			int best=100000;
			int score=100000;
			//Score is set at 100000 so we can determine the best possible score (lowest score)
			for (int x=0; x<3; x++) {
				for (int y=0; y<3; y++) {
					if (board[x][y].equals("")) {
						board[x][y]="O";
						//If the spot it open O is placed
						if(game.check(board)!=-100) {
							score=game.check(board);
							//If game is complete score is the value of board
							}
							else {
							score=minimax(board,true);
							//If game is not complete score is taken from opponent
							}
						board[x][y]="";
						//Original move is cleared
						if (score<best) {
							best=score;
							//Best score is the lowest score since O is trying to win or block X from winning the game
						}
					}
				}
			}
			return best;
			//Best score for the player is returned (lowest value)
		}
	}
	public static void random(String board[][]) {
		/*Pre:Purpose to choose a random place for the computer to make its move
		 * one 2D string parameter board which stores all the positions of the previous moves
		 * post: chooses 2 random open spaces and sets xc (x coordinate) and yc (y coordinate) to those positions
		 */
		while(!(board[xc][yc].equals(""))) {
			//If the position is taken then different numbers are selected
		xc=(int)(Math.random()*3);
		yc=(int)(Math.random()*3);
		//Finds random numbers between 0 and 2 to choose 
	}
		board[xc][yc]="X";
		//Computer moves in the random location found
	}
}
	