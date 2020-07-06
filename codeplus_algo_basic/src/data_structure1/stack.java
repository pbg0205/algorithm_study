package data_structure1;

import java.util.Scanner;
import java.util.Stack;

public class stack {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		int test = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < test; i++){
			String line = sc.nextLine();
			String[] menu = line.split(" ");	//[0] : 메뉴 | [1] : push value
			switch(menu[0]){
				case "push": 
					s.push(Integer.parseInt(menu[1]));
					break;
				case "pop": 
					System.out.println(s.isEmpty() ? -1 : s.pop());
					break;
				case "size": 
					System.out.println(s.size());
					break;
				case "empty": 
					System.out.println(s.isEmpty() ? 1 : 0);
					break;
				case "top": 
					System.out.println(s.isEmpty() ? -1 : s.peek());
					break;
							
			}
		}
	}
}
