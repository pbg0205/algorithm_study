package baekjoon_fast;

import java.util.Scanner;

public class blackJack_2798 {
	//1,문제 제목 : 블랙잭
	//2. 문제 난이도 : 하(easy)
	//3. 문제 유형 : 배열, 와전탐색
	//4.추언 문제 풀이 시간 : 20분 -> 연습때는 x2로 계산해서 물기
	//5. 문제 풀이 여부 : O (10분 소요)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cardNum = sc.nextInt();
		int cardSum = sc.nextInt();
		sc.nextLine();
		
		int[] cardArr = new int[cardNum];
		int max = 0;
		for(int i = 0 ; i < cardNum; i++) cardArr[i] = sc.nextInt();
		
		for(int firstNum = 0; firstNum < cardArr.length; firstNum++) {
			for(int secondNum = firstNum + 1; secondNum < cardArr.length; secondNum++) {
				for(int thirdNum = secondNum + 1; thirdNum < cardArr.length; thirdNum++) {
					int sum = cardArr[firstNum] + cardArr[secondNum] + cardArr[thirdNum];
					if(sum <= cardSum && max < sum)	max = sum;
				}
			}
		}
		
		System.out.println(max);
		
		
		sc.close();
	}
}
