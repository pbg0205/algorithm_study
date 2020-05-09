package baekjoon_level1_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pro_10951 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = null;
		while((str = br.readLine()) != null || str != "") {
			String[] arr = str.split(" ",-1);
			//양수 : 배열의 개수, 0 : 구분자는 모두 제거 및 구분자 제외 문자만 배열 생성, 음수 : 구분자 기준하여 배열 생성
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);			
			
			//bw.write((a+b) + "\n");
			System.out.println(a+b);
		}
		//bw.close();
		br.close();
	}//write로 진행시 안떠오름;;
}
