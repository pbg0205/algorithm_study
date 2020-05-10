package baekjoon_level1_4;

import java.util.Scanner;

public class Pro_1080 {
	public void mul(double a, double b) {
		System.out.println(a/b);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		
		double a = Double.parseDouble(line[0]);
		double b = Double.parseDouble(line[1]);
		
		Pro_1080 pro = new Pro_1080();
		pro.mul(a, b);
	}
	
	///float : 메모리 크기 4byte(32bit) / 표현가능 소수점 이하 자리수 : 6
	///double : 메모리 크기 8byte(64bit) / 표현가능 소수점 이하 자리수 : 15
	///long double : 메모리 크기 8byte(64bit) / 표현가능 소수점 이하 자리수 : 15이상
}
