// 20210702040 - Emir Devlet Ertörer - Assignment 9

public class Reservation extends Services implements Comparable<Reservation>{
	
	private String hotelName, reservationMonth, roomType;
	private int reservationStart, reservationEnd, dailyCost;
	public Room room;
	public static int totalNumOfReservations = 0;
	
	// The parameter 'type' is for the displayInfo method
	public Reservation(String name, Room input, String month, int start, int end, String type) { // constructor
		hotelName = name;
		reservationMonth = month;
		roomType = type;
		
		room = input;
		
        dailyCost = room.getCost();
		reservationStart = start;
		reservationEnd = end;
		
		totalNumOfReservations++; // Total is incremented everytime a Reservation instance is created
		setCustomerID(totalNumOfReservations);
	 
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
	
	public int totalPrice() {
		// the ternary operator determines whether to use the base calculateTotalPrice or the overloaded one
		return ((reservationMonth.equalsIgnoreCase("june") || 
                reservationMonth.equalsIgnoreCase("july") || 
                reservationMonth.equalsIgnoreCase("august")) 
               ? calculateTotalPrice(reservationEnd, reservationStart, dailyCost * 2) 
               : calculateTotalPrice());
	}
	
	
	public void displayInfo() {
		System.out.printf("\nReservation for a %s room in %s starts on %s %d and ends on %s %d. Reservation has a total cost of $%d\n",
				roomType, getHotelName(), getReservationMonth(), getReservationStart(), getReservationMonth(), getReservationEnd(), totalPrice());
	}
	
	@Override
	public String getServiceType() {
		return "Reservation";
	}
	
	@Override
	public double calculateService() {
		return totalPrice();
	}
	
	@Override
	public double getCost() {
		return calculateService();
	}
	
	@Override
	public int compareTo(Reservation other) { // the overriden compareTo method
		return hotelName.compareTo(other.getHotelName());
    }
	
	@Override
	public void displayServiceInfo() { // overriden the displayServiceInfo for sorting based on hotel name
		System.out.printf("Hotel Name: %s, Customer ID: %d, Service Type: Room booking, Cost: %.2f\n",
				getHotelName(), getCustomerID(), calculateService());
	}
	
	public void displayServiceInfoFromServices() { // to call the non overriden one if needed
        super.displayServiceInfo();
    }
}