// 20210702040 - Emir Devlet Ertörer - Assignment 11

public class RoomTypeException extends Exception{
	
	public RoomTypeException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return "\nRoom type is not valid!\n";
	}
}