package Baekjoon.src.baekjoon15650;

import java.util.Scanner;

public class Main2 {

    private static int[] data;
    private static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[M];

        dfs(1,0);
    }

    public static void dfs(int index, int depth) {
        if(depth == M) {
            print(data);
            return;
        }

        for (int i = index; i  <= N; i++) {
            data[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    private static void print(int[] data) {
        for (int datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }
}
