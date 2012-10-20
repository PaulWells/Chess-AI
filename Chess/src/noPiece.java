
import java.util.ArrayList;


public class noPiece extends chessPiece {

	noPiece(int[] location, String team, String name) {
		super(location, team, name);
		// TODO Auto-generated constructor stub
	}
	
	noPiece copy(){
		noPiece newPiece = new noPiece(this.location.clone(),this.team,this.name);
		newPiece.pinned = this.pinned;
		newPiece.enPassant = this.enPassant;
		newPiece.originalPosition = this.originalPosition;
		
		return newPiece;
	}

	@Override
	ArrayList<move> possibleMoves(chessPiece[][] board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
