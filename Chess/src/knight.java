

import java.util.ArrayList;

public class knight extends chessPiece {
	
	public boolean enPassant;
	public boolean originalPosition;
	public boolean pinned;
	
	knight(int[] location, String team, String name){
		super(location, team, name);
		
		this.pinned = false;
		this.enPassant = false;
		this.originalPosition = true;
	}
	
	knight copy(){
		knight newPiece = new knight(this.location.clone(),this.team,this.name);
		newPiece.pinned = this.pinned;
		newPiece.enPassant = this.enPassant;
		newPiece.originalPosition = this.originalPosition;
		
		return newPiece;
	}
	
	ArrayList<move> possibleMoves(chessPiece[][] board){
		
		ArrayList<move> moveSet = new ArrayList<move>();
		int[][] eightSpots = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
		int[] newLocation = null;
		move newMove;
		
		for(int x =0;x<8;x++){
 
	        if( this.location[0]+eightSpots[x][0] >= 0 && this.location[0]+eightSpots[x][0] <= 7 && this.location[1]+eightSpots[x][1] >= 0 && this.location[1]+eightSpots[x][1] <= 7){
	            if(board[this.location[0]+eightSpots[x][0]][this.location[1]+eightSpots[x][1]].name == "" || board[this.location[0]+eightSpots[x][0]][this.location[1]+eightSpots[x][1]].team != this.team && board[this.location[0]+eightSpots[x][0]][this.location[1]+eightSpots[x][1]].team != ""){
	                
	            	newLocation = location.clone();
	            	newLocation[0] = newLocation[0]+eightSpots[x][0];
	            	newLocation[1] = newLocation[1]+eightSpots[x][1];
	            	newMove = new move(this.name,this.location,newLocation); 
	            	moveSet.add(newMove);
	            
	            }
	        }
	        
	        
		}
		
		
		return moveSet;
		
	}

}
