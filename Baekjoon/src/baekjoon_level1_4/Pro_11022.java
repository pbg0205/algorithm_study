package baekjoon_level1_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pro_11022 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testNum; i++) {
			String[] sample = br.readLine().split(" ");
			int cal1 = Integer.parseInt(sample[0]);
			int cal2 = Integer.parseInt(sample[1]);
			
			bw.write("Case #"+ i +": "+ cal1 + " + " + cal2 + " = "+ (cal1+cal2) + "\n"); 
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
