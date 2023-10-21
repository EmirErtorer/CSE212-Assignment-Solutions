// 20210702040 - Emir Devlet Ertörer - Assignment 7

public class Bills implements Calculable{
	
	private String type, month;
	private double amount;
	
	public Bills(String type, String month, double amount) {
		this.setType(type);
		this.month = month;
		this.amount = amount;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public double getCost() {
		return amount;
	}
}