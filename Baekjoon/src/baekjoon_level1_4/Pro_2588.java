package baekjoon_level1_4;

import java.io.*;

public class Pro_2588 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int test1 = Integer.parseInt(a);
		int test2 = Integer.parseInt(b);
		int result = 0;
		int index = 1;
		
		//연산하기
		for(int i = 1; i <= 3; i++) {
			int temp1 = test2 % 10;
			test2 /= 10;
			
			int inter_result = test1 * temp1;
			System.out.println(inter_result);

			result += inter_result * index;
			index *= 10;
		}
		
		System.out.println(result);
	}
}
