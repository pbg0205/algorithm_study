package baekjoon_level5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_1546_st {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//과목수
		double subNum = Double.parseDouble(br.readLine());
		//과목 점수
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		
		double maxValue = 0; double sum = 0; double subPoint;
		//최대값, 합 계산
		while(st.hasMoreTokens()) {
			subPoint = Double.parseDouble(st.nextToken());
			maxValue = (maxValue < subPoint) ? subPoint : maxValue;
			sum += subPoint;
		}
		sum = (sum/maxValue) * 100.0;
		//평균 계산
		double avr = sum / subNum;
		System.out.println(avr);
	}
}
