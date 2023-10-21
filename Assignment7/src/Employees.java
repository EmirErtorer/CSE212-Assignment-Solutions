// 20210702040 - Emir Devlet Ertörer - Assignment 7

public class Employees implements Calculable{
	
	private String name, surname;
	private double monthlyPayment;
	private int id;
	
	public Employees(int id, double monthlyPayment, String name, String surname) {
		this.setID(id);
		this.monthlyPayment = monthlyPayment;
		this.setName(name);
		this.setSurname(surname);
	}
	
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public double getCost() {
		return monthlyPayment;
	}	
}