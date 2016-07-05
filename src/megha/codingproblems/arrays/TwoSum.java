package megha.codingproblems.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Program to solve the 2 sum problem
 * Problem statement - Given an array of integers, find two numbers such that they add up to a specific target number
 * Variation to this is to return all the pairs of integers in an integer array who sum up to the target value
 * 
 * @author megha krishnamurthy
 *
 */
public class TwoSum {

	/**
	 * Method to return the indices of 2 array elements that sum up to the given target value
	 * Time complexity - O(n)
	 * Space complexity - Best/Average of O(1) and Worst case of O(n)
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public int[] findPairWithSum(int[] array, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++) {
			int difference = target - array[i];
			if(map.containsKey(array[i])) {
				result[0] = map.get(array[i]);
				result[1] = i;
			} else {
				map.put(difference, i);
			}
		}
		return result;
	}
	
	/**
	 * Method to return all the unique pairs in a given integer array that sum up to a target value
	 * Time complexity - O(n)
	 * Space complexity - Best/Average of O(1) and Worst case of O(n)
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public Set<Pair> findPairsWithSum(int[] array, int target) {
		if(array == null || array.length == 0) {
			return null;
		}
		Set<Pair> uniquePairs = new HashSet<Pair>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++) {
			int difference = target - array[i];
			if(map.containsKey(array[i])) {
				Pair pair = new Pair(difference, array[i]);
				uniquePairs.add(pair);
			} else {
				map.put(difference, array[i]);
			}
		}
		return uniquePairs;
	}
	
	public static void main(String args[]) {
		int[] firstArray = {2,5,11,1,7,6,9};
		TwoSum twoSum = new TwoSum();
		int[] result = twoSum.findPairWithSum(firstArray, 6);
		
		System.out.println(result[0] + "," + result[1]);
		
		int[] secondArray = {2,-5,3,1,6,4,11,0,2,4};
		Set<Pair> uniquePairs = twoSum.findPairsWithSum(secondArray, 6);
		Pair.printPairs(uniquePairs);
	}
}

/**
 * Class to store the integer pairs
 * @author megha krishnamurthy
 *
 */
class Pair{
	private int first;
	private int second;
	
	/*
	 * Overriding the constructor to maintain unique pairs
	 * This avoids pairs like (2,4) and (4,2)
	 */
	Pair(int first, int second) {
		if(first > second) {
			this.first = second;
			this.second = first; 
		} else {
			this.first = first;
			this.second = second; 
		}
	}
	
	static void printPairs(Set<Pair> pairs) {
		if(pairs != null && !pairs.isEmpty()) {
			for(Pair pair : pairs) {
				System.out.println(pair.first + "," + pair.second);
			}
		} else {
			System.out.println("No input pairs");
		}
	}
	
	@Override
	public int hashCode() {
		return this.first + this.second;
	}
	
	@Override
	public boolean equals(Object object) {
		Pair pair = (Pair)object;
		return(pair.first == this.first && pair.second == this.second);
	}
}

