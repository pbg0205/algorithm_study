package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class candy_game {
	static char[][] data;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		data = new char[n][n];
		for (int i = 0; i < n; i++)
			data[i] = br.readLine().toCharArray();
		
		int ans = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if(col + 1 < n) {
					char char_tmp = data[row][col];
					data[row][col] = data[row][col+1];
					data[row][col + 1] = char_tmp;
					
					int ans_tmp = check(data);
					if(ans < ans_tmp)
						ans = ans_tmp;
					char_tmp = data[row][col];
					data[row][col] = data[row][col + 1];
					data[row][col + 1] = char_tmp;
				}
				
				if(row + 1 < n) {
					char char_tmp = data[row][col];
					data[row][col] = data[row+1][col];
					data[row + 1][col] = char_tmp;
					
					int ans_tmp = check(data);
					if(ans < ans_tmp)
						ans = ans_tmp;
					char_tmp = data[row][col];
					data[row][col] = data[row + 1][col];
					data[row + 1][col] = char_tmp;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int check(char[][] data) {
		int n = data.length;
		int ans = 1;
		int count = 1;
		for (int row = 0; row < n; row++) {
			count = 1;
			for (int col = 1; col < n; col++) {
				if(data[row][col] == data[row][col-1]) {
					count+= 1;
				}else {
					count = 1;
				}
				if(ans < count)
					ans = count;
			}
		}
		
		count = 1;
		for (int col = 0; col< n; col++) {
			count = 1;
			for (int row = 1; row < n; row++) {
				if(data[row][col] == data[row - 1][col]) {
					count+= 1;
				}else {
					count = 1;
				}
				if(ans < count)
					ans = count;
			}
		}
		
		return ans;
	}
}
