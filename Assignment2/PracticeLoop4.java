/* Author: Seoeun Hong; Date: 07/25/2019;
 * Class: CS210; Project Name: PracticeLoop4;
 * Description:Display a number pyramid. Numbers in pyramid have certain pattern;
 * */
import java.util.Scanner;

public class PracticeLoop4 {
	public static void main (String[] args) {
		//declare a Scanner object as number
		Scanner number = new Scanner(System.in);
		System.out.print("Enter a number:");
		//Declare user-input number as height; Height determines the number of output's lines
		int height = number.nextInt();
		System.out.println();
		//This outer for loop makes structure of the number pyramid; This method makes each line;
		for(int line = 1; line<=height; line++) {
		//This inner for loop makes left space of each line;
			for(int left_space = 1; left_space<=2*(height-line); left_space++) {
				System.out.print(" ");	
			}
		//This inner for loop makes left part and middle of numbers of each line;
			for(int left_and_middle_number=0;left_and_middle_number<=line-1;left_and_middle_number++) {
				System.out.print((int)Math.pow(2,left_and_middle_number)+" ");
			}
		//This inner for loop makes right parts of numbers of each line;
			for(int right_number=line-2;right_number>=0;right_number--) {
				System.out.print((int)Math.pow(2,right_number)+" ");
			}
		//This statement leads to the next line;
			System.out.println();
		}
		
	}

}