

public class makeMove {
	
	public static void movePiece(chessPiece[][] board, int[] start, int[] finish){
		
		
		//promote pawn to queen or just move piece
	    if(board[start[0]][start[1]] instanceof pawn && finish[0] == 0){
	    	int[] queenLocation = new int[2];
	    	queenLocation[0] = finish[0];
	    	queenLocation[1] = finish[1];
	    	board[finish[0]][finish[1]] = new queen(queenLocation, "black", "promoted queen");
	    }
	    else if(board[start[0]][start[1]] instanceof pawn && finish[0] == 7){
	    	int[] queenLocation = new int[2];
	    	queenLocation[0] = finish[0];
	    	queenLocation[1] = finish[1];
	    	board[finish[0]][finish[1]] = new queen(queenLocation, "white", "promoted queen");
	    }
	    
	    board[start[0]][start[1]].location[0] = finish[0];
		board[start[0]][start[1]].location[1] = finish[1];
		board[start[0]][start[1]].originalPosition = false;
	    board[finish[0]][finish[1]] = board[start[0]][start[1]].copy();

	    int[] location = new int[2];
	    location[0] = start[0];
	    location[1] = start[1];
	    
	    board[start[0]][start[1]] = new noPiece(location,"none","");
	    
	    //removes pawn if enPassant occurs
	    if(finish[0] == 1 || finish[0] == 6){
	    	if (board[finish[0]][finish[1]] instanceof pawn && (board[finish[0]+1][finish[1]].enPassant)){
	    		board[finish[0]][finish[1]] = new noPiece(location,"none","");
	    	}
	    	else if (board[finish[0]][finish[1]] instanceof pawn && (board[finish[0]-1][finish[1]].enPassant)){
	    		board[finish[0]][finish[1]] = new noPiece(location,"none","");
	    	}
	    }
	    
	    

	    if (board[finish[0]][finish[1]] instanceof king && Math.abs(finish[1]-start[1]) > 1){
	        if (finish[0] == 0 && finish[1] == 1){
	            board[0][2] = board[0][0];
	            board[0][0] = new noPiece(location,"none","");
	            board[0][2].location[0] = 0;
	            board[0][2].location[1] = 2;
	        }
	        else if( finish[0] == 0 && finish[1] == 6){
	        
	            board[0][5] = board[0][7];
	            board[0][7] = new noPiece(location,"none","");
	            board[0][5].location[0] = 0;
	            board[0][5].location[1] = 5;
	        }
	        else if( finish[0] == 7 && finish[1] == 1){
	            board[7][2] = board[7][0];
	            board[7][0] = new noPiece(location,"none","");
	            board[7][2].location[0] = 7;
	            board[7][2].location[1] = 2;
	        }

	        else if( finish[0] == 7 && finish[1] == 6){
	            board[7][5] = board[7][7];
	            board[7][7] = new noPiece(location,"none","");
	            board[7][5].location[0] = 7;
	            board[7][5].location[1] = 5;
	        }
	    }
	    
	   /* for(int x = 0;x <8;x++){
			System.out.print("\n");
			for (int y = 0; y < 8;y++)
				System.out.print(board[x][y] + " ");
		}
		System.out.println("");*/
	}
}
