package dp1;

import java.util.Scanner;

public class sum_of_square {
	static final int max_num = 320;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] countArr = new int[max_num + 1];
		
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = max_num; i > 0; i--) {//320....1
			int temp = n;
			int i_temp = i;
			
			if(temp < Math.pow(i_temp, 2))	continue;
			while(temp > 0) {
				if(Math.pow(i_temp, 2) <= temp ) {
					temp -= Math.pow(i_temp, 2);
					countArr[i]++;
				}else {
					i_temp--;
				}
			}
		}
		
		for (int i : countArr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int min = 100000;
		for (int i = max_num; i >= 1; i--) {
			if(min > countArr[i] && countArr[i] != 0) {
				min = countArr[i];
			}
		}
		
		System.out.println(min);
		
		
		sc.close();
	}
}
//반례 존재 : 142
//답 3 출력 4