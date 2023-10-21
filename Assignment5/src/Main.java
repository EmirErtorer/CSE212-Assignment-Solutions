// 20210702040 - Emir Devlet Ertörer - Assignment 5

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		// Creating an ArrayList to store objects of type Reservation
		ArrayList<Reservation> info = new ArrayList<Reservation>(3);
		Room room = new Single(); // initial type is a single room
		
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
	            	
	            	scanner.nextLine(); // For the case that Hotel Name is a multiple word string
	            	
	            	System.out.print("\nHotel Name: ");
	            	String name = scanner.nextLine();
	            	
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
	            	
	            	System.out.println("\nReservation created!");
	            	
	            	//Each instance of object gets stored in an arraylist
	            	info.add(new Reservation(name, room, month, start, end, "Single")); // single by default
	            	break;
	            	
	            case OPT2:
	            	System.out.println("ROOM INFOS:\n\n"
	            			+ "Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: False\n"
	            			+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: False\n"
	            			+ "Room Type: Club,   Daily Cost: 250, Room Size: 45, Has Bath: True\n"
	            			+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: False\n"
	            			+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: True\n"
	            			+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: True");
	            	
	            	
	            	scanner.nextLine();
	            	System.out.print("\nHotel Name: ");
	            	String name2 = scanner.nextLine();
	            	
	            	System.out.print("Room Type: ");
	            	String type = scanner.nextLine();
	            	
	            	System.out.print("Reservation Month: ");
	            	String month2 = scanner.next();
	            	
	            	System.out.print("Reservation Start: ");
	            	int start2 = scanner.nextInt();
	            	// A condition to make sure that reservation start can't be less than 1
	            	if(start2 < 1) {
	            		System.out.println("**Reservation start cant be less than 1, rounding it to 1**");
	            		start2 = 1;
	            	}
	            	
	            	System.out.print("Reservation End: ");
	            	int end2 = scanner.nextInt();
	            	
	            	// A condition to make sure that reservation end can't be more than 30
	            	if(end2 > 31) {
	            		System.out.println("**Reservation end cant be more than 31, rounding it to 30**");
	            		end2 = 30;
	            	}
	            	
	            	if(start2 > end2) { // for the case where user inputs a start day bigger than the end day 
	            		System.out.println("**Start day can't be bigger than the end day. Switching the dates:**");
	            		int temp = start2;
	            		start2 = end2;
	            		end2 = temp;
	            	}
	            	
	            	System.out.println("\nReservation created!");
	            	
	            	if(type.equalsIgnoreCase("single")) room = new Single();
	            	if(type.equalsIgnoreCase("double")) room = new Double();
	            	if(type.equalsIgnoreCase("club")) room = new Club();
	            	if(type.equalsIgnoreCase("family")) room = new Family();
	            	if(type.equalsIgnoreCase("family with view")) room = new FamilyView();
	            	if(type.equalsIgnoreCase("suite")) room = new Suite();
	            	
	            	//Each instance of object gets stored in an arraylist
	            	info.add(new Reservation(name2, room, month2, start2, end2, type)); // single by default
	            	break;	            	
	            	
	            case OPT3:
	            	
	            	if(info.size() == 0) System.out.println("\nNo reservation has been made yet to display information!");
	            	
	            	// Iterates over the arraylist and prints the information stored for each object
	            	for(Reservation reservation : info) { // foreach loop to display the information
	            		reservation.displayInfo();
	            	}
	            	break;
	            
	            case OPT4:
	            	System.out.printf("\n%d reservations created so far.\n", Reservation.totalNumOfReservations);
	            	break;
	            
	            case OPT5:
	            	System.out.print("Type a city name for a reservation search: ");
	            	String city = scanner.next();
	            	List<Reservation> infoList = info; // converted the Reservation from ArrayList to List
	            	Iterator<Reservation> iterator = infoList.iterator(); // get iterator
	            	
	            	while(iterator.hasNext()){
	            		Reservation reservation = iterator.next();
	            		if(reservation.getHotelName().toLowerCase().contains(city.toLowerCase())) { 
	            			System.out.println(reservation.getHotelName());
	            		}
	            	}
	            	
	            	break;
	            	
	            case OPT6:
	            	System.out.print("Type a city name for a reservation search: ");
	            	String search = scanner.next();
	            	List<Reservation> removeList = new ArrayList<>(info); // converted the Reservation from ArrayList to List
	            	Iterator<Reservation> iterator2 = removeList.iterator(); // get iterator
	            	
	            	int removeCount = 0; // counter for the amount of reservations removed
	            	
	            	while(iterator2.hasNext()){ // iterates over the removeList
	            		Reservation reservation2 = iterator2.next();
	            		
	            		if(reservation2.getHotelName().toLowerCase().contains(search.toLowerCase())) {
	            			iterator2.remove(); // Remove the object containing the city from removeList
	            			removeCount++;	            			
	            		}	
	            	}
	            	System.out.printf("Successfully deleted all reservations in %s city\n", search);
	            	
	            	info.clear(); // Clear the contents of the info ArrayList
	                info.addAll(removeList); // Add the elements from removeList to info
        			
	            	Reservation.totalNumOfReservations = Reservation.totalNumOfReservations - removeCount; // update the total reservation count
	            	
	            	break;
	            	
	            case OPT7:
	         
	            	scanner.close();
	            	System.out.println("\nExiting..");
	            	break;
	            	
	            default:
	            	System.out.println("\nInvalid choice. Please try again.");
            }
			
		}while(choice != 7);
	}
}
