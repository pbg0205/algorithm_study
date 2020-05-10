package intermediate;

import java.util.Scanner;
import java.util.Stack;

public class Stack1_bracket {
	public int checkBracket(char[] test_charArr) {
		Stack<Character> bracket_stack = new Stack<>();
		//	[:91	]:93
		//	{:123	}:125
		//	<:60	>:62
		//	(:40	):41
		for (int index = 0; index < test_charArr.length; index++) {
			//System.out.println(index);
			//앞 괄호일 때, 뒷 괄호를 bracket_stack에 push한다.
			if(test_charArr[index] == 91)	bracket_stack.push((char)93);
			if(test_charArr[index] == 123)	bracket_stack.push((char)125);
			if(test_charArr[index] == 60)	bracket_stack.push((char)62);
			if(test_charArr[index] == 40)	bracket_stack.push((char)41);
		
			if(!bracket_stack.isEmpty() && 
					test_charArr[index] == 93 || test_charArr[index] == 125 ||
					test_charArr[index] == 62 || test_charArr[index] == 41) {
				
				if(test_charArr[index] == bracket_stack.peek())	bracket_stack.pop();
				else return 0;
			}
		}
		
		if(bracket_stack.isEmpty())	return 1;
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {			
			int test_len = Integer.parseInt(sc.nextLine());
			String test_case = sc.nextLine();
			
			char[] test_charArr = test_case.toCharArray();
			Stack1_bracket sol = new Stack1_bracket();
			System.out.println("#" + i + " " + sol.checkBracket(test_charArr));
		}
	}
}
