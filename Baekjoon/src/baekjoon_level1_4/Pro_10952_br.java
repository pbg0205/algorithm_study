package baekjoon_level1_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_10952_br {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String test = br.readLine();
			String[] arr = test.split(" ");
			
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			
			if(a == 0 && b == 0) break;
			System.out.println(a + b);
		}
		br.close();
	}
}
