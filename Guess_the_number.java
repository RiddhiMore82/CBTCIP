import java.util.Scanner;
import java.util.Random;

public class Guess_the_number{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.println("Welcome to Guess the Number Game..!!");
		int maxAttempts = 5;
		System.out.println("You have maximum " + maxAttempts + "attempts to guess the number.");
		System.out.println();
		System.out.println("Let's begin playing...");
		System.out.println();
		
		int numberToBeGuessed = rd.nextInt(100) + 1;       // To take numbers randomly from the range 1 - 100
		System.out.println("I've guessed the number between 1 - 100.");	
	
		System.out.println("Can you guess it..??");
		int guessedNumber = 0;
		boolean guessedCorrectly = false;
		int attempts = 0;
		
		while(!guessedCorrectly && attempts < maxAttempts){
			System.out.println("Enter your guessing: ");
			guessedNumber = sc.nextInt();
			attempts++;
			
			if(guessedNumber < 1 || guessedNumber > 100){
				System.out.println("Please enter a number between the range 1 and 100");
			}else if(guessedNumber < numberToBeGuessed){
				System.out.println("Oops..! The guessed number is too small.. Try again..");
			}else if(guessedNumber > numberToBeGuessed){
				System.out.println("Ohh..! The guessed number is too high.. Try again..");
			}else{ 
				System.out.println("Wow..! You guessed it right..!");
				guessedCorrectly = true;
			}
			System.out.println();
			
			if(!guessedCorrectly){
				System.out.println("You have "+ (maxAttempts - attempts) + " attempts remaining.");
			}
			System.out.println();
		}
		
		if(!guessedCorrectly){
			System.out.println("Sorry..!! You have utilised all attempts..");
			System.out.println("The number was "+ numberToBeGuessed);
			System.out.println();
		}
		
		if(guessedCorrectly){
			System.out.println("Your score is: "+ ((maxAttempts - attempts) * 10));
			System.out.println();
		}
		
		System.out.println("Happy Playing...!!!");
		sc.close();
	}
}