import java.util.Scanner;

public class TicTacToe {
//2D array to hold the game board
	private char [][] gameBoard;
//shared global variable for both players
	private char playerMark;

//returns the cuurent player's mark
	public char getPlayerMark(){
		return playerMark;
	}
//sets the current players mark
	public void setPlayerMark(char m){
		playerMark = m;
	}
//initializes the game board
	public TicTacToe(){
		gameBoard = new char[3][3];
		playerMark = 'X';
		emptyBoard();
	}
//prints the current game board
	public String toString(){
		for (int i = 0; i < gameBoard.length; i++){
			for (int j = 0; j < gameBoard.length; j++){
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
		return(" ");
	}
//clears the game board
	public void emptyBoard(){
		for (int i = 0; i < gameBoard.length; i++){
			for (int j = 0; j < gameBoard.length; j++){
				gameBoard[i][j] = '*';
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
//checks if the game board is filled up
	public boolean fullBoard(){
		int counter = 0;
		for (int i = 0; i < gameBoard.length; i++){
			for (int j = 0; j < gameBoard.length; j++){
				if (gameBoard[i][j] == 'X' || gameBoard[i][j] == 'O'){
					++counter;
				}
			}
		}
		if (counter != 9){
			return false;
		}
		else 
			return true;
	}
//adds an X or an O to the board
	public boolean addMove(int row, int col){
		if ((row >= 0 && row < 3) && (col >= 0 && col < 3)){
			if (gameBoard[row][col] == '*'){
				gameBoard[row][col] = playerMark;
				return true;
			}
		}
		return false;
	}
//checks if 3 chars are equal
	public boolean checkEqual(char first, char second, char third){
		if ((first != '*') && (first == second) && (second == third)){
			return true;
		}
		return false;
	}
//checks for 3 in a row
	public boolean rowWin(){
		for (int i = 0; i < gameBoard.length; i++){
			if (checkEqual(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2])){
				System.out.println("The winner is " + gameBoard[i][0] + "!");
				return true;
			}
		}
		return false;
	}
//checks for 3 in a column
	public boolean colWin(){
		for (int i = 0; i < gameBoard.length; i++){
			if (checkEqual(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i])){
				System.out.println("The winner is " + gameBoard[0][i] + "!");
				return true;
			}
		}
		return false;
	}
//checks for 3 in a diagonal
	public boolean diagonalWin(){
		if (checkEqual(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]) || checkEqual(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0])){
			System.out.println("The winner is " + gameBoard[1][1] + "!");
			return true;
		}
		return false;
	}
//switches player turna
	public void changePlayer(){
		if (playerMark=='X'){
			playerMark='O';
			System.out.println("It's now the turn of player O");
		}
		else if (playerMark=='O'){
			playerMark='X';
			System.out.println("It's now the turn of player X");
		}
	}

	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe");
		TicTacToe game1 = new TicTacToe();
		
		System.out.println("Player: " + game1.getPlayerMark() + " starts!");
		int row;
		int column;
		String again;
		boolean playAgain = true;
		boolean move; 
		boolean rWin;
		boolean cWin;
		boolean dWin;

		while (playAgain){
			System.out.print("Enter Row: ");
			row = (input.nextInt()) - 1;
			System.out.print("Enter Column: ");
			column = (input.nextInt()) - 1;

			while ((row < 0 || row > 2)){
				System.out.print("Enter Valid Row: ");
				row = (input.nextInt()) - 1;
			}
			while (column < 0 || column > 2){
				System.out.print("Enter Valid Column: ");
				column = (input.nextInt()) - 1;
			}
			move = game1.addMove(row, column);

			while (!move){
				System.out.println("INVALID: Slot taken");
				System.out.print("Enter Row: ");
				row = (input.nextInt()) - 1;
				while ((row < 0 || row > 2)){
					System.out.print("Enter Valid Row: ");
					row = (input.nextInt()) - 1;
				}
				System.out.print("Enter Column: ");
				column = (input.nextInt())- 1;
				while ((column < 0 || column > 2)){
					System.out.print("Enter Valid Column: ");
					column = (input.nextInt()) - 1;
				}
				move = game1.addMove(row, column);
			}
			System.out.println();
			System.out.println(game1);
			//checks for a win
			rWin = game1.rowWin();
			cWin = game1.colWin();
			dWin = game1.diagonalWin();
			//restarts game if the game is won
			if (rWin || cWin || dWin){
				System.out.print("Play again Y/N: ");
				again = input.next();			
				if (again.equalsIgnoreCase("n")){
					System.out.println("Thanks for playing! Goodbye!");
					playAgain = false;
					break;
				}
				else if (again.equalsIgnoreCase("y")){
					game1.emptyBoard();
				}
				else{
					while (!again.equalsIgnoreCase("y") || !again.equalsIgnoreCase("n")){
						System.out.println("INVALID");
						System.out.print("Play again Y/N: ");
						again = input.next();
					}
				}
			}
			//restarts game if the game is tied
			if (!rWin && !cWin && !dWin && (game1.fullBoard() == true)){
				System.out.println("There is no winner :(");
				System.out.print("Play again Y/N: ");
				again = input.next();
				if (again.equalsIgnoreCase("n")){
					System.out.println("Thanks for playing! Goodbye!");
					playAgain = false;
					break;
				}
				else if (again.equalsIgnoreCase("y")){
					game1.emptyBoard();
				}
				else{
					while (!again.equalsIgnoreCase("y") || !again.equalsIgnoreCase("n")){
						System.out.println("INVALID");
						System.out.print("Play again Y/N: ");
						again = input.next();
					}
				}
			}
			game1.changePlayer();

		}
	}
}
