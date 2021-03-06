//The TicTacToe game
//A command Line Game to Play a game of TicTacToe with computer
import java.util.*;
public class TicTacToe{

	static int u=0, c=0;
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();	

	public static void main(String ar[]){
		
		while(true){
			char[][] gameBoard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
			};				

			while(true){
				int playerPos = Integer.parseInt(inputPosition());			
				
				if(playerPos == 0)
					System.out.println("Invalid input");
				else if(playerPos == 11)
					System.exit(0);
				else if(playerPos == 10)
					printScoreBoard();
				else{
					while(playerPositions.contains(playerPos) || computerPositions.contains(playerPos)){
						System.out.println("Invalid move, place already taken");
						playerPos = Integer.parseInt(inputPosition());
					}

					placePiece(gameBoard, playerPos, "player");
			
					String result = checkWinner();
					if(result.length()>0){
						printGameBoard(gameBoard);
						if(result.equals("User win"))
							u++;
						else if(result.equals("Computer wins"))
							c++;
						System.out.println(result);
						playerPositions.clear();
						computerPositions.clear();
						break;
					}

					Random rn = new Random();
					int computerPos = rn.nextInt(9) + 1;
					while(playerPositions.contains(computerPos) || computerPositions.contains(computerPos)){
						computerPos = rn.nextInt(9) + 1;
					}

					placePiece(gameBoard, computerPos, "computer");

					result = checkWinner();
					if(result.length()>0){
						printGameBoard(gameBoard);
						if(result.equals("User win"))
							u++;
						else if(result.equals("Computer wins"))
							c++;
						System.out.println(result);
						playerPositions.clear();
						computerPositions.clear();
						break;
					}
					
					printGameBoard(gameBoard);
				}			
			}
		}
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
 
	public static void printGameBoard(char[][] gameBoard){

		for(char[] row : gameBoard){
			for(char c : row)
				System.out.print(c);
			System.out.println();
		}
	}

	public static String checkWinner(){
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List crossOne = Arrays.asList(1,5,9);
		List crossTwo = Arrays.asList(7,5,3);
	
		List<List> winningList = new ArrayList<List>();
		winningList.add(topRow);
		winningList.add(midRow);
		winningList.add(bottomRow);
		winningList.add(leftCol);
		winningList.add(midCol);
		winningList.add(rightCol);
		winningList.add(crossOne);
		winningList.add(crossTwo);

		for(List list : winningList){
			if(playerPositions.containsAll(list))
				return "User win";
			else if(computerPositions.containsAll(list))
				return "Computer wins";
			else if(playerPositions.size() + computerPositions.size() == 10)
				return "The Game is a Draw";
		}
		return "";
	}

	public static String inputPosition(){

		Scanner scan = new Scanner(System.in);			
		System.out.print("tictactoe>");
		String input = scan.nextLine();				

		if(input.equals("move 0,0"))
			return "1";
		else if(input.equals("move 0,2"))
			return "2";
		else if(input.equals("move 0,4"))
			return "3";
		else if(input.equals("move 2,0"))
			return "4";
		else if(input.equals("move 2,2"))
			return "5";
		else if(input.equals("move 2,4"))
			return "6";
		else if(input.equals("move 4,0"))
			return "7";
		else if(input.equals("move 4,2"))
			return "8";
		else if(input.equals("move 4,4"))
			return "9";
		else if(input.equals("scoreboard"))
			return "10";
		else if(input.equals("quite"))
			return "11";
		return "0";		
	}

	public static void printScoreBoard(){

		System.out.println("| Computer win | User win |" );
		System.out.println("| "+ c + "            | "+ u+"        |");
	}
}