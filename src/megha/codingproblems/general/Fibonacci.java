package megha.codingproblems.general;

/**
 * Fibonacci program - Both iterative and recursive versions
 * 
 * @author megha krishnamurthy
 *
 */
public class Fibonacci {
	
	/**
	 * Iterative implementation for nth fibonacci number
	 * Time complexity - O(n)
	 * Space complexity - O(1)
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacciIterative(int n) {
		if(n <= 1) {
			return n;
		}
		int fib = 1;
		int prevFib = 1;
		
		for(int i=2; i<n; i++) {
			int temp = fib;
			fib+= prevFib;
			prevFib = temp;
		}
		return fib;
	}
	
	/**
	 * Recursive implementation for nth fibonacci number
	 * Time complexity - O(n)
	 * Space complexity - O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacciRecursive(int n) {
		if(n <= 1) {
			return n;
		}
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	public static void main(String args[]) {
		Fibonacci fib = new Fibonacci();
		
		System.out.println("Iterative version:");
		System.out.println(fib.fibonacciIterative(5));
		System.out.println(fib.fibonacciIterative(10));
		System.out.println(fib.fibonacciIterative(20));
		System.out.println(fib.fibonacciIterative(30));
		
		System.out.println("Recursive version:");
		System.out.println(fib.fibonacciRecursive(5));
		System.out.println(fib.fibonacciRecursive(10));
		System.out.println(fib.fibonacciRecursive(20));
		System.out.println(fib.fibonacciRecursive(30));
	}
}
