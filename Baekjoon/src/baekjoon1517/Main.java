package baekjoon1517;
/*
 * @problem		버블소트(1517)
 * @url			https://www.acmicpc.net/problem/1517
 * @author		pbg0205
 */

import java.io.*;
import java.util.*;


class Main {
	static long swapCount = 0;
	static long[] sorted;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		sorted = new long[n];
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		mergetSort(arr, 0, n-1);
		
		System.out.println(swapCount);
	}

	private static void mergetSort(long[] arr, int low, int high) {
		if(low < high) {
			int mid = (low  + high) / 2;
			mergetSort(arr, low, mid);
			mergetSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(long[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int index = low;
		
		while(i <= mid && j <= high) {
			if(arr[i] <= arr[j])
				sorted[index++] = arr[i++];
			else {
				sorted[index++] = arr[j++];
				swapCount += (mid + 1 - i);
			}
		}
		
		while(i <= mid)
			sorted[index++] = arr[i++];
		
		while(j <= high)
			sorted[index++] = arr[j++];
		
		for(int k = low; k <= high; k++)
			arr[k] = sorted[k];
	}
}
