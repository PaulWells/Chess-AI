
import java.util.ArrayList;


public class bishop extends chessPiece {
	
	public boolean enPassant;
	public boolean originalPosition;
	public boolean pinned;
	
	bishop(int[] location, String team, String name){
		super(location, team, name);
		
		this.pinned = false;
		this.enPassant = false;
		this.originalPosition = true;
	}
	
	bishop copy(){
		bishop newPiece = new bishop(this.location.clone(),this.team,this.name);
		newPiece.pinned = this.pinned;
		newPiece.enPassant = this.enPassant;
		newPiece.originalPosition = this.originalPosition;
		
		return newPiece;
	}
	
	ArrayList<move> possibleMoves(chessPiece[][] board){
		ArrayList<move> moveSet = new ArrayList<move>();
		int[] newLocation = null;
		move newMove;
		int[] firstPieceLocation = new int[2];
	        
        int row = 1;
        int col = 1;
        boolean foundPiece = false;
        boolean secondPiece = false;
        
        
        
        while( this.location[0] + row <= 7 && this.location[1] + col <= 7 && secondPiece == false){
            
            if (board[this.location[0]+row][this.location[1]+col].name == "" || board[this.location[0]+row][this.location[1]+col].team != this.team){
                if( foundPiece == false){
                	newLocation = location.clone();
	            	newLocation[0] = newLocation[0]+row;
	            	newLocation[1] = newLocation[1]+col;
	            	newMove = new move(this.name,this.location,newLocation); 
	            	moveSet.add(newMove);
                }
            }
            if (board[this.location[0]+row][this.location[1]+col].name != ""){
                if (foundPiece){
                    secondPiece = true;
                    board[firstPieceLocation[0]][firstPieceLocation[1]].pinned = true;
                }
                else{
                    foundPiece = true;
                    
                    firstPieceLocation[0] = this.location[0]+row;
                    firstPieceLocation[1] = this.location[1]+col;
                }
            }
            row = row + 1;
            col = col + 1;
        }
        
        foundPiece = false;
        secondPiece = false;
        row = 1;
        col = 1;
        
        while( this.location[0] - row >= 0 && this.location[1] - col >= 0 && secondPiece == false){
            
            if(board[this.location[0]-row][this.location[1]-col].name == "" || board[this.location[0]-row][this.location[1]-col].team != this.team){
                if (foundPiece == false){
                	newLocation = location.clone();
	            	newLocation[0] = newLocation[0]-row;
	            	newLocation[1] = newLocation[1]-col;
	            	newMove = new move(this.name,this.location,newLocation); 
	            	moveSet.add(newMove);
                }
            }
            if (board[this.location[0]-row][this.location[1]-col].name != ""){
                if(foundPiece){
                    secondPiece = true;
                    board[firstPieceLocation[0]][firstPieceLocation[1]].pinned = true;
                }
                else{
                    foundPiece = true;
                    firstPieceLocation[0] = this.location[0]-row;
                    firstPieceLocation[1] = this.location[1]-col;
                }
            }
            row = row + 1;
            col = col + 1;
        }
        
        foundPiece = false;
        secondPiece = false;
  
        row = 1;
        col = 1;
            
        while( this.location[1] + col <= 7 && this.location[0] - row >= 0 && secondPiece == false){
            
            if (board[this.location[0]-row][this.location[1]+col].name == "" || board[this.location[0]-row][this.location[1]+col].team != this.team){
                if (foundPiece == false){
                	newLocation = location.clone();
	            	newLocation[0] = newLocation[0]-row;
	            	newLocation[1] = newLocation[1]+col;
	            	newMove = new move(this.name,this.location,newLocation); 
	            	moveSet.add(newMove);
                }
            }
            if (board[this.location[0]-row][this.location[1]+col].name != ""){
                if (foundPiece){
                    secondPiece = true;
                    board[firstPieceLocation[0]][firstPieceLocation[1]].pinned = true;
                }
                else{
                    foundPiece = true;
                    firstPieceLocation[0] = this.location[0]-row;
                    firstPieceLocation[1] = this.location[1]+col;
                }
            }
            col = col + 1;
            row = row + 1;
            
        }
        
        foundPiece = false;
        secondPiece = false;
        col = 1;
        row = 1;
        
        while( this.location[1] - col >= 0 && this.location[0] + row <= 7 && secondPiece == false){
            
            if( board[this.location[0]+row][this.location[1]-col].name == "" || board[this.location[0]+row][this.location[1]-col].team != this.team){
                if (foundPiece == false){
                	newLocation = location.clone();
	            	newLocation[0] = newLocation[0]+row;
	            	newLocation[1] = newLocation[1]-col;
	            	newMove = new move(this.name,this.location,newLocation); 
	            	moveSet.add(newMove);
                    
                }
            }
            if (board[this.location[0]+row][this.location[1]-col].name != ""){
                if (foundPiece){
                    secondPiece = true;
                    board[firstPieceLocation[0]][firstPieceLocation[1]].pinned = true;
                }
                else{
                    foundPiece = true;
                    firstPieceLocation[0] = this.location[0]+row;
                    firstPieceLocation[1] = this.location[1]-col;
                }
            }
            col = col + 1;
            row = row + 1;
            
        }
        return moveSet;
	}
}
