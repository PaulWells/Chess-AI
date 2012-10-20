
import java.util.ArrayList;


public class getMoves {
	
	public static void findMoves(String turn, chessPiece [][] board, ArrayList<move> blackMoves, ArrayList<move> whiteMoves, ArrayList<move> blackKingMoves, ArrayList<move> whiteKingMoves){
		
		ArrayList<move> possibleMoves = new ArrayList<move>();
		boolean clearPath;
	    
	    for(int x=0;x<8;x++){
	        for(int y = 0;y<8;y++) {
	        	
	        	
	            if (board[x][y].name != ""){
	            
	                if  (board[x][y].team == "white"){
	                	
	                    possibleMoves = board[x][y].possibleMoves(board);
	                    for(int z = 0;z<possibleMoves.size();z++){ 
	                        whiteMoves.add(possibleMoves.get(z));
	                    }
	                    
	                    if(board[x][y] instanceof king){

	                        possibleMoves = board[x][y].possibleMoves(board);
	                        for(int z = 0;z<possibleMoves.size();z++){ 
	                            whiteKingMoves.add(possibleMoves.get(z));
	                        }
	                    }
	                }       
	                else if (board[x][y].team == "black"){
	                    possibleMoves = board[x][y].possibleMoves(board);
	                
	                    for(int z = 0;z<possibleMoves.size();z++){ 
	                        blackMoves.add(possibleMoves.get(z));
	                    }
	                    
	                    if (board[x][y] instanceof king){
	                        possibleMoves = board[x][y].possibleMoves(board);
	                        
	                        for(int i = 0;i<possibleMoves.size();i++){ 
	                            blackKingMoves.add(possibleMoves.get(i));
	                        }
	                    }
	                }
	            }            
	        }
	    }

	    
   
	        
	    if(turn == "white"){
	        if (board[0][3] instanceof king && board[0][3].originalPosition){

	            clearPath = true;
	            
	            if (board[0][1].name != "" || board[0][2].name != "" || board[0][3].name != ""){
	                clearPath = false;
	            }
	            else{
	                for(int j = 0;j < blackMoves.size();j++) {
	                    if (blackMoves.get(j).endLocation[0] == 0 && blackMoves.get(j).endLocation[1] == 1 || (blackMoves.get(j).endLocation[0] == 0 && blackMoves.get(j).endLocation[1] == 2) || (blackMoves.get(j).endLocation[0] == 0 && blackMoves.get(j).endLocation[1] == 3)){
	                        clearPath = false;
	                    }
	                }
	            }
	            if (board[0][0] instanceof castle && board[0][0].originalPosition == true && clearPath == true){
	                int[] startLocation = {0,3};
	                int[] endLocation = {0,1};
	                
	            	move newMove = new move(board[0][3].name,startLocation,endLocation);
	            
	            	whiteMoves.add(newMove);
	            }


	            clearPath = true;
	            
	            if( board[0][6].name != "" || board[0][5].name != ""){
	                clearPath = false;
	            }

	            else{
	                for(int z = 0;z<blackMoves.size();z++){
	                    if ((blackMoves.get(z).endLocation[0] == 0 && blackMoves.get(z).endLocation[1] == 6) || (blackMoves.get(z).endLocation[0] == 0 && blackMoves.get(z).endLocation[1] == 5)){
	                        clearPath = false;
	                    }
	                }
	            }
	            
	            if(board[0][7] instanceof castle && board[0][7].originalPosition == true && clearPath ==true){
	            	int[] startLocation = {0,3};
	                int[] endLocation = {0,6};
	                
	            	move newMove = new move(board[0][3].name,startLocation,endLocation);
	            	whiteMoves.add(newMove);
	            }
	        }       
	    }
	    
	    if( turn == "black"){
	        if ((board[7][3] instanceof king) && board[7][3].originalPosition == true){
	            
	            clearPath = true;
	            
	            if( board[7][5].name != "" || board[7][6].name != "" || board[7][7].name != "")
	                clearPath = false;

	            else{
	                for(int z = 0;z<blackMoves.size();z++){
	                    if ((whiteMoves.get(z).endLocation[0] == 7 && whiteMoves.get(z).endLocation[1] == 5) || (whiteMoves.get(z).endLocation[0] == 7 && whiteMoves.get(z).endLocation[1] == 6) || (whiteMoves.get(z).endLocation[0] == 7 && whiteMoves.get(z).endLocation[2] == 7)){
	                        clearPath = false;
	                    }
	                }
	            }         
	            if ((board[7][0] instanceof castle) && board[7][0].originalPosition == true && clearPath == true){
	            	int[] startLocation = {7,3};
	                int[] endLocation = {7,1};
	            	move newMove = new move(board[0][3].name,startLocation,endLocation);
	            	blackMoves.add(newMove);
	            }

	            clearPath = true;
	            
	            if( board[7][1].name != "" || board[7][2].name != "")
	                clearPath = false;

	            else{
	                for(int z = 0;z<blackMoves.size();z++){ 
	                    if ((blackMoves.get(z).endLocation[0] == 7 && blackMoves.get(z).endLocation[1] == 1) || (blackMoves.get(z).endLocation[0] == 7 && blackMoves.get(z).endLocation[1] == 2)){
	                        clearPath = false;
	                    }
	                }
	            }
	            
	            if((board[7][7] instanceof castle) && board[7][7].originalPosition == true && clearPath == true){
	            	int[] startLocation = {7,3};
	                int[] endLocation = {7,6};
	            	move newMove = new move(board[0][3].name,startLocation,endLocation);
	                blackMoves.add(newMove);
	            }
	        }               
	    }
	    //remove moves where the king puts itself in check
	    //allow king to move in front of pawns!!!!!
	    
	    boolean wasRemoved;
	    
	    if( turn == "white"){
	        int x = 0;
	        while( x < whiteKingMoves.size()){
	            
	            int y = 0;
	            wasRemoved = false;
	            while( y < blackMoves.size() && wasRemoved == false){
	                
	                if( whiteKingMoves.get(x).endLocation[0] == blackMoves.get(y).endLocation[0] && whiteKingMoves.get(x).endLocation[1] == blackMoves.get(y).endLocation[1]){
	                    if (blackMoves.get(y).name.charAt(0) != 'p' || blackMoves.get(y).startLocation[0] != blackMoves.get(y).endLocation[0] - 1){
	                        whiteKingMoves.remove(whiteKingMoves.get(x));
	                        wasRemoved = true;
	                    }
	                        
	                }
	                y = y+1;
	            }          
	            x = x+1;
	        }
	        //ArrayList<move> toRemove = new ArrayList<move>();
	        for(int z = 0;z<whiteMoves.size();z++){
	            if (whiteMoves.get(z).name == "king"){
	            	whiteMoves.remove(z);
	            	z++;
	            }
	        }     
	          
	        whiteMoves.addAll(whiteKingMoves);
	    }
	    else{

	        int x = 0;
	        while( x < blackKingMoves.size()){
	            
	            int y = 0;
	            wasRemoved = false;
	            while( y < whiteMoves.size() && wasRemoved == false){
	                
	                if( blackKingMoves.get(x).endLocation[0] == whiteMoves.get(y).endLocation[0] && blackKingMoves.get(x).endLocation[1] == whiteMoves.get(y).endLocation[1]){
	                    if (whiteMoves.get(y).name.charAt(0) != 'p' || whiteMoves.get(y).startLocation[0] != whiteMoves.get(y).endLocation[0] - 1){
	                        blackKingMoves.remove(blackKingMoves.get(x));
	                        wasRemoved = true;
	                    }
	                        
	                }
	                y++;
	            }
	            
	            x++;
	                        
	        }
	        
	        for (int z = 0; z<blackMoves.size();z++){ 
	            
	            
	            if (blackMoves.get(z).name == "king"){
	                blackMoves.remove(z);
	                z++;
	            }
	             
	                
	        }        
 
	        blackMoves.addAll(blackKingMoves);
    
	    }       

	}
	
}
	            
	        
