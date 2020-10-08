package baekjoon9093;
/*
 * @problem		단어뒤집기(9093) : https://www.acmicpc.net/problem/9093
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for (int test_num = 1; test_num <= test_case; test_num++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			str += ' ';
			//ex) I' 'am' 'happy' 'today' '
			for (int index = 0; index < str.length(); index++) {
				if(str.charAt(index) == ' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				}else {
					stack.add(str.charAt(index));
				}
			}
			System.out.println();
		}
		br.close();
	}
}

//1.string에 결과값을 추가하여 넣는 방법을 사용할 시, 메모리 초과 현항이 발생했다.
// -> System.out.print로 출력해서 '메모리 초과' 문제 해결.
