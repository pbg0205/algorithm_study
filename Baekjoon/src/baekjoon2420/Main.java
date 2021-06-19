package Baekjoon.src.baekjoon2420;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long popularityA = scanner.nextInt();
        long popularityB = scanner.nextInt();

        System.out.println(Math.abs(popularityA - popularityB));

        scanner.close();
    }
}
