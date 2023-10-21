// 20210702040 - Emir Devlet Ertörer - Assignment 2

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Creating an ArrayList to store objects of type Reservation
		ArrayList<Reservation> info = new ArrayList<Reservation>();
		
		int choice;
		
		do {
			Scanner scanner = new Scanner(System.in);
			
            System.out.println("\n1. Create new Reservation");
            System.out.println("2. Display all Reservations");
            System.out.println("0. Exit");
            
            choice = scanner.nextInt();
            
            switch(choice) {
            	
	            case 1:
	            	
	            	scanner.nextLine(); // For the case that Hotel Name is a multiple word string
	            	
	            	System.out.print("\nHotel Name: ");
	            	String name = scanner.nextLine();
	            	
	            	System.out.print("Reservation Month: ");
	            	String month = scanner.next();
	            	
	            	System.out.print("Reservation Start: ");
	            	int start = scanner.nextInt();
	            	// A condition to make sure that reservation start cant be less than 1
	            	if(start < 1) {
	            		System.out.println("**Reservation start cant be less than 1, rounding it to 1**");
	            		start = 1;
	            	}
	            	
	            	System.out.print("Reservation End: ");
	            	int end = scanner.nextInt();
	            	// A condition to make sure that reservation end cant be more than 30
	            	if(end > 30) {
	            		System.out.println("**Reservation end cant be more than 30, rounding it to 30**");
	            		end = 30;
	            	}
	            	
	            	System.out.print("Daily Cost: ");
	            	int cost = scanner.nextInt();
	         
	            	System.out.println("\nReservation created!");
	            	
	            	//Each instance of object gets stored in an arraylist
	            	info.add(new Reservation(name, month, start, end, cost));
	            	break;
	            	
	            case 2:
	            	
	            	if(info.size() == 0) System.out.println("\nNo reservation has been made yet to display information!");
	            	
	            	// Iterates over the arraylist and prints the information stored for each object
	            	for(int i = 0; i < info.size(); i++) {
	            		info.get(i).displayInfo();
	            	}
	            	break;
	            	
	            case 0:
	            	
	            	scanner.close();
	            	System.out.println("\nExiting..");
	            	break;
	            	
	            default:
	            	System.out.println("\nInvalid choice. Please try again.");
            }
			
		}while(choice != 0);

	}

}
