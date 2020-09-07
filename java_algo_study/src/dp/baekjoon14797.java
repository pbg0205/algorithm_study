package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem     방 배정하기(14697)
 * @Author      pbg0205
 * @Created by  09.07.20
 *
 */
public class baekjoon14797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        int[] dp = new int[301];
        dp[0] = 1;

        for (int i = 1; i <= total; i++) {
            if (i >= a) {
                if (i >= b) {
                    if (i >= c) {
                        dp[i] = dp[i - a] + dp[i - b] + dp[i - c];
                    }
                    else {
                        dp[i] = dp[i - a] + dp[i - b];
                    }
                }
                else {
                    dp[i] = dp[i - a];
                }
            }
            else {
                dp[i] = 0;
            }
        }

        if (dp[total] == 0) {
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }
    }
}
