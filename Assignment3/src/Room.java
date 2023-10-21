// 20210702040 - Emir Devlet Ertörer - Assignment 3


public class Room{
	
	public String roomType;
	public boolean hasBath;
	public int roomSize;
	private int dailyCost;
	
	public Room(String type) { // constructor
		
		roomType = type.toLowerCase(); // so it's not case sensitive
		
		/* Using switch because based on the inputted type; roomSize,
		   hasBath and dailyCost will be different.
		  (based on the specifications table provided in the PDF)*/
		switch(roomType) {
			case "single":
				roomSize = 15;
				hasBath = false;
				setCost(100);
				break;
				
			case "double":
				roomSize = 30;
				hasBath = false;
				setCost(180);
				break;
				
			case "club":
				roomSize = 45;
				hasBath = true;
				setCost(250);
				break;
				
			case "family":
				roomSize = 50;
				hasBath = false;
				setCost(450);
				break;
				
			case "family with view":
				roomSize = 50;
				hasBath = true;
				setCost(450);
				break;
				
			case "suite":
				roomSize = 80;
				hasBath = true;
				setCost(650);
				break;
		}
	}
	
	public void setCost(int cost) { // setter
		dailyCost = cost;
	}
	
	public int getCost(){ // getter
		return dailyCost;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public boolean getHasBath() {
		return hasBath;
	}
	
	public int getRoomSize() {
		return roomSize;
	}
}