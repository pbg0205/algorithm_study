package baekjoon1003;

import java.io.*;

/*
 * @Problem     피보나치 함수(1003)
 * @Author      pbg0205
 * @Created by  09.07.20
 */
class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        dp = new int[41][2];

        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;

        for (int i = 2; i <= 40 ; i++) {

            dp[i][0] = dp[i-2][0] + dp[i-2][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];

        }

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " "  + dp[n][1]);
        }
    }
}