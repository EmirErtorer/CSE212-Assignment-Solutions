// 20210702040 - Emir Devlet Ertörer - Assignment 2

public class Reservation{
	
	private String hotelName, reservationMonth;
	private int reservationStart, reservationEnd, dailyCost;
	
	public Reservation(String name, String month, int start, int end, int cost) { // constructor
		hotelName = name;
		reservationMonth = month;
		reservationStart = start;
		reservationEnd = end;
		dailyCost = cost;
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
	
	public int getDailyCost() {
		return dailyCost;
	}
	
	
	public int calculateTotalPrice() {
		return (getReservationEnd() - getReservationStart()) * getDailyCost();
	}
	
	public void displayInfo() {
		System.out.printf("\nReservation for %s starts on %s %d and ends on %s %d. Reservation has a total cost of $%d\n",
				getHotelName(), getReservationMonth(), getReservationStart(), getReservationMonth(), getReservationEnd(), calculateTotalPrice());
	}
	
	
}