package Sorting_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortTest {
	//bubble sort 내림차순
	public int [] bubbleDesc(int[] arr) {
		for(int i = arr.length-1 ; i > 0; i--) {
			int swap_count = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[j+1]) {
					swap(arr, j, j+1);
					swap_count++;
				}
			}
			if(swap_count == 0)	break;
		}
		return arr;
	}
	//selection sort 내림차순
	public int[] selectDesc(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int index = i;
			int max = arr[i];
			for(int j = i+1; j < arr.length; j++) {
				if(max < arr[j]) {
				max = arr[j];	
				index = j;
				}
			}
			swap(arr, index, i);
		}
		return arr;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int[] strTointArr(String line) {
		String[] strArr  = line.split(" ");
		int [] intArr = new int[strArr.length];
		int index = 0;
		for(String  input : strArr ) {
			intArr[index] = Integer.parseInt(input);
			index++;
		}
		
		return intArr;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SortTest test = new SortTest();
		
		String line = br.readLine();
		int[] arr = strTointArr(line);
		test.selectDesc(arr);
		
		for(int output : arr) {
			System.out.print(output + " " );
		}
		
	}
}
