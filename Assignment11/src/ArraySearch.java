// 20210702040 - Emir Devlet Ertörer - Assignment 11

import java.util.ArrayList;

public class ArraySearch implements Runnable {
    private ArrayList<Calculable> calculablesList;
    private String value;
    private int start_index, end_index;
    private static String found_IDS = "";
    

    public ArraySearch(ArrayList<Calculable> calculablesList, String value, int start_index, int end_index) {
        this.calculablesList = calculablesList;
        this.value = value;
        this.start_index = start_index;
        this.end_index = end_index;
        System.out.println("Thread created with start index: " + start_index + ", end index: " + end_index);
    }

    public static String getID() {
        return found_IDS;
    }

    public static void resetID() {
        found_IDS = "";
    }

    @Override
    public void run() {   	 
    	 for (int i = start_index; i < end_index; i++) {
    	        if (((Reservation) calculablesList.get(i)).getHotelName().toLowerCase().equalsIgnoreCase(value)) {
    	            synchronized (ArraySearch.class) { // synchronize on the class
    	                found_IDS += (((Reservation) calculablesList.get(i)).getCustomerID()) + " ";       
    	            }
    	        }
    	    }
    }
}