package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Problem     제곱수의 합(1699)
 * @Author      pbg0025
 * @Created by  09.08.20
 *
 */

public class baekjoon1699 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            double n_tmp = i - Math.pow((int)Math.sqrt(i), 2);
            dp[i] = 1 + dp[(int)n_tmp];

            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }
}
