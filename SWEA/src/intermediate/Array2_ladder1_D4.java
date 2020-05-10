package intermediate;

import java.util.Arrays;
import java.util.Scanner;

public class Array2_ladder1_D4 {
	/*
	 * 1. 시작 위치 탐색 
	 * 2. 좌우 탐색 (1이 시작되는 위치 파악) 
	 * 3. 좌 > 우이면 leftFlag true/ 좌 < 우 rightFlag true; 
	 * 4. 해당 위치로 이동 
	 * 5. 상하 탐색 
	 * 6. 다음 위치가 0이면 위로 이동 
	 * 7. 만약 column이 1이라면, 위치 반환
	 * 
	 */
	public int ladder(int[][] bridge) {
		int finishRow = searchFinish(bridge);
		//System.out.println("finishRow: " + finishRow);

		int col = bridge.length - 2;
		int row = finishRow;
		boolean left_flag = false;
		boolean right_flag = false;
		//System.out.println(colIndex);
		
		while(col >= 1) {
		// 왼쪽, 오른쪽 열 탐색
			col--;
			//System.out.println("colIndex_up:" + colIndex);
			
			if(col == 1)	return row - 1;
			
			if (bridge[col][row-1] == 1) {
				left_flag = true;
				//System.out.println("left_Col:"+ colIndex);
				//System.out.println("left_flag: " + left_flag);
			
			}else if(bridge[col][row + 1] == 1) {
				right_flag = true;
				//System.out.println("right_Col:"+ colIndex);
				//System.out.println("right_flag: " + right_flag);
			}
			
		
		
		//true일 시, 값이 이동하는 현황을 check
		if (left_flag == true) {
			for (int i = row; i >= 1; i--) {
				if (bridge[col ][i - 1] == 0) {
					row = i;
					left_flag = false;
					//System.out.println("left_flag 이동 column: "+ colIndex);
					//System.out.println("left_flag row: "+ rowIndex);
					//System.out.println("left_flag: " + right_flag);
					break;
				}
			}
		} else if (right_flag == true) {
			for (int i = row; i <= 100; i++) {
				if(bridge[col][i+1] == 0)	{
					row = i;
					right_flag = false;
//					System.out.println("right_flag 이동 column: "+ colIndex);
//					System.out.println("right_flag row: "+ rowIndex);
//					System.out.println("right_flag: " + right_flag);
					break;
				}
			}
		}
//		System.out.println("\n");
		
		}
		
		return -1;
	}
	
	public int searchFinish(int[][] bridge){
		int column = 100; 
		for(int row = 1; row <= 100; row++) {
			if(bridge[column][row] == 2)	return row;
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		Array2_ladder1_D4 sol = new Array2_ladder1_D4();
		Scanner sc = new Scanner(System.in);
		// 1.사다리 입력
		int[][] bridge = new int[102][102];
		int testNum = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= 10; i++) {
			
			for (int column = 1; column <= 100; column++) {
				for (int row = 1; row <= 100; row++) {
					bridge[column][row] = sc.nextInt();
				}
				sc.nextLine();
			}
			//System.out.println("testcase:" + i);
			System.out.println("#" + i + " " + sol.ladder(bridge));
		}
	}
}
