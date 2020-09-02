package codeplus.basic.math1;

import java.io.*;

//제시한 수 중 소수의 개수를 출력하는 문제
public class counting_prime {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		String[] temp_input = input.split(" ");
		int[] num_arr = new int[n];
		for (int i = 0; i < num_arr.length; i++) num_arr[i] = Integer.parseInt(temp_input[i]);
		
		int demical_counting = 0;
		for (int i = 0; i < n; i++) {
			if(num_arr[i] == 1) continue;
			boolean is_demical = true;
			for (int dividing_num = num_arr[i] / 2; dividing_num >= 2; dividing_num--) {
				if(num_arr[i] % dividing_num == 0)	is_demical = false;
			}
			if(is_demical)	demical_counting++;
		}
		
		bw.write(String.valueOf(demical_counting));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
