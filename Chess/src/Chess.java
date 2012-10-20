
import java.util.ArrayList;
import java.util.Scanner;


public class Chess {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner( System.in );
		String input = "";
		String[] brokenInput = {"","","",""};
		boolean goodInput = false;
		move nextMove = new move();
		int[] startLocation = new int[2];
		startLocation[0] = 0;
		startLocation[1] = 0;
		int[] endLocation = {0,0};
		
		chessPiece[][] originalBoard = new chessPiece[8][8];
		ArrayList<move> whiteMoves = new ArrayList<move>();
		ArrayList<move> blackMoves = new ArrayList<move>();
		ArrayList<move> whiteKingMoves = new ArrayList<move>();
		ArrayList<move> blackKingMoves = new ArrayList<move>();

		initializeBoard.createBoard(originalBoard);


		getMoves.findMoves("white", originalBoard, blackMoves, whiteMoves, blackKingMoves, whiteKingMoves);
		
		int[] nullLocation = {-1,-1};
		move nullMove = new move("none",nullLocation,nullLocation);
		
		boardTree boardStates;
		
		while(input != "quit"){
			
			long startTime = System.currentTimeMillis();
			
			for(int x = 7;x >=0;x--){
				System.out.print("\n");
				for (int y = 0; y <8;y++)
					System.out.print(originalBoard[x][y] + " ");
			}
			System.out.println("");
			boardStates = new boardTree(originalBoard, nullMove, 1000, -1000);
			
			
			nextMove = makeBoardTree.createBoardTree("white", 5, boardStates);
			
			System.out.println(nextMove.name);
			System.out.println(nextMove.startLocation[0] + "," + nextMove.startLocation[1]);
			System.out.println(nextMove.endLocation[0] + "," + nextMove.endLocation[1]);
			
			makeMove.movePiece(originalBoard, nextMove.startLocation.clone(),nextMove.endLocation.clone());
			
			long endTime = System.currentTimeMillis();
			
			System.out.println((endTime-startTime) /1000.0);
			
			for(int x = 7;x >=0;x--){
				System.out.print("\n");
				for (int y = 0; y <7;y++)
					System.out.print(originalBoard[x][y] + " ");
			}
			System.out.println("");
			
			while(goodInput == false){
				try{
					input = scanner.nextLine();
					if(input.length() == 7)
						goodInput = true;
				}catch(Exception e){
					System.out.println("bad move");
				}
			}
			goodInput = false;
			brokenInput = input.split(" ");
			
			startLocation[0] = Integer.parseInt(brokenInput[0]);
			startLocation[1] = Integer.parseInt(brokenInput[1]);
			endLocation[0] = Integer.parseInt(brokenInput[2]);
			endLocation[1] = Integer.parseInt(brokenInput[3]);
			
			makeMove.movePiece(originalBoard, startLocation.clone(),endLocation.clone());
		}
		
		
		

	}

}
