package programmers.src.level2.prime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static boolean[] isPrime = new boolean[10000001];
    static int data[];
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        char[] charArr = numbers.toCharArray();

        for (int i = 2; i * i <= 10000000; i++) {
            for (int j = i * i; j <= 10000000; j += i) {
                isPrime[j] = false;
            }
        }

        int n = numbers.length();
        data = new int[n + 1];
        visited = new boolean[n + 1];

        for (int r = 1; r <= n; r++) {
            permutation(n, r, 0, charArr);
        }

        return set.size();
    }

    private void permutation(int n, int r, int depth, char[] charArr) {
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
}
