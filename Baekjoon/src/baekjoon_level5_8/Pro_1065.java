package baekjoon_level5_8;

import java.util.*;

public class Pro_1065 {
	//-한수의 갯수 맞추는 문제
	//1. 만약, 100미만의 자연수의 경우 모두 한수에 해당한다.
	//2. 만약, 100이상의 자연수의 경우 값을 나눈 후, 이전의 값과 뺀다.
	//3. 반복시행 시, 값의 차이가 다르면 건너뛰기.
	public int getHanSu(int testCase) {
		int hansu = 0;
		
		for(int testNum = 1; testNum <= testCase; testNum++) {
			if(testNum < 100)	hansu++;
			if(testNum >= 100) {
				int hansu_test_number = testNum;
				
				int hansu_test_number_prev = hansu_test_number % 10;
				hansu_test_number /= 10;
				int hansu_test_number_after = hansu_test_number % 10;
				
				int common_difference = hansu_test_number_after - hansu_test_number_prev;//공차
				//나머지 값들 공차와 비교
				while(hansu_test_number > 0) {
					hansu_test_number_prev = hansu_test_number_after;
//					System.out.println("hansu_test_number_prev: "+hansu_test_number_prev);
					hansu_test_number /= 10;
					hansu_test_number_after = hansu_test_number % 10;
//					System.out.println("hansu_test_number_after: "+hansu_test_number_after);
					if(common_difference != (hansu_test_number_after - hansu_test_number_prev)) break;
					if(hansu_test_number_after == 0)	continue;
//					System.out.println(testNum);
					hansu++;
				}
				//123을 중복을 없애는 방법
			}
		}
		
		return hansu;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		
		Pro_1065 sol = new Pro_1065();
		System.out.println(sol.getHanSu(testCase));
		
		sc.close();
	}
}
