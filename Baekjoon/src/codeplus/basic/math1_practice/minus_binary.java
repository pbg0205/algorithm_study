package codeplus.basic.math1_practice;

import java.util.Scanner;

public class minus_binary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		String output = "";
		
		 if(input == 0)
	            System.out.println(input);
		
		while(input != 0) {
			output += (int)Math.abs(input % -2);
			input = (int)Math.ceil((double)input / -2);
		}
		
		System.out.println(output);
		
		sc.close();
	}
}

//ceil : 자리 올림
//round : 반올림
//floor : 자리 내림
