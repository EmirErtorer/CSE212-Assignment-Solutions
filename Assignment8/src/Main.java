// 20210702040 - Emir Devlet Ertörer - Assignment 8

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Calculable> calculables = new ArrayList<Calculable>(); // an unlimited element Services array
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
	            	
	            	calculables.add(new Reservation(name, room, month, start, end, type));
	            	
	            	System.out.printf("\nReservation ID: %d is created!\n", Reservation.totalNumOfReservations );
	    
	            	break;
	            	
	            case OPT2:
	            	if(calculables.size() == 0) System.out.println("\nNo reservation has been made yet to display information!");
	            	
	            	// Iterates over the arraylist and prints the information stored for each object
	            	for(Calculable reservation : calculables) { // foreach loop to display the information
	            		if (reservation instanceof Reservation) {
	            	        ((Reservation) reservation).displayInfo(); // downcasting
	            	    } 
	            	}
	            	
	            	break;	            	
	            	
	            case OPT3:
	            	System.out.print("Type a city name for a reservation search: ");
	            	String city = scanner.next();
	            	List<Calculable> infoList = calculables; // converted the Services from ArrayList to List
	            	Iterator<Calculable> iterator = infoList.iterator(); // get iterator
	            	
	            	while(iterator.hasNext()){
	            		Calculable reservation = iterator.next();
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
	            		calculables.add(new Laundry(id, piece));
	            	}
	            	if(extra == 2) {
	            		System.out.println("How many days?");
	            		int day = scanner.nextInt();
	            		calculables.add(new Spa(id, day));
	            	}
	            	
	            	break;
	            
	            case OPT5:
	            	for(Calculable reservation1 : calculables) {
	            		if(reservation1 instanceof Reservation) {
	            			System.out.printf("The cost for the Room booking service of reservation ID %d: %.2f\n", ((Reservation)reservation1).getCustomerID(),
	            					((Reservation)reservation1).calculateService()); 
	            		}
	            		if(reservation1 instanceof Spa) {
	            			System.out.printf("The cost for the Spa service of reservation ID %d: %.2f\n", ((Services)reservation1).getCustomerID(),
	            					((Services)reservation1).calculateService()); 
	            		}
	            		if(reservation1 instanceof Laundry) {
	            			System.out.printf("The cost for the Laundry service of reservation ID %d: %.2f\n", ((Services)reservation1).getCustomerID(),
	            					((Services)reservation1).calculateService()); 
	            		} 		
	            	}
	            	
	            	break;
	            	
	            case OPT6:
	            	
	            	for(Calculable reservation1 : calculables) {
	            		if(reservation1 instanceof Reservation) { // enters the second loop only when it is a Reservation object
	            			double total = ((Reservation)reservation1).calculateService();
		            		for(Calculable service : calculables) {
		            			if (( ((Services)service).getCustomerID() == ((Reservation)reservation1).getCustomerID()) &&
		            					(((Services)service).getServiceType().equals("Spa") || ((Services)service).getServiceType().equals("Laundry"))) {
		            				total += ((Services)service).calculateService();
		            			}
		            		}
		            		System.out.printf("The total cost of all services of the reservation with ID: %d is %.2f\n", ((Reservation)reservation1).getCustomerID(), total);
	            		}
	            	}
	            	
	            	break;
	            	
	            case OPT7:
	            	System.out.println("\nName: ");
	            	String userName = scanner.next();
	            	System.out.println("Surname: ");
	            	String surname = scanner.next();
	            	System.out.println("ID: ");
	            	int userID = scanner.nextInt();
	            	System.out.println("Monthly Payment: ");
	            	double monthlyPayment = scanner.nextDouble();
	            	
	            	calculables.add(new Employees(userID, monthlyPayment, userName, surname));
	            	
	            	break;
	            	
	            case OPT8:
	            	System.out.println("\nType: ");
	            	String billType = scanner.next();
	            	System.out.println("Amount: ");
	            	double billAmount = scanner.nextDouble();
	            	System.out.println("Month: ");
	            	String billMonth = scanner.next();
	            	
	            	calculables.add(new Bills(billType, billMonth, billAmount));
	            	
	            	break;
	            	
	            case OPT9:
	            	
	            	System.out.println("\nEnter Month: ");
	            	String Month = scanner.next();
	            	
	            	// the three variables below allows me to track monthly gains and costs
	            	double totalIncome = 0, totalBills = 0, totalEmployee = 0;
	            	//int checkID = 0; // it allows locating Laundry and Spa services for the inputted month 
	            	
	            	for (Calculable elem : calculables) {
	            	    if (elem instanceof Reservation && Month.equalsIgnoreCase(((Reservation) elem).getReservationMonth())) {
	            	        int checkID = ((Reservation) elem).getCustomerID();
	            	        System.out.printf("\nFor reservation ID: %d, Service type: Room booking, Service Cost: %.2f ",
	            	        		checkID, ((Reservation) elem).getCost());
	            	        totalIncome += ((Reservation) elem).getCost();
	            	        
	            	     // nested loop to accurectly find every Laundry and Spa that has the same ID as Reservation
	            	        for (Calculable nestedElem : calculables) { 
	            	            if (nestedElem instanceof Laundry && checkID == ((Laundry) nestedElem).getCustomerID()) {
	            	                System.out.printf("\nFor reservation ID: %d, Service type: Laundry, Service Cost: %.2f ", 
	            	                		((Laundry) nestedElem).getCustomerID(), ((Laundry) nestedElem).getCost());
	            	                totalIncome += ((Laundry) nestedElem).getCost();
	            	            }
	            	            if (nestedElem instanceof Spa && checkID == ((Spa) nestedElem).getCustomerID()) {
	            	                System.out.printf("\nFor reservation ID: %d, Service type: Spa, Service Cost: %.2f ", 
	            	                		((Spa) nestedElem).getCustomerID(), ((Spa) nestedElem).getCost());
	            	                totalIncome += ((Spa) nestedElem).getCost();
	            	            }
	            	        }
	            	    }

	            	    if (elem instanceof Bills && Month.equalsIgnoreCase(((Bills) elem).getMonth())) {
	            	        totalBills += ((Bills) elem).getCost();
	            	    }

	            	    if (elem instanceof Employees) {
	            	        totalEmployee += ((Employees) elem).getCost();
	            	    }
	            	}
	            	
	            	System.out.printf("\nTotal monthly income: %.2f", totalIncome);
	            	System.out.printf("\nTotal monthly bills due: %.2f", totalBills);
	            	System.out.printf("\nTotal monthly employee cost: %.2f", totalEmployee);
	            	System.out.printf("\nEnd of month balance: %.2f\n", totalIncome - (totalBills + totalEmployee));
	       
	            	break;
	            
	            case OPT10:
	            	ArrayList<Services> tempList = new ArrayList<Services>(); // temporary ArrayList to store instances of Services in calculables list
	            	for(Calculable elem : calculables) {
	            		if(elem instanceof Services) tempList.add((Services)elem); // downcast elem to type Services
	            	}
	            	
	            	Collections.sort(tempList, Collections.reverseOrder(new CostComparator())); // changes from ascending to descending
	            	
	            	System.out.println(); // empty line
	            	for(Services element : tempList) {
	            		if (element instanceof Reservation) {
	            	        ((Reservation) element).displayServiceInfoFromServices(); // if the element is a Reservation object, it calls the non overriden method
	            	    } else {
	            	        element.displayServiceInfo();
	            	    }
	            	}
	            	
	            	break;
	            	
	            case OPT11:
	            	ArrayList<Reservation> tempList2 = new ArrayList<Reservation>(); // temporary ArrayList to store instances of Reservation in calculables list
	            	for(Calculable elem : calculables) {
	            		if(elem instanceof Reservation) tempList2.add((Reservation)elem); // downcast elem to type Reservation
	            	}
	            	Collections.sort(tempList2); // sort in ascending order
	            	
	            	System.out.println(); // empty line
	            	for(Reservation element : tempList2) {
	            		element.displayServiceInfo();
	            	}
	            	
	            	break;
	            	
	            case OPT12:
	         
	            	scanner.close();
	            	System.out.println("\nExiting, Goodbye!");
	            	break;
	            	
	            default:
	            	System.out.println("\nInvalid choice. Please try again.");
            }
			
		}while(choice != 12);
	
	}
	
}