package baekjoon_level5_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pro_2523_br {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= test; i++) {
			for(int j = 1; j <= i;j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		
		for(int i = test-1; i >= 1; i--) {
			for(int j = i; j >= 1; j--) {
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}
}
