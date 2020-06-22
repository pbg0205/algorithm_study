package data_structure;

import java.util.Iterator;

public class bubbleSort {
	public static void main(String[] args) {
		int[] intArr = {3, 44, 38, 5, 47, 15, 36, 26,
						27,	2, 46, 4, 19, 50, 48};
		for (int i : intArr)	System.out.print(i + " ");
		System.out.println();
		
		intArr = bubbleSort(intArr);
		for (int i : intArr)	System.out.print(i + " ");
	}
	
	public static int[] bubbleSort(int[] intArr) {
		for (int idx = 0; idx <= intArr.length - 2 ; idx++) {
			for (int left_idx = intArr.length - 2; left_idx >= idx; left_idx--) {
				int right_idx = left_idx + 1;
				if(intArr[left_idx] > intArr[right_idx])	swap(intArr, left_idx, right_idx);
			}
		}
		
		return intArr;
	}
	
	public static void swap(int[] intArr, int left_idx, int right_idx) {
		if(intArr[left_idx] > intArr[right_idx]) {
			int tmp = intArr[left_idx];
			intArr[left_idx] = intArr[right_idx];
			intArr[right_idx] = tmp;
		}
	}
}
