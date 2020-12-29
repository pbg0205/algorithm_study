package Baekjoon1431;

/*
 * @problem		제곱수의 합(1699)
 * @url         https://www.acmicpc.net/problem/1699
 * @author		pbg0205
 * @create by   12.29.20
 */

import java.util.Arrays;
import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        String[] serialNumbers = new String[n];

        int count = 0;
        while (count < serialNumbers.length) {
            serialNumbers[count++] = scanner.nextLine();
        }

        Arrays.sort(serialNumbers, (o1, o2) -> {
            if(o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }

            if(o1.length() == o2.length()) {
                int sumOfPrev = getSum(o1);
                int sumOfAfter = getSum(o2);

                if(sumOfPrev == sumOfAfter) {
                    return o1.compareTo(o2);
                }

                return Integer.compare(sumOfPrev, sumOfAfter);
            }

            return 0;
        });

        for (String serialNumber : serialNumbers) {
            System.out.println(serialNumber);
        }
    }

    private static int getSum(String serial) {
        int sum = 0;
        char[] serialChar = serial.toCharArray();

        for (Character character : serialChar) {
            if(character >= '0' && character <= '9') {
                sum += character - '0';
            }
        }

        return sum;
    }
}
