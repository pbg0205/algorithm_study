package Baekjoon.src.baekjoon3004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int row = 1;
        int col = 1;

        for (int i = 1; i <= n ; i++) {
            int tempA = (row + 1) * col;
            int tempB = row * (col + 1);

            if(tempA > tempB) {
                row++;
            }else {
                col++;
            }
        }

        System.out.println(row * col);

        scanner.close();
    }
}
