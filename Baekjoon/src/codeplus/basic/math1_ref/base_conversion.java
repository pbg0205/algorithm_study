package codeplus.basic.math1_ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//문제 : Base Conversion(11576)
public class base_conversion {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int future_base = Integer.parseInt(temp[0]);
		int now_base = Integer.parseInt(temp[1]);
		
		int digit_num = Integer.parseInt(br.readLine());
		
		temp = br.readLine().split(" ");
		int[] base_future = new int[digit_num];
		for (int i = base_future.length - 1; i >= 0; i--) base_future[i] = Integer.parseInt(temp[digit_num - (i+1)]);
		// 16 2
		//for (int i : base_future)	System.out.print(i + " ");
		
		
		int base_10 = 0;
		int r = 0;
		for (int i = 0; i < base_future.length; i++)	base_10 += base_future[i] * Math.pow(future_base, r++);
		
//		System.out.println(base_10);
		int answer[] = new int[1000000];
		Arrays.fill(answer, -1);
		
		int idx = 0;
		while(base_10 > 0) {
			answer[idx++] = (base_10 % now_base);
			base_10 /= now_base;
			//System.out.println(base_10);
		}
		
		while(idx > 0) {
			System.out.print(answer[--idx] + " ");
		}
		
		
		br.close();
	}
}
