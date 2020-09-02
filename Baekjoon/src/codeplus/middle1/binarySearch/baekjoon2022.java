package codeplus.middle1.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2022 {
	
	static double x;
	static double y;
	static double c;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());
		
		if(x < y) {
			double tmp = x;
			x = y;
			y = tmp;
		}
		
		double l = 0;
		double r = y;
		
		while(true) {
			double d = (l + r) / 2;
			double myC = getC(d);
			
			if(Math.abs(myC - c) <= 0.001) {
				System.out.printf(".3%f",d);
				return ;
			}
			
			if(myC > c) {
				l = d;
			}else {
				r = d;
			}
		}
	}


	private static double getC(double d) {
		double a = Math.sqrt(x*x - d*d);
		double b = Math.sqrt(y*y - d*d);
		
		return (a*b)/(a+b);
	}
}
