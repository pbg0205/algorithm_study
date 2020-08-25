package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * problem		{스택 수열 (1874)}
 * author		{pbg0205}
 * Create by	{08.25.20}
 */
public class baekjoon1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		
		Stack<Integer> stack = new Stack<>();
		boolean isAble = true;
		
		for (int i = 0; i < n; i++) {
			int data = Integer.parseInt(br.readLine());
			
			if(isAble) {
				if(cnt <= data) {
					while(cnt <= data) {
						stack.push(cnt++);
						sb.append("+ \n");
					}
				}
				if(stack.isEmpty()) {		/*로직 진행 중에 비어있는 경우를 대비한 조건문*/
					isAble = false;		
				}else {
					while(stack.peek() >= data) {
						stack.pop();
						sb.append("- \n");
						if(stack.isEmpty()) {/*완료 시, 반복문 탈출 조건문 */
							break;	
						}
					}
				}
			}
		}
		br.close();

		if(isAble) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
	}
}
