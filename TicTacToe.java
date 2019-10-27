import java.util.Scanner;
public class TicTacToe
{
	public char[][] gameBoard;
	public char playerMark;
	public TicTacToe()
	{
		// initialize size of game board
		gameBoard = new char[3][3];
		// starts the game with player x
		playerMark = 'X'
		// starts game with empty board
		emptyBoard();
	}
	//   display method for the game
	public void display()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++ )
				System.out.print(gameBoard[i][j]+' ');	
			System.out.println();
		}
	}
	// resets the board to empty after the game
	public void emptyBoard()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++ )
			{
				gameBoard[i][j] = '*';
				System.out.print(gameBoard[i][j]+' ');	
			}
			System.out.println();
		}
	}
	// checks to see if the board is full 
	public boolean fullBoard()
	{
		// counter to check if every slot is taken
		int counter = 0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++ )
			{
				// if every square has X or O then add to counter
				if(gameBoard[i][j]=='X' || gameBoard[i][j]=='O')
				{
					counter++;
				}	
			}
		}
		// if the counter is equal to 9 then the board is full
		if(counter != 9)
			return false;
		else
			return true;
	}
	public boolean placeMark(int row, int col)
	{
		Boolean valid = true;
		// checks if the row&col is valid
		if(row == 0 || row == 1 ||row == 2) && (col == 0 || col == 1 || col == 2)
			for(int i=0; i<arr.length;i++)


	}
	// returns true if three in a row are the same
	public boolean checkRow(char first, char second, char third)
	{
		return((first == second) && (second == third));
	}
	
	public boolean rowWin()
	{
		for(int i=0; i<3; i++)
		{
			// checks if the row is 3 in a row and returns true if they all match
			if(checkRow(gameBoard[i][0], gameBoard[i][1], gameBoard[i][3]) == true)
			{
				return true;
			}
		}
		return false;
	}
	public boolean colWin()
	{
		for(int i=0; i<3)
	}
	
	public static void main (char[] args)
	{
		Scanner input = new Scanner(System.in);
		

	}
}