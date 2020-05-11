package intermediate;

import java.util.Scanner;

public class Tree1_inOrder {
//문제요약 : Tree 중위순회를 통한 값 나열하기
//문제 개념(complete binary tree에서 사용 가능)
//	idx *2		: 왼쪽 자식 노드
//	idx *2 + 1	: 오른쪽 자식 노드
	static Scanner sc = new Scanner(System.in);
	static char[] nodes;
	static int degree;
	
	public static void main(String[] args) {
		
		for(int tc = 1; tc <= 10; tc++) {
			degree = Integer.parseInt(sc.nextLine());
			nodes = new char[degree + 1];
			
			for(int i = 1; i <= degree; i++) {
				nodes[i] = (sc.nextLine().split(" ")[1]).charAt(0);
			}

			System.out.print("#" + tc + " ");
			inOrder(1);
			System.out.println();
		}
		
		sc.close();
	}

	static void inOrder(int idx) {
		if(is_valid(idx)) {
			inOrder(idx*2);
			System.out.print(nodes[idx]);
			inOrder(idx*2 + 1);			
		}
	}
	
	static boolean is_valid(int idx) {
		if(idx > degree) {
			return false;
		}
		return true;
	}
}
