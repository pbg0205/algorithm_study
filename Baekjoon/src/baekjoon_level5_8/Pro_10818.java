package baekjoon_level5_8;

import java.util.Scanner;

public class Pro_10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = Integer.parseInt(sc.nextLine());
		String line = sc.nextLine();
		
		String[] strArr = line.split(" ");
		int[] intArr = new int[testNum];
		for(int i = 0 ; i < testNum ; i ++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		
		int Min = intArr[0];
		int Max = intArr[0];
		
		for(int j = 0; j < testNum ; j ++) {
			if(Min > intArr[j])	Min = intArr[j];
			if(Max < intArr[j])	Max = intArr[j];
		}
		
		System.out.print(Min + " " + Max);
		
		sc.close();
	}
}
