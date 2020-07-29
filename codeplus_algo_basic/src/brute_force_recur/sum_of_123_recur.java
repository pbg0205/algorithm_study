package brute_force_recur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sum_of_123_recur {
	static int tc;
	static int num[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tn = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tn; i++) {
			tc = Integer.parseInt(br.readLine());
			num = new int[tc+1];
			int sum = recur(tc);
			bw.write(String.valueOf(sum) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	// top-down 방식
	public static int recur(int tc) {
		if(num[tc] > 0) {
			return num[tc];
		}
		
		if(tc == 0 || tc == 1) {
			num[tc] = 1;
			return num[tc]; 
		}	
		
		if(tc == 2) {
			num[tc] = 2;
			return num[tc]; 
		}
		
		if(tc == 3) {
			num[tc] = 4;
			return num[tc];	
		}
		
		num[tc] = recur(tc-1) + recur(tc-2) + recur(tc-3);
		
		return num[tc];
	}
}
