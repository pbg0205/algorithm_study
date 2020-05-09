package baekjoon_level5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//레벨5_최소, 최대 - 런타임 에러
public class Pro_10818_br {
	public int Min(int Arr[]) {
		int Min = Arr[0];
		for(int i = 0; i < Arr.length; i++) {
			if(Min > Arr[i])	Min = Arr[i];
		}
		
		return Min;
	}

	public int Max(int Arr[]) {
		int Max = Arr[0];
		for(int i = 0; i < Arr.length; i++) {
			if(Max < Arr[i])	Max = Arr[i];
		}
		return Max;
	}	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		String testLine = br.readLine();//테스트케이스를 받을 배열 입력
		String[] strArr = testLine.split(" ");//int배열 담기 이전에 임시 str배열
		
		//strArr에 있는 value를 int배열로 변환
		int [] testArr = new int[strArr.length];
		int index = 0;
		
		for(String input : strArr) {
			testArr[index] = Integer.parseInt(input);
			index++;
		}
		
		Pro_10818_br sol = new Pro_10818_br();
		System.out.print(sol.Min(testArr) + " ");
		System.out.print(sol.Max(testArr));
		
		br.close();
	}
}
