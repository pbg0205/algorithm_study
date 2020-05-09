package baekjoon_level5_8;

import java.io.*;

public class Pro_3052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [] inputArr = new int[10];
		int otherNum = 0;
		
		for(int i = 0; i < 10; i++)	inputArr[i] = Integer.parseInt(br.readLine()) % 42;
		for(int j = 0; j < inputArr.length; j++) {
			for(int k = j+1; k < inputArr.length; k++) 
				if(inputArr[j] == inputArr[k])	inputArr[k] = -1;
		}
		
		for(int l = 0; l < inputArr.length; l++) {
			if(inputArr[l] == -1)	continue;
			otherNum++;
		}
		
		bw.write(String.valueOf(otherNum));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
