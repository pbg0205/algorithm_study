package baekjoon1000;

import java.util.Scanner;

/*
 * @problem     A + B(1000)
 * @author      pbg0205
 * @url         https://www.acmicpc.net/problem/1000
 * @cretaed by  2020.01.06
 */

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        PlusFunction f = Integer::sum;

        System.out.println(f.plus(a, b));

        scanner.close();
    }

}

interface PlusFunction{
    int plus(int x, int y);
}