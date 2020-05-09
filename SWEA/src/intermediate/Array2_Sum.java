package intermediate;

import java.util.Scanner;

public class Array2_Sum {
	public int searchMaxSum(int[][] intArr) {
		int maxValue = 0;
		//가로
		int sum = 0;
		for(int column = 1; column <= 100; column++) {
			sum = 0;
			for (int row = 1; row <= 100; row++) {
				sum += intArr[column][row];
			}
			if(sum > maxValue)	maxValue = sum;
		}
		
		//세로
		for (int row = 1; row <= 100; row++) {
			sum = 0;
			for (int column = 1; column <= 100; column++) {
					sum += intArr[column][row];
				}
				if(sum > maxValue)	maxValue = sum;
			}
		
		//대각선(좌->우)
		sum = 0;
		for (int i = 1 ; i <= 100; i++) {
			sum += intArr[i][i];
		}
		if(sum > maxValue)	maxValue = sum;

		//대각선(우->좌)
		sum = 0;
		for (int i = 100 ; i >= 1; i--) {
			sum += intArr[i][i];
		}
		if(sum > maxValue)	maxValue = sum;
		
		return maxValue;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Array2_Sum sol = new Array2_Sum();
		
		for(int i = 1; i <= 10; i++) {
			int test_num = Integer.parseInt(sc.nextLine());
			int[][] intArr = new int[101][101];
			for(int column = 1; column <= 100; column++) {
				for (int row = 1; row <= 100; row++) {
					intArr[column][row] = sc.nextInt();
				}
				sc.nextLine();
			}
			System.out.println("#" + i + " " + sol.searchMaxSum(intArr));
			
			}	
		
		sc.close();
	}
}
