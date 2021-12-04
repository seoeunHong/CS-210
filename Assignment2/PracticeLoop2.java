/* Author: Seoeun Hong; Date: 07/25/2019;
 * Class: CS210; Project Name: PracticeLoop2;
 * Description: Display a number pyramid. Numbers in pyramid have certain pattern;
 * */
public class PracticeLoop2 {
	//declare number of line that you want to get with final int height.
	public static final int HEIGHT = 7;
	public static void main (String [] args) {
		//This outer for loop makes structure of the number pyramid. This method makes each line;
		for(int line = 1; line <= HEIGHT; line++ ) {
			//This inner for loop composes each line's content;
			for(int number = 0; number<line; number++) {
			//This statement prints each integers with pattern;
				System.out.print(2*(line+1)+number+" ");
			}
			//This statement leads to the next line.
			System.out.println();
		}
	}

}
