package megha.codingproblems.dynamicprog;

import java.util.Arrays;

/**
 * Problem statement: A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 * 
 * The solution uses memoization to cache the intermediate results
 * 
 * Time complexity - O(n)
 * 
 * @author megha.krishnamurthy
 *
 */
public class TripleStep {

	public int countWays(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}
	
	public int countWays(int n, int[] memo) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		}
		if(memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
			return memo[n];
		}
	}
	
	public static void main(String args[]) {
		TripleStep tripleStep = new TripleStep();
		System.out.println("Ways to climb 6 steps:" + tripleStep.countWays(6));
		System.out.println("Ways to climb 20 steps:" + tripleStep.countWays(20));
		System.out.println("Ways to climb 2 steps:" + tripleStep.countWays(2));
		System.out.println("Ways to climb 0 steps:" + tripleStep.countWays(0));
		System.out.println("Ways to climb 12 steps:" + tripleStep.countWays(12));
	}
}
