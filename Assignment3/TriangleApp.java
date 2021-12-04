/* Author: Seoeun Hong; Date: 08/05/2019;
 * Class: CS210; Project Name:TriangleApp;
 * Description: Calculate and display opposite of right-angle-triangle's value
 * */

import java.util.Scanner;

public class TriangleApp {
	public static void main (String[] args) {
		//declare Scanner object as usernumber;
		Scanner usernumber = new Scanner(System.in);
		System.out.print("Please enter the length for side a >>");
		//declare user-input number as hypotenuse; (a value for example);
		int hypotenuse = usernumber.nextInt();
		System.out.print("Please enter the length for side c >>");
		//declare user-input number as hypotenuse; (c value for example);
		int adjacent = usernumber.nextInt();
		//declare result value of calculateB() method as opposite; (b value for example);
		int opposite = calculateB(hypotenuse, adjacent);
		System.out.println("a = "+hypotenuse+"\nb = "+opposite+"\nc = "+adjacent);
	}
	//This method return value of b; The type of b is an integer;
	public static int calculateB(int a, int c) {
	//Calculate b value calling sqrt method in Math class; Casting integer for matching return type;
		return (int)Math.sqrt(a*a-c*c);
	}

}