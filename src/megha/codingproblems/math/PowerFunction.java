package megha.codingproblems.math;

/**
 * Program to implement the power(x,y) or x^y
 * Time complexity - O(log n)
 * Space complexity - O(1)
 * 
 * @author megha krishnamurthy
 *
 */
public class PowerFunction {

	/**
	 * Method to compute x^y where both x and y are integers
	 * @param x
	 * @param y
	 * @return
	 */
	public double power(int x, int y) {
		if(y == 0) {
			return 1;
		}
		double temp = power(x, y/2);
		if(x % 2 == 0) {
			return temp * temp;
		} else {
			return x * temp * temp;
		}
	}
	
	/**
	 * Method to compute x^y where x is a double and y can be negative 
	 * @param x
	 * @param y
	 * @return
	 */
	public double power(double x, int y) {
		if(y == 0) {
			return 1;
		}
		double temp = power(x, y/2);
		if(y %2 == 0) {
			return temp * temp;
		} else {
			if(y > 0) {
				return x * temp * temp;
			} else {
				return (temp * temp)/x;
			}
		}
	}
	
	public static void main(String args[]) {
		PowerFunction powerFunc = new PowerFunction();
		System.out.println(powerFunc.power(9,7));
		System.out.println(powerFunc.power(3,4));
		System.out.println(powerFunc.power(5, 6));
		
		System.out.println(powerFunc.power(3.0, -2));
	}
}
