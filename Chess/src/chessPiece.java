
import java.util.ArrayList;

//make it so king can move in front of pawns



public abstract class chessPiece extends Object {
	
	public int[] location = new int[2];
	public String team;
	public String name;
	public boolean pinned;
	public boolean enPassant;
	public boolean originalPosition;
	
	chessPiece(int location[], String team, String name){
		this.location = location.clone();
		this.team = team;
		this.name = name;
		this.pinned = false;
		this.enPassant = false;
		this.originalPosition = true;
		
	}
	
	
	
	chessPiece copy(){
		
		chessPiece newPiece = null;
		newPiece.location = this.location.clone();
		newPiece.team = this.team;
		newPiece.name = this.name;
		newPiece.pinned = this.pinned;
		newPiece.enPassant = this.enPassant;
		newPiece.originalPosition = this.originalPosition;
		
		return newPiece;
		
	}
	
	abstract ArrayList<move> possibleMoves(chessPiece[][] board);
	
}
