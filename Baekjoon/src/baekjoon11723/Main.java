package baekjoon11723;
/*
 * @problem		집합(11723) : https://www.acmicpc.net/problem/11723
 * @author		pbg0205
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int T = scan.nextInt();
		int S = 0;
		for (int i = 0; i < T; i++) {
			String command = scan.next();
			if (command.equals("add")) {
				int x = scan.nextInt();
				S = S | (1 << x);
			} else if (command.equals("remove")) {
				int x = scan.nextInt();
				S = S & ~(1 << x);
			} else if (command.equals("check")) {
				int x = scan.nextInt();
				if ((S & (1 << x)) > 0)
					result.append("1\n");
				else
					result.append("0\n");
			} else if (command.equals("toggle")) {
				int x = scan.nextInt();
				S = S ^ (1 << x);
			} else if (command.equals("all")) {
				S = (1 << 21) - 1;
			} else
				S = 0;
		}
		System.out.println(result);

	}
}
