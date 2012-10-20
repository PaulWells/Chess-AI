
import java.util.ArrayList;


public class makeBoardTree {
	
	 public static move createBoardTree(String startTeam, int maxDepth, boardTree treeRoot){
		
		move nullMove = new move();
		feedBack sendBack = new feedBack();
	    sendBack = recursiveMakeBoardTree(startTeam, maxDepth, 1, treeRoot, treeRoot.beta, treeRoot.alpha,nullMove );
	    
	    return sendBack.path;
	    
	  
	    
	 }

	 @SuppressWarnings("unchecked")
	private static feedBack recursiveMakeBoardTree(String team, int maxDepth, int depth, boardTree treeRoot, double beta, double alpha, move lastMove){
		 
		 treeRoot.alpha = alpha;
		 treeRoot.beta = beta;
		 
		 int theMove = 0;
		 
		 if(depth == maxDepth){
			 
			feedBack sendBack = new feedBack();
        	treeRoot.strength = positionStrength.evaluatePosition(team,treeRoot);
        	
        	sendBack.path = lastMove;
        	sendBack.strength = treeRoot.strength;
        
        	return sendBack;
        	
	    }
		
		//get moves for node
		 /////////////////////////////////
		ArrayList<move> whiteMoves = new ArrayList<move>();
		ArrayList<move> blackMoves = new ArrayList<move>();
		ArrayList<move> whiteKingMoves = new ArrayList<move>();
		ArrayList<move> blackKingMoves = new ArrayList<move>();
	    
		chessPiece[][] newBoard = new chessPiece[8][8];
		
		String otherTeam;

	    if (team == "white")
	        otherTeam = "black";
	    else
	        otherTeam = "white";

	    getMoves.findMoves(team, treeRoot.boardState, blackMoves,whiteMoves, blackKingMoves, whiteKingMoves);
	    
	    ArrayList<move> currentMoves = new ArrayList<move>();
	    
	    if(team == "white")
	        currentMoves = (ArrayList<move>) whiteMoves.clone();
	    else
	        currentMoves = (ArrayList<move>) blackMoves.clone();
	 
	    
	    ///////////////////////////////
	    
	    feedBack passBack = new feedBack();
	    int x = 0;
	    passBack.strength = 0;
    	//passBack.path = new Move;
	    
	    
	    while(x < currentMoves.size() && treeRoot.alpha < treeRoot.beta ){
	    	
	    	
	    	//generate child
	    	/////////////////////////////
	        for(int y=0;y<8;y++) {
	            for(int z = 0;z<8;z++){
	            	
	                newBoard[y][z] = treeRoot.boardState[y][z].copy();
	            }
	        }
	        makeMove.movePiece(newBoard, currentMoves.get(x).startLocation,currentMoves.get(x).endLocation);   
	        getMoves.findMoves(team, newBoard, blackMoves,whiteMoves, blackKingMoves, whiteKingMoves);
	        boardTree newNode = new boardTree(newBoard,currentMoves.get(x).copy(), beta, alpha);  
	        treeRoot.children.add(newNode);
	        
	        //////////////////////////////

            passBack = recursiveMakeBoardTree(otherTeam, maxDepth, depth + 1, treeRoot.children.get(treeRoot.children.size()-1),treeRoot.beta,treeRoot.alpha, currentMoves.get(x).copy());
        	//max node
            
            
            
            if(depth % 2 != 0){
        		if(treeRoot.alpha < passBack.strength){
        			treeRoot.alpha = passBack.strength;
        			theMove = x;
        		}
        	}
        	else{
        		if(treeRoot.beta > passBack.strength){
        			treeRoot.beta = passBack.strength;
                    
        			
        		}
        	}
	        
	        x++;  
	    }
	    
	    //max node
	    
	    if(depth %2 != 0){
	    	passBack.strength = treeRoot.alpha;
	    }
	    else{
	    	passBack.strength = treeRoot.beta;
	    	
	    }
	    
	    passBack.path = currentMoves.get(theMove);
	    return passBack;
	 }
}
