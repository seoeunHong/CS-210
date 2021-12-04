/* Author: Seoeun Hong; Date: 08/05/2019;
 * Class: CS210; Project Name:GuessGame;
 * Description:Program selects the random number from 1 to 100 and the user guesses that number
 * 			   Program shows different statements according to input value
 * */
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessGame {
	public static void main (String[] args) {
		//Assigning false value for finish; Value changes to true when user guessing is correct;
		boolean finish = false;
		//Open do-while-loop to restart when program throws exception;
		do{
		//Open a try/catch block to handle the invalid user inputs;
		try{ 
		//declare Scanner object as usernumber;
		Scanner userinput = new Scanner(System.in);
		//Assigning 0 value for at total_tries first; Grows by one when tries of user continue;
		int total_tries = 0;
		//Assigning false value for answer; Value changes to true when user guessing is correct;
		boolean answer = false;
		//Select the random number;
		int correct_number = (int)(Math.random()*100+1);
		//Open while-loop; With ! operator, set test as true so that while-loop to be executed;
		while(!answer) {
			System.out.print("Guess a number between 1 and 100:");
			//Store user-input value
			int guess_number = userinput.nextInt();
				//with using if/else if, show different results by condition;
				if(guess_number<1||guess_number>100) {
					System.out.println("You typed out-range number. Please type range number");
				}else if((guess_number<correct_number)&&(guess_number>=1)) {
					//increase total_tries value for counting user's tries;
					total_tries++;
					System.out.println("Your guess is too low");
				}else if (guess_number == correct_number){
					total_tries++;
					System.out.println("You won! After "+total_tries+" tries!");
					//change answer value as true, so that finish this while-loop
					answer=true;
					//change finish value as true, so that finish this program;
					finish=true;
				}else if ((guess_number>correct_number)&&(guess_number<=100)) {
					total_tries++;
					System.out.println("Your guess is too high");
				}
			}
		}catch(InputMismatchException e) {
			//Show this statement when user typed input rather than number;
			System.out.println("You typed Invalid Input. Please Try again with Valid Input.");
			
		}	
		//With ! operator, set test as true so that while-loop to be executed;
		}while(!finish); 
	}
}