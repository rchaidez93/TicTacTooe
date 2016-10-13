import java.util.Scanner;
public class TicTacToeGame {
	
	//Variables for Winning player 'X' and 'O'
	final static int playerX_Won = 1;
	final static int playerO_Won = 2;
	final static int Tie = 3;
	
	final static int Continue = 0;
	
	//Char variable to old the letter 'X' or 'O'
    static char WhoPlaying;
    
    //Holds if player 'X' or 'O' Won, or a tie
    static int BoardStatus;
    
	static int Row = 0;
	static int Col = 0;
	
	static Scanner input = new Scanner(System.in);
	
	final static char [][] board = new char[3][3];
	
	//************MAIN**************//
	public  static void main(String[] args){
		
		WhoPlaying = 'X'; //Player x starts
		EmptyBoard();// Display empty board
		BoardStatus = Continue;
		
		//Do-While loop
		do{
			
			playerMove(WhoPlaying);	
			BoardMoves(WhoPlaying, Row, Col);
			DisplayBoard();
			if(BoardStatus == playerX_Won){
				System.out.println("Player X Won!");
			}
			else if(BoardStatus == playerO_Won){
				System.out.println("Player O Won!");
			}
			else if(BoardStatus == Tie){
				System.out.println("It's a Tie!");
			}
			
			swiWhoPlaying();
			
		}while(BoardStatus == Continue);
				
		
		
	}//End Main	
	
	
		
	
	//Get playerX and playerO moves
	public static void playerMove(char WhoPlaying){
		 boolean validinput = false;
		do{
			if(WhoPlaying == 'X'){
				System.out.println("Player X enter a number row[1-3] and number column [1-3] with space to place X\n");
			}
			else
				System.out.println("Player O enter a number row[1-3] and number column [1-3] with space to place O\n");
		
			Row = input.nextInt() -1;
			Col = input.nextInt() -1;
			//Check if inputs are in the 2D array
			if(Row >= 0 && Row < 3 && Col >= 0 && Col < 3 && board[Row][Col] == 0){
				board[Row][Col] =  WhoPlaying; //Send where to place X or O
				validinput = true;
			}
			else
				System.out.println("That was not a valid input.\n");
			
				
		}while(!validinput);
		
		
	}//end playerMove
	
	//Display empty board outside do while loop
	public static void EmptyBoard(){
		for(int row = 0; row < 3; ++row){
			for(int col = 0; col < 3; ++col){
				if(col == 0){
					System.out.println("  |   |");
				}
			}
			
			if(row != 3 -1){
				System.out.println("-----------");
			}
		}
		System.out.println();
	}//end EmptyBoard
	
	 //Display board with the players mark in the cell
	 public static void DisplayBoard() {
		 for (int row = 0; row < 3; ++row) {
	         for (int col = 0; col < 3; ++col) {
	            if (col == 2) {
	               System.out.print(board[row][col]);// print vertical partition
	           }
	            else
		           System.out.print(board[row][col] + " |  " );// print vertical partition

	         }
	         System.out.println();
	         if (row != 2) {
	            System.out.println("------------");// print horizontal partition
	         }
	         
	      }
	      System.out.println();
	   }//End DisplayBoard



	//Determine if the cells are all occupied
	 public static boolean isFull(){
		 for(int i = 0; i < 3; i++){
			 for(int j = 0; j < 3; j++){
				 if(board[i][j] == 0){
					 return false; // At least one cell is not filled, Keep Playing
				 }
			 }
		 }
		 return true; //All cells are filled, Tie
	 }//end isFull
	 
	 //Check if there is a Winner
	 //Bring down the players Row and Col input
	 public static boolean isWon(char WhoPlaying, int Row, int Col){
		 			//Check all row
			 return ((board[Row][0] == WhoPlaying) &&
			    (board[Row][1] == WhoPlaying) &&
			    (board[Row][2] == WhoPlaying) ||
			    (board[0][Col] == WhoPlaying) && //Check all columns
				(board[1][Col] == WhoPlaying) &&
				(board[2][Col] == WhoPlaying) ||
				(board[0][0] == WhoPlaying) && //Check major diagonal
				(board[1][1] == WhoPlaying) && 
				(board[2][2] == WhoPlaying) ||
				(board[0][2] == WhoPlaying) && //Check SubDiagonal
				(board[1][1] == WhoPlaying) &&
				(board[2][0] == WhoPlaying));
			 }//end isWon
	 
	 //Checking if after the player marks, there is a winner
	 //Or if there is a Tie
	 public static void BoardMoves(char WhoPlaying, int Row, int Col){
		 if(isWon(WhoPlaying, Row, Col)){
			 if(WhoPlaying == 'X'){
				 BoardStatus = playerX_Won;
			 }
			 else 
				 BoardStatus = playerO_Won;
		 }
		 else if(isFull()){
			 BoardStatus = Tie;
		 }
		 
	 }
	 
	//Switch players after its called in main and there is no winner yet
		public static void swiWhoPlaying(){
			if(WhoPlaying == 'X'){
				WhoPlaying = 'O';
			} 
			else 
				WhoPlaying = 'X';
		}//End swiWhoPlaying
	 
	
			 
			
	}//End program
