package dp1;

import java.util.Scanner;
//문제: 1만들기 (1463)
//-> Topdown방식 : **재귀함수**로 큰 문제에서 작은 문제의 정답을 이용하는 과정
public class make_1_TopDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
