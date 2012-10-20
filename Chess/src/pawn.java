
import java.util.ArrayList;




public class pawn extends chessPiece{
	
	public boolean enPassant;
	public boolean originalPosition;
	public boolean pinned;
	
	pawn(int[] location, String team, String name){
		super(location, team, name);
		this.pinned = false;
		this.enPassant = false;
		this.originalPosition = true;
	}
	
	void move(int[] newLocation){
		if(Math.abs(newLocation[0]-this.location[0])>1)
			this.enPassant = true;
		else
			this.enPassant = false;
		
	}
	
	pawn copy(){
		pawn newPiece = new pawn(this.location.clone(),this.team,this.name);
		newPiece.pinned = this.pinned;
		newPiece.enPassant = this.enPassant;
		newPiece.originalPosition = this.originalPosition;
		
		return newPiece;
	}
	
	ArrayList<move> possibleMoves(chessPiece[][] board){
		
		ArrayList<move> moveSet = new ArrayList<move>();
		int forward;
		
		
		
		//team's pawns move in different directions
		if (this.team == "white")
			forward = 1;
		else
			forward = -1;
		
		int[] newLocation = null;
		move newMove;
		
		//if no piece in front of pawn can move there
		
		if(this.location[0] + forward >= 0 && this.location[0] + forward <=7){
			
			if (board[this.location[0]+forward][this.location[1]].name == ""){
				
				newLocation = location.clone();
				newLocation[0] = newLocation[0]+forward;
				
				newMove = new move(this.name,this.location,newLocation);
	
	            moveSet.add(newMove);
			}
		}
        //if on original square can move two if space free
		if (this.location[0]+forward*2 < 8 && this.location[0]+forward*2 >= 0){
	        if (board[this.location[0]+forward*2][this.location[1]].name == "" && board[this.location[0]+forward][this.location[1]].name == "" && this.originalPosition == true){
	        	newLocation = location.clone();
	        	newLocation[0] = newLocation[0] +forward*2;
	        	newMove = new move(this.name,this.location,newLocation);
	  
	        	
	        	moveSet.add(newMove);
	        }
		}
        
        if( this.location[1] != 0){

            if( board[this.location[0]+forward][this.location[1]-1].name != ""){

                if (board[this.location[0]+forward][this.location[1]-1].team != this.team && board[this.location[0]+forward][this.location[1]-1].team != ""){
                	newLocation = location.clone();
                	newLocation[0] = newLocation[0]+forward;
                	newLocation[1] = newLocation[1]-1;
                	newMove = new move(this.name,this.location,newLocation);
                	moveSet.add(newMove);
                }
            }
            
            if(board[this.location[0]][this.location[1]-1] instanceof pawn && board[this.location[0]][this.location[1]-1].enPassant == true){
            	newLocation = location.clone();
            	newLocation[0] = newLocation[0]+forward;
            	newLocation[1] = newLocation[1]-1;
            	newMove = new move(this.name,this.location,newLocation);
            	moveSet.add(newMove);
                
            }

        }                       

        if (this.location[1] != 7){

            if( board[this.location[0]+forward][this.location[1]+1].name != ""){

                if( board[this.location[0]+forward][this.location[1]+1].team != this.team && board[this.location[0]+forward][this.location[1]+1].team != "" ){
                	newLocation = location.clone();
                	newLocation[0] = newLocation[0]+forward;
                	newLocation[1] = newLocation[1]+1;
                	newMove = new move(this.name,this.location,newLocation);
                	moveSet.add(newMove);
                    
                }
                if(this.location[0]+forward <8 && this.location[0]+forward*2 <8 && this.location[0]+forward >0 && this.location[0]+forward*2 >0){
	                if( this.originalPosition == true && board[this.location[0]+forward][this.location[1]].name == "" && board[this.location[0]+forward*2][this.location[1]].name == ""){
	                	newLocation = location.clone();
	                	newLocation[0] = newLocation[0]+forward*2;
	                	newLocation[1] = newLocation[1];
	                	newMove = new move(this.name,this.location,newLocation);
	                	moveSet.add(newMove);
	               
	                }
                }

            }
            if(this.location[1]+1 < 8){
	            if( board[this.location[0]][this.location[1]+1] instanceof pawn && board[this.location[0]][this.location[1]+1].enPassant == true){
	
	            	newLocation = location.clone();
	            	newLocation[0] = newLocation[0]+forward;
	            	newLocation[1] = newLocation[1]+1;
	            	newMove = new move(this.name,this.location,newLocation); 
	            	moveSet.add(newMove);
	            	
	            }
            }
        }
		return moveSet;
	}
}
