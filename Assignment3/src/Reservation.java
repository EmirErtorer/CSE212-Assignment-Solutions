// 20210702040 - Emir Devlet Ertörer - Assignment 3

public class Reservation{
	
	private String hotelName, reservationMonth;
	private int reservationStart, reservationEnd, dailyCost;
	public Room room;
	
	
	public Reservation(String name, String roomType, String month, int start, int end) { // constructor
		hotelName = name;
		reservationMonth = month;
        room = new Room(roomType); // room is initialized with the user inputted type
        dailyCost = room.getCost();
		reservationStart = start;
		reservationEnd = end;
	
	}

	public String getHotelName() {
		return hotelName;
	}
	
	public String getReservationMonth() {
		return reservationMonth;
	}
	
	public int getReservationStart() {
		return reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}
	
	public int calculateTotalPrice() {
		return (reservationEnd - reservationStart) * dailyCost;
	}
	
	public int calculateTotalPrice(int end, int start, int multiplier) {  // overloaded method
		return (end - start) * multiplier;
	}
	
	
	public void displayInfo() {
		
		// the ternary operator determines whether to use the base calculateTotalPrice or the overloaded one
		int totalPrice = (reservationMonth.equalsIgnoreCase("june") || 
                reservationMonth.equalsIgnoreCase("july") || 
                reservationMonth.equalsIgnoreCase("august")) 
               ? calculateTotalPrice(reservationEnd, reservationStart, dailyCost * 2) 
               : calculateTotalPrice();

		System.out.printf("\nReservation for %s starts on %s %d and ends on %s %d. Reservation has a total cost of $%d\n",
				getHotelName(), getReservationMonth(), getReservationStart(), getReservationMonth(), getReservationEnd(), totalPrice);
	}
}