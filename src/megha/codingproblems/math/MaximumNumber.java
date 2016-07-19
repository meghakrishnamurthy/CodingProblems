package megha.codingproblems.math;

/**
 * Problem statement - Given a number, find the maximum number formed after deleting only 1 digit
 * Time complexity - O(n) where n is the length of the integer
 * Space complexity - O(1)
 * 
 * @author megha.krishnamurthy
 *
 */
public class MaximumNumber {
	
	/**
	 * Method takes an integer and returns the maximum number obtained after deleting only 1 digit
	 * This works only on positive integers
	 * @param number
	 * @return
	 */
	public int getMaximumNumber(int number) {
		int maxNumber = 0;
		
		String numStr = Integer.toString(number);
		int length = numStr.length();
		if(length == 1) {
			maxNumber = number;
		} else {
			for(int i=0; i<length; i++) {
				String temp = numStr.substring(0, i) + numStr.substring(i+1, length);
				int currentNumber = Integer.parseInt(temp);
				if(currentNumber > maxNumber) {
					maxNumber = currentNumber;
				}
			} 
		}
		return maxNumber;
	}
	
	/**
	 * Method takes an integer and returns the maximum number obtained after deleting only 1 digit
	 * This handles both negative and positive integers
	 * @param number
	 * @return
	 */
	public int getMaximumNumberAllIntegers(int number) {
		int maxNumber = Integer.MIN_VALUE;
		
		boolean isNegative = false;
		if(number < 0) {
			isNegative = true;
		}
		
		String numStr = Integer.toString(number);
		int i = isNegative ? 1 : 0;
		int beginIndex = isNegative ? 1 : 0;
		int length = numStr.length();
		if(length == 1) {
			maxNumber = number;
		} else {
			for(;i < length; i++) {
				String temp = numStr.substring(beginIndex,i) + numStr.substring(i+1, length);
				int currentNumber = Integer.parseInt(temp);
				if(isNegative) {
					currentNumber = -currentNumber;
				}
				if(currentNumber > maxNumber) {
					maxNumber = currentNumber;
				}
			}
		}
		return maxNumber;
	}
	
	public static void main(String args[]) {
		MaximumNumber maxNumber = new MaximumNumber();
		System.out.println(maxNumber.getMaximumNumber(921839128));
		System.out.println(maxNumber.getMaximumNumber(5));
		System.out.println(maxNumber.getMaximumNumberAllIntegers(-15835));
		System.out.println(maxNumber.getMaximumNumberAllIntegers(15835));
		System.out.println(maxNumber.getMaximumNumberAllIntegers(921839128));
		System.out.println(maxNumber.getMaximumNumberAllIntegers(0));
	}
}
