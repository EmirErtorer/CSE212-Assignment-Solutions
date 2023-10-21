// 20210702040 - Emir Devlet Ertörer - Assignment 10


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainFrame extends JFrame {
    
	ArrayList<Calculable> calculables = new ArrayList<Calculable>(); // an unlimited element Calculable array
	
    public MainFrame() {
    	
        super("Hotel Reservation System"); // setting the title
        setLayout(new BorderLayout());
        
        
        // Create a menu bar
 		JMenuBar menuBar = new JMenuBar();
 		
 		// Create menus
 		JMenu fileMenu = new JMenu("File");
 		JMenu newMenu = new JMenu("New");
 		JMenu helpMenu = new JMenu("Help");
 		
 		// Create menu items
 		JMenuItem reservationItem = new JMenuItem("Reservation");
 		JMenuItem servicesItem = new JMenuItem("Services");
 		JMenuItem contentsItem = new JMenuItem("Contents");
 		JMenuItem aboutItem = new JMenuItem("About");
 		JMenuItem exitItem = new JMenuItem("Exit");
 		
 		// Add menu items to menus
 		fileMenu.add(exitItem);
 		newMenu.add(reservationItem);
 		newMenu.add(servicesItem);
 		helpMenu.add(contentsItem);
 		helpMenu.add(aboutItem);
 		
 		// Add menus to menu bar
 		menuBar.add(fileMenu);
 		menuBar.add(newMenu);
 		menuBar.add(helpMenu);
 		
 		//add action listeners for the menu items:
 		reservationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String city = JOptionPane.showInputDialog("Enter City:");
            	String hotel = JOptionPane.showInputDialog("Enter Hotel Name:");
            	String month = JOptionPane.showInputDialog("Enter Month:");
            	String start = JOptionPane.showInputDialog("Enter Reservation Start:");
            	String end = JOptionPane.showInputDialog("Enter Reservation End:");
            	
            	// parsing them to get ints
            	int startDate = Integer.parseInt(start);
            	int endDate = Integer.parseInt(end);
            	
            	// add the Reservation object to the ArrayList
            	calculables.add(new Reservation(city, hotel, month, startDate, endDate ));
            }
        });
 		
 		servicesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String extra = JOptionPane.showInputDialog("\nPlease select one of the extra services from below:\n1. Laundry Service\n2. Spa Service");
            	String id = JOptionPane.showInputDialog("Type the reservation ID to credit this service:");
            	int ID = Integer.parseInt(id);
            	int service = Integer.parseInt(extra);
            	
            	if(service == 1) {
            		String piece = JOptionPane.showInputDialog("How many pieces of clothing?:");
                	int pieces = Integer.parseInt(piece);
                	// add the Laundry object to the ArrayList
                	calculables.add(new Laundry(ID, pieces));
            	}
            	
            	if(service == 2) {
            		String day = JOptionPane.showInputDialog("How many days?:");
                	int days = Integer.parseInt(day);
                	// add the Spa object to the ArrayList
                	calculables.add(new Spa(ID, days));
            	}
            }
        });
 		
 		contentsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String content = "To make a new Reservation or a new Services, click on New from the Menu Bar above.\n"
            			+ "If you want to display information click on one of the options on the screen below the Menu Bar.\n"
            			+ "If you want to exit the program, click on File above and click on Exit";
            	JOptionPane.showMessageDialog(null, content);
            }
        });
 		
 		aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Author:\nEmir Devlet Ertörer\n20210702040");
            }
        });
 		
 		exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0); // exit the program
            }
        });
 		
 		// Add the menu bar to frame
 		setJMenuBar(menuBar);
 		
 		
 		
        // Create a JTextArea to display information
 		JPanel textAreaPanel = new JPanel(new FlowLayout());
        JTextArea textArea = new JTextArea(30, 80); 
        // Add the JTextArea to the frame
        textAreaPanel.add(new JScrollPane(textArea)); // Add scrolling to the JTextArea
        Font font = textArea.getFont().deriveFont(16f); //increase the font
        textArea.setFont(font);
        
        
       
        // Create a JPanel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // create buttons for the three options
        JButton displayReservationsButton = new JButton("Display Reservations");
        JButton extraReservationsButton = new JButton("Display Extra Services");
        JButton cityReservationsButton = new JButton("Display Reservations For City");
        
        // Add buttons to the JPanel
        buttonPanel.add(displayReservationsButton);
        buttonPanel.add(extraReservationsButton);
        buttonPanel.add(cityReservationsButton);
        
        // Add the JPanel to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(textAreaPanel, BorderLayout.CENTER);
        
        //Add action listeners to the panel buttons
        displayReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	textArea.setText(""); // clearing the text area
            	if(calculables.size() == 0) textArea.setText("No reservation has been made yet to display information!");
            	
            	// Iterates over the arraylist and prints the information stored for each object
            	for(Calculable reservation : calculables) { // foreach loop to display the information
            		if (reservation instanceof Reservation) {
            			
            			String information = String.format("Reservation for %s:\nReservation ID #%d%s\n\n",
            					((Reservation) reservation).getCity(), ((Reservation) reservation).getCustomerID(), 
            					((Reservation) reservation).displayInfo());
            	        textArea.append(information);
            	    } 
            	}
            }
        });
        
        extraReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	textArea.setText(""); // clearing the text area
            	for(Calculable reservation1 : calculables) {       
            		if(reservation1 instanceof Spa) {
            			String message = String.format("Reservation ID #%d has %d days of SPA services.\n",
            	                ((Services) reservation1).getCustomerID(),
            	                ((Spa) reservation1).getDays());
            			textArea.append(message); 
            		}
            		if(reservation1 instanceof Laundry) {
            			String message = String.format("Reservation ID #%d has %d pieces for Laundry Service.\n",
            	                ((Services) reservation1).getCustomerID(),
            	                ((Laundry) reservation1).getClothingPiece());
            			textArea.append(message); 
            		} 		
            	}
            }
        });
        
        cityReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	textArea.setText(""); // clearing the text area
            	String city = JOptionPane.showInputDialog("Type a city name:");
            	List<Calculable> infoList = calculables; // converted the Services from ArrayList to List
            	Iterator<Calculable> iterator = infoList.iterator(); // get iterator
            	
            	while(iterator.hasNext()){
            		Calculable reservation = iterator.next();
            		if(reservation instanceof Reservation) {
            			if( ((Reservation) reservation).getCity().toLowerCase().equalsIgnoreCase(city)) { 
                			String cityMessage = String.format("Reservation for %s:\nReservation ID #%d\n%s\n\n",
                					city, ((Reservation) reservation).getCustomerID(), ((Reservation) reservation).displayInfo());
                			textArea.append(cityMessage);
                		}
            		}
            		
            	}
            }
        });
        
        
        
    }
}



