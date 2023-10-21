// 20210702040 - Emir Devlet Ertörer - Assignment 10

public class Room {
	private int dailyCost;
	private int roomSize;
	private boolean hasBath;
	
	public Room(int cost, int size, Boolean bath)
	{
		dailyCost = cost;
		roomSize = size;
		hasBath = bath;
	}
	
	public void setCost(int cost) { // setter
		dailyCost = cost;
	}
	
	public int getCost(){ // getter
		return dailyCost;
	}
	
	public void setHasBath(boolean bath) {
		hasBath = bath;
	}
	
	public boolean getHasBath() {
		return hasBath;
	}
	
	public void setRoomSize(int size) {
		roomSize = size;
	}
	
	public int getRoomSize() {
		return roomSize;
	}
}

// All the room classes were in seperate files in my last assignment, i changed that

class Single extends Room{
	
	public Single() {
		super(100, 15, false);
	}
}

class Double extends Room{
	
	public Double() {
		super(180, 30, false);
	}
}

class Club extends Room{
	
	public Club() {
		super(250, 45, true);
	}
	
}

class Family extends Room{
	
	public Family() {
		super(400, 50, false);
	}
	
}

class FamilyView extends Room{
	
	public FamilyView() {
		super(450, 50, true);
	}
	
}

class Suite extends Room{
	
	public Suite() {
		super(650, 80, true);
	}
}
	
