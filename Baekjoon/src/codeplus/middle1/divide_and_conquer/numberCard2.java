package codeplus.middle1.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numberCard2 {
	
	static StringTokenizer st;
	
	static int[] inputArr;
	static int[] compareArr;
	
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		inputArr = new int[n];
		inputData(n, inputArr);
		
		m = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		compareArr = new int[m];
		inputData(m, compareArr);
		
		quickSort(inputArr, 0, inputArr.length - 1);

		StringBuilder sb = new StringBuilder();
		for(int num : compareArr)
			sb.append(find(num)).append(" ");
		
		System.out.println(sb);
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	private static void inputData(int length, int[] arr) {
		for (int idx = 0; idx < length; idx++) {
			arr[idx] = stoi(st.nextToken());
		}
	}
	
	private static int find(int num) {
		int left = findLeft(inputArr, 0 , inputArr.length, num);
		int right = findRight(inputArr, 0 , inputArr.length, num);
		
		return right - left;//정렬 후, 인덱스를 통해 갯수를 구하는 방법(left<= 숫자 < right)
	}
	
	private static int findLeft(int[] arr, int left, int right, int num) {
		int mid = (left + right) / 2;
		if(left >= right) {
			return mid;
		}
		
		if(arr[mid] >= num) {
			return findLeft(arr, left, mid, num);
		}else {
			return findLeft(arr, mid + 1, right, num);
		}
	}

	private static int findRight(int[] arr, int left, int right, int num) {
		int mid = (left + right) / 2;
		if(left >= right) {
			return mid;
		}
		
		if(arr[mid] <= num) {
			return findRight(arr, mid + 1, right, num);
		}else {
			return findRight(arr, left, mid, num);
		}
	}

	private static void quickSort(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int x = arr[(pl + pr) / 2];
		
		do {
			while(arr[pl] < x) pl++;
			while(arr[pr] > x)	pr--;
			if(pl <= pr) {
				swap(arr, pl++, pr--);
			}
			
		}while(pl <= pr);
		
		if(left < pr) quickSort(arr, left, pr);
		if(pl < right) quickSort(arr, pl, right);
	}

	private static void swap(int[] arr, int pl, int pr) {
		int tmp = arr[pl];
		arr[pl] = arr[pr];
		arr[pr] = tmp;
	}
}
