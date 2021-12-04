/* Author: Seoeun Hong; Date: 08/14/2019;
 * Class: CS210; Project Name:Seattle_911_Event_Manager;
 * Description: Read incident data from the file that I put and display matching incidents that satisfy conditions that user put
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Seattle_911_Event_Manager {
	public static void main(String[] args) {
		// Open try-catch for catching FileNotFoundException;
		try {
			// Declare file;
			File file = new File("Seattle_911_Incidents.csv");
			// Declare Scanner object for reading data from the declared file;
			Scanner fileScanner = new Scanner(file);
			int totalEventNumber = 0;
			// Skip header of the data;
			fileScanner.nextLine();
			// Count total number of the events by reading line by line of the data;
			while (fileScanner.hasNextLine()) {
				totalEventNumber++;
				fileScanner.nextLine();
			}
			fileScanner.close();
			// Make an 'events' object array to store the Event objects that hold specific
			// data of one event;
			Event[] events = new Event[totalEventNumber];
			// Move cursor to the start point of the data;
			fileScanner = new Scanner(file);
			// Skip header of the data;
			fileScanner.nextLine();
			int i = 0;
			// Repeat this work until file has next line;
			while (fileScanner.hasNextLine()) {
				// Declare Scanner object for reading each line's data element(token)
				// separately;
				Scanner lineScanner = new Scanner(fileScanner.nextLine());
				// Set lineScanner's delimiter as ',' for reading data separated by ',';
				lineScanner.useDelimiter(",");
				// Read each data element of each line;
				String id = lineScanner.next();
				String type = lineScanner.next();
				// Event Clearance Date element have four data in it; day,month,year and time;
				// read separately with declaring new Scanner objects;
				// Split date and time data and get date data first;
				Scanner seperateDateAndTime = new Scanner(lineScanner.next());
				// Separate day, month, and year from date;
				Scanner dateScanner = new Scanner(seperateDateAndTime.next());
				// Set dateScanner's delimiter as '/' for reading data separated by '/';
				dateScanner.useDelimiter("/");
				int day = dateScanner.nextInt();
				int month = dateScanner.nextInt();
				int year = dateScanner.nextInt();
				// Get time data;
				String time = seperateDateAndTime.next();
				seperateDateAndTime.close();
				// Keep reading other elements from the line;
				String address = lineScanner.next();
				String sector = lineScanner.next();
				String zone = lineScanner.next();
				// Store each event data elements to each Event object and store each objects to
				// each events array's element;
				events[i] = new Event(id, type, day, month, year, time, address, sector, zone);
				i++;
			}
			fileScanner.close();
			// Call printEventNumber method;
			printEventNumber(events);
			// Assigning false value for quit; Value changes to true when user put 3 as
			// search operation for quit;
			boolean quit = false;
			// Open do-while-loop to restart until user want to finish this program;
			do {
				// Open try-catch for catching InputMismatchException;
				try {
					System.out.println("+++++++++++++++++++++++++++++++++");
					System.out.println("Seattle 911 Event Search Manager:");
					System.out.println("1-Search by Date");
					System.out.println("2-Search by Type");
					System.out.println("3-Quit");
					System.out.print("Choose a search operation:");
					// Declare Scanner object to read and store user-input-data from the console;
					Scanner console = new Scanner(System.in);
					int searchOperation = console.nextInt();
					// Show different statements by user input;
					if (searchOperation == 1) {
						System.out.print("Enter date (dd/mm/yy):");
						// Store user input;
						String userInputDate = console.next();
						// For reading day, month, and year from the user input, scan stored user input;
						Scanner scanUserInputDate = new Scanner(userInputDate);
						// Set scenUserInputDate's delimiter as '/' for reading data separated by '/';
						scanUserInputDate.useDelimiter("/");
						// Read each day, month, and year data;
						int userDay = scanUserInputDate.nextInt();
						int userMonth = scanUserInputDate.nextInt();
						int userYear = scanUserInputDate.nextInt();
						scanUserInputDate.close();
						int matchingEventCount = 0;
						// Open for loop for counting and printing all events that satisfy conditions
						// that user put;
						for (int j = 0; j < events.length; j++) {
							// For avoiding NullPointerException;
							if (events[j] != null)
								// Print each matching event's detail information;
								if (events[j].day == userDay && events[j].month == userMonth
										&& events[j].year == userYear) {
									// Count the number of matching events;
									++matchingEventCount;
									System.out
											.println("Event-" + matchingEventCount + "-------------------------------");
									System.out.println(events[j]);
								}
						}
						// Print number of matching event;
						System.out.println(matchingEventCount + " events.");
					} else if (searchOperation == 2) {
						System.out.print("Enter keyword for type: ");
						String userInputTypeKeyword = console.next();
						System.out.print("Enter sector: ");
						String userInputSector = console.next();
						// Make both String data to upper case for comparing with inserted data;
						userInputTypeKeyword = userInputTypeKeyword.toUpperCase();
						userInputSector = userInputSector.toUpperCase();
						int matchingEventCount = 0;
						for (int j = 0; j < events.length; j++) {
							if (events[j] != null)
								if (events[j].type.contains(userInputTypeKeyword)
										&& events[j].sector.equals(userInputSector)) {
									++matchingEventCount;
									System.out
											.println("Event-" + matchingEventCount + "-------------------------------");
									System.out.println(events[j]);
								}
						}
						System.out.println(matchingEventCount + " events.");
					} else if (searchOperation == 3) {
						System.out.println("Stay Safe!");
						// Change quit value as true for finishing this program;
						quit = true;
					} else {
						// Show following statement when user type invalid input rather than 1,2, or 3;
						System.out.println("You Put Invalid Input. Please Try Again.");
					}
				} catch (InputMismatchException e) {
					System.out.println("You Put Invalid Input. Please Try Again.");
				}
			} while (!quit);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}

	}

	// Calculate and print number of events;
	public static void printEventNumber(Event[] events) {
		int year15 = 0;
		int year16 = 0;
		int year17 = 0;
		// Calculate number of events by year;
		for (int i = 0; i < events.length; i++) {
			if (events[i] != null) {
				if (events[i].year == 15) {
					year15++;
				} else if (events[i].year == 16) {
					year16++;
				} else {
					year17++;
				}
			}
		}
		System.out.println("Total events: " + (year15 + year16 + year17));
		System.out.println("2015: " + year15 + " events");
		System.out.println("2016: " + year16 + " events");
		System.out.println("2017: " + year17 + " events");
		System.out.println("Total events: " + (year15 + year16 + year17));
	}
}
