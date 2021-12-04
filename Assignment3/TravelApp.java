/* Author: Seoeun Hong; Date: 08/05/2019;
 * Class: CS210; Project Name:TravelApp;
 * Description: Display the distance between two places and its travel time for 
 *				foot, bicycle, and car
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TravelApp {
	public static void main (String[] args) {
		//Assigning false value for finish; Value changes to true when calculation is done successfully;
		boolean finish = false;
		//Open do-while-loop to restart when program throws exception;
		do {
		//Open a try/catch block to handle the invalid user inputs;
		try {	
			//declare Scanner object as usernumber;
			Scanner usernumber = new Scanner(System.in);
			System.out.print("Please enter Latitude for City 1:");
			//Store user-input value;
			double latitude_city1 = usernumber.nextDouble();
			System.out.print("Please enter Longitude for City 1:");
			double longitude_city1 = usernumber.nextDouble();
			System.out.print("Please enter Latitude for City 2:");
			double latitude_city2 = usernumber.nextDouble();
			System.out.print("Please enter Longitude for City 2:");
			double longitude_city2 = usernumber.nextDouble();
	//Store distance value; Bring distance value which is gotten from caculateDistance method;
			double distance = calculateDistance(latitude_city1,longitude_city1,latitude_city2,longitude_city2);
	//Display distance which is double value rounded to 2 digits after decimal;
			System.out.printf("Distance = %.2f km\n",distance);
			System.out.println("Travel Times....");
	//Display travel time by foot which is double value rounded to 2 digits after decimal;
			System.out.printf("Foot = %.2f hours\n",distance/6);
	//Display travel time by bicycle which is double value rounded to 2 digits after decimal;
			System.out.printf("Bicycle = %.2f hours\n",distance/16);
	//Display travel time by bicycle which is double value rounded to 2 digits after decimal;
			System.out.printf("Car = %.2f hours\n",distance/90);
			//change finish value as true, so that finish this program;
			finish = true;
		//catch input value rather than number (invalid Input);
		}catch(InputMismatchException e) {
			//Show this statement when user typed input rather than number;
			System.out.println("You typed Invalid Input. Please Try again with Valid Input.");
		}
		//With ! operator, set test as true so that do-while-loop to be executed;
		}while(!finish);
	}
	//Calculate Distance with given value;
	public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		//Store changed value;
		lat1 = convertToRadiant(lat1);
		lon1 = convertToRadiant(lon2);
		lat2 = convertToRadiant(lat2);
		lon2 = convertToRadiant(lon2);
		//The formula to calculate distance from latitude and longitude;
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat/2),2)+Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(dlon/2),2);
		double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		double radius_Earth = 6378.137;
		double d = radius_Earth*c;
		//return distance value which is double type number;
		return d;
	}
	//Convert decimal values to radiant;
	public static double convertToRadiant (double value) {
		return value/(180/Math.PI);
	}
}