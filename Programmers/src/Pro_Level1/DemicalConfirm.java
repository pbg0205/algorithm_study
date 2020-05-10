package Pro_Level1;

public class DemicalConfirm {
	/*
	 * 문제. 제곱근 구하기 
	 * 1. 입력값이 정수의 제곱근의 경우, 해당 정수에서 값을 출력한다.
	 */
	public long solution(long n) {
		if(Math.pow((int)Math.sqrt(n),2) == n)
			return (long) Math.pow(Math.sqrt(n) + 1, 2);
		return -1;
	}
	
	
	public static void main(String[] args) {
		DemicalConfirm sol = new DemicalConfirm();
		long n1 = 121;
		long n2 = 3;
		
		System.out.println(sol.solution(n1));
	}
}
