package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class remote_controller {
	static boolean[] isBroken = new boolean[10];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int min = Math.abs(N - 100);
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int broken_num = Integer.parseInt(st.nextToken());
					isBroken[broken_num] = true;
			}
		}
		
		for (int num = 0; num <= 5000000; num++) {
			int len = check(num);
			if(len > 0) {
				int press_num = Math.abs(num - N);
				if(min > len + press_num) {
					min = len + press_num;
				}
			}
		}
		
		System.out.println(min);
		
		br.close();
	}
	
	public static int check(int num) {
		int len = 0;

		if(num == 0) {
			if(isBroken[0])	return 0;
			else			return 1;
		}
		
		while(num > 0) {
			if(isBroken[num % 10])	return 0;
		
			len += 1;
			num /= 10;
		}
		
		return len;
	}
}

