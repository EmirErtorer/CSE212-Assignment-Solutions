// 20210702040 - Emir Devlet Ertörer - Assignment 6

public abstract class Services {
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

