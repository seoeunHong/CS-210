/* Author: Seoeun Hong; Date: 07/18/2019;
 * Class: CS210; Project Name: UnicodeArt;
 * Description: Display the cat, the owl, and the chess board with separate method.
 * */

public class UnicodeArt {
	public static void main (String [] args) {
		drawCat(); //call the drawCat function.
		drawOwl(); //call the drawOwl function.
		drawChessboard(4,4); //call the drawChessboard function.
	}
	public static void drawCat() {
		//This method displays Cat image.
		System.out.println(" _");
	    System.out.println("(  \\");
	    System.out.println(" )  )");
	    System.out.println("(  (    .-\"\"-.    A.-.A");
	    System.out.println(" \\  \\/        \\/  ,   , \\");
	    System.out.println("  \\       \\   =;    t   /=");
	    System.out.println("   \\       |\"\".   ,---.");
	    System.out.println("     /    //     |  ||");
	    System.out.println("    /  _,))      |_, ))");
	   // This makes a spaces between the cat image and the owl image.		    
	    System.out.println(""); 

	}
	public static void drawOwl () {
		//This method draws Owl image.
		System.out.println(" \u2571\u2572  \uFE35  \u2571\u2572"); 
		System.out.println("\u007c (\u25C9) (\u25C9)\u007c");
		System.out.println("  \\   \uFE36   \\/ \uFE36  /");
		System.out.print("  /");
		drawBodyOfOwl(6); //call the drawBodyOfOwl function.
		System.out.println("\\");
		//repeating \u21BA 6 times
		drawBodyOfOwl(8); //call the drawBodyOfOwl function again.
		System.out.print("\n  \\");
		//repeating \u21BA 8 times
		drawBodyOfOwl(6); //call the drawBodyOfOwl function again.
		System.out.println("/");	
		//repeating \u21BA 6 times
		System.out.println(" \u00AF\u00AF/\\\u00AF/\\\u00AF");
		// This makes a spaces between the owl image and the box image.
		System.out.println(""); 
	}
	public static void drawBodyOfOwl (int times) {
		//this method displays repeating part of owl's body
		//repeating times is determined what parameter that you put 
		for(int a=1; a<=times;a++) {
			System.out.print("\u21BA");
		}
	}
	//This method draws Chess board. put half the desired number of tiles, each in height and width.
	public static void drawChessboard(int dupleheight, int duplewidth) {
		//This for loop shows vertical tile set; this set consists of two horizontal line of the chess board
		//set number is determined by 'dupleheight's' value.
		for(int a=1; a<=dupleheight;a++) {
			horizontalLine1(duplewidth); //call horizentalLine1 function (One of the horizontal tile set)
			System.out.println(); //move to the new line
			horizontalLine2(duplewidth);//call horizentalLine1 function (the other horizontal tile set)
			System.out.println(); //move to the new line
		}
	}
	//One of the horizontal tile set; display one shade tile and one black tile.
	//set number is determined by 'duplewidth's' value.
	public static void horizontalLine1(int duplewidth) {
		for(int a=1;a<=duplewidth;a++) {
			System.out.print("\u2588\u2588\u2591\u2591");
		}
	}
	//another horizontal tile set; display one black tiles and one shade tile.
	//set number is determined by 'duplewidth's' value.
	public static void horizontalLine2(int duplewidth) {
		for(int a=1;a<=duplewidth;a++) {
			System.out.print("\u2591\u2591\u2588\u2588");
		}
	}
}