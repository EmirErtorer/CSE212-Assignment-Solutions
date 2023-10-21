// 20210702040 - Emir Devlet Ertörer - Assignment 9

public class Laundry extends Services{
	private int clothingPieces;
	private double laundryCost = 0;
	
	public Laundry( int customerID, int piece) {
		setCustomerID(customerID);
		clothingPieces = piece;
		laundryCost = 20 * getClothingPiece();
	}
	
	public void setClothingPiece(int piece) {
		clothingPieces = piece;
	}
	
	public int getClothingPiece() {
		return clothingPieces;
	}
	
	@Override
	public String getServiceType() {
		return "Laundry";
	}
	
	@Override
	public double calculateService() {
		return laundryCost ;
	}
	
	@Override
	public double getCost() {
		return calculateService();
	}
}