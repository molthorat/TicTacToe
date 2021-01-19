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

}