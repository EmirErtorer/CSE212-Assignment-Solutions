// 20210702040 - Emir Devlet Ertörer - Assignment 9

public abstract class Services implements Calculable {
	private int CustomerID;
	
	public void setCustomerID(int ID) { // setter
		CustomerID = ID;
	}
	
	public int getCustomerID(){ // getter
		return CustomerID;
	}
	
	public void displayServiceInfo() {
		System.out.printf("Customer ID: %d, Service Type: %s, Cost: %.2f\n", getCustomerID(), 
				getServiceType(), calculateService());
	}
	
	public abstract String getServiceType(); // abstract methods
	public abstract double calculateService();
}

