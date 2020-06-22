package data_structure;

public class selectionSort {
	public static void main(String[] args) {
		int[] arr = {10,6,4,5,2,3,1,7,9,8};
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
		arr = selectionSort(arr);
		for (int i : arr) System.out.print(i + " ");
		
	}
	
	public static int[] selectionSort(int[] arr) {
		for (int left_idx = 0; left_idx < arr.length - 1; left_idx++) {
			int min_idx = left_idx;
			for (int right_idx = left_idx + 1; right_idx < arr.length; right_idx++) {
				if(arr[min_idx] > arr[right_idx])	min_idx = right_idx;
			}
			if(min_idx != left_idx)	swap(arr,left_idx, min_idx);
		}
		
		return arr;
	}
	
	public static void swap(int[] arr, int left_idx, int right_idx) {
		int temp = arr[left_idx];
		arr[left_idx] = arr[right_idx];
		arr[right_idx] = temp;
	}
}
