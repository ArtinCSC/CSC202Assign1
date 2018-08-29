/**
 * BigIntClass(ArrayList)
 * A program that calculate two integer in an Array /& ArrayList 
 * Artin Malekian
 * Dr. Franssell
 * CSC 202 - Assignment #1
 * 18 January 2017
 */
package BigIntLinked;

import java.util.*;
import java.lang.*;

class BigInt {

	private String sign = "+";
	private ArrayList<Integer> myNum;

	public BigInt() {

	}

	public BigInt(String wholeS) {

		wholeS = errorChecker(wholeS);
		wholeS = wholeS.trim();
		myNum = new ArrayList<Integer>();

		for (int i = 0; i < wholeS.length(); i++) {
			if (i == (wholeS.length() - 1))
				myNum.add(Integer.parseInt(wholeS.substring(i)));
			else
				myNum.add(Integer.parseInt(wholeS.substring(i, i + 1)));
		}
	}

	private ArrayList<Integer> getNumb() {
		return myNum;
	}

	private String getSign() {
		return sign;
	}

	/**
	 * Precondition: input is the String (userInput). Postcondition: Return back
	 * the string without the sign at the beginning of it or Exit the system if
	 * the input has mismatch character.
	 */
	private String errorChecker(String s) {

		if ((s.length() > 1) && ((s.substring(0, 1).charAt(0) == 43) || (s.substring(0, 1).charAt(0) == 45))) {
			sign = s.substring(0, 1);
			s = s.substring(1);
		}
		if ((s.length() == 1) && ((s.substring(0).charAt(0) < 48) || (s.substring(0).charAt(0) > 57))) {
			System.out.println("Error: \n" + "There is no number to be calculated  \n" + "Goodbay");
			System.exit(0);
		} else if ((s.length() > 0) && (s.substring(0, 1).charAt(0) == 32)) {
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
	private boolean unmatchInputFinder(String n) {
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
	private boolean integerChecker(String c) {
		boolean result = true;
		if (c.charAt(0) < 48 || c.charAt(0) > 57)
			result = false;

		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return the
	 * reverse order.
	 */
	private ArrayList<Integer> reverser(ArrayList<Integer> u) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = (u.size() - 1); i >= 0; i--) {
			result.add(u.get(i));
		}
		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return the
	 * reduced zeros.
	 */
	private ArrayList<Integer> reduceZero(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == 0)
				a.remove(i);
			else if (a.get(i) > 0)
				i = a.size() - 1;
		}
		if (a.size() == 0)
			a.add(0);
		return a;
	}

	/**
	 * Precondition: inputs are an arrarList integer and the String sign.
	 * Postcondition: Return the combined of number and the sign in String.
	 */
	private String stringConverter(ArrayList<Integer> a, String s) {
		String result = s;
		for (int i : a) {
			result += Integer.toString(i);
		}
		return result;
	}

	/**
	 * Precondition: inputs are an arrarList integer and the String sign.
	 * Postcondition: Return the combined of number and the sign in String.
	 */
	private String signChoser(ArrayList<Integer> num, String sign2) {
		String wholN = "";
		if (num.size() > myNum.size()) {
			num = sub(num, 0);
			if (sign2.charAt(0) == 43)
				wholN = stringConverter(num, "-");
			else
				wholN = stringConverter(num, "+");
		} else if (num.size() < myNum.size()) {
			num = sub(num, 1);
			wholN = stringConverter(num, sign);
		} else if (num.size() == myNum.size()) {
			if (numEvaluator(num, sign2) == sign) {
				num = sub(num, 1);
				wholN = stringConverter(num, sign);
			} else if (numEvaluator(num, sign2) == sign2) {
				num = sub(num, 0);
				if (sign2.charAt(0) == 43)
					wholN = stringConverter(num, "-");
				else
					wholN = stringConverter(num, "+");
			} else {
				num = sub(num, 0);
				wholN = stringConverter(num, "");
			}
		}
		return wholN;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return a calculated/add
	 * object.
	 */
	public BigInt add(int newInt) {
		BigInt result;
		String myNumStr = sign;
		for (int i : myNum)
			myNumStr += i;
		int myNumInt = Integer.parseInt(myNumStr);

		myNumInt = myNumInt + newInt;
		String wholN = Integer.toString(myNumInt);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return a
	 * calculated/subtract object.
	 */
	public BigInt subtract(int newInt) {
		BigInt result;
		String myNumStr = sign;
		for (int i : myNum)
			myNumStr += i;
		int myNumInt = Integer.parseInt(myNumStr);

		myNumInt = myNumInt - newInt;
		String wholN = Integer.toString(myNumInt);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return a
	 * calculated/divideBy object.
	 */
	public BigInt divideBy(int newInt) {
		BigInt result;
		String myNumStr = sign;
		for (int i : myNum)
			myNumStr += i;
		int myNumInt = Integer.parseInt(myNumStr);

		if (newInt == 0 || myNumInt == 0)
			myNumInt = 0;
		else
			myNumInt = (int) (myNumInt / newInt);
		String wholN = Integer.toString(myNumInt);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return a
	 * calculated/multiply object.
	 */
	public BigInt multiply(int newInt) {
		BigInt result;
		String myNumStr = sign;
		for (int i : myNum)
			myNumStr += i;
		int myNumInt = Integer.parseInt(myNumStr);

		myNumInt = myNumInt * newInt;
		String wholN = Integer.toString(myNumInt);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return a
	 * calculated/multiply object.
	 */
	public BigInt modulus(int newInt) {
		BigInt result;
		String myNumStr = sign;
		for (int i : myNum)
			myNumStr += i;
		int myNumInt = Integer.parseInt(myNumStr);

		if (newInt == 0 || myNumInt == 0)
			myNumInt = 0;
		else
			myNumInt = (myNumInt % newInt);
		String wholN = Integer.toString(myNumInt);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return a
	 * calculated/multiply arrayList.
	 */
	private ArrayList<Integer> multiply(ArrayList<Integer> n, ArrayList<Integer> n0) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		n1 = reverser(n0);
		n = reverser(n);
		int carry;

		for (int i = 0; i < n.size(); i++) {
			carry = 0;
			for (int o = 0; o < n0.size(); o++) {
				if (i == 0) {
					result.add(calcRemainder((n.get(i) * n1.get(o)) + carry));
				} else if (i + o > result.size() - 1) {
					result.add(calcRemainder((n.get(i) * n1.get(o)) + carry));
				} else {
					result.set(i + o, (result.get(i + o) + (calcRemainder((n.get(i) * n1.get(o)) + carry))));
				}
				carry = carryFinder(n.get(i) * n1.get(o) + carry);
			}
			if (carry != 0)
				result.add(carry);
		}
		result = reverser(result);
		return result;
	}

	/**
	 * Precondition: input is two arrarList integer. Postcondition: Return false
	 * if the number is greater and return true if the number is smaller or
	 * equal
	 */
	private boolean numEvaluator(ArrayList<Integer> a, ArrayList<Integer> b) {
		boolean result = true;
		if (a.size() > b.size())
			result = false;
		else if (a.size() < b.size())
			result = true;
		else {
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) > b.get(i)) {
					i = a.size() - 1; // return false if the number is greater
					result = false;
				} else if (b.get(i) > a.get(i)) {
					i = a.size() - 1;
					result = true; // return true if the number is smaller or
									// equal
				}
			}
		}
		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return a
	 * calculated/division arrayList.
	 */
	private ArrayList<Integer> divideBy(ArrayList<Integer> n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		ArrayList<Integer> n2 = new ArrayList<Integer>();
		n1 = myNum;
		int j = 0;

		while (numEvaluator(n, n1) == true) {
			for (int i = 0; i < n.size() + myNum.size(); i++) {
				n2 = cuteSize(n1, n.size() + i);
				if (numEvaluator(n, n2) == true) {
					result.add(dividNum(n, n2));
					n2.clear();
					n2.add(result.get(j));
					n1 = sub(n1, multiply(n, zeroAdder(n2, (n1.size() - n.size() - i))));
					i = (n.size() + myNum.size()) - 1;
					j++;
				}
			}
		}
		return result;
	}

	/**
	 * Precondition: input is an arrarList integer and an integer.
	 * Postcondition: Return a the arrayList in the size that is asked.
	 */
	private ArrayList<Integer> cuteSize(ArrayList<Integer> n1, int s) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < s; i++)
			result.add(n1.get(i));
		return result;
	}

	/**
	 * Precondition: input is an arrarList integer and an integer.
	 * Postcondition: Return a the arrayList in the size that is asked.
	 */
	private ArrayList<Integer> zeroAdder(ArrayList<Integer> r, int a) {
		for (int i = 0; i < a; i++)
			r.add(0);
		return r;
	}

	/**
	 * Precondition: input is two arrarList integer. Postcondition: Return an
	 * integer (number of devision that can be applied).
	 */
	private int dividNum(ArrayList<Integer> n, ArrayList<Integer> n0) {
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		int mult = 0;

		for (int i = 1; i <= n.size(); i++) {
			n1.add(i);
			if (numEvaluator(multiply(n, n1), n0) == true) {
				n1.clear();
				mult++;
			} else // if false
				i = n.size();
		}
		return mult;
	}

	/**
	 * Precondition: input is an arrarList integer and a String (sign).
	 * Postcondition: Return a String version calculated number.
	 */
	private String numBaseOnSign(ArrayList<Integer> num, String sign2) {
		String result = "";
		if (sign2.charAt(0) == sign.charAt(0))
			result = stringConverter(divideBy(num), "+");
		else if (sign2.charAt(0) != sign.charAt(0))
			result = stringConverter(divideBy(num), "-");
		return result;
	}

	public String toString() {
		String result = "";
		reduceZero(myNum);
		for (int myNums : myNum)
			result += myNums;
		if (sign.charAt(0) == 45) {
			if (result.length() == 1 && Integer.parseInt(result) == 0)
				return result;
			else
				return sign + result;
		}
		return result;
	}

	/**
	 * Precondition: input is an object. Postcondition: Return a
	 * calculated/division object based on its sign.
	 */
	public BigInt divideBy(BigInt newNum) {
		BigInt result;
		ArrayList<Integer> num = new ArrayList<Integer>();
		String sign2 = newNum.getSign(), wholN = "";
		num = newNum.getNumb();
		if (num.size() > myNum.size())
			wholN = "0";
		else if (num.get(0) == 0 || myNum.get(0) == 0)
			wholN = "0";
		else
			wholN = numBaseOnSign(num, sign2);
		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an object. Postcondition: Return a
	 * calculated/modulus object based on its sign.
	 */
	public BigInt modulus(BigInt newNum) {
		BigInt result;
		ArrayList<Integer> num = new ArrayList<Integer>();
		String sign2 = newNum.getSign(), wholN = "";
		num = newNum.getNumb();

		if ((num.size() > myNum.size()) || (num.get(0) == 0) || (myNum.get(0) == 0))
			wholN = signBase(sign2);
		else if (num.size() == myNum.size() && numEvaluator(num, sign2) == "")
			wholN = "0";
		else
			wholN = mod(num, sign2);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is a String (sign). Postcondition: Return a String
	 * version calculated number.
	 */
	private String mod(ArrayList<Integer> num, String sign2) {
		String result = "";
		if (sign2.charAt(0) == sign.charAt(0))
			result = stringConverter(sub(myNum, multiply(divideBy(num), num)), "+");
		else if (sign2.charAt(0) != sign.charAt(0))
			result = stringConverter(sub(myNum, multiply(divideBy(num), num)), "-");
		return result;
	}

	/**
	 * Precondition: input is a String (sign). Postcondition: Return a String
	 * version calculated number.
	 */
	private String signBase(String sign2) {
		String result = "";
		if (sign2.charAt(0) == sign.charAt(0))
			result = stringConverter(myNum, "+");
		else
			result = stringConverter(myNum, "-");
		return result;
	}

	/**
	 * Precondition: input is an object. Postcondition: Return a
	 * calculated/multiply object based on its sign.
	 */
	public BigInt multiply(BigInt newNum) {
		BigInt result;
		ArrayList<Integer> num = new ArrayList<Integer>();
		String sign2 = newNum.getSign(), wholN = "";
		num = multiply(newNum.getNumb(), myNum);

		if (sign2.charAt(0) != sign.charAt(0))
			wholN = stringConverter(num, "-");
		else if (sign2.charAt(0) == sign.charAt(0))
			wholN = stringConverter(num, "");

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an object. Postcondition: Return a calculated
	 * object based on its sign/ add or subtract.
	 */
	public BigInt subtract(BigInt newNum) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		String sign2 = newNum.getSign(), wholN = "";
		num = newNum.getNumb();

		if (sign2.charAt(0) != sign.charAt(0)) {
			num = add(num);
			wholN = stringConverter(num, sign);
		} else if (sign2.charAt(0) == sign.charAt(0))
			wholN = signChoser(num, sign2);

		BigInt result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: input is an object . Postcondition: Return a calculated
	 * object based on its sign/ add or subtract.
	 */
	public BigInt add(BigInt newNum) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		String sign2 = newNum.getSign(), wholN = "";
		BigInt result;
		num = newNum.getNumb();

		if (sign2.charAt(0) == sign.charAt(0))
			wholN = stringConverter(add(num), sign2);
		else if (sign2.charAt(0) != sign.charAt(0))
			wholN = signChoserAdd(num, sign2);

		result = new BigInt(wholN);
		return result;
	}

	/**
	 * Precondition: inputs are an arrarList integer and String sign.
	 * Postcondition: Return a String combined of this two input base on the
	 * sign.
	 */
	private String signChoserAdd(ArrayList<Integer> num, String sign2) {
		String wholN = "";
		if (num.size() > myNum.size()) {
			num = sub(num, 0);
			wholN = stringConverter(num, sign2);
		} else if (myNum.size() > num.size()) {
			num = sub(num, 1);
			wholN = stringConverter(num, sign);
		} else if (num.size() == myNum.size()) {
			if (numEvaluator(num, sign2) == sign2) {
				num = sub(num, 0);
				wholN = stringConverter(num, sign2);
			} else if (numEvaluator(num, sign2) == sign) {
				num = sub(num, 1);
				wholN = stringConverter(num, sign);
			} else if (numEvaluator(num, sign2) == "") {
				num = sub(num, 1);
				wholN = stringConverter(num, "");
			}
		}
		return wholN;
	}

	/**
	 * Precondition: inputs are two arrarList integer. Postcondition: Return an
	 * arrarList subtracted number.
	 */
	private ArrayList<Integer> sub(ArrayList<Integer> n1, ArrayList<Integer> n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		n1 = reverser(n1);
		n = reverser(n);
		if (n1.size() > n.size())
			n = sizeMaker(n1, n);
		else
			n1 = sizeMaker(n, n1);
		for (int i = 0; i < n.size(); i++) {
			if (n1.get(i) < n.get(i)) {
				n1.set(i, n1.get(i) + 10);
				if (n1.get(i + 1) == 0) {
					int c = 1;
					while (n1.get(i + c) == 0) {
						n1.set(i + c, 9);
						c++;
					}
					n1.set(i + c, n1.get(i + c) - 1);
				} else
					n1.set(i + 1, n1.get(i + 1) - 1);
			}
			result.add(n1.get(i) - n.get(i));
		}
		result = reverser(result);
		result = zeroReduser(result);
		if (result.size() == 0)
			result.add(0);

		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return the
	 * same arrayList but reduced extra zeros.
	 */
	private ArrayList<Integer> zeroReduser(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(0) == 0)
				a.remove(0);
			else
				i = a.size() - 1;
		}
		return a;
	}

	/**
	 * Precondition: input is an arrarList integer and an integer number 0 or 1.
	 * Postcondition: Return a calculated arrayList.
	 */
	private ArrayList<Integer> sub(ArrayList<Integer> n, int s) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		n1 = reverser(myNum);
		n = reverser(n);

		if (n1.size() > n.size()) {
			n = sizeMaker(n1, n);
		} else if (n.size() > n1.size()) {
			n1 = sizeMaker(n, n1);
		}
		if (s == 0) {
			for (int i = 0; i < n.size(); i++) {
				if (n.get(i) < n1.get(i)) {
					n.set(i, n.get(i) + 10);
					if (n.get(i + 1) == 0) {
						int c = 1;
						while (n.get(i + c) == 0) {
							n.set(i + c, 9);
							c++;
						}
						n.set(i + c, n.get(i + c) - 1);
					} else
						n.set(i + 1, n.get(i + 1) - 1);
				}
				result.add(n.get(i) - n1.get(i));
			}
		} else if (s == 1) {
			for (int i = 0; i < n.size(); i++) {
				if (n1.get(i) < n.get(i)) {
					n1.set(i, n1.get(i) + 10);
					if (n1.get(i + 1) == 0) {
						int c = 1;
						while (n1.get(i + c) == 0) {
							n1.set(i + c, 9);
							c++;
						}
						n1.set(i + c, n1.get(i + c) - 1);
					} else
						n1.set(i + 1, n1.get(i + 1) - 1);
				}
				result.add(n1.get(i) - n.get(i));
			}
		}
		result = reverser(result);
		return result;
	}

	/**
	 * Precondition: input is the two arrarList integer with different size.
	 * Postcondition: Return the equal size arrayList integer.
	 */
	private ArrayList<Integer> sizeMaker(ArrayList<Integer> a, ArrayList<Integer> b) {
		int o = (a.size() - b.size());
		for (int i = 0; i < o; i++)
			b.add(0);
		return b;
	}

	/**
	 * Precondition: input is the an arrarList integer and string sign.
	 * Postcondition: Return true if num is bigger or return false if num1 is
	 * bigger.
	 */
	private String numEvaluator(ArrayList<Integer> num, String s) {
		String result = "";
		for (int i = 0; i < num.size(); i++) {
			if (num.get(i) > myNum.get(i)) {
				i = num.size() - 1;
				result = s;
			} else if (myNum.get(i) > num.get(i)) {
				result = sign;
				i = num.size() - 1;
			} else if (myNum.get(i) == num.get(i)) {
				result = "";
			}
		}
		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return a
	 * calculated arrayList.
	 */
	private ArrayList<Integer> add(ArrayList<Integer> n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		n1 = reverser(myNum);
		n = reverser(n);

		if (n1.size() > n.size()) {
			n = sizeMaker(n1, n);
		} else if (n.size() > n1.size()) {
			n1 = sizeMaker(n, n1);
		}
		int carry = 0;
		for (int i = 0; i < n.size(); i++) {
			result.add(calcRemainder(n.get(i) + n1.get(i) + carry));
			carry = carryFinder(n.get(i) + n1.get(i));
		}
		if (carry != 0)
			result.add(carry);
		result = reverser(result);

		return result;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return the first digit
	 * of the number as the carry in.
	 */
	private int carryFinder(int c) {
		int result = 0;
		if (c >= 10)
			result = Integer.parseInt(Integer.toString(c).substring(0, 1));
		return result;
	}

	/**
	 * Precondition: input is an integer. Postcondition: Return the remainder.
	 */
	private int calcRemainder(int a) {
		return a % 10;
	}
}
