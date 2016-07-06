package megha.codingproblems.arrays;

public class MergeSortedArrays {
	
	public int[] merge(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		int[] result = new int[m+n];
		
		while(k >= 0) {
			if(j<0 || (i>=0 && a[i] > b[j])) {
				result[k--] = a[i--];
			} else {
				result[k--] = b[j--];
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		int[] a = {4,8,11,16,21};
		int[] b = {2,5,7,10};
		
		MergeSortedArrays merge = new MergeSortedArrays();
		int[] result = merge.merge(a, b);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
