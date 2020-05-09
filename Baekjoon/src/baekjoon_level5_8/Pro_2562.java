package baekjoon_level5_8;
import java.io.*;

public class Pro_2562 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [] intArr = new int[9];
		
		for(int i = 0; i < 9; i++)	intArr[i] = Integer.parseInt(br.readLine());
		
		int MaxValue = intArr[0];
		int index = 0;
		for(int j = 0; j < 9; j++) {
			if(MaxValue < intArr[j]) {
				MaxValue = intArr[j];
				index = j;
			}
		}
		
		index++;
		
		bw.write(String.valueOf(MaxValue));
		bw.newLine();
		bw.write(String.valueOf(index));
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
