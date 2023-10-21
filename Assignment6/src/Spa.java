// 20210702040 - Emir Devlet Ertörer - Assignment 6

public class Spa extends Services{
	private int days;
	private double spaCost = 0;
	
	
	public Spa( int customerID, int day) {
		setCustomerID(customerID);
		days = day;
		spaCost = 100 * getDays();
	}
	
	public int getDays() {
		return days;
	}
	
	@Override
	public String getServiceType() {
		return "Spa";
	}
	
	@Override
	public double calculateService() {
		return spaCost;
	}
	
}