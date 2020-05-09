package Pro_Level1;

import java.util.Arrays;

public class gymSuit {
	public int solution_gymSuit(int n, int[] lost, int[] reserve) {
	int answer = 0;
	
	/*
	 * 문제 조건
	 * 1. 여벌의 체육복이 있는 학생이 이들에게 체육복을 빌려준다.
	 * 2. 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.(4 -> 3 or 5)
	 * 3. 체육복이 없으면 수업을 들을 수 없다.(최대한 많은 학생이 체육수엄 들어야함)
	 * 
	 * 접근 방식
	 * 1. 전체 학생 배열 생성
	 * 2. 잃어버린 친구 true 표시
	 * 3. 이전에 주었는지 여부 확인 필요(이전에 주었으면 true)
	 * 4. 없는 학생 기준 탐색, lost -> reserve
	 * 5. 탐색 후, 앞 뒤 학생 존재시 False 하기
	 * 6. 수업 참여 가능 학생 count
	 * 
	 * 7.여벌을 가지고 있는데도 도난을 당한 학생의 수를 계산해야함!
	 */
	
	//1. 전체 학생들의 배열 생성(기준 1로 설정)
	int[] student = new int[n+1];
	Arrays.fill(student, 1);

	for(int reserveStuNum : reserve)	student[reserveStuNum] += 1;//여벌의 체육복을 가지고 있는 학생처리
	for(int lostStuNum  : lost)	student[lostStuNum] -= 1;//체육복을 잃어버린 학생 처리
	
	//체육복 빌려줄지 말지 하는 알고리즘
	for(int lostStuNum  : lost) {
		int prev_lostStuNum = lostStuNum -1;
		int back_lostStunum = lostStuNum + 1;
//		System.out.println("**lostStuNum: "+lostStuNum);
		
		for (int i = 0; i < reserve.length; i++) {
			
//			System.out.println("reserve: " + reserve[i]);
//			System.out.print("prev_lostStuNum: " + prev_lostStuNum  + "\t");
//			System.out.println("back_lostStunum:" + back_lostStunum);
			
			if(prev_lostStuNum == reserve[i] || back_lostStunum == reserve[i]) {
				if(student[reserve[i]] > 1 && student[lostStuNum] == 0) {
					student[lostStuNum]++;
					student[reserve[i]]--;
				}
			}
		}
	}
	
	//수업에 참여할 수 있는 수 count
	for (int i = 1; i < student.length; i++) {
//		System.out.println("student["+i+"]: " + student[i]);
		if(student[i] >= 1) answer++;
	}
	return answer;
	}
	
	public static void main(String[] args) {
	gymSuit sol = new gymSuit();
	
	int n_1 = 5;
	int n_2 = 5;
	int n_3 = 3;
	int n_12 = 5;
	
	int [] lost1 = {2, 4};
	int [] lost2 = {2, 4};		
	int [] lost3 = {3};
	int [] lost12 = {1,2};

	int []reserve1 = {1, 3, 5};
	int []reserve2 = {3};
	int []reserve3 = {1};
	int []reserve12 = {2,3};
	
	System.out.println(sol.solution_gymSuit(n_12, lost12, reserve12));
	}
}
