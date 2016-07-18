package megha.codingproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem statement: Given an array S of n integers
 * Find all unique triplets in the array which gives the target sum
 * 
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 * 
 * @author megha.krishnamurthy
 *
 */
public class ThreeSum {

	public List<List<Integer>> findThreeSumTuples(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(array == null || array.length < 3) {
			return result;
		}
		
		Arrays.sort(array);
		
		for(int i=0; i<array.length-2; i++) {
			if(i == 0 || array[i] > array[i-1]) {
				int j = i+1;
				int k = array.length-1;
				while(j < k) {
					if(array[i] + array[j] + array[k] == target) {
						List<Integer> tuple = new ArrayList<Integer>();
						tuple.add(array[i]);
						tuple.add(array[j]);
						tuple.add(array[k]);
						result.add(tuple);
						
						j++;
						k--;
						
						/* Handle duplicates */
						while(j<k && array[j] == array[j-1]) {
							j++;
						}
						while(j<k && array[k] == array[k+1]) {
							k--;
						}
					} else if(array[i] + array[j] + array[k] > target) {
						k--;
					} else {
						j++;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		int[] array = {-1, 0, 1, 2, -1, -4};
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> result = threeSum.findThreeSumTuples(array, 0);
		for(List<Integer> tuple : result) {
			System.out.println("[" + tuple.get(0) + "," + tuple.get(1) + "," + tuple.get(2) + "]");
		}
	}
}
