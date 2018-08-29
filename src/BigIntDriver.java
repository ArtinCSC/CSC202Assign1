/**
 * Driver
 * A program that calculate two integer in an Array /& ArrayList 
 * Artin Malekian
 * Dr. Franssell
 * CSC 202 - Assignment #1
 * 18 January 2017
 */
import java.util.Scanner;

public class BigIntDriver {

	public static void main(String[] args) {
		//String response;
		BigInt1 b1;
		BigInt1 b2;
		BigInt1 b3;
		Scanner input = new Scanner(System.in);
	//do{	
		System.out.println("please enter the first numbers: ");
		String userInput1 = input.nextLine();
		
		System.out.println("please enter the second numbers: ");
		String userInput2 = input.nextLine();
		
		 b1 = new BigInt1(userInput1);
		 b2 = new BigInt1(userInput2);
		 //b3 = b1.add(b2);

		System.out.println(b1);
		
		//System.out.println("Do you want to try different number: yes/no");
		// response = input.next();
	//}while(response.equalsIgnoreCase("yes"));
	
	}
	
}
