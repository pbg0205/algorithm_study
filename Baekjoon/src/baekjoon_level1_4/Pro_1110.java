package baekjoon_level1_4;

import java.io.*;

public class Pro_1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int oriNum = Integer.parseInt(br.readLine());
		
		int temp1 = oriNum / 10;
		int temp2 = oriNum % 10;
		int temp3 = temp1 + temp2;
		int result = -1;
		int count = 0;
		
//		System.out.println("temp1 : " + temp1);
//		System.out.println("temp2 : " + temp2);
//		System.out.println("temp3 : " + temp3);
		
		while(oriNum != result){
			temp1 = temp2;
			temp2 = temp3 % 10;
			temp3 = temp1 + temp2;
			
			result = temp1 * 10 + temp2;
			count++;
			
//			bw.write("countNum:" + count + "\n");
//			bw.write("temp1: " + temp1 + "\n");
//			bw.write("temp2: " + temp2 + "\n");
//			bw.write("temp3: " + temp3 + "\n");
//			bw.write("result: " + result + "\n");
		
		};
			bw.write(""+count);
			bw.flush();	
			bw.close();
			br.close();
	}
}
