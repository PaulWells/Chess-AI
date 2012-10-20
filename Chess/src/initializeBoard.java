

public class initializeBoard {
	
	public static void createBoard(chessPiece[][] board){
		
  
	    //initialize pieces on board
	    
	    //white team
	    
	    for(int x =  0;x<8;x++){
	    	int[] startLocation = {1,x};
	        board[1][x] = new pawn(startLocation,"white","p" + Integer.toString(x));
	    }
	    
	    int[] startLocation = {0,0};
		
	    board[0][0] = new castle(startLocation,"white","c1");
	    startLocation [0] = 0;
	    startLocation[1] = 7;
	    board[0][7] = new castle(startLocation,"white","c2");
	    startLocation [0] = 0;
	    startLocation[1] = 1;
	    board[0][1] = new knight(startLocation,"white","k1");
	    startLocation [0] = 0;
	    startLocation[1] = 6;
	    board[0][6] = new knight(startLocation,"white","k2");
	    startLocation [0] = 0;
	    startLocation[1] = 2;
	    board[0][2] = new bishop(startLocation,"white","b1");
	    startLocation [0] = 0;
	    startLocation[1] = 5;
	    board[0][5] = new bishop(startLocation,"white","b2");
	    startLocation [0] = 0;
	    startLocation[1] = 3;
	    board[0][3] = new king(startLocation,"white","king");
	    startLocation [0] = 0;
	    startLocation[1] = 4;
	    board[0][4] = new queen(startLocation,"white","queen");
	    
	    
	    
	  
	    
	    for(int x = 2; x<6;x++){
	    	for(int y = 0; y<8;y++){
	    		startLocation[0] = x;
	    		startLocation[1] = y;
	    		board[x][y] = new noPiece(startLocation,"none","");
	    	}
	    }
	    
	    //black team
	    
	    for(int x = 0;x<8;x++){
	    	startLocation[0] = 6;
	    	startLocation[1] = x;
	        board[6][x] = new pawn(startLocation,"black","p" + Integer.toString(x));
	    }
	    
	    startLocation [0] = 7;
	    startLocation[1] = 0;
	    board[7][0] = new castle(startLocation,"black","c1");
	    startLocation [0] = 7;
	    startLocation[1] = 7;	
	    board[7][7] = new castle(startLocation,"black","c2");
	    startLocation [0] = 7;
	    startLocation[1] = 1;
	    board[7][1] = new knight(startLocation,"black","k1");
	    startLocation [0] = 7;
	    startLocation[1] = 6;
	    board[7][6] = new knight(startLocation,"black","k2");
	    startLocation [0] = 7;
	    startLocation[1] = 2;
	    board[7][2] = new bishop(startLocation,"black","b1");
	    startLocation [0] = 7;
	    startLocation[1] = 5;
	    board[7][5] = new bishop(startLocation,"black","b2");
	    startLocation [0] = 7;
	    startLocation[1] = 3;
	    board[7][3] = new king(startLocation,"black","king");
	    startLocation [0] = 7;
	    startLocation[1] = 4;
	    board[7][4] = new queen(startLocation,"black","queen");
	}
}
