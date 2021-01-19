//The TicTacToe game
//A command Line Game to Play a game of TicTacToe with computer
import java.util.*;
public class TicTacToe{

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();	

	public static void main(String ar[]){
		char[][] gameBoard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
	
		int playerPos = Integer.parseInt(inputPosition());			
			
		if(playerPos == 0){
			System.out.println("Invalid input");
		}
		else if(playerPos == 11){
			System.exit(0);
		}else if(playerPos == 10){
			//print scoreboard
		}else{
			placePiece(gameBoard, playerPos, "player");

			Random rn = new Random();
			int computerPos = rn.nextInt(9) + 1;
			placePiece(gameBoard, computerPos, "computer");

			printGameBoard(gameBoard);
		}
	}

	public static void printGameBoard(char[][] gameBoard){
		for(char[] row : gameBoard){
			for(char c : row){
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static String inputPosition(){
		Scanner sc = new Scanner(System.in);			
		System.out.print("tictactoe>");
		String input = sc.nextLine();				

		if(input.equals("move 0,0")){return "1";}
		else if(input.equals("move 0,2")){return "2";}
		else if(input.equals("move 0,4")){return "3";}
		else if(input.equals("move 2,0")){return "4";}
		else if(input.equals("move 2,2")){return "5";}
		else if(input.equals("move 2,4")){return "6";}
		else if(input.equals("move 4,0")){return "7";}
		else if(input.equals("move 4,2")){return "8";}
		else if(input.equals("move 4,4")){return "9";}
		else if(input.equals("scoreboard")){return "10";}
		else if(input.equals("quite")){return "11";}
		return "0";		
	}

	public static void placePiece(char[][] gameBoard, int pos, String user){		

		char symbol = ' ';
		if(user.equals("player")){ 
			symbol = 'X';
			playerPositions.add(pos);	
		}else if(user.equals("computer")){
			symbol = 'O';
			computerPositions.add(pos);		
		}

		switch(pos){
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
		}
	}

}