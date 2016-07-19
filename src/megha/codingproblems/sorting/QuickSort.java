package megha.codingproblems.sorting;

public class QuickSort {
	private static int[] array;
	public static void quickSort(int start, int end) {
		int i = start;
		int j = end;
		int pivot = (start + end)/2;
		
		while (i < j) {
			while(array[i] < array[pivot]) {
				i++;
			}
			while(array[j] > array[pivot]) {
				j--;
			}
			
			if(i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				i++;
				j--;
			}
		}
		if(j > start) {
			quickSort(start, j);
		}
		if(i < end) {
			quickSort(i, end);
		}
	}
	
	public static void main(String args[]) {
		array = new int[]{6,1,4,2,8,7,10,5};
		quickSort(0, array.length-1);
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + ",");
		}
		
	}
}
