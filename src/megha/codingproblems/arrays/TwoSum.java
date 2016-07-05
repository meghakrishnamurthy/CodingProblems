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
	
	/**
	 * Method to return all the unique pairs that sum up to the target value in a sorted array
	 * Time complexity - O(n)
	 * Space complexity - O(1)
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public Set<Pair> findPairsWithSumSortedArray(int[] array, int target) {
		if(array == null || array.length == 0) {
			return null;
		}
		
		int low = 0;
		int high = array.length - 1;
		Set<Pair> uniquePairs = new HashSet<Pair>();
		
		while (low < high) {
			int currentSum = array[low] + array[high];
			if(currentSum == target) {
				Pair pair = new Pair(array[low], array[high]);
				uniquePairs.add(pair);
				low++;
				high--;
			} else if (currentSum < target) {
				low++;
			} else {
				high--;
			}
		}
		return uniquePairs;
	}
	
	public static void main(String args[]) {
		TwoSum twoSum = new TwoSum();
		int target = 6;

		System.out.println("The indices for the pair are:");
		int[] firstArray = {2,5,11,1,7,6,9};
		int[] result = twoSum.findPairWithSum(firstArray, target);
		System.out.println(result[0] + "," + result[1]);
		
		System.out.println("The pairs in the unsorted array are:");
		int[] secondArray = {2,-5,3,1,6,4,11,0,2,4};
		Set<Pair> uniquePairs1 = twoSum.findPairsWithSum(secondArray, target);
		Pair.printPairs(uniquePairs1);
		
		System.out.println("The pairs in the sorted array are:");
		int[] sortedArray = {-5,0,1,2,2,3,4,4,6,11};
		Set<Pair> uniquePairs2 = twoSum.findPairsWithSumSortedArray(sortedArray, target);
		Pair.printPairs(uniquePairs2);
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

