package bruteforce.programmers;

/*
 * @Problem     소수찾기(https://programmers.co.kr/learn/courses/30/lessons/42842)
 * @Author      pbg02025
 * @Created by  09.15.20
 *
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNum {
    static boolean[] isPrime = new boolean[10000001];
    static int data[];
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        PrimeNum sol = new PrimeNum();

        String numbers01 = "17";
        String numbers02 = "011";

        int answer = sol.solution(numbers02);
        System.out.println(answer);
    }

    public int solution(String numbers) {

        char[] charArr = numbers.toCharArray();
        int n = numbers.length();

        isPrime = getPrime(isPrime);

        data = new int[n + 1];
        visited = new boolean[n + 1];

        for (int r = 1; r <= n; r++) {
            permutation(n, r, 0, charArr);
        }

        return set.size();
    }

    /*
     * - 순열 반환 함수(nPr) : dfs로 구현
     * (내부 로직 리팩토링 필요)
     */
    private void permutation(int n, int r, int depth, char[] charArr) {
        /*
         * - dfs 함수 탈출 조건
         * 1. depth == r일 때, 반복문을 통한 숫자 반환
         * 2. 숫자 반환 후, 소수 여부 판별
         * 3. 소수일 경우, set에 추가
         *
         */
        if (depth == r) {
            String tmp = "";
            for (int i = 0; i < r; i++) {
                tmp += charArr[data[i]];
            }

            int number = Integer.parseInt(tmp);
            if (isPrime[number] && !set.contains(number)) {
                set.add(number);
            }
            return;
        }
        for (int idx = 0; idx < n; idx++) {
            if (!visited[idx]) {
                visited[idx] = true;
                data[depth] = idx;
                permutation(n, r, depth + 1, charArr);
                visited[idx] = false;
            }
        }
    }

    /*
     * - 소수 판별 배열 반환 함수 : 에라토스테네스 체 구현
     */
    private boolean[] getPrime(boolean[] isPrime){
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 10000000; i++) {
            for (int j = i * i; j <= 10000000; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
