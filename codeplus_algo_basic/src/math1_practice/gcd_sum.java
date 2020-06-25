package math1_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class gcd_sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_num = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= test_num; i++) {
			String testcase = br.readLine();
			StringTokenizer st = new StringTokenizer(testcase);
			
			int test_case_num = Integer.parseInt(st.nextToken());
			int[] intArr = new int[test_case_num];
			long sum_of_gcd = 0;
			for (int j = 0; j < test_case_num; j++)	intArr[j] = Integer.parseInt(st.nextToken());
			
			for (int left_idx = 0; left_idx < intArr.length - 1; left_idx++) {
				for (int right_idx = left_idx + 1; right_idx < intArr.length; right_idx++) {
					sum_of_gcd += getGCD(intArr[left_idx], intArr[right_idx]);
				}
			}
			System.out.println(sum_of_gcd);
		}
	}
	
	public static int getGCD(int left, int right) {
		if(left < right) {
			int temp = left;
			left = right;
			right = temp;
		}
		
		while(left % right != 0) {
			int temp = right;
			right = left % right;
			left = temp;
		}
		
		return right;
	}
}
