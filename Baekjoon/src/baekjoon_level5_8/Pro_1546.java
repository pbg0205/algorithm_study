package baekjoon_level5_8;

import java.util.Scanner;

public class Pro_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Double subNum = Double.parseDouble(sc.nextLine());
		String[] strArr = sc.nextLine().split(" ");
		int size = strArr.length;
		Double[] doubleArr = new Double[size];
		//doubleArr에 과목값 입력
		for(int i = 0; i < doubleArr.length; i++)
			doubleArr[i] = Double.parseDouble(strArr[i]);
		
		//과목 중 최대값 구하기
		Double MaxValue = doubleArr[0];
		for(Double input : doubleArr)
			MaxValue = (MaxValue < input) ? input:MaxValue;	
		
		//새로운 점수 구하기
		double sum = 0;
		for(int i = 0; i < doubleArr.length; i++)
			sum += doubleArr[i] / MaxValue * 100;
		
		System.out.println(sum/subNum);
	}
}
