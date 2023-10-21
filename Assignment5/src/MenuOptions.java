// 20210702040 - Emir Devlet Ertörer - Assignment 5

public enum MenuOptions {
	
		OPT1("1. Create new Reservation"),
		OPT2("2. Create new Reservation with Room Type"),
		OPT3("3. Display all Reservations"),
		OPT4("4. Display the total number of reservations"),
		OPT5("5. List the reservations for a specific city"),
		OPT6("6. Remove reservations in a specific city"),
		OPT7("7. Exit");		
		
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