package Baekjoon.src.baekjoon15650;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int data[];
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[N+1];
        visited = new boolean[N+1];

        combination(1,0);


        sc.close();
    }

    private static void combination(int start, int num) {
        if(num == M) {
            for (int i = 0; i < M-1; i++) {
                if(data[i] > data[i+1])	continue;
            }
            for (int i = 0; i < M; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = start; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                data[num] = i;
                combination(i+1, num+1);
                visited[i] = false;
            }
        }

    }
}
