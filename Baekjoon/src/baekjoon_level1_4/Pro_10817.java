package baekjoon_level1_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pro_10817 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] sample = new int[3];
		int index = 0;
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		while(st.hasMoreTokens()) {
			sample[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		
		Arrays.sort(sample);
		
		System.out.println(sample[1]);
		
		br.close();
	}
}
