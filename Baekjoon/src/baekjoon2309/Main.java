package baekjoon2309;
/*
 * @problem		일곱 난쟁이(2309) : https://www.acmicpc.net/problem/2309
 * @author		pbg0205
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dwarf = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		boolean is_finished = false;

		for (int i = 1; i <= 9; i++) {
			dwarf[i] = Integer.parseInt(sc.nextLine());
			sum += dwarf[i];
		}
		
		for (int i = 1; i <= 9; i++) {
			if(is_finished) break;
			for (int j = 1; j < i; j++) {
				if(sum - (dwarf[i] + dwarf[j]) == 100) {
					dwarf[i] = dwarf[j] = -1;
					is_finished = true; 
					break;
				}
			}
		}
		
		Arrays.sort(dwarf);
		
		for (int idx = 1; idx <= 9; idx++) {
			if(dwarf[idx] != -1 && dwarf[idx] != 0)
			System.out.println(dwarf[idx]);
		}
		
		sc.close();
	}
}
