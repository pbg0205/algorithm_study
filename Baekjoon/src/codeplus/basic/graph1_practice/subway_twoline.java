package codeplus.basic.graph1_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subway_twoline {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		
		for (int test_case = 1; test_case <= n; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		}
		
		
		br.close();
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
