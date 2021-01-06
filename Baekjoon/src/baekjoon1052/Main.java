package baekjoon1052;

/*
 * @Problem     물병(1052)
 * @Url         https://www.acmicpc.net/problem/1052
 * @author      pbg0205
 * @created by  2020.01.06
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(solution(n, k));

        scanner.close();
    }

    private static int solution(int n, int k) {
        int bottles_min;
        int additionalBottles = 0;

        if(n <= k) {
            return 0;
        }

        while(true) {
            bottles_min = getMinBottles(n);

            if(bottles_min <= k) {
                return additionalBottles;
            }

            n++;
            additionalBottles++;
        }
    }

    private static int getMinBottles(int n) {
        int count = 0;

        while(n > 0) {
            count = (n % 2 == 1) ? ++count : count;
            n /= 2;
        }

        return count;
    }
}
