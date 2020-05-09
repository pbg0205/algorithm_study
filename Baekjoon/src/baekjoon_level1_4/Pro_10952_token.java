package baekjoon_level1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_10952_token {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a == 0 && b == 0)	break;
		
		System.out.println(a+b);
		
		}
		br.close();
	}
}
