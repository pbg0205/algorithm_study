package Pro_Level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class minValueRemove {
	public int[] solution(int[] arr) {
		//답을 입력하는  Array(int)
		int[] answer = new int[arr.length-1];
		int min = 9999;
		int minIndex = 0;
		
		if(arr.length > 1) {
			//최소값 탐색
			for (int i = 0; i < arr.length; i++) {
				if(min > arr[i]) {
					min = arr[i];
					minIndex = i;
				}
			}
			
			//위치 변경하기(최소값 가장 끝으로 보내기) + 만약 최소값이 마지막에 있으면 그대로
			if(minIndex < arr.length - 1)	rightSwap(arr, minIndex);	
		
			//by.병기 : 정렬된 arr배열에서 최소값을 제외한 값을 배열 answer배열에 대입
			for (int k = 0; k < answer.length; k++) {
				answer[k] += arr[k];
			}
			
		}else if(arr.length == 1) {
			answer = new int[arr.length];
			answer[0] += -1;
		}
		return answer;
	}
	
	//by.병기 Array(int형) 값 첨가 후 오른쪽으로 밀고 값대입
	public void rightSwap(int[] arr, int minIndex) {
		int minTemp = arr[minIndex];
		for(int i = minIndex ; i < arr.length - 1 ; i++) {
			if(i < arr.length - 1)	arr[i] = arr[i+1];
		}
		arr[arr.length - 1] = minTemp;
	}
	
	//by.병기 Array(int형) 위치 변경함수
//	public void swap(int[] arr, int i, int j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,3,1};
		int[] arr2 = {10};
		minValueRemove sol = new minValueRemove();
		
//		sol.rightSwap(arr, 1);
//		for(int input: arr ) {
//			System.out.print(input + " ");
//		}
		
		int[] answer = sol.solution(arr);
		for(int input: answer) {
		System.out.print(input + " ");
		}		
	}
}
