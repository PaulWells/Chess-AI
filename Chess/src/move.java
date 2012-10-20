

public class move {
	
	public String name;
	public int[] startLocation;
	public int[] endLocation;
	
	move(String name, int[] startLocation, int[] endLocation){
		this.name = name;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	move(){
		this.name = "none";
		int[] location = {-1,-1};
		this.startLocation = location;
		this.endLocation = location;
		
	}
	
	move copy(){
		move otherMove = new move();
		otherMove.name = this.name;
		otherMove.startLocation = this.startLocation;
		otherMove.endLocation = this.endLocation;
		
		return otherMove;
	}

}
