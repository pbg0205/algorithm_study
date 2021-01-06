package baekjoon10757;

/*
 * @Problem     큰 수 A + b
 * @url         https://www.acmicpc.net/problem/10757
 * @author      pbg0205
 * @created by  2021.01.06
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        StringBuilder a = toStringBuilder(scanner.next());
        StringBuilder b = toStringBuilder(scanner.next());

        int index_a = a.length() - 1;
        int index_b = b.length() - 1;

        boolean carry = false;
        int sum;

        while (index_a >= 0 || index_b >= 0) {
            int number_a = initNumber(a, index_a--);
            int number_b = initNumber(b, index_b--);

            sum = sum(number_a, number_b, carry);
            carry = carry(number_a, number_b, carry);

            result.insert(0, sum);
        }

        if (carry) {
            result.insert(0, "1");
        }

        System.out.println(result);

        scanner.close();
    }

    private static StringBuilder toStringBuilder(String numberAsStr) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = numberAsStr.toCharArray();

        for (char c : charArr) {
            sb.append(c);
        }

        return sb;
    }

    private static int initNumber(StringBuilder a, int index_a) {
        return index_a >= 0 ? a.charAt(index_a) - '0' : 0;
    }

    private static boolean carry(int a, int b, boolean carry) {
        return carry ? ((a + b + 1) >= 10) : ((a + b) >= 10);
    }

    private static int sum(int a, int b, boolean carry) {
        return carry ? (a + b + 1) % 10 : (a + b) % 10;
    }
}