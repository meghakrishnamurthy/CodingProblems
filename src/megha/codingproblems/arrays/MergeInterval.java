package megha.codingproblems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge intervals program
 * Problem statement:
 * Given a collection of intervals, merge all overlapping intervals
 * 
 * Time complexity - O(n)
 * Space complexity - O(n)
 * 
 * @author megha krishnamurthy
 *
 */
public class MergeInterval {
	
	/**
	 * Function that takes a collection of Interval objects and returns a collection of merged intervals
	 * The idea is to sort the collection of intervals and then merge the sorted intervals
	 * @param intervals
	 * @return
	 */
	public List<Interval> mergeIntervals(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.isEmpty()) {
			return result;
		}
		
		//Sort the intervals
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if(i1.start != i2.start) {
					return i1.start-i2.start;
				} else {
					return i1.end - i2.end;
				}
			}
		});
		
		Interval pre = intervals.get(0);
		for(Interval current:intervals) {
			if(current.start > pre.end) {
				result.add(pre);
				pre = current;
			} else {
				Interval merged = new Interval(pre.start, Math.max(pre.end, current.end));
				pre = merged;
			}
		}
		result.add(pre);
		
		return result;
	}
	
	/*
	 * Private utility method to setup data
	 */
	private List<Interval> setupData() {
		List<Interval> intervals = new ArrayList<Interval>();
		Interval i1 = new Interval(8,10);
		Interval i2 = new Interval(1,3);
		Interval i3 = new Interval(2,6);
		Interval i4 = new Interval(3,9);
		Interval i5 = new Interval(15,18);
		
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		
		return intervals;
	}
	
	public static void main(String args[]) {
		MergeInterval mergeInterval = new MergeInterval();
		List<Interval> intervals = mergeInterval.setupData();
		List<Interval> result = mergeInterval.mergeIntervals(intervals);
		Interval.printIntervals(result);
		
	}
}

/**
 * Interval class
 * @author megha krishnamurthy
 *
 */
class Interval {
	int start;
	int end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	/*
	 * Utility method to print intervals
	 */
	static void printIntervals(List<Interval> intervals) {
		if(intervals != null && !intervals.isEmpty()) {
			for(Interval interval: intervals) {
				if(interval != null) {
					System.out.println("[" + interval.start + "," + interval.end + "]");
				}
			}
		}
	}
}
