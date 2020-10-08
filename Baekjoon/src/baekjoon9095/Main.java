package baekjoon9095;
/*
 * @problem		1, 2, 3 더하기(9095) : https://www.acmicpc.net/problem/9095
 * @author		pbg0205
 */
import java.io.*;

class Main {
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
