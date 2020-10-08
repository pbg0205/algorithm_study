package baekjoon9012;
/*
 * @problem		괄호(9012) : https://www.acmicpc.net/problem/9012
 * @author		pbg0205
 */
import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		for (int test_num = 1; test_num <= test_case; test_num++) {
			
			Stack<Character> stack = new Stack<>();
			String brackets = sc.nextLine();
			boolean is_vps = true;
			
			for (int i = 0; i < brackets.length(); i++) {
				char bracket = brackets.charAt(i);
				if(bracket == '(')	stack.push(')');
				if(bracket == ')') {
					if(!stack.isEmpty() && brackets.charAt(i) == stack.peek()) {
						stack.pop();	
					}else {
						is_vps = false;
						break;
					}
				}
			}

			if(is_vps && stack.isEmpty())	{
				System.out.println("YES");
			}else {
				System.out.println("NO");	
			}

		}
		
		sc.close();
	}
}
