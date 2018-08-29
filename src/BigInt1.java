/**
 * BigIntClass(Array)
 * A program that calculate two integer in an Array /& ArrayList 
 * Artin Malekian
 * Dr. Franssell
 * CSC 202 - Assignment #1
 * 18 January 2017
 */
public class BigInt1 {
private static String sign = "+";
private static int bigInt;
private static int[] myNum;
	public BigInt1(String wholeS) {
		

		wholeS = errorChecker(wholeS);
		wholeS = wholeS.trim();
		myNum = new int[wholeS.length()];

		for(int b = 0; b < wholeS.length(); b++){
			for(int e = wholeS.length()-1; e >= 0; e--){
			if(e == (wholeS.length()-1))
				myNum[b] = Integer.parseInt(wholeS.substring(e));
			else
			myNum[b] = Integer.parseInt(wholeS.substring(e, e + 1));
		}
		}
		
		
	}

	/**
	 * Precondition: input is the String (userInput). Postcondition: Return back
	 * the string without the sign at the beginning of it or Exit the system if the
	 * input has mismatch character.
	 */
	private static String errorChecker(String s) {

		if ((s.length() > 1) &&(s.substring(0,1).charAt(0) == 43) || (s.substring(0,1).charAt(0) == 45)) {
			 sign = s.substring(0, 1);
		s = s.substring(1);
	}
		if ((s.length() == 1) && ((s.substring(0).charAt(0) == 43) || (s.substring(0).charAt(0) == 45) || (s.substring(0).charAt(0) == 32))) {
			System.out.println("Error: \n" + "There is no number to be calculated  \n" + "Goodbay");
			System.exit(0);
		} else if (s.substring(0,1).charAt(0) == 32) {
			System.out.println("Error: \n" + "There is a space in the begining which is not allowed \n" + "Goodbay");
			System.exit(0);
		} else if (unmatchInputFinder(s) == false) {
			System.out.println("Error: \n" + "There is a charactor which is not integer  \n" + "Goodbay");
			System.exit(0);
		}
		
		return s;
	}

	/**
	 * Precondition: input is a String. Postcondition: Return false if there is
	 * a character. Return true if all the characters are integer
	 */
	private static boolean unmatchInputFinder(String n) {
		boolean result = true;
		for (int i = 0; i < n.length(); i++) {
			String myChar = " ";

			if (i == (n.length() - 1))
				myChar = n.substring(i);
			myChar = n.substring(i, i + 1);

			if (integerChecker(myChar) == false) {
				result = false;
				i = n.length();
			}

		}

		return result;
	}

	/**
	 * Precondition: input is char. Postcondition: Return false if the character
	 * is not an integer. Return true if the character is an integer
	 */
	private static boolean integerChecker(String c) {
		boolean result = true;
		if (c.charAt(0) < 48 || c.charAt(0) > 57)
			result = false;

		return result;
	}
	public String toString(){
		if(sign.charAt(0) == 45)
			return "The Big Integer is: " + sign + myNum; //bigInt;
		
		return "The Big Integer is: " + bigInt;
	}
	
	public Object add(BigInt1 num){
		//BigInt bigInt = null;
		int[] bigInt = new int[myNum.length];
		
		
		for(int i = myNum.length; i >=1; i++){
			//bigInt = myNum[i] + num[i];
		}
		
		return bigInt;
		
		
	}

}
