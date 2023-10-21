// 20210702040 - Emir Devlet Ertörer - Assignment 7

public enum MenuOptions {
	
		OPT1("1. Create new Reservation with Room Type"),
		OPT2("2. Display all Reservations"),
		OPT3("3. List the reservations for a specific city"),
		OPT4("4. Add extra services to a reservation"),
		OPT5("5. Calculate total cost for each service"),
		OPT6("6. Display the total cost of every customer"),
		OPT7("7. Add an Employee"),
		OPT8("8. Add a Bill"),
		OPT9("9. Get Monthly Balance"),
		OPT10("10. Exit");		
		
		private final String stringValue;
		
		private MenuOptions(String stringValue )
		{
			//this.intValue = intValue;
			this.stringValue = stringValue;
		}
		
		
		public String getString() {
			return stringValue;
		}
}