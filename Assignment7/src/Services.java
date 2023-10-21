// 20210702040 - Emir Devlet Ertörer - Assignment 7

public abstract class Services implements Calculable {
	private int CustomerID;
	
	public void setCustomerID(int ID) { // setter
		CustomerID = ID;
	}
	
	public int getCustomerID(){ // getter
		return CustomerID;
	}
	
	public abstract String getServiceType(); // abstract methods
	public abstract double calculateService();
}

