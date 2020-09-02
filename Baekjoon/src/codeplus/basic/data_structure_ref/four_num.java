package codeplus.basic.data_structure_ref;

import java.util.Scanner;

public class four_num {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String AB = "";
		String CD = "";
		
		AB += sc.next() + sc.next();
		CD += sc.next() + sc.next();
		
		long total_sum = Long.parseLong(AB) + Long.parseLong(CD);
		System.out.println(total_sum);
		
		sc.close();
	}
}
