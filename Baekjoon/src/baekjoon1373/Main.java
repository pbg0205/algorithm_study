package baekjoon1373;
/*
 * @problem		2진수 8진수(1373) : https://www.acmicpc.net/problem/1373
 * @author		pbg0205
 */
import java.util.Scanner;

class Main {
	   public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	        int n = s.length();
	        
	        if (n%3 == 1)
	        	System.out.print(s.charAt(0));
	        else if (n%3 == 2)
	        	System.out.print((s.charAt(0)-'0')*2 + (s.charAt(1)-'0'));
	        
	        
	        for (int i=n%3; i<n; i+=3) 
	            System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
	        
	        System.out.println();
	    }
}
