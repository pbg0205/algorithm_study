package baekjoon_fast;

import java.util.Scanner;
//1,문제 제목 : 음계
//2. 문제 난이도 : 하(easy)
//3. 문제 유형 : 배열, 구현
//4.추언 문제 풀이 시간 : 15분 -> 연습때는 x2로 계산해서 물기
//5. 문제 풀이 여부 : O (10분 소요)
public class scale_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] testArr = new int[8];
		
		for(int testcase = 0; testcase < testArr.length; testcase++) {
			testArr[testcase] = sc.nextInt();
		}
		
		int common_difference = testArr[1] - testArr[0];
		
		for(int index = 0; index < testArr.length - 1; index++) {
			if(common_difference != testArr[index+1] - testArr[index]) {
				System.out.println("mixed");
				System.exit(0);
			}
		}
		
		if(common_difference > 0) {
			System.out.println("ascending");
		}else if (common_difference < 0){
			System.out.println("descending");			
		}
		
		
		sc.close();
	}
}
