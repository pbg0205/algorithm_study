package baekjoon_level5_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pro_2446_brbw {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
			
		//for(int i = 1; i <= test; i++) {
		//	for(int j = 1; j < i; j++)	bw.write(" ");
		//	for(int k = 1; k <= 2 * (test-i+1) - 1 ; k++)	bw.write("*");
		//	bw.newLine();
		//}
		
		/* for문 하나 더 돌리게 되면 value 출력이 안됨;; */
		for(int i = 2; i <= test; i++) {
			for(int j = 1; j < i; j++) bw.write(" ");
			for(int k = 1; k <= 2 * i -1;i++) bw.write("*");
			bw.newLine();
		}
			
		br.close();
		bw.close();
	}
}
