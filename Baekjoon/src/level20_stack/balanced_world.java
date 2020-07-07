package level20_stack;

import java.util.Scanner;
import java.util.Stack;

public class balanced_world {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			boolean	is_finished = true;
			
			if(str.equals("."))	break;
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(')	stack.push(')');
				if(str.charAt(i) == '[')	stack.push(']');
				
				if(str.charAt(i) == ')' || str.charAt(i) == ']') {
					if(stack.isEmpty()) {
						is_finished = false;
						break;
					}
					if(!stack.isEmpty() && str.charAt(i) == stack.peek()) {
						stack.pop();
					}else {
						is_finished = false;
						break;
					}
				}
			}
			
			if(is_finished && stack.isEmpty())	System.out.println("yes");
			else								System.out.println("no");
		}	
		
		
		sc.close();
	}
}
