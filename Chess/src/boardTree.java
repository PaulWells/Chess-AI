
import java.util.ArrayList;


public class boardTree extends Object {
	
	public ArrayList<boardTree> children;
	public chessPiece[][] boardState;
	public double strength;
	public move lastMove;
	public double alpha;
	public double beta;
	/*public ArrayList<move> whiteMoves;
	public ArrayList<move> blackMoves;
	public ArrayList<move> whiteKingMoves;
	public ArrayList<move> blackKingMoves;*/
	
	boardTree(chessPiece[][] boardState, move lastMove, double beta, double alpha){//, ArrayList<move> whiteMoves, ArrayList<move> blackMoves, ArrayList<move> whiteKingMoves, ArrayList<move> blackKingMoves){
        
       this.children = new ArrayList<boardTree>();
       this.alpha = alpha;
       this.beta = beta;
       this.boardState = boardState.clone();
       this.lastMove = lastMove.copy();
       /*this.whiteMoves = whiteMoves;
       this.blackMoves = blackMoves;
       this.whiteKingMoves = whiteKingMoves;
       this.blackKingMoves = blackKingMoves;*/
	}

}
