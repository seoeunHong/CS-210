/* Author: Seoeun Hong; Date: 07/25/2019;
 * Class: CS210; Project Name: PracticeLoop3;
 * Description: Display Christmas Tree;
 * */
public class PracticeLoop3 {
	//declare number of line that you want to get with final int height.
	public static final int HEIGHT = 9;
	public static void main (String[] args) {
		//This outer for loop makes structure of the Christmas Tree. This method makes each line;
		for(int line = 1; line<=HEIGHT; line++) {
		//This inner for loop prints left outside dots;
			for(int left_outside_dot = 1; left_outside_dot <=HEIGHT-line; left_outside_dot++) {
				System.out.print(".");
			}
		//* represents after drawing dots by pattern;
		System.out.print("*");
		//This inner for loop prints left inside dot;
			for(int left_inside_dot = 1; left_inside_dot<=line-1; left_inside_dot++) {
				System.out.print(".");
			}
		//* represents after drawing dots by pattern;
		System.out.print("*");
		//This inner for loop prints right inside dot;
			for(int right_inside_dot = 1; right_inside_dot<=line-1; right_inside_dot++) {
			System.out.print(".");
			}
		//* represents after drawing dots by pattern;
		System.out.print("*");
		//This inner for loop prints right outside dots;
			for(int right_outside_dot = 1; right_outside_dot <=HEIGHT-line; right_outside_dot++) {
			System.out.print(".");
			}	
		//This statement leads to the next line.
		System.out.println();
		}
	}
}
