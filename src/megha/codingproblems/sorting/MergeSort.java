package megha.codingproblems.sorting;

public class MergeSort {
	private static int[] array;
	private static int[] helper;
	
	public static void mergeSort() {
		mergeSort(0, array.length-1);
	}
	
	public static void mergeSort(int low, int high) {
		if(low < high) {
			int middle = (low + high)/2;
			mergeSort(low, middle);
			mergeSort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	public static void merge(int low, int middle, int high) {
		helper = new int[array.length];
		for(int i=low; i<=high; i++) {
			helper[i] = array[i];
		}
		
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i <= middle && j <= high) {
			if(helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle) {
			array[k] = helper[i];
			i++;
			k++;
		}
	}
	
	public static void main(String args[]) {
		array = new int[]{10,8,6,4,2,3,5,7,9,1};
		mergeSort();
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + ",");
		}
		
	}	
}
