// 20210702040 - Emir Devlet Ertörer - Assignment 6

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Services> services = new ArrayList<Services>(); // an unlimited element Services array
		Room room = new Single();
		
		int choice;
		
		do {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println();
			
			// prints the options from the enum class
            for(MenuOptions options : MenuOptions.values()){
            	System.out.printf("%s\n", options.getString());
            }
            
            choice = scanner.nextInt();
            
            switch(MenuOptions.values()[choice - 1]){ //Checking the user input by comparig it to enum constants
            	
	            case OPT1:
	            	System.out.println("ROOM INFOS:\n\n"
	            			+ "Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: False\n"
	            			+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: False\n"
	            			+ "Room Type: Club,   Daily Cost: 250, Room Size: 45, Has Bath: True\n"
	            			+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: False\n"
	            			+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: True\n"
	            			+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: True");
	            	
	            	
	            	scanner.nextLine();
	            	System.out.print("\nHotel Name: ");
	            	String name = scanner.nextLine();
	            	
	            	System.out.print("Room Type: ");
	            	String type = scanner.nextLine();
	            	
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
	            		
	            	if(type.equalsIgnoreCase("single")) room = new Single();
	            	if(type.equalsIgnoreCase("double")) room = new Double();
	            	if(type.equalsIgnoreCase("club")) room = new Club();
	            	if(type.equalsIgnoreCase("family")) room = new Family();
	            	if(type.equalsIgnoreCase("family with view")) room = new FamilyView();
	            	if(type.equalsIgnoreCase("suite")) room = new Suite();
	            	
	            	services.add(new Reservation(name, room, month, start, end, type));
	            	
	            	System.out.printf("\nReservation ID: %d is created!\n", Reservation.totalNumOfReservations );
	    
	            	break;
	            	
	            case OPT2:
	            	if(services.size() == 0) System.out.println("\nNo reservation has been made yet to display information!");
	            	
	            	// Iterates over the arraylist and prints the information stored for each object
	            	for(Services reservation : services) { // foreach loop to display the information
	            		if (reservation instanceof Reservation) {
	            	        ((Reservation) reservation).displayInfo(); // downcasting
	            	    } 
	            	}
	            	
	            	break;	            	
	            	
	            case OPT3:
	            	System.out.print("Type a city name for a reservation search: ");
	            	String city = scanner.next();
	            	List<Services> infoList = services; // converted the Services from ArrayList to List
	            	Iterator<Services> iterator = infoList.iterator(); // get iterator
	            	
	            	while(iterator.hasNext()){
	            		Services reservation = iterator.next();
	            		if( ((Reservation) reservation).getHotelName().toLowerCase().contains(city.toLowerCase())) { 
	            			System.out.println( ((Reservation) reservation).getHotelName());
	            		}
	            	}
	            	break;
	            
	            case OPT4:
	            	
	            	System.out.println("\nPlease select one of the extra services from below:\n1. Laundry Service\n2. Spa Service");
	            	int extra = scanner.nextInt();
	            	System.out.println("Type the reservation ID to credit this service:");
	            	int id = scanner.nextInt();

	            	if(extra == 1) {
	            		System.out.println("How many pieces of clothing?");
	            		int piece = scanner.nextInt();
	            		services.add(new Laundry(id, piece));
	            	}
	            	if(extra == 2) {
	            		System.out.println("How many days?");
	            		int day = scanner.nextInt();
	            		services.add(new Spa(id, day));
	            	}
	            	
	            	break;
	            
	            case OPT5:
	            	for(Services reservation1 : services) {
	            		if(reservation1 instanceof Reservation) {
	            			System.out.printf("The cost for the Room booking service of reservation ID %d: %.2f\n", reservation1.getCustomerID(), reservation1.calculateService()); 
	            		}
	            		if(reservation1 instanceof Spa) {
	            			System.out.printf("The cost for the Spa service of reservation ID %d: %.2f\n", reservation1.getCustomerID(), reservation1.calculateService()); 
	            		}
	            		if(reservation1 instanceof Laundry) {
	            			System.out.printf("The cost for the Laundry service of reservation ID %d: %.2f\n", reservation1.getCustomerID(), reservation1.calculateService()); 
	            		} 		
	            	}
	            	
	            	break;
	            	
	            case OPT6:
	            	
	            	for(Services reservation1 : services) {
	            		if(reservation1 instanceof Reservation) { // enters the second loop only when it is a Reservation object
	            			double total = reservation1.calculateService();
		            		for(Services service : services) {
		            			if ((service.getCustomerID() == reservation1.getCustomerID()) && (service.getServiceType().equals("Spa") || service.getServiceType().equals("Laundry"))) {
		            				total += service.calculateService();
		            			}
		            		}
		            		System.out.printf("The total cost of all services of the reservation with ID: %d is %.2f\n", reservation1.getCustomerID(), total);
	            		}
	            	}
	            	
	            	break;
	            	
	            case OPT7:
	         
	            	scanner.close();
	            	System.out.println("\nExiting, Goodbye!");
	            	break;
	            	
	            default:
	            	System.out.println("\nInvalid choice. Please try again.");
            }
			
		}while(choice != 7);
	
	}
	
}
