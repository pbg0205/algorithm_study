package Pro_Level1;

import java.util.*;

public class Pro_Crain {
	
	 //1.크레인 인형뽑기 게임
	public int solution(int[][] board, int[] moves) {
		/*
		 * 내용 정리
		 * 1.크레인이 인형을 옮긴다
		 * 2.장바구니에 옮겨진 인형은 위아래 같은 인형이 존재하게 되면 사라진다.
		 * 3.없는 위치에서 꺼내려고 하면 아무일도 일어나지 않는다.
		 */
//			[0,0,0,0,0]
//			[0,0,1,0,3]
//			[0,2,5,0,1]
//			[4,2,4,4,2]
//			[3,5,1,3,1]
		/*
		  * 1. 장바구니 만들기 + 이전에 들어갔던 수 파악하기(stack:pop하고 다르면 다시 첨부하기)
		  * 2. 꺼내면 값 변경하기 (0으로)
		 */
		int answer = 0;
		Stack<Integer> ShoppingBasket = new Stack<Integer>();
		
		for (int outNumber : moves) {
			int row = outNumber - 1;
			System.out.println("rowNum:" + outNumber);
			for (int column = 0; column < board.length; column++) {
				if (board[column][row] == 0)	{
					continue;
				}
				if (board[column][row] != 0) {
					if (ShoppingBasket.empty()) {
						ShoppingBasket.push(board[column][row]);
						board[column][row] = 0;
						break;
					} else {
						int doll_in_basket = ShoppingBasket.peek();
						if (doll_in_basket != board[column][row]) {
							ShoppingBasket.push(board[column][row]);
							board[column][row] = 0;
							break;
						} else if (doll_in_basket == board[column][row]) {
							ShoppingBasket.pop();
							board[column][row] = 0;
							answer+=2;
							break;
						} // if:장바구니에서 값뽑아서 비교
					} // if:장바구니 비어있지 않은경우
				} // board 존재 for문
			} // for(row)
		} // foreach
		return answer;
	}



	
	public static void main(String[] args) {
		
		 Pro_Crain sol = new Pro_Crain();
		 
		 int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		 int[] moves = {1,5,3,5,1,2,1,4};
		
		 System.out.println("result : " + sol.solution(board, moves)); 
	}		
}