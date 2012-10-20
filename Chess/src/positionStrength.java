
import java.util.ArrayList;


public class positionStrength {
	
	
	public static double evaluatePosition(String team, boardTree gameState){
		double strength = 0;
		
		ArrayList<move> whiteMoves = new ArrayList<move>();
		ArrayList<move> blackMoves = new ArrayList<move>();
		ArrayList<move> whiteKingMoves = new ArrayList<move>();
		ArrayList<move> blackKingMoves = new ArrayList<move>();
		
		getMoves.findMoves(team, gameState.boardState, blackMoves,whiteMoves, blackKingMoves, whiteKingMoves);
		
		int materialStrength = materialEdge(gameState.boardState,team);
		strength = strength + materialStrength;
		
		double pawnStrength = pawnFormation(gameState.boardState, team);
		strength = strength + pawnStrength;
		
		double mobility;
		
		if(team == "white"){
			mobility = mobility(team, whiteMoves);
		}
		else{
			mobility = mobility(team, blackMoves);
		}
		
		strength = strength + mobility;
		
		
		return strength;
	}
	
	private static double mobility(String team, ArrayList<move> allMoves){
		double positionMobility = 0;
		positionMobility = allMoves.size()/36.0;
		return positionMobility;
		
	}
	
	private static double pawnFormation(chessPiece[][] board, String team){
		
		double pawnStrength = 0;
		int forward;
		double weighting =0.125;
		
		if (team == "white")
			forward = 1;
		else
			forward = -1;
		
		//find double pawns
		for (int x = 0;x<8;x++){

			for(int y = 0; y<8;y++){
				
				if(x+forward >= 0 && x+forward <8 && y+1 >= 0 && y+1 <8){
					if(board[x][y] instanceof pawn && board[x+forward][y+1] instanceof pawn && board[x][y].team == team && board[x+forward][y+1].team == team){
						pawnStrength = pawnStrength + weighting;
					}
					else if(board[x][y] instanceof pawn && board[x+forward][y+1] instanceof pawn && board[x][y].team != team && board[x+forward][y+1].team != team){
						pawnStrength = pawnStrength - weighting;
					}
				}
				if(x+forward >= 0 && x+forward <8 && y-1 >= 0 && y-1 <8){
					if(board[x][y] instanceof pawn && board[x+forward][y-1] instanceof pawn && board[x][y].team == team && board[x+forward][y-1].team == team){
						pawnStrength = pawnStrength + weighting;
					}
					else if(board[x][y] instanceof pawn && board[x+forward][y-1] instanceof pawn && board[x][y].team != team && board[x+forward][y-1].team != team){
						pawnStrength = pawnStrength - weighting;
					}
				}
			}
			
			
		}
		
		
		return pawnStrength;
	}
	
	private static int materialEdge(chessPiece[][] board, String team){
		
		int whiteMaterial = 0;
		int blackMaterial = 0;
		
		for (int x = 0;x<8;x++){
			for(int y = 0; y<8;y++){
				if(board[x][y].name != ""){
					
					if(board[x][y].team == "white"){
						
						if(board[x][y] instanceof pawn)
							whiteMaterial = whiteMaterial + 1;
						else if(board[x][y] instanceof castle){
							whiteMaterial = whiteMaterial + 5;
						}
						else if(board[x][y] instanceof knight){
							whiteMaterial = whiteMaterial + 3;
						}
						else if(board[x][y] instanceof bishop){
							whiteMaterial = whiteMaterial + 3;
						}
						else if(board[x][y] instanceof queen){
							whiteMaterial = whiteMaterial + 9;
						}
						else if(board[x][y] instanceof king){
							whiteMaterial = whiteMaterial + 100;
						}
					}
					
					else if(board[x][y].team == "black"){
						
						if(board[x][y] instanceof pawn)
							blackMaterial = blackMaterial + 1;
						else if(board[x][y] instanceof castle){
							blackMaterial = blackMaterial + 5;
						}
						else if(board[x][y] instanceof knight){
							blackMaterial = blackMaterial + 3;
						}
						else if(board[x][y] instanceof bishop){
							blackMaterial = blackMaterial + 3;
						}
						else if(board[x][y] instanceof queen){
							blackMaterial = blackMaterial + 9;
						}
						else if(board[x][y] instanceof king){
							blackMaterial = blackMaterial + 100;
						}
					}
				}
			}
		}
		
		if(team == "white")
			return  whiteMaterial - blackMaterial;
		else
			return blackMaterial - whiteMaterial;
		
	}

}
