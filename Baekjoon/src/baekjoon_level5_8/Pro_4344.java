package baekjoon_level5_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_4344 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				int stuNum = Integer.parseInt(st.nextToken());
				//overAvr : 평균이상 수, sum : 합계, avr : 평균, ratio : overAvr / stuNum
				double overAvr = 0, sum = 0, avr, ratio;
				
				//점수들 배열에 담아서 평균, 비율 구하기
				double[] subPoint = new double[stuNum];
				int index = 0;
				while(st.hasMoreTokens()) {
					subPoint[index] = Double.parseDouble(st.nextToken());
					sum += subPoint[index];//합계 구하기
					index++;
				}
				avr = sum / stuNum; //평균 구하기
				for(double input : subPoint) {
					if(avr < input)	overAvr++; //평균 이상 학생수 구하기
				}
				ratio = overAvr / stuNum;//비율 계산
				System.out.printf("%5.3f%% \n", ratio * 100);
			}
		}
	}
}
