package Baekjoon.src.baekjoon15652;

import java.util.Scanner;

public class Main {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        arr = new int[M];

        dfs(1, 0, N, M);
    }

    private static void dfs(int index, int depth, int N, int M) {
        if(depth == M) {
            printResult();
            return;
        }

        for (int i = index; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1, N, M);
        }
    }

    private static void printResult() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
