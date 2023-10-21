// 20210702040 - Emir Devlet Ertörer - Assignment 10

public class RoomTypeException extends Exception{
	
	private static final long serialVersionUID = 1L; // gives me a warning if i dont put this

	public RoomTypeException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return "\nRoom type is not valid!\n";
	}
}