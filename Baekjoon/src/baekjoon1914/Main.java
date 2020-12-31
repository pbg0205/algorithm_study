package baekjoon1914;

/*
 * @problem     하노이의 탑(1914)
 * @url         https://www.acmicpc.net/problem/1914
 * @author      pbg0205
 * @created by  2021.01.01
 */

import java.math.BigInteger;
import java.util.Scanner;

class Main {

    private static BigInteger result = new BigInteger("2");
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printResult(n);
        printMovement(n);

        scanner.close();
    }

    private static void printResult(int n) {
        result = result.pow(n)
                        .subtract(new BigInteger("1"));

        System.out.println(result);
    }

    private static void printMovement(int n) {
        if (n > 20) {
            return;
        }
        move(n, 1, 2, 3);

        System.out.println(sb);
    }

    private static void move(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        move(n - 1, start, end, mid);
        sb.append(start + " " + end + "\n");
        move(n - 1, mid, start, end);
    }
}