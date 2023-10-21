// 20210702040 - Emir Devlet Ertörer - Assignment 3

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
            System.out.println("3. Display the total number of Reservations");
            System.out.println("0. Exit");
            
            choice = scanner.nextInt();
            
            switch(choice) {
            	
	            case 1:
	            	
	            	scanner.nextLine(); // For the case that Hotel Name is a multiple word string
	            	
	            	System.out.print("\nHotel Name: ");
	            	String name = scanner.nextLine();
	            	
	            	
	            	System.out.print("Room Type: ");
	            	String type = scanner.nextLine().toLowerCase();
	            	
	            	System.out.print("Reservation Month: ");
	            	String month = scanner.next();
	            	
	            	System.out.print("Reservation Start: ");
	            	int start = scanner.nextInt();
	            	// A condition to make sure that reservation start can't be less than 1
	            	if(start < 1) {
	            		System.out.println("**Reservation start cant be less than 1, rounding it to 1**");
	            		start = 1;
	            	}
	            	
	            	System.out.print("Reservation End: ");
	            	int end = scanner.nextInt();
	            	// A condition to make sure that reservation end can't be more than 30
	            	if(end > 31) {
	            		System.out.println("**Reservation end cant be more than 31, rounding it to 30**");
	            		end = 30;
	            	}
	            	
	            	if(start > end) { // for the case where user inputs a start day bigger than the end day 
	            		System.out.println("**Start day can't be bigger than the end day. Switching the dates:**");
	            		int temp = start;
	            		start = end;
	            		end = temp;
	            	}
	            	
	            	Room room1 = new Room(type); // created an object to access it's information
	            	System.out.printf("Daily Cost: $%d\n", room1.getCost());
	            	System.out.printf("Has Bath: %s\n", (room1.getHasBath() ? "True" : "False"));
	            	System.out.printf("Room Size: %d\n", room1.getRoomSize());
	            	System.out.println("\nReservation created!");
	            	
	            	//Each instance of object gets stored in an arraylist
	            	info.add(new Reservation(name, type, month, start, end));
	            	break;
	            	
	            case 2:
	            	
	            	if(info.size() == 0) System.out.println("\nNo reservation has been made yet to display information!");
	            	
	            	// Iterates over the arraylist and prints the information stored for each object
	            	for(Reservation reservation : info) { // foreach loop to display the information
	            		reservation.displayInfo();
	            	}
	            	break;
	            	
	            case 3:
	            	
	            	System.out.printf("\n%d reservations created so far.\n", info.size());
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
