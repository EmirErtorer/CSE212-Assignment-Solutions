// 20210702040 - Emir Devlet Ertörer - Assignment 4

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
