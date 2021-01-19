//The TicTacToe game
//A command Line Game to Play a game of TicTacToe with computer
import java.util.*;
public class TicTacToe{
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
			System.out.println(playerPos);
		}

		printGameBoard(gameBoard);
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

}