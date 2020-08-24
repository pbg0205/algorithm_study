package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * problem		{에디터 (1406)}
 * author		{pbg0205}
 * Create by	{08.24.20}
*/
public class baekjoon1406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		editor(str, n);
		
	}
	
	public static void editor(String str, int n) throws IOException {
		StringBuilder sb = new StringBuilder();
		Stack<Character> lStack = new Stack<>();
		Stack<Character> rStack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++)
			lStack.push(str.charAt(i));
		
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
			case "L":
				if (!lStack.isEmpty()) {
					rStack.push(lStack.pop());
				}
				break;
			case "D":
				if (!rStack.isEmpty()) {
					lStack.push(rStack.pop());
				}
				break;
			case "B":
				if (!lStack.isEmpty()) {
					lStack.pop();
				}
				break;
			case "P":
				lStack.push(command[1].charAt(0));
				break;
			}
		}
		
		while(!lStack.isEmpty())
			rStack.push(lStack.pop());
		
		while(!rStack.isEmpty())
			sb.append(rStack.pop());
		
		System.out.println(sb.toString());
	}
}
