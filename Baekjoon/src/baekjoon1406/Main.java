package baekjoon1406;
/*
 * @problem		에디터(1406) : https://www.acmicpc.net/problem/1406
 * @author		pbg0205
 */


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> lStack = new Stack<>();
		Stack<Character> rStack = new Stack<>();		
		
		
		String str = br.readLine();
		int command_num = Integer.parseInt(br.readLine());

		for (int i = 0; i < str.length(); i++)	lStack.push(str.charAt(i));
		
		for (int i = 1; i <= command_num; i++) {
			String command = br.readLine();
			
			if(command.startsWith("L")) {
				if(!lStack.empty()) {
					rStack.push(lStack.pop());
				}
			}
			
			if(command.startsWith("D")) {
				if(!rStack.empty()) {
                    lStack.push(rStack.pop());
                }
			}
			
			if(command.startsWith("B")) {
                if(!lStack.empty()) {
                    lStack.pop();
                }
			}
			
			if(command.startsWith("P")) {
				String[] pCommand = command.split(" ");
				lStack.push(pCommand[1].toCharArray()[0]);
			}
		}
		 
        while(!lStack.empty()) {
            rStack.push(lStack.pop());
        }
 
        while(!rStack.empty()) {
            bw.write(rStack.pop());
        }
 
        br.close();
        bw.flush();
        bw.close();
	}
}
