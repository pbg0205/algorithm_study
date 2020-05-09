package baekjoon_level5_8;

import java.io.*;
import java.util.*;

public class Pro_10996_br {
	public static void main(String[] args) throws IOException{
		long startTime = (long) System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testNum * 2; i++) {
			for(int j = 0; j < testNum; j++) {
				if(i % 2 == 0 && j % 2 == 0)	bw.write("*");
				if(i % 2 == 0 && j % 2 != 0)	bw.write(" ");
				if(i % 2 != 0 && j % 2 == 0)	bw.write(" ");
				if(i % 2 != 0 && j % 2 != 0)	bw.write("*");
			}
			bw.newLine();
		}
		
	
		long endTime = (long) System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		bw.close();
		br.close();
	}
}
