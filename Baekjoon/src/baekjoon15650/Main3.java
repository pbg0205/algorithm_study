package Baekjoon.src.baekjoon15650;

import java.util.Scanner;

//combination이 맞긴한데 순서 보장을 안해준다는 단점.
public class Main3 {

    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        bitmask(N, M);
    }

    private static void bitmask(int N, int M) {
        for (int i = 0; i < (1 << N); i++) {
            if(Integer.bitCount(i) == M) {
                for (int j = 0; j < N; j++) {
                    if((i & (1 << j)) > 0) {
                        System.out.print((j + 1) + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
